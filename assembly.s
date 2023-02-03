	.text
	.globl	kunkun
	.p2align	2
kunkun
.Lfunc_end0:
	.globl	main
	.p2align	2
main
.Lfunc_end1:
	.globl	nothing
	.p2align	2
nothing
.Lfunc_end2:
#    --String Constants
	.section	.rodata
.L.str0:
	.asciz	"hl"
#    --UnInitialized Global Variables;
	.section	.sbss
a:
	.word	0
hello:
	.word	0
