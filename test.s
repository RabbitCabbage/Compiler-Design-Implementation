	.data
	.globl	.str0
.str0:
	.asciz	"( "
	.globl	.str1
.str1:
	.asciz	", "
	.globl	.str2
.str2:
	.asciz	" )"
	.globl	.str3
.str3:
	.asciz	"vector x: "
	.globl	.str4
.str4:
	.asciz	"excited!"
	.globl	.str5
.str5:
	.asciz	"vector y: "
	.globl	.str6
.str6:
	.asciz	"x + y: "
	.globl	.str7
.str7:
	.asciz	"x * y: "
	.globl	.str8
.str8:
	.asciz	"(1 << 3) * y: "
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
	addi	sp,	sp,	-260
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
	li	a1	4
	call	malloc_
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	56(sp)
	li	a0	10
	li	a1	40
	call	malloc_
	mv	t0,	a0
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	60(sp)
	li	t0	0
	sw	t0,	64(sp)
	j	for.cond7.1
for.cond7.1:
	lw	t0,	64(sp)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	li	t1	10
	slt	t0,	t0,	t1
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	beqz	t0,	for.end7.1
	j	for.body7.1
for.body7.1:
	lw	t0,	64(sp)
	sw	t0,	96(sp)
	lw	t0,	60(sp)
	sw	t0,	100(sp)
	lw	t0,	96(sp)
	slli	t0,	t0,	2
	lw	t1,	100(sp)
	add	t0,	t0,	t1
	sw	t0,	104(sp)
	lw	t0,	64(sp)
	sw	t0,	108(sp)
	li	t0	9
	lw	t1,	108(sp)
	sub	t0,	t0,	t1
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	lw	t1,	104(sp)
	sw	t0,	0(t1)
	j	for.inc7.1
for.inc7.1:
	lw	t0,	64(sp)
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	sw	t0,	64(sp)
	j	for.cond7.1
for.end7.1:
	lw	t0,	56(sp)
	sw	t0,	124(sp)
	lw	t0,	60(sp)
	sw	t0,	128(sp)
	lw	a0,	124(sp)
	lw	a1,	128(sp)
	call	init
	lui	t0,	%hi(.str3)
	addi	t0,	t0,	%lo(.str3)
	sw	t0,	132(sp)
	lw	a0,	132(sp)
	call	print
	lw	t0,	56(sp)
	sw	t0,	136(sp)
	lw	a0,	136(sp)
	call	tostring
	mv	t0,	a0
	sw	t0,	140(sp)
	lw	a0,	140(sp)
	call	println
	li	a0	0
	li	a1	4
	call	malloc_
	mv	t0,	a0
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	sw	t0,	152(sp)
	lw	t0,	56(sp)
	sw	t0,	156(sp)
	lw	a0,	152(sp)
	lw	a1,	156(sp)
	call	copy
	mv	t0,	a0
	sw	t0,	160(sp)
	lw	t0,	68(sp)
	sw	t0,	164(sp)
	lw	a0,	164(sp)
	li	a1	3
	li	a2	817
	call	set
	mv	t0,	a0
	sw	t0,	168(sp)
	lw	t0,	168(sp)
	beqz	t0,	if.end9.1
	j	if.then9.1
if.then9.1:
	lui	t0,	%hi(.str4)
	addi	t0,	t0,	%lo(.str4)
	sw	t0,	172(sp)
	lw	a0,	172(sp)
	call	println
	j	if.end9.1
