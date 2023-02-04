	.text
	.globl	kunkun
	.p2align	2
kunkun
entry.0:
	li	t0	0
	lui	t1,	%hi(a)
	sw	t0,	%lo(a)(t1)
	li	t0	99
	lui	t1,	%hi(d)
	sw	t0,	%lo(d)(t1)
.Lfunc_end0:
	.globl	main
	.p2align	2
main
entry.1:
	li	t0	0
	sw	t0,	4(sp)
	lui	t1,	%hi(a)
	lw	t0,	%lo(a)(t1)
	sw	t0,	16(sp)
	lw	t0,	16(sp)
	sw	t0,	8(sp)
	lui	t1,	%hi(d)
	lw	t0,	%lo(d)(t1)
	sw	t0,	20(sp)
	lw	t0,	20(sp)
	sw	t0,	8(sp)
	lw	t0,	8(sp)
	sw	t0,	2(sp)
	lw	t0,	2(sp)
	sw	t0,	12(sp)
	li	t0	0
	sw	t0,	4(sp)
exit.1:
	lw	t0,	4(sp)
	sw	t0,	3(sp)
.Lfunc_end1:
#    --UnInitialized Global Variables;
	.section	.sbss
a:
	.word	0
d:
	.word	0
