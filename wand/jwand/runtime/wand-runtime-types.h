#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>

#define wand_malloc malloc
#define wand_free free


#define WAND_TYPE_INTERFACE 1
#define WAND_TYPE_CLASS 2
#define WAND_TYPE_DECORATOR 3

typedef void* virtual_table;

typedef struct wand_callable *WandCallable;
typedef struct wand_type *WandType;

typedef struct wand_class_inst *WandClassInst;
typedef struct wand_interface_inst *WandInterfaceInst;
typedef struct wand_decorator_inst *WandDecoratorInst;

#define WAND_TYPE(klass) (_wand_get_type_##klass( ))

#define WAND_INST_ALLOC(klass) ( _wand_alloc_##klass##_inst( ) )

#define WAND_INST_GET_TYPE(inst) ( _wand_rt_get_inst_type( (WandCallable)(inst) ) )
#define WAND_INST_DECORATED_BY(inst,type) ( _wand_rt_check_for_decorator( (WandCallable)(inst), (type) ) )
#define WAND_INST_DECORATE_INST(inst,decoratorType) ( _want_rt_decorate_interface( (WandCallable)(inst), (decoratorType) ) )

#define WAND_INST_GET_VTABLE(inst,klass) ( (_wand_class_##klass##_vtable*)((WandCallable)(inst))->vtable )
#define WAND_INST_VCALL(inst,klass,funcName, args...) \
	( *( WAND_INST_GET_VTABLE(inst,klass) )->funcName )( (WandCallable)(inst), ## args )

// note: the compiler itself verifies a cast is legitimate superclass
// before calling this. another method should be used for subclass casting.
#define WAND_INST_CAST_SUPER(inst,klass) ( (_wand_##klass##_class_ref)(inst) )

#define WAND_TYPE_GET_SUPER(type) ( (type)->superClass )

/*
#define WAND_VTABLE_OFFSET(vtbl,offset) (&(vtbl)[(offset)])
#define WAND_TYPE_VTABLE_OFFSET(type,offset) WAND_VTABLE_OFFSET( (type)->vtable, (offset) )
*/

typedef struct wand_callable {
	WandCallable instance;
	WandType type;
	
	virtual_table vtable;
} wand_callable;

typedef struct wand_class_inst {
	wand_callable callable;
	
	WandInterfaceInst interfaces[];
	
	// data members follow
} wand_class_inst;

typedef struct wand_interface_inst {
	wand_callable callable;
} wand_interface_inst;

typedef struct wand_decorator_inst {
	/* callable's instance member and vtable is the
	 * original instance (before decoration)
	 * callable's type is the decorator's WandType
	 */
	wand_callable callable;
	
	// data members follow
} wand_decorator_inst;

typedef struct wand_type {
	int typeCode; // WAND_TYPE_*
	char *name;
	
	WandType superClass; // if applicable
	
	virtual_table vtable;
} wand_type;



static inline WandType _wand_rt_get_inst_type( WandCallable callable ) {
	WandCallable baseCallable = NULL;
	
	/* dereference to the parent callable until
	 * we find a callable that references itself.
	 * this is the _real_ instance, eg without any
	 * decorators
	 */
	while ( baseCallable != callable ) {
		baseCallable = callable;
		callable = callable->instance;
	}
	
	return callable->type;
}

static inline bool _wand_rt_check_for_decorator( WandCallable callable, WandType decoratorType ) {
	assert( decoratorType->typeCode == WAND_TYPE_DECORATOR );
	
	WandCallable baseCallable = NULL;
	bool foundDecorator = false;
	
	/* dereference to the parent callable until
	 * we find a callable that references itself (fail).
	 * or we find a callable that has the specified decorator
	 * as the type (success)
	 */
	while ( !foundDecorator && baseCallable != callable ) {
		if ( callable->type == decoratorType ) {
			foundDecorator = true;
		}
		
		baseCallable = callable;
		callable = callable->instance;
	}
	
	return foundDecorator;
}

static inline void _want_rt_decorate_interface( WandInterfaceInst interface, WandType decorator ) {
	// note that an actual interface must be decorated (may be decorated, but must be the latest)
	assert( interface->callable.type->typeCode == WAND_TYPE_INTERFACE );
	assert( decorator->typeCode == WAND_TYPE_DECORATOR );
	
	WandDecoratorInst decoratorInst = wand_malloc(sizeof(wand_decorator_inst));
	
	/*** create the decorator callable, which partly backs up the original implementation ***/
	
	// remember the original instance/vtable
	decoratorInst->callable.instance = interface->callable.instance;
	decoratorInst->callable.vtable = interface->callable.vtable;
	
	// but store the type of the decorator instead
	decoratorInst->callable.type = decorator;
	
	/*** rewrite the interface implementation, because we have our backup ***/
	
	// make the decorator replace the interface implementation
	interface->callable.instance = (WandCallable)decoratorInst;
	interface->callable.vtable = decorator->vtable;
	// note: leaving the interface type alone, because it's still an interface!
	// we've only changed who implements it.
}

static inline void _wand_rt_undecorate_interface( WandInterfaceInst interface, WandType decorator ) {
	assert( decorator->typeCode == WAND_TYPE_DECORATOR );
	assert( WAND_INST_DECORATED_BY(interface, decorator) );
	
	// we start by finding the callable that needs to be changed.
	// it doesn't have the decorator as a type, it has a pointer to
	// an instance (backup) which has the decorator as type (see above)
	
	WandCallable callable = (WandCallable)interface;
	
	// check that the _next_ down the chain is the decoratorInst created
	// in the above function (eg, backup)
	// note that this loop must terminate, as the decorator is guarenteed
	// to be there according to the function preconditions (assert)
	while ( callable->instance->type != decorator ) {
		callable = callable->instance;
	}
	
	assert( callable->instance->type == decorator );
	
	// we now need to un-decorate the callable
	WandDecoratorInst decoratorInst = (WandDecoratorInst)callable->instance;
	
	callable->instance = decoratorInst->callable.instance;
	callable->vtable = decoratorInst->callable.vtable;
	
	// there is now no reference to decoratorInst, yay!
	wand_free( decoratorInst );
}



#define WAND_GEN_VTABLE_SUPER(vtable,super) \
{ \
	void _wand_gen_vtable_##super ( void *vtable ); \
	_wand_gen_vtable_##super ( (vtable) ); \
}


#define WAND_DEFINE_CLASS_FUNCS(klass, super) \
\
void _wand_gen_vtable_##super ( void *vtable ); \
WandType _wand_get_type_##super ( ); \
\
_wand_class_##klass##_vtable *_wand_get_vtable_##klass ( ) { \
	static _wand_class_##klass##_vtable *vtable = NULL; \
	\
	if ( vtable == NULL ) { \
		vtable = wand_malloc(sizeof(_wand_class_##klass##_vtable)); \
		\
		_wand_gen_vtable_##klass( vtable ); \
	} \
	\
	return vtable; \
} \
\
WandType _wand_get_type_##klass ( ) { \
	static WandType type = NULL; \
	\
	if ( type == NULL ) { \
		type = wand_malloc(sizeof(wand_type)); \
		\
		type->typeCode = WAND_TYPE_CLASS; \
		type->name = #klass; \
		type->superClass = _wand_get_type_##super ( ); \
		type->vtable = _wand_get_vtable_##klass ( ); \
	} \
	\
	return type; \
} \
\
_wand_##klass##_class_ref _wand_alloc_##klass##_inst( ) { \
	_wand_##klass##_class_ref inst = NULL; \
	WandCallable callable; \
	\
	inst = (_wand_##klass##_class_ref)malloc(sizeof(_wand_##klass##_class)); \
	\
	callable = (WandCallable)inst; \
	callable->instance = callable; \
	callable->type = _wand_get_type_##klass ( ); \
	callable->vtable = callable->type->vtable; \
	\
	\
	return inst; \
}