if.end9.1:
	lui	t0,	%hi(.str5)
	addi	t0,	t0,	%lo(.str5)
	sw	t0,	176(sp)
	lw	a0,	176(sp)
	call	print
	lw	t0,	68(sp)
	sw	t0,	180(sp)
	lw	a0,	180(sp)
	call	tostring
	mv	t0,	a0
	sw	t0,	184(sp)
	lw	a0,	184(sp)
	call	println
	lui	t0,	%hi(.str6)
	addi	t0,	t0,	%lo(.str6)
	sw	t0,	188(sp)
	lw	a0,	188(sp)
	call	print
	lw	t0,	56(sp)
	sw	t0,	192(sp)
	lw	t0,	68(sp)
	sw	t0,	196(sp)
	lw	a0,	192(sp)
	lw	a1,	196(sp)
	call	add
	mv	t0,	a0
	sw	t0,	200(sp)
	lw	t0,	200(sp)
	sw	t0,	204(sp)
	lw	a0,	204(sp)
	call	tostring
	mv	t0,	a0
	sw	t0,	208(sp)
	lw	a0,	208(sp)
	call	println
	lui	t0,	%hi(.str7)
	addi	t0,	t0,	%lo(.str7)
	sw	t0,	212(sp)
	lw	a0,	212(sp)
	call	print
	lw	t0,	56(sp)
	sw	t0,	216(sp)
	lw	t0,	68(sp)
	sw	t0,	220(sp)
	lw	a0,	216(sp)
	lw	a1,	220(sp)
	call	dot
	mv	t0,	a0
	sw	t0,	224(sp)
	lw	a0,	224(sp)
	call	toString
	mv	t0,	a0
	sw	t0,	228(sp)
	lw	a0,	228(sp)
	call	println
	lui	t0,	%hi(.str8)
	addi	t0,	t0,	%lo(.str8)
	sw	t0,	232(sp)
	lw	a0,	232(sp)
	call	print
	lw	t0,	68(sp)
	sw	t0,	236(sp)
	li	t0	1
	li	t1	3
	sll	t0,	t0,	t1
	sw	t0,	240(sp)
	lw	a0,	236(sp)
	lw	a1,	240(sp)
	call	scalarInPlaceMultiply
	mv	t0,	a0
	sw	t0,	244(sp)
	lw	t0,	244(sp)
	sw	t0,	248(sp)
	lw	a0,	248(sp)
	call	tostring
	mv	t0,	a0
	sw	t0,	252(sp)
	lw	a0,	252(sp)
	call	println
	li	t0	0
	sw	t0,	52(sp)
	j	exit.1
exit.1:
	lw	t0,	52(sp)
	sw	t0,	256(sp)
	lw	t0,	256(sp)
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
	addi	sp,	sp,	260
	ret
	.globl	init
init:
entry.2:
	addi	sp,	sp,	-168
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
	lw	t0,	56(sp)
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	mv	t1,	zero
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	beqz	t0,	if.end0.2
	j	if.then0.2
if.then0.2:
	j	exit.2
