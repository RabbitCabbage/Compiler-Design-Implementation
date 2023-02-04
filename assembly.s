	.text
	.globl	kunkun
	.p2align	2
kunkun
entry.0:
	#	--store i32 0, i32* @a
	li	t0	0
	lui	t1,	%hi(a)
	sw	t0,	%lo(a)(t1)
	#	--store i32 99, i32* @d
	li	t0	99
	lui	t1,	%hi(d)
	sw	t0,	%lo(d)(t1)
	#	--ret void
	#	--%retval = alloca i32
	#	--%b = alloca i32
	#	--%c = alloca i32
.Lfunc_end0:
	.globl	main
	.p2align	2
main
entry.1:
	#	--store i32 0, i32* %retval
	li	t0	0
	sw	t0,	4(sp)
	#	--call void @kunkun()
	#	--%0 = load i32, i32* @a
	lui	t1,	%hi(a)
	lw	t0,	%lo(a)(t1)
	sw	t0,	16(sp)
	#	--store i32 %0, i32* %b
	lw	t0,	16(sp)
	sw	t0,	8(sp)
	#	--%1 = load i32, i32* @d
	lui	t1,	%hi(d)
	lw	t0,	%lo(d)(t1)
	sw	t0,	20(sp)
	#	--store i32 %1, i32* %b
	lw	t0,	20(sp)
	sw	t0,	8(sp)
	#	--%2 = load i32, i32* %b
	lw	t0,	8(sp)
	sw	t0,	2(sp)
	#	--store i32 %2, i32* %c
	lw	t0,	2(sp)
	sw	t0,	12(sp)
	#	--store i32 0, i32* %retval
	li	t0	0
	sw	t0,	4(sp)
	#	--br label %exit
exit.1:
	#	--%3 = load i32, i32* %retval
	lw	t0,	4(sp)
	sw	t0,	3(sp)
	#	--ret i32 %3
.Lfunc_end1:
#    --UnInitialized Global Variables;
	.section	.sbss
a:
	.word	0
d:
	.word	0
