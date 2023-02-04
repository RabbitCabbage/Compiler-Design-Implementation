	.data
	.globl	.str0
.str0:
	.asciz	"jay chou\n\""
	.text
	.globl	kunkun
kunkun:
entry.0:
	addi	sp,	sp,	-52
	mv	t0,	ra
	sw	t0,	0(sp)
	mv	t0,	s0
	sw	t0,	4(sp)
	mv	t0,	s1
	sw	t0,	8(sp)
	mv	t0,	s2
	sw	t0,	12(sp)
	mv	t0,	s3
	sw	t0,	16(sp)
	mv	t0,	s4
	sw	t0,	20(sp)
	mv	t0,	s5
	sw	t0,	24(sp)
	mv	t0,	s6
	sw	t0,	28(sp)
	mv	t0,	s7
	sw	t0,	32(sp)
	mv	t0,	s8
	sw	t0,	36(sp)
	mv	t0,	s9
	sw	t0,	40(sp)
	mv	t0,	s10
	sw	t0,	44(sp)
	mv	t0,	s11
	sw	t0,	48(sp)
	lw	t0,	4(sp)
	mv	s0,	t0
	lw	t0,	8(sp)
	mv	s1,	t0
	lw	t0,	12(sp)
	mv	s2,	t0
	lw	t0,	16(sp)
	mv	s3,	t0
	lw	t0,	20(sp)
	mv	s4,	t0
	lw	t0,	24(sp)
	mv	s5,	t0
	lw	t0,	28(sp)
	mv	s6,	t0
	lw	t0,	32(sp)
	mv	s7,	t0
	lw	t0,	36(sp)
	mv	s8,	t0
	lw	t0,	40(sp)
	mv	s9,	t0
	lw	t0,	44(sp)
	mv	s10,	t0
	lw	t0,	48(sp)
	mv	s11,	t0
	lw	t0,	0(sp)
	mv	ra,	t0
	addi	sp,	sp,	52
	ret
	.globl	main