if.end0.2:
	lw	t0,	52(sp)
	sw	t0,	72(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	72(sp)
	add	t0,	t0,	t1
	sw	t0,	76(sp)
	lw	t0,	56(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	sw	t0,	84(sp)
	lw	a0,	84(sp)
	call	getArraySize
	mv	t0,	a0
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	92(sp)
	lw	a0,	88(sp)
	lw	a1,	92(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	lw	t1,	76(sp)
	sw	t0,	0(t1)
	li	t0	0
	sw	t0,	60(sp)
	j	for.cond1.2
for.cond1.2:
	lw	t0,	60(sp)
	sw	t0,	104(sp)
	lw	t0,	56(sp)
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	sw	t0,	112(sp)
	lw	a0,	112(sp)
	call	getArraySize
	mv	t0,	a0
	sw	t0,	116(sp)
	lw	t0,	104(sp)
	lw	t1,	116(sp)
	slt	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	beqz	t0,	for.end1.2
	j	for.body1.2
for.body1.2:
	lw	t0,	60(sp)
	sw	t0,	124(sp)
	lw	t0,	52(sp)
	sw	t0,	128(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	128(sp)
	add	t0,	t0,	t1
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	lw	t0,	0(t0)
	sw	t0,	136(sp)
	lw	t0,	124(sp)
	slli	t0,	t0,	2
	lw	t1,	136(sp)
	add	t0,	t0,	t1
	sw	t0,	140(sp)
	lw	t0,	60(sp)
	sw	t0,	144(sp)
	lw	t0,	56(sp)
	sw	t0,	148(sp)
	lw	t0,	144(sp)
	slli	t0,	t0,	2
	lw	t1,	148(sp)
	add	t0,	t0,	t1
	sw	t0,	152(sp)
	lw	t0,	152(sp)
	lw	t0,	0(t0)
	sw	t0,	156(sp)
	lw	t0,	156(sp)
	lw	t1,	140(sp)
	sw	t0,	0(t1)
	j	for.inc1.2
for.inc1.2:
	lw	t0,	60(sp)
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	164(sp)
	lw	t0,	164(sp)
	sw	t0,	60(sp)
	j	for.cond1.2
for.end1.2:
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
	addi	sp,	sp,	168
	ret
	.globl	getDim
getDim:
entry.3:
	addi	sp,	sp,	-100
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
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	lw	t0,	0(t0)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	mv	t1,	zero
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	beqz	t0,	if.end1.3
	j	if.then1.3
if.then1.3:
	li	t0	0
	sw	t0,	52(sp)
	j	exit.3
if.end1.3:
	lw	t0,	56(sp)
	sw	t0,	76(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	76(sp)
	add	t0,	t0,	t1
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	lw	t0,	0(t0)
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	88(sp)
	lw	a0,	88(sp)
	call	getArraySize
	mv	t0,	a0
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	sw	t0,	52(sp)
	j	exit.3
exit.3:
	lw	t0,	52(sp)
	sw	t0,	96(sp)
	lw	t0,	96(sp)
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
	addi	sp,	sp,	100
	ret
	.globl	dot
dot:
entry.4:
	addi	sp,	sp,	-156
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
	sw	a1,	60(sp)
	li	t0	0
	sw	t0,	52(sp)
	li	t0	0
	sw	t0,	64(sp)
	li	t0	0
	sw	t0,	68(sp)
	j	while.cond2.4
while.cond2.4:
	lw	t0,	64(sp)
	sw	t0,	72(sp)
	lw	t0,	56(sp)
	sw	t0,	76(sp)
	lw	a0,	76(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	80(sp)
	lw	t0,	72(sp)
	lw	t1,	80(sp)
	slt	t0,	t0,	t1
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	beqz	t0,	while.end2.4
	j	while.body2.4
while.body2.4:
	lw	t0,	64(sp)
	sw	t0,	88(sp)
	lw	t0,	56(sp)
	sw	t0,	92(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	92(sp)
	add	t0,	t0,	t1
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	lw	t0,	0(t0)
	sw	t0,	100(sp)
	lw	t0,	88(sp)
	slli	t0,	t0,	2
	lw	t1,	100(sp)
	add	t0,	t0,	t1
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	lw	t0,	0(t0)
	sw	t0,	108(sp)
	lw	t0,	64(sp)
	sw	t0,	112(sp)
	lw	t0,	60(sp)
	sw	t0,	116(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	116(sp)
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	lw	t0,	0(t0)
	sw	t0,	124(sp)
	lw	t0,	112(sp)
	slli	t0,	t0,	2
	lw	t1,	124(sp)
	add	t0,	t0,	t1
	sw	t0,	128(sp)
	lw	t0,	128(sp)
	lw	t0,	0(t0)
	sw	t0,	132(sp)
	lw	t0,	108(sp)
	lw	t1,	132(sp)
	mul	t0,	t0,	t1
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	sw	t0,	68(sp)
	lw	t0,	64(sp)
	sw	t0,	140(sp)
	lw	t0,	140(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	sw	t0,	64(sp)
	j	while.cond2.4
while.end2.4:
	lw	t0,	68(sp)
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	sw	t0,	52(sp)
	j	exit.4
exit.4:
	lw	t0,	52(sp)
	sw	t0,	152(sp)
	lw	t0,	152(sp)
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
	addi	sp,	sp,	156
	ret
	.globl	scalarInPlaceMultiply
scalarInPlaceMultiply:
entry.5:
	addi	sp,	sp,	-168
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
	sw	a1,	60(sp)
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	lw	t0,	0(t0)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	mv	t1,	zero
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	beqz	t0,	if.end2.5
	j	if.then2.5
if.then2.5:
	mv	t0,	zero
	sw	t0,	52(sp)
	j	exit.5
if.end2.5:
	li	t0	0
	sw	t0,	64(sp)
	j	for.cond3.5
for.cond3.5:
	lw	t0,	64(sp)
	sw	t0,	84(sp)
	lw	t0,	56(sp)
	sw	t0,	88(sp)
	lw	a0,	88(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	92(sp)
	lw	t0,	84(sp)
	lw	t1,	92(sp)
	slt	t0,	t0,	t1
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	beqz	t0,	for.end3.5
	j	for.body3.5
for.body3.5:
	lw	t0,	64(sp)
	sw	t0,	100(sp)
	lw	t0,	56(sp)
	sw	t0,	104(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	lw	t0,	0(t0)
	sw	t0,	112(sp)
	lw	t0,	100(sp)
	slli	t0,	t0,	2
	lw	t1,	112(sp)
	add	t0,	t0,	t1
	sw	t0,	116(sp)
	lw	t0,	60(sp)
	sw	t0,	120(sp)
	lw	t0,	64(sp)
	sw	t0,	124(sp)
	lw	t0,	56(sp)
	sw	t0,	128(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	128(sp)
	add	t0,	t0,	t1
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	lw	t0,	0(t0)
	sw	t0,	136(sp)
	lw	t0,	124(sp)
	slli	t0,	t0,	2
	lw	t1,	136(sp)
	add	t0,	t0,	t1
	sw	t0,	140(sp)
	lw	t0,	140(sp)
	lw	t0,	0(t0)
	sw	t0,	144(sp)
	lw	t0,	120(sp)
	lw	t1,	144(sp)
	mul	t0,	t0,	t1
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	lw	t1,	116(sp)
	sw	t0,	0(t1)
	j	for.inc3.5
for.inc3.5:
	lw	t0,	64(sp)
	sw	t0,	152(sp)
	lw	t0,	152(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	156(sp)
	lw	t0,	156(sp)
	sw	t0,	64(sp)
	j	for.cond3.5
for.end3.5:
	lw	t0,	56(sp)
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	sw	t0,	52(sp)
	j	exit.5
exit.5:
	lw	t0,	52(sp)
	sw	t0,	164(sp)
	lw	t0,	164(sp)
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
	addi	sp,	sp,	168
	ret
	.globl	add
add:
entry.6:
	addi	sp,	sp,	-252
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
	sw	a1,	60(sp)
	lw	t0,	56(sp)
	sw	t0,	76(sp)
	lw	a0,	76(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	80(sp)
	lw	t0,	60(sp)
	sw	t0,	84(sp)
	lw	a0,	84(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	88(sp)
	lw	t0,	80(sp)
	lw	t1,	88(sp)
	sub	t0,	t0,	t1
	snez	t0,	t0
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	beqz	t0,	if.else3.6
	j	if.then3.6
if.then3.6:
	li	t0	1
	sw	t0,	64(sp)
	j	if.end3.6
if.else3.6:
	lw	t0,	56(sp)
	sw	t0,	96(sp)
	lw	a0,	96(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	li	t1	0
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	sw	t0,	64(sp)
	j	if.end3.6
if.end3.6:
	lw	t0,	64(sp)
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	beqz	t0,	if.end4.6
	j	if.then4.6
if.then4.6:
	mv	t0,	zero
	sw	t0,	52(sp)
	j	exit.6
if.end4.6:
	li	a0	0
	li	a1	4
	call	malloc_
	mv	t0,	a0
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	sw	t0,	120(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	120(sp)
	add	t0,	t0,	t1
	sw	t0,	124(sp)
	lw	t0,	56(sp)
	sw	t0,	128(sp)
	lw	a0,	128(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	136(sp)
	lw	a0,	132(sp)
	lw	a1,	136(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	140(sp)
	lw	t0,	140(sp)
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	lw	t1,	124(sp)
	sw	t0,	0(t1)
	li	t0	0
	sw	t0,	72(sp)
	j	for.cond4.6
for.cond4.6:
	lw	t0,	72(sp)
	sw	t0,	148(sp)
	lw	t0,	56(sp)
	sw	t0,	152(sp)
	lw	a0,	152(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	156(sp)
	lw	t0,	148(sp)
	lw	t1,	156(sp)
	slt	t0,	t0,	t1
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	beqz	t0,	for.end4.6
	j	for.body4.6
for.body4.6:
	lw	t0,	72(sp)
	sw	t0,	164(sp)
	lw	t0,	68(sp)
	sw	t0,	168(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	168(sp)
	add	t0,	t0,	t1
	sw	t0,	172(sp)
	lw	t0,	172(sp)
	lw	t0,	0(t0)
	sw	t0,	176(sp)
	lw	t0,	164(sp)
	slli	t0,	t0,	2
	lw	t1,	176(sp)
	add	t0,	t0,	t1
	sw	t0,	180(sp)
	lw	t0,	72(sp)
	sw	t0,	184(sp)
	lw	t0,	56(sp)
	sw	t0,	188(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	188(sp)
	add	t0,	t0,	t1
	sw	t0,	192(sp)
	lw	t0,	192(sp)
	lw	t0,	0(t0)
	sw	t0,	196(sp)
	lw	t0,	184(sp)
	slli	t0,	t0,	2
	lw	t1,	196(sp)
	add	t0,	t0,	t1
	sw	t0,	200(sp)
	lw	t0,	200(sp)
	lw	t0,	0(t0)
	sw	t0,	204(sp)
	lw	t0,	72(sp)
	sw	t0,	208(sp)
	lw	t0,	60(sp)
	sw	t0,	212(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	212(sp)
	add	t0,	t0,	t1
	sw	t0,	216(sp)
	lw	t0,	216(sp)
	lw	t0,	0(t0)
	sw	t0,	220(sp)
	lw	t0,	208(sp)
	slli	t0,	t0,	2
	lw	t1,	220(sp)
	add	t0,	t0,	t1
	sw	t0,	224(sp)
	lw	t0,	224(sp)
	lw	t0,	0(t0)
	sw	t0,	228(sp)
	lw	t0,	204(sp)
	lw	t1,	228(sp)
	add	t0,	t0,	t1
	sw	t0,	232(sp)
	lw	t0,	232(sp)
	lw	t1,	180(sp)
	sw	t0,	0(t1)
	j	for.inc4.6
for.inc4.6:
	lw	t0,	72(sp)
	sw	t0,	236(sp)
	lw	t0,	236(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	240(sp)
	lw	t0,	240(sp)
	sw	t0,	72(sp)
	j	for.cond4.6
for.end4.6:
	lw	t0,	68(sp)
	sw	t0,	244(sp)
	lw	t0,	244(sp)
	sw	t0,	52(sp)
	j	exit.6
exit.6:
	lw	t0,	52(sp)
	sw	t0,	248(sp)
	lw	t0,	248(sp)
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
	addi	sp,	sp,	252
	ret
	.globl	set
set:
entry.7:
	addi	sp,	sp,	-112
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
	sw	a1,	60(sp)
	sw	a2,	64(sp)
	li	t0	0
	sw	t0,	52(sp)
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	lw	a0,	68(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	60(sp)
	sw	t0,	76(sp)
	lw	t0,	72(sp)
	lw	t1,	76(sp)
	slt	t0,	t0,	t1
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	beqz	t0,	if.end5.7
	j	if.then5.7
if.then5.7:
	li	t0	0
	sw	t0,	52(sp)
	j	exit.7
if.end5.7:
	lw	t0,	60(sp)
	sw	t0,	84(sp)
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
	lw	t0,	84(sp)
	slli	t0,	t0,	2
	lw	t1,	96(sp)
	add	t0,	t0,	t1
	sw	t0,	100(sp)
	lw	t0,	64(sp)
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	lw	t1,	100(sp)
	sw	t0,	0(t1)
	li	t0	1
	sw	t0,	52(sp)
	j	exit.7
exit.7:
	lw	t0,	52(sp)
	sw	t0,	108(sp)
	lw	t0,	108(sp)
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
	addi	sp,	sp,	112
	ret
	.globl	tostring
tostring:
entry.8:
	addi	sp,	sp,	-204
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
	lui	t0,	%hi(.str0)
	addi	t0,	t0,	%lo(.str0)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	sw	t0,	60(sp)
	lw	t0,	56(sp)
	sw	t0,	72(sp)
	lw	a0,	72(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	li	t1	0
	slt	t0,	t1,	t0
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	beqz	t0,	if.end6.8
	j	if.then6.8
if.then6.8:
	lw	t0,	60(sp)
	sw	t0,	84(sp)
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
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	96(sp)
	add	t0,	t0,	t1
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	lw	t0,	0(t0)
	sw	t0,	104(sp)
	lw	a0,	104(sp)
	call	toString
	mv	t0,	a0
	sw	t0,	108(sp)
	lw	a0,	84(sp)
	lw	a1,	108(sp)
	call	string_concat
	mv	t0,	a0
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	sw	t0,	60(sp)
	j	if.end6.8
if.end6.8:
	li	t0	1
	sw	t0,	64(sp)
	j	for.cond5.8
for.cond5.8:
	lw	t0,	64(sp)
	sw	t0,	116(sp)
	lw	t0,	56(sp)
	sw	t0,	120(sp)
	lw	a0,	120(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	124(sp)
	lw	t0,	116(sp)
	lw	t1,	124(sp)
	slt	t0,	t0,	t1
	sw	t0,	128(sp)
	lw	t0,	128(sp)
	beqz	t0,	for.end5.8
	j	for.body5.8
for.body5.8:
	lw	t0,	60(sp)
	sw	t0,	132(sp)
	lui	t0,	%hi(.str1)
	addi	t0,	t0,	%lo(.str1)
	sw	t0,	136(sp)
	lw	a0,	132(sp)
	lw	a1,	136(sp)
	call	string_concat
	mv	t0,	a0
	sw	t0,	140(sp)
	lw	t0,	64(sp)
	sw	t0,	144(sp)
	lw	t0,	56(sp)
	sw	t0,	148(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	148(sp)
	add	t0,	t0,	t1
	sw	t0,	152(sp)
	lw	t0,	152(sp)
	lw	t0,	0(t0)
	sw	t0,	156(sp)
	lw	t0,	144(sp)
	slli	t0,	t0,	2
	lw	t1,	156(sp)
	add	t0,	t0,	t1
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	lw	t0,	0(t0)
	sw	t0,	164(sp)
	lw	a0,	164(sp)
	call	toString
	mv	t0,	a0
	sw	t0,	168(sp)
	lw	a0,	140(sp)
	lw	a1,	168(sp)
	call	string_concat
	mv	t0,	a0
	sw	t0,	172(sp)
	lw	t0,	172(sp)
	sw	t0,	60(sp)
	j	for.inc5.8
for.inc5.8:
	lw	t0,	64(sp)
	sw	t0,	176(sp)
	lw	t0,	176(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	180(sp)
	lw	t0,	180(sp)
	sw	t0,	64(sp)
	j	for.cond5.8
for.end5.8:
	lw	t0,	60(sp)
	sw	t0,	184(sp)
	lui	t0,	%hi(.str2)
	addi	t0,	t0,	%lo(.str2)
	sw	t0,	188(sp)
	lw	a0,	184(sp)
	lw	a1,	188(sp)
	call	string_concat
	mv	t0,	a0
	sw	t0,	192(sp)
	lw	t0,	192(sp)
	sw	t0,	60(sp)
	lw	t0,	60(sp)
	sw	t0,	196(sp)
	lw	t0,	196(sp)
	sw	t0,	52(sp)
	j	exit.8
exit.8:
	lw	t0,	52(sp)
	sw	t0,	200(sp)
	lw	t0,	200(sp)
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
	addi	sp,	sp,	204
	ret
	.globl	copy
copy:
entry.9:
	addi	sp,	sp,	-196
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
	sw	a1,	60(sp)
	li	t0	0
	sw	t0,	52(sp)
	lw	t0,	60(sp)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	mv	t1,	zero
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	beqz	t0,	if.end7.9
	j	if.then7.9
if.then7.9:
	li	t0	0
	sw	t0,	52(sp)
	j	exit.9
if.end7.9:
	lw	t0,	60(sp)
	sw	t0,	76(sp)
	lw	a0,	76(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	li	t1	0
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	beqz	t0,	if.else8.9
	j	if.then8.9
if.then8.9:
	lw	t0,	56(sp)
	sw	t0,	88(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	88(sp)
	add	t0,	t0,	t1
	sw	t0,	92(sp)
	mv	t0,	zero
	lw	t1,	92(sp)
	sw	t0,	0(t1)
	j	if.end8.9
if.else8.9:
	lw	t0,	56(sp)
	sw	t0,	96(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	96(sp)
	add	t0,	t0,	t1
	sw	t0,	100(sp)
	lw	t0,	60(sp)
	sw	t0,	104(sp)
	lw	a0,	104(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	112(sp)
	lw	a0,	108(sp)
	lw	a1,	112(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	lw	t1,	100(sp)
	sw	t0,	0(t1)
	li	t0	0
	sw	t0,	64(sp)
	j	for.cond6.9
for.cond6.9:
	lw	t0,	64(sp)
	sw	t0,	124(sp)
	lw	t0,	56(sp)
	sw	t0,	128(sp)
	lw	a0,	128(sp)
	call	getDim
	mv	t0,	a0
	sw	t0,	132(sp)
	lw	t0,	124(sp)
	lw	t1,	132(sp)
	slt	t0,	t0,	t1
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	beqz	t0,	for.end6.9
	j	for.body6.9
for.body6.9:
	lw	t0,	64(sp)
	sw	t0,	140(sp)
	lw	t0,	56(sp)
	sw	t0,	144(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	144(sp)
	add	t0,	t0,	t1
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	lw	t0,	0(t0)
	sw	t0,	152(sp)
	lw	t0,	140(sp)
	slli	t0,	t0,	2
	lw	t1,	152(sp)
	add	t0,	t0,	t1
	sw	t0,	156(sp)
	lw	t0,	64(sp)
	sw	t0,	160(sp)
	lw	t0,	60(sp)
	sw	t0,	164(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	164(sp)
	add	t0,	t0,	t1
	sw	t0,	168(sp)
	lw	t0,	168(sp)
	lw	t0,	0(t0)
	sw	t0,	172(sp)
	lw	t0,	160(sp)
	slli	t0,	t0,	2
	lw	t1,	172(sp)
	add	t0,	t0,	t1
	sw	t0,	176(sp)
	lw	t0,	176(sp)
	lw	t0,	0(t0)
	sw	t0,	180(sp)
	lw	t0,	180(sp)
	lw	t1,	156(sp)
	sw	t0,	0(t1)
	j	for.inc6.9
for.inc6.9:
	lw	t0,	64(sp)
	sw	t0,	184(sp)
	lw	t0,	184(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	188(sp)
	lw	t0,	188(sp)
	sw	t0,	64(sp)
	j	for.cond6.9
for.end6.9:
	j	if.end8.9
if.end8.9:
	li	t0	1
	sw	t0,	52(sp)
	j	exit.9
exit.9:
	lw	t0,	52(sp)
	sw	t0,	192(sp)
	lw	t0,	192(sp)
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
	addi	sp,	sp,	196
	ret
