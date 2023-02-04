	.text
	.globl	kunkun
	.p2align	2
kunkun
entry.0:
	addi	sp,	sp,	-56
	mv	t0,	ra
	sw	t0,	4(sp)
	mv	t0,	s0
	sw	t0,	8(sp)
	mv	t0,	s1
	sw	t0,	12(sp)
	mv	t0,	s2
	sw	t0,	16(sp)
	mv	t0,	s3
	sw	t0,	20(sp)
	mv	t0,	s4
	sw	t0,	24(sp)
	mv	t0,	s5
	sw	t0,	28(sp)
	mv	t0,	s6
	sw	t0,	32(sp)
	mv	t0,	s7
	sw	t0,	36(sp)
	mv	t0,	s8
	sw	t0,	40(sp)
	mv	t0,	s9
	sw	t0,	44(sp)
	mv	t0,	s10
	sw	t0,	48(sp)
	mv	t0,	s11
	sw	t0,	52(sp)
	#	--store i32 9, i32* @he
	li	t0	9
	lui	t1,	%hi(he)
	sw	t0,	%lo(he)(t1)
	#	--ret void
	lw	t0,	8(sp)
	mv	s0,	t0
	lw	t0,	12(sp)
	mv	s1,	t0
	lw	t0,	16(sp)
	mv	s2,	t0
	lw	t0,	20(sp)
	mv	s3,	t0
	lw	t0,	24(sp)
	mv	s4,	t0
	lw	t0,	28(sp)
	mv	s5,	t0
	lw	t0,	32(sp)
	mv	s6,	t0
	lw	t0,	36(sp)
	mv	s7,	t0
	lw	t0,	40(sp)
	mv	s8,	t0
	lw	t0,	44(sp)
	mv	s9,	t0
	lw	t0,	48(sp)
	mv	s10,	t0
	lw	t0,	52(sp)
	mv	s11,	t0
	lw	t0,	4(sp)
	mv	ra,	t0
	addi	sp,	sp,	56
	ret
.Lfunc_end0:
	.globl	hello
	.p2align	2
hello
entry.1:
	addi	sp,	sp,	-120
	mv	t0,	ra
	sw	t0,	4(sp)
	mv	t0,	s0
	sw	t0,	8(sp)
	mv	t0,	s1
	sw	t0,	12(sp)
	mv	t0,	s2
	sw	t0,	16(sp)
	mv	t0,	s3
	sw	t0,	20(sp)
	mv	t0,	s4
	sw	t0,	24(sp)
	mv	t0,	s5
	sw	t0,	28(sp)
	mv	t0,	s6
	sw	t0,	32(sp)
	mv	t0,	s7
	sw	t0,	36(sp)
	mv	t0,	s8
	sw	t0,	40(sp)
	mv	t0,	s9
	sw	t0,	44(sp)
	mv	t0,	s10
	sw	t0,	48(sp)
	mv	t0,	s11
	sw	t0,	52(sp)
	#	--store i32 %x, i32* %x.addr
	sw	a0,	60(sp)
	#	--store i32 %y, i32* %y.addr
	sw	a1,	64(sp)
	#	--store i32 %z, i32* %z.addr
	sw	a2,	68(sp)
	#	--store i32 %a, i32* %a.addr
	sw	a3,	72(sp)
	#	--store i32 %b, i32* %b.addr
	sw	a4,	76(sp)
	#	--store i32 %c, i32* %c.addr
	sw	a5,	80(sp)
	#	--store i32 %d, i32* %d.addr
	sw	a6,	84(sp)
	#	--store i32 %e, i32* %e.addr
	sw	a7,	88(sp)
	#	--store i32 %hell, i32* %hell.addr
	lw	t0,	128(sp)
	sw	t0,	92(sp)
	#	--store i32 %shit, i32* %shit.addr
	lw	t0,	124(sp)
	sw	t0,	96(sp)
	#	--store i1 %fuck, i1* %fuck.addr
	lw	t0,	120(sp)
	sw	t0,	100(sp)
	#	--store i8* %damn, i8** %damn.addr
	lw	t0,	116(sp)
	sw	t0,	104(sp)
	#	--store i32 0, i32* %retval
	li	t0	0
	sw	t0,	56(sp)
	#	--%0 = load i32, i32* %hell.addr
	lw	t0,	92(sp)
	sw	t0,	108(sp)
	#	--store i32 %0, i32* %retval
	lw	t0,	108(sp)
	sw	t0,	56(sp)
	#	--br label %exit
	j	exit
exit.1:
	#	--%1 = load i32, i32* %retval
	lw	t0,	56(sp)
	sw	t0,	112(sp)
	#	--ret i32 %1
	lw	t0,	112(sp)
	mv	a0,	t0
	lw	t0,	8(sp)
	mv	s0,	t0
	lw	t0,	12(sp)
	mv	s1,	t0
	lw	t0,	16(sp)
	mv	s2,	t0
	lw	t0,	20(sp)
	mv	s3,	t0
	lw	t0,	24(sp)
	mv	s4,	t0
	lw	t0,	28(sp)
	mv	s5,	t0
	lw	t0,	32(sp)
	mv	s6,	t0
	lw	t0,	36(sp)
	mv	s7,	t0
	lw	t0,	40(sp)
	mv	s8,	t0
	lw	t0,	44(sp)
	mv	s9,	t0
	lw	t0,	48(sp)
	mv	s10,	t0
	lw	t0,	52(sp)
	mv	s11,	t0
	lw	t0,	4(sp)
	mv	ra,	t0
	addi	sp,	sp,	120
	ret
