	.data
	.globl	hashsize
hashsize:
	.word	0
	.globl	table
table:
	.word	0
	.globl	.str0
.str0:
	.asciz	" "
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
	li	t0	100
	lui	t1,	%hi(hashsize)
	sw	t0,	%lo(hashsize)(t1)
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
	.globl	getHash
getHash:
entry.1:
	addi	sp,	sp,	-80
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
	sw	a0,	56(sp)
	li	t0	0
	sw	t0,	52(sp)
	lw	t0,	56(sp)
	sw	t0,	60(sp)
	lw	t0,	60(sp)
	li	t1	237
	mul	t0,	t0,	t1
	sw	t0,	64(sp)
	lui	t1,	%hi(hashsize)
	lw	t0,	%lo(hashsize)(t1)
	sw	t0,	68(sp)
	lw	t0,	64(sp)
	lw	t1,	68(sp)
	rem	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	52(sp)
	j	exit.1
exit.1:
	lw	t0,	52(sp)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
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
	addi	sp,	sp,	80
	ret
	.globl	put
put:
entry.2:
	addi	sp,	sp,	-312
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
	mv	t0,	zero
	sw	t0,	64(sp)
	mv	t0,	zero
	sw	t0,	64(sp)
	lw	t0,	52(sp)
	sw	t0,	68(sp)
	lw	a0,	68(sp)
	call	getHash
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	60(sp)
	lw	t0,	60(sp)
	sw	t0,	76(sp)
	lui	t1,	%hi(table)
	lw	t0,	%lo(table)(t1)
	sw	t0,	80(sp)
	lw	t0,	76(sp)
	slli	t0,	t0,	2
	lw	t1,	80(sp)
	add	t0,	t0,	t1
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	lw	t0,	0(t0)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	mv	t1,	zero
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	beqz	t0,	if.end0.2
	j	if.then0.2