main:
entry.1:
	addi	sp,	sp,	-116
	mv	t0,	ra
	sw	t0,	0(sp)
	mv	t0,	s0
	sw	t0,	4(sp)
	mv	t0,	s1
	sw	t0,	8(sp)
	mv	t0,	s2
	sw	t0,	12(sp)
	mv	t0,	s3
	sw	t0,	16(sp)
	mv	t0,	s4
	sw	t0,	20(sp)
	mv	t0,	s5
	sw	t0,	24(sp)
	mv	t0,	s6
	sw	t0,	28(sp)
	mv	t0,	s7
	sw	t0,	32(sp)
	mv	t0,	s8
	sw	t0,	36(sp)
	mv	t0,	s9
	sw	t0,	40(sp)
	mv	t0,	s10
	sw	t0,	44(sp)
	mv	t0,	s11
	sw	t0,	48(sp)
	li	t0	0
	sw	t0,	52(sp)
	call	kunkun
	li	a0	0
	li	a1	16
	call	malloc_
	mv	t0,	a0
	sw	t0,	60(sp)
	lw	t0,	60(sp)
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	sw	t0,	56(sp)
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	lui	t0,	%hi(.str0)
	addi	t0,	t0,	%lo(.str0)
	sw	t0,	72(sp)
	lw	a0,	68(sp)
	li	a1	4
	li	a2	5
	lw	a3,	72(sp)
	call	init
	lw	t0,	56(sp)
	sw	t0,	76(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	76(sp)
	add	t0,	t0,	t1
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	lw	t0,	0(t0)
	sw	t0,	84(sp)
	lw	a0,	84(sp)
	call	print
	lw	t0,	56(sp)
	sw	t0,	88(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	88(sp)
	add	t0,	t0,	t1
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	lw	t0,	0(t0)
	sw	t0,	96(sp)
	lw	a0,	96(sp)
	call	printInt
	lw	t0,	56(sp)
	sw	t0,	100(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	100(sp)
	add	t0,	t0,	t1
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	lw	t0,	0(t0)
	sw	t0,	108(sp)
	lw	a0,	108(sp)
	call	printInt
	li	t0	0
	sw	t0,	52(sp)
	j	exit.1
exit.1:
	lw	t0,	52(sp)
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	mv	a0,	t0
	lw	t0,	4(sp)
	mv	s0,	t0
	lw	t0,	8(sp)
	mv	s1,	t0
	lw	t0,	12(sp)
	mv	s2,	t0
	lw	t0,	16(sp)
	mv	s3,	t0
	lw	t0,	20(sp)
	mv	s4,	t0
	lw	t0,	24(sp)
	mv	s5,	t0
	lw	t0,	28(sp)
	mv	s6,	t0
	lw	t0,	32(sp)
	mv	s7,	t0
	lw	t0,	36(sp)
	mv	s8,	t0
	lw	t0,	40(sp)
	mv	s9,	t0
	lw	t0,	44(sp)
	mv	s10,	t0
	lw	t0,	48(sp)
	mv	s11,	t0
	lw	t0,	0(sp)
	mv	ra,	t0
	addi	sp,	sp,	116
	ret
	.globl	init
init:
entry.2:
	addi	sp,	sp,	-140
	mv	t0,	ra
	sw	t0,	0(sp)
	mv	t0,	s0
	sw	t0,	4(sp)
	mv	t0,	s1
	sw	t0,	8(sp)
	mv	t0,	s2
	sw	t0,	12(sp)
	mv	t0,	s3
	sw	t0,	16(sp)
	mv	t0,	s4
	sw	t0,	20(sp)
	mv	t0,	s5
	sw	t0,	24(sp)
	mv	t0,	s6
	sw	t0,	28(sp)
	mv	t0,	s7
	sw	t0,	32(sp)
	mv	t0,	s8
	sw	t0,	36(sp)
	mv	t0,	s9
	sw	t0,	40(sp)
	mv	t0,	s10
	sw	t0,	44(sp)
	mv	t0,	s11
	sw	t0,	48(sp)
	sw	a0,	52(sp)
	sw	a1,	56(sp)
	sw	a2,	60(sp)
	sw	a3,	64(sp)
	lw	t0,	52(sp)
	sw	t0,	68(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	56(sp)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	lw	t1,	72(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	80(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	80(sp)
	add	t0,	t0,	t1
	sw	t0,	84(sp)
	lw	t0,	60(sp)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	lw	t1,	84(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	92(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	92(sp)
	add	t0,	t0,	t1
	sw	t0,	96(sp)
	lw	t0,	64(sp)
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	lw	t1,	96(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	104(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	lw	t0,	0(t0)
	sw	t0,	112(sp)
	lw	a0,	112(sp)
	call	printInt
	lw	t0,	52(sp)
	sw	t0,	116(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	116(sp)
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	lw	t0,	0(t0)
	sw	t0,	124(sp)
	lw	a0,	124(sp)
	call	printInt
	lw	t0,	52(sp)
	sw	t0,	128(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	128(sp)
	add	t0,	t0,	t1
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	lw	t0,	0(t0)
	sw	t0,	136(sp)
	lw	a0,	136(sp)
	call	print
	j	exit.2
exit.2:
	lw	t0,	4(sp)
	mv	s0,	t0
	lw	t0,	8(sp)
	mv	s1,	t0
	lw	t0,	12(sp)
	mv	s2,	t0
	lw	t0,	16(sp)
	mv	s3,	t0
	lw	t0,	20(sp)
	mv	s4,	t0
	lw	t0,	24(sp)
	mv	s5,	t0
	lw	t0,	28(sp)
	mv	s6,	t0
	lw	t0,	32(sp)
	mv	s7,	t0
	lw	t0,	36(sp)
	mv	s8,	t0
	lw	t0,	40(sp)
	mv	s9,	t0
	lw	t0,	44(sp)
	mv	s10,	t0
	lw	t0,	48(sp)
	mv	s11,	t0
	lw	t0,	0(sp)
	mv	ra,	t0
	addi	sp,	sp,	140
	ret
