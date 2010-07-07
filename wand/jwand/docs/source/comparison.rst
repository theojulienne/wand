Wand language comparison
========================

D Programming Language
----------------------

The D programming language probably provided the most influence in the design 
of Wand. For the most part, Wand syntax is borrowed from D, however there are
a few key design differences that make Wand significantly more reliable.

The most notable difference is that Wand attempts only to provide a language,
and doesn't try to reinvent the compiler. Wand doesn't write assembly/machine
code, this is left up to the already very stable C compiler, GCC.

Wand doesn't support filename-based "modules" like D, and instead uses a
namespace system more similar to that of Vala.

Vala Programming Language
-------------------------

Vala uses a similar compiler design to Wand, in that it generates only C code.
Wand also borrows Vala's syntax for multiple named class constructors and other
features.

The most notable difference is that Wand uses garbage collection and its own
class structure, whereas Vala uses reference counting and the GObject type
system.

There are both benefits and disadvantages to Vala's choice of GObject, the
largest benefit being its immediate compatibility with GObject-based libraries
like GTK. However, by Wand using its own class system, it has a greater deal of
implementation flexibility and requires no external dependency. GObject also
forces the use of reference counting, and garbage collection was the method
of choice for Wand.

The use of garbage collection in Wand also provides many benefits compared to
reference counting in Vala, especially when using libraries that don't use
GObject. Reference counting works best when you can rely on all libraries that
are used also using reference counting. This makes compatibility with other
libraries difficult, and it is a major design requirement of Wand that all C
libraries should be easy to interface with (and wrap).

Wand namespaces are very similar to Vala's namespaces, though Wand uses
slightly different rules and syntax.

Java Programming Language
-------------------------

Java is another major source for design concepts for Wand. In fact, D itself
was largely inspired by Java, so Wand inherits Java concepts this way as well.

The most notable difference is that Wand is a compiled language (via C),
whereas Java is (usually) a bytecode language that requires a virtual machine 
(JVM) to run.