.Lfunc_end1:
	.globl	main
	.p2align	2
main
entry.2:
	addi	sp,	sp,	-112
	mv	t0,	ra
	sw	t0,	4(sp)
	mv	t0,	s0
	sw	t0,	8(sp)
	mv	t0,	s1
	sw	t0,	12(sp)
	mv	t0,	s2
	sw	t0,	16(sp)
	mv	t0,	s3
	sw	t0,	20(sp)
	mv	t0,	s4
	sw	t0,	24(sp)
	mv	t0,	s5
	sw	t0,	28(sp)
	mv	t0,	s6
	sw	t0,	32(sp)
	mv	t0,	s7
	sw	t0,	36(sp)
	mv	t0,	s8
	sw	t0,	40(sp)
	mv	t0,	s9
	sw	t0,	44(sp)
	mv	t0,	s10
	sw	t0,	48(sp)
	mv	t0,	s11
	sw	t0,	52(sp)
	#	--store i32 0, i32* %retval
	li	t0	0
	sw	t0,	56(sp)
	#	--call void @kunkun()
	call	kunkun
	#	--%call0 = call i32 @getInt()
	call	getInt
	mv	t0,	a0
	sw	t0,	64(sp)
	#	--store i32 %call0, i32* %h
	lw	t0,	64(sp)
	sw	t0,	60(sp)
	#	--%0 = load i32, i32* @he
	lui	t1,	%hi(he)
	lw	t0,	%lo(he)(t1)
	sw	t0,	68(sp)
	#	--%1 = load i32, i32* %h
	lw	t0,	60(sp)
	sw	t0,	72(sp)
	#	--%2 = load i32, i32* %h
	lw	t0,	60(sp)
	sw	t0,	76(sp)
	#	--%3 = load i32, i32* %h
	lw	t0,	60(sp)
	sw	t0,	80(sp)
	#	--%4 = load i32, i32* %h
	lw	t0,	60(sp)
	sw	t0,	84(sp)
	#	--%5 = load i32, i32* %h
	lw	t0,	60(sp)
	sw	t0,	88(sp)
	#	--%6 = load i32, i32* %h
	lw	t0,	60(sp)
	sw	t0,	92(sp)
	#	--%7 = load i32, i32* %h
	lw	t0,	60(sp)
	sw	t0,	96(sp)
	#	--%8 = getelementptr inbounds [8 x i8], [8 x i8]* @.str0, i32 0, i32 0
	#	--%call1 = call i32 @hello(i32 0, i32 99, i32 %0, i32 %1, i32 %2, i32 %3, i32 %4, i32 %5, i32 %6, i32 %7, i1 false, i8* %8)
	li	a0	0
	li	a1	99
	lw	a2,	68(sp)
	lw	a3,	72(sp)
	lw	a4,	76(sp)
	lw	a5,	80(sp)
	lw	a6,	84(sp)
	lw	a7,	88(sp)
	lw	t0,	92(sp)
	sw	t0,	0(sp)
	lw	t0,	96(sp)
	sw	t0,	-4(sp)
	li	t0	0
	sw	t0,	-8(sp)
	lw	t0,	100(sp)
	sw	t0,	-12(sp)
	call	hello
	mv	t0,	a0
	sw	t0,	104(sp)
	#	--store i32 %call1, i32* %h
	lw	t0,	104(sp)
	sw	t0,	60(sp)
	#	--store i32 0, i32* %retval
	li	t0	0
	sw	t0,	56(sp)
	#	--br label %exit
	j	exit
exit.2:
	#	--%9 = load i32, i32* %retval
	lw	t0,	56(sp)
	sw	t0,	108(sp)
	#	--ret i32 %9
	lw	t0,	108(sp)
	mv	a0,	t0
	lw	t0,	8(sp)
	mv	s0,	t0
	lw	t0,	12(sp)
	mv	s1,	t0
	lw	t0,	16(sp)
	mv	s2,	t0
	lw	t0,	20(sp)
	mv	s3,	t0
	lw	t0,	24(sp)
	mv	s4,	t0
	lw	t0,	28(sp)
	mv	s5,	t0
	lw	t0,	32(sp)
	mv	s6,	t0
	lw	t0,	36(sp)
	mv	s7,	t0
	lw	t0,	40(sp)
	mv	s8,	t0
	lw	t0,	44(sp)
	mv	s9,	t0
	lw	t0,	48(sp)
	mv	s10,	t0
	lw	t0,	52(sp)
	mv	s11,	t0
	lw	t0,	4(sp)
	mv	ra,	t0
	addi	sp,	sp,	112
	ret
.Lfunc_end2:
#    --String Constants
	.section	.rodata
.L.str0:
	.asciz	"damn it"
#    --UnInitialized Global Variables;
	.section	.sbss
he:
	.word	0
