	.data
	.globl	b
b:
	.word	0
	.globl	.str0
.str0:
	.asciz	" "
	.globl	.str1
.str1:
	.asciz	"\n"
	.text
	.globl	kunkun
kunkun:
entry.0:
	addi	sp,	sp,	-108
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
	li	a0	3
	li	a1	12
	call	malloc_
	mv	t0,	a0
	sw	t0,	60(sp)
	lw	t0,	60(sp)
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	sw	t0,	52(sp)
	li	t0	0
	sw	t0,	56(sp)
	j	for.cond1.0
for.cond1.0:
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	li	t1	3
	slt	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	beqz	t0,	for.end1.0
	j	for.body1.0
for.body1.0:
	lw	t0,	56(sp)
	sw	t0,	76(sp)
	lw	t0,	52(sp)
	sw	t0,	80(sp)
	lw	t0,	76(sp)
	slli	t0,	t0,	2
	lw	t1,	80(sp)
	add	t0,	t0,	t1
	sw	t0,	84(sp)
	li	a0	4
	li	a1	16
	call	malloc_
	mv	t0,	a0
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	lw	t1,	84(sp)
	sw	t0,	0(t1)
	j	for.inc1.0
for.inc1.0:
	lw	t0,	56(sp)
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	sw	t0,	56(sp)
	j	for.cond1.0
for.end1.0:
	lw	t0,	52(sp)
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	lui	t1,	%hi(b)
	sw	t0,	%lo(b)(t1)
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
	addi	sp,	sp,	108
	ret
	.globl	main
main:
entry.1:
	addi	sp,	sp,	-224
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
	li	t0	0
	sw	t0,	56(sp)
	j	for.cond2.1
for.cond2.1:
	lw	t0,	56(sp)
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	li	t1	3
	slt	t0,	t0,	t1
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	beqz	t0,	for.end2.1
	j	for.body2.1
for.body2.1:
	li	t0	0
	sw	t0,	60(sp)
	j	for.cond3.1
for.cond3.1:
	lw	t0,	60(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	li	t1	4
	slt	t0,	t0,	t1
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	beqz	t0,	for.end3.1
	j	for.body3.1
for.body3.1:
	lw	t0,	60(sp)
	sw	t0,	88(sp)
	lw	t0,	56(sp)
	sw	t0,	92(sp)
	lui	t1,	%hi(b)
	lw	t0,	%lo(b)(t1)
	sw	t0,	96(sp)
	lw	t0,	92(sp)
	slli	t0,	t0,	2
	lw	t1,	96(sp)
	add	t0,	t0,	t1
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	lw	t0,	0(t0)
	sw	t0,	104(sp)
	lw	t0,	88(sp)
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	56(sp)
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	li	t1	10
	mul	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	60(sp)
	sw	t0,	124(sp)
	lw	t0,	120(sp)
	lw	t1,	124(sp)
	add	t0,	t0,	t1
	sw	t0,	128(sp)
	lw	t0,	128(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	lw	t1,	108(sp)
	sw	t0,	0(t1)
	j	for.inc3.1
for.inc3.1:
	lw	t0,	60(sp)
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	140(sp)
	lw	t0,	140(sp)
	sw	t0,	60(sp)
	j	for.cond3.1
for.end3.1:
	j	for.inc2.1
for.inc2.1:
	lw	t0,	56(sp)
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	sw	t0,	56(sp)
	j	for.cond2.1
for.end2.1:
	li	t0	0
	sw	t0,	64(sp)
	j	for.cond4.1
for.cond4.1:
	lw	t0,	64(sp)
	sw	t0,	152(sp)
	lw	t0,	152(sp)
	li	t1	3
	slt	t0,	t0,	t1
	sw	t0,	156(sp)
	lw	t0,	156(sp)
	beqz	t0,	for.end4.1
	j	for.body4.1
for.body4.1:
	li	t0	0
	sw	t0,	68(sp)
	j	for.cond5.1
for.cond5.1:
	lw	t0,	68(sp)
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	li	t1	4
	slt	t0,	t0,	t1
	sw	t0,	164(sp)
	lw	t0,	164(sp)
	beqz	t0,	for.end5.1
	j	for.body5.1
for.body5.1:
	lw	t0,	68(sp)
	sw	t0,	168(sp)
	lw	t0,	64(sp)
	sw	t0,	172(sp)
	lui	t1,	%hi(b)
	lw	t0,	%lo(b)(t1)
	sw	t0,	176(sp)
	lw	t0,	172(sp)
	slli	t0,	t0,	2
	lw	t1,	176(sp)
	add	t0,	t0,	t1
	sw	t0,	180(sp)
	lw	t0,	180(sp)
	lw	t0,	0(t0)
	sw	t0,	184(sp)
	lw	t0,	168(sp)
	slli	t0,	t0,	2
	lw	t1,	184(sp)
	add	t0,	t0,	t1
	sw	t0,	188(sp)
	lw	t0,	188(sp)
	lw	t0,	0(t0)
	sw	t0,	192(sp)
	lw	a0,	192(sp)
	call	printInt
	lui	t0,	%hi(.str0)
	addi	t0,	t0,	%lo(.str0)
	sw	t0,	196(sp)
	lw	a0,	196(sp)
	call	print
	j	for.inc5.1
for.inc5.1:
	lw	t0,	68(sp)
	sw	t0,	200(sp)
	lw	t0,	200(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	204(sp)
	lw	t0,	204(sp)
	sw	t0,	68(sp)
	j	for.cond5.1
for.end5.1:
	lui	t0,	%hi(.str1)
	addi	t0,	t0,	%lo(.str1)
	sw	t0,	208(sp)
	lw	a0,	208(sp)
	call	print
	j	for.inc4.1
for.inc4.1:
	lw	t0,	64(sp)
	sw	t0,	212(sp)
	lw	t0,	212(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	216(sp)
	lw	t0,	216(sp)
	sw	t0,	64(sp)
	j	for.cond4.1
for.end4.1:
	j	exit.1
exit.1:
	lw	t0,	52(sp)
	sw	t0,	220(sp)
	lw	t0,	220(sp)
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
	addi	sp,	sp,	224
	ret