if.then0.2:
	lw	t0,	60(sp)
	sw	t0,	96(sp)
	lui	t1,	%hi(table)
	lw	t0,	%lo(table)(t1)
	sw	t0,	100(sp)
	lw	t0,	96(sp)
	slli	t0,	t0,	2
	lw	t1,	100(sp)
	add	t0,	t0,	t1
	sw	t0,	104(sp)
	li	a0	0
	li	a1	12
	call	malloc_
	mv	t0,	a0
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	lw	t1,	104(sp)
	sw	t0,	0(t1)
	lw	t0,	60(sp)
	sw	t0,	116(sp)
	lui	t1,	%hi(table)
	lw	t0,	%lo(table)(t1)
	sw	t0,	120(sp)
	lw	t0,	116(sp)
	slli	t0,	t0,	2
	lw	t1,	120(sp)
	add	t0,	t0,	t1
	sw	t0,	124(sp)
	lw	t0,	124(sp)
	lw	t0,	0(t0)
	sw	t0,	128(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	128(sp)
	add	t0,	t0,	t1
	sw	t0,	132(sp)
	lw	t0,	52(sp)
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	lw	t1,	132(sp)
	sw	t0,	0(t1)
	lw	t0,	60(sp)
	sw	t0,	140(sp)
	lui	t1,	%hi(table)
	lw	t0,	%lo(table)(t1)
	sw	t0,	144(sp)
	lw	t0,	140(sp)
	slli	t0,	t0,	2
	lw	t1,	144(sp)
	add	t0,	t0,	t1
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	lw	t0,	0(t0)
	sw	t0,	152(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	152(sp)
	add	t0,	t0,	t1
	sw	t0,	156(sp)
	lw	t0,	56(sp)
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	lw	t1,	156(sp)
	sw	t0,	0(t1)
	lw	t0,	60(sp)
	sw	t0,	164(sp)
	lui	t1,	%hi(table)
	lw	t0,	%lo(table)(t1)
	sw	t0,	168(sp)
	lw	t0,	164(sp)
	slli	t0,	t0,	2
	lw	t1,	168(sp)
	add	t0,	t0,	t1
	sw	t0,	172(sp)
	lw	t0,	172(sp)
	lw	t0,	0(t0)
	sw	t0,	176(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	176(sp)
	add	t0,	t0,	t1
	sw	t0,	180(sp)
	mv	t0,	zero
	lw	t1,	180(sp)
	sw	t0,	0(t1)
	j	exit.2
if.end0.2:
	lw	t0,	60(sp)
	sw	t0,	184(sp)
	lui	t1,	%hi(table)
	lw	t0,	%lo(table)(t1)
	sw	t0,	188(sp)
	lw	t0,	184(sp)
	slli	t0,	t0,	2
	lw	t1,	188(sp)
	add	t0,	t0,	t1
	sw	t0,	192(sp)
	lw	t0,	192(sp)
	lw	t0,	0(t0)
	sw	t0,	196(sp)
	lw	t0,	196(sp)
	sw	t0,	64(sp)
	j	while.cond1.2
while.cond1.2:
	lw	t0,	64(sp)
	sw	t0,	200(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	200(sp)
	add	t0,	t0,	t1
	sw	t0,	204(sp)
	lw	t0,	204(sp)
	lw	t0,	0(t0)
	sw	t0,	208(sp)
	lw	t0,	52(sp)
	sw	t0,	212(sp)
	lw	t0,	208(sp)
	lw	t1,	212(sp)
	sub	t0,	t0,	t1
	snez	t0,	t0
	sw	t0,	216(sp)
	lw	t0,	216(sp)
	beqz	t0,	while.end1.2
	j	while.body1.2
while.body1.2:
	lw	t0,	64(sp)
	sw	t0,	220(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	220(sp)
	add	t0,	t0,	t1
	sw	t0,	224(sp)
	lw	t0,	224(sp)
	lw	t0,	0(t0)
	sw	t0,	228(sp)
	lw	t0,	228(sp)
	mv	t1,	zero
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	232(sp)
	lw	t0,	232(sp)
	beqz	t0,	if.end1.2
	j	if.then1.2
if.then1.2:
	lw	t0,	64(sp)
	sw	t0,	236(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	236(sp)
	add	t0,	t0,	t1
	sw	t0,	240(sp)
	li	a0	0
	li	a1	12
	call	malloc_
	mv	t0,	a0
	sw	t0,	244(sp)
	lw	t0,	244(sp)
	sw	t0,	248(sp)
	lw	t0,	248(sp)
	lw	t1,	240(sp)
	sw	t0,	0(t1)
	lw	t0,	64(sp)
	sw	t0,	252(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	252(sp)
	add	t0,	t0,	t1
	sw	t0,	256(sp)
	lw	t0,	256(sp)
	lw	t0,	0(t0)
	sw	t0,	260(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	260(sp)
	add	t0,	t0,	t1
	sw	t0,	264(sp)
	lw	t0,	52(sp)
	sw	t0,	268(sp)
	lw	t0,	268(sp)
	lw	t1,	264(sp)
	sw	t0,	0(t1)
	lw	t0,	64(sp)
	sw	t0,	272(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	272(sp)
	add	t0,	t0,	t1
	sw	t0,	276(sp)
	lw	t0,	276(sp)
	lw	t0,	0(t0)
	sw	t0,	280(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	280(sp)
	add	t0,	t0,	t1
	sw	t0,	284(sp)
	mv	t0,	zero
	lw	t1,	284(sp)
	sw	t0,	0(t1)
	j	if.end1.2
if.end1.2:
	lw	t0,	64(sp)
	sw	t0,	288(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	288(sp)
	add	t0,	t0,	t1
	sw	t0,	292(sp)
	lw	t0,	292(sp)
	lw	t0,	0(t0)
	sw	t0,	296(sp)
	lw	t0,	296(sp)
	sw	t0,	64(sp)
	j	while.cond1.2
while.end1.2:
	lw	t0,	64(sp)
	sw	t0,	300(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	300(sp)
	add	t0,	t0,	t1
	sw	t0,	304(sp)
	lw	t0,	56(sp)
	sw	t0,	308(sp)
	lw	t0,	308(sp)
	lw	t1,	304(sp)
	sw	t0,	0(t1)
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
	addi	sp,	sp,	312
	ret
	.globl	get
get:
entry.3:
	addi	sp,	sp,	-132
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
	sw	a0,	56(sp)
	mv	t0,	zero
	sw	t0,	60(sp)
	li	t0	0
	sw	t0,	52(sp)
	mv	t0,	zero
	sw	t0,	60(sp)
	lw	t0,	56(sp)
	sw	t0,	64(sp)
	lw	a0,	64(sp)
	call	getHash
	mv	t0,	a0
	sw	t0,	68(sp)
	lui	t1,	%hi(table)
	lw	t0,	%lo(table)(t1)
	sw	t0,	72(sp)
	lw	t0,	68(sp)
	slli	t0,	t0,	2
	lw	t1,	72(sp)
	add	t0,	t0,	t1
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	lw	t0,	0(t0)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	sw	t0,	60(sp)
	j	while.cond2.3
while.cond2.3:
	lw	t0,	60(sp)
	sw	t0,	84(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	84(sp)
	add	t0,	t0,	t1
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	lw	t0,	0(t0)
	sw	t0,	92(sp)
	lw	t0,	56(sp)
	sw	t0,	96(sp)
	lw	t0,	92(sp)
	lw	t1,	96(sp)
	sub	t0,	t0,	t1
	snez	t0,	t0
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	beqz	t0,	while.end2.3
	j	while.body2.3
while.body2.3:
	lw	t0,	60(sp)
	sw	t0,	104(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	lw	t0,	0(t0)
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	sw	t0,	60(sp)
	j	while.cond2.3
while.end2.3:
	lw	t0,	60(sp)
	sw	t0,	116(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	116(sp)
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	lw	t0,	0(t0)
	sw	t0,	124(sp)
	lw	t0,	124(sp)
	sw	t0,	52(sp)
	j	exit.3
exit.3:
	lw	t0,	52(sp)
	sw	t0,	128(sp)
	lw	t0,	128(sp)
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
	addi	sp,	sp,	132
	ret
	.globl	main
main:
entry.4:
	addi	sp,	sp,	-176
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
	li	a0	100
	li	a1	400
	call	malloc_
	mv	t0,	a0
	sw	t0,	60(sp)
	lw	t0,	60(sp)
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	lui	t1,	%hi(table)
	sw	t0,	%lo(table)(t1)
	li	t0	0
	sw	t0,	56(sp)
	j	for.cond3.4
for.cond3.4:
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	lui	t1,	%hi(hashsize)
	lw	t0,	%lo(hashsize)(t1)
	sw	t0,	72(sp)
	lw	t0,	68(sp)
	lw	t1,	72(sp)
	slt	t0,	t0,	t1
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	beqz	t0,	for.end3.4
	j	for.body3.4
for.body3.4:
	lw	t0,	56(sp)
	sw	t0,	80(sp)
	lui	t1,	%hi(table)
	lw	t0,	%lo(table)(t1)
	sw	t0,	84(sp)
	lw	t0,	80(sp)
	slli	t0,	t0,	2
	lw	t1,	84(sp)
	add	t0,	t0,	t1
	sw	t0,	88(sp)
	mv	t0,	zero
	lw	t1,	88(sp)
	sw	t0,	0(t1)
	j	for.inc3.4
for.inc3.4:
	lw	t0,	56(sp)
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	sw	t0,	56(sp)
	j	for.cond3.4
for.end3.4:
	li	t0	0
	sw	t0,	56(sp)
	j	for.cond4.4
for.cond4.4:
	lw	t0,	56(sp)
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	li	t1	1000
	slt	t0,	t0,	t1
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	beqz	t0,	for.end4.4
	j	for.body4.4
for.body4.4:
	lw	t0,	56(sp)
	sw	t0,	108(sp)
	lw	t0,	56(sp)
	sw	t0,	112(sp)
	lw	a0,	108(sp)
	lw	a1,	112(sp)
	call	put
	j	for.inc4.4
for.inc4.4:
	lw	t0,	56(sp)
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	sw	t0,	56(sp)
	j	for.cond4.4
for.end4.4:
	li	t0	0
	sw	t0,	56(sp)
	j	for.cond5.4
for.cond5.4:
	lw	t0,	56(sp)
	sw	t0,	124(sp)
	lw	t0,	124(sp)
	li	t1	1000
	slt	t0,	t0,	t1
	sw	t0,	128(sp)
	lw	t0,	128(sp)
	beqz	t0,	for.end5.4
	j	for.body5.4
for.body5.4:
	lw	t0,	56(sp)
	sw	t0,	132(sp)
	lw	a0,	132(sp)
	call	toString
	mv	t0,	a0
	sw	t0,	136(sp)
	lui	t0,	%hi(.str0)
	addi	t0,	t0,	%lo(.str0)
	sw	t0,	140(sp)
	lw	a0,	136(sp)
	lw	a1,	140(sp)
	call	string_concat
	mv	t0,	a0
	sw	t0,	144(sp)
	lw	t0,	56(sp)
	sw	t0,	148(sp)
	lw	a0,	148(sp)
	call	get
	mv	t0,	a0
	sw	t0,	152(sp)
	lw	a0,	152(sp)
	call	toString
	mv	t0,	a0
	sw	t0,	156(sp)
	lw	a0,	144(sp)
	lw	a1,	156(sp)
	call	string_concat
	mv	t0,	a0
	sw	t0,	160(sp)
	lw	a0,	160(sp)
	call	println
	j	for.inc5.4
for.inc5.4:
	lw	t0,	56(sp)
	sw	t0,	164(sp)
	lw	t0,	164(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	168(sp)
	lw	t0,	168(sp)
	sw	t0,	56(sp)
	j	for.cond5.4
for.end5.4:
	li	t0	0
	sw	t0,	52(sp)
	j	exit.4
exit.4:
	lw	t0,	52(sp)
	sw	t0,	172(sp)
	lw	t0,	172(sp)
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
	addi	sp,	sp,	176
	ret
