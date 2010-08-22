#include <wand-runtime-types.h>
#include <wand-runtime-object.h>

#include <stdio.h>

int Foo_foo_impl( WandCallable this, int num ) {
	printf( "[%d] Foo.foo()\n", num );
	return 123;
}

int Foo_bar_impl( WandCallable this, int num ) {
	printf( "[%d] Foo.bar()\n", num );
	return 123;
}

int Bar_foo_impl( WandCallable this, int num ) {
	printf( "[%d] Bar.foo() (override)\n", num );
	return 123;
}

int Bar_baz_impl( WandCallable this, int num ) {
	printf( "[%d] Bar.baz()\n", num );
	return 123;
}


typedef struct _wand_Foo_class {
	_wand_Object_class super;
	
	// members go here
} *_wand_Foo_class_ref, _wand_Foo_class;


typedef struct {
	int (*fooMangledFunc)(WandCallable, int);
	int (*barMangledFunc)(WandCallable, int);
} _wand_class_Foo_vtable;

void _wand_gen_vtable_Foo( void *_vtable ) {
	_wand_class_Foo_vtable *vtable = (_wand_class_Foo_vtable *)_vtable;
	
	WAND_GEN_VTABLE_SUPER( vtable, Object );
	
	vtable->fooMangledFunc = Foo_foo_impl;
	vtable->barMangledFunc = Foo_bar_impl;
}

WAND_DEFINE_CLASS_FUNCS( Foo, Object );




typedef struct _wand_Bar_class {
	_wand_Foo_class super;
	
	// members go here
} *_wand_Bar_class_ref, _wand_Bar_class;

typedef struct {
	// COPY OF FOO
	int (*fooMangledFunc)(WandCallable, int);
	int (*barMangledFunc)(WandCallable, int);
	
	// NEW
	int (*bazMangledFunc)(WandCallable, int);
} _wand_class_Bar_vtable;

void _wand_gen_vtable_Bar( void *_vtable ) {
	_wand_class_Bar_vtable *vtable = (_wand_class_Bar_vtable *)_vtable;
	
	WAND_GEN_VTABLE_SUPER( vtable, Foo );
	
	vtable->fooMangledFunc = Bar_foo_impl;
	vtable->bazMangledFunc = Bar_baz_impl;
}

WAND_DEFINE_CLASS_FUNCS( Bar, Foo );






//#include <stdio.h>

static void __attribute__((constructor)) _wand_lib_init( ) {
	//printf( "construct!\n" );
	_wand_get_type_Foo( );
	_wand_get_type_Bar( );
}

static void __attribute__((destructor)) _wand_lib_destroy( ) {
	//printf( "destruct!\n" );
}

int main(int argc, char const *argv[]) {
	_wand_Foo_class_ref foo = WAND_INST_ALLOC( Foo );
	
	WAND_INST_VCALL( foo, Foo, fooMangledFunc,   1 );
	WAND_INST_VCALL( foo, Foo, barMangledFunc,   2 );
	
	_wand_Bar_class_ref bar = WAND_INST_ALLOC( Bar );
	
	WAND_INST_VCALL( bar, Bar, fooMangledFunc,   3 );
	WAND_INST_VCALL( bar, Bar, barMangledFunc,   4 );
	WAND_INST_VCALL( bar, Bar, bazMangledFunc,   5 );
	
	foo = WAND_INST_CAST_SUPER( bar, Foo );
	
	WAND_INST_VCALL( foo, Foo, fooMangledFunc,   6 );
	WAND_INST_VCALL( foo, Foo, barMangledFunc,   7 );
	// can't call baz, not part of Foo, even though this
	// instance technically has it
	
	return 0;
}