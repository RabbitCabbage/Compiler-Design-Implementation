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
	addi	sp,	sp,	-188
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
	li	a0	5
	li	a1	20
	call	malloc_
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	56(sp)
	lw	t0,	56(sp)
	sw	t0,	80(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	80(sp)
	add	t0,	t0,	t1
	sw	t0,	84(sp)
	li	t0	99
	lw	t1,	84(sp)
	sw	t0,	0(t1)
	li	a0	5
	li	a1	20
	call	malloc_
	mv	t0,	a0
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	sw	t0,	60(sp)
	li	t0	0
	sw	t0,	64(sp)
	j	for.cond1.1
for.cond1.1:
	lw	t0,	64(sp)
	sw	t0,	96(sp)
for.body1.1:
	lw	t0,	64(sp)
	sw	t0,	104(sp)
	lw	t0,	60(sp)
	sw	t0,	108(sp)
	lw	t0,	104(sp)
	slli	t0,	t0,	2
	lw	t1,	108(sp)
	add	t0,	t0,	t1
	sw	t0,	112(sp)
	li	a0	3
	li	a1	12
	call	malloc_
	mv	t0,	a0
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	lw	t1,	112(sp)
	sw	t0,	0(t1)
	j	for.inc1.1
for.inc1.1:
	lw	t0,	64(sp)
	sw	t0,	124(sp)
	lw	t0,	128(sp)
	sw	t0,	64(sp)
	j	for.cond1.1
for.end1.1:
	lw	t0,	60(sp)
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	sw	t0,	136(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	136(sp)
	add	t0,	t0,	t1
	sw	t0,	140(sp)
	lw	t0,	140(sp)
	lw	t0,	0(t0)
	sw	t0,	144(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	144(sp)
	add	t0,	t0,	t1
	sw	t0,	148(sp)
	li	t0	999
	lw	t1,	148(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	152(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	152(sp)
	add	t0,	t0,	t1
	sw	t0,	156(sp)
	lw	t0,	156(sp)
	lw	t0,	0(t0)
	sw	t0,	160(sp)
	lw	a0,	160(sp)
	call	printInt
	lw	t0,	68(sp)
	sw	t0,	164(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	164(sp)
	add	t0,	t0,	t1
	sw	t0,	168(sp)
	lw	t0,	168(sp)
	lw	t0,	0(t0)
	sw	t0,	172(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	172(sp)
	add	t0,	t0,	t1
	sw	t0,	176(sp)
	lw	t0,	176(sp)
	lw	t0,	0(t0)
	sw	t0,	180(sp)
	lw	a0,	180(sp)
	call	printInt
	li	t0	0
	sw	t0,	52(sp)
	j	exit.1
exit.1:
	lw	t0,	52(sp)
	sw	t0,	184(sp)
	lw	t0,	184(sp)
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
	addi	sp,	sp,	188
	ret
