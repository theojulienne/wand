#include <wand-runtime-types.h>
#include <wand-runtime-object.h>

// WAND_DEFINE_CLASS_FUNCS assumes _wand_get_type_SUPER exists,
// which it doesn't in this case. so lets define it:
static inline WandType _wand_get_type_BASECLASS( ) {
	return NULL;
}




typedef struct {
} _wand_class_Object_vtable;

void _wand_gen_vtable_Object( _wand_class_Object_vtable *vtable ) {
}

WAND_DEFINE_CLASS_FUNCS( Object, BASECLASS )
