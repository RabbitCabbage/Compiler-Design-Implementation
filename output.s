	.data
	.globl	N
N:
	.word	0
	.globl	M
M:
	.word	0
	.globl	ch
ch:
	.word	0
	.globl	l
l:
	.word	0
	.globl	r
r:
	.word	0
	.globl	w
w:
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
	.globl	merge
merge:
entry.1:
	addi	sp,	sp,	-248
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
	lw	t0,	56(sp)
	sw	t0,	72(sp)
	li	t0	0
	lw	t1,	72(sp)
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	beqz	t0,	if.end0.1
	j	if.then0.1
if.then0.1:
	lw	t0,	60(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	sw	t0,	52(sp)
	j	exit.1
if.end0.1:
	lw	t0,	60(sp)
	sw	t0,	84(sp)
	li	t0	0
	lw	t1,	84(sp)
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	beqz	t0,	if.end1.1
	j	if.then1.1
if.then1.1:
	lw	t0,	56(sp)
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	sw	t0,	52(sp)
	j	exit.1
if.end1.1:
	lw	t0,	56(sp)
	sw	t0,	96(sp)
	lui	t1,	%hi(w)
	lw	t0,	%lo(w)(t1)
	sw	t0,	100(sp)
	lw	t0,	96(sp)
	slli	t0,	t0,	2
	lw	t1,	100(sp)
	add	t0,	t0,	t1
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	lw	t0,	0(t0)
	sw	t0,	108(sp)
	lw	t0,	60(sp)
	sw	t0,	112(sp)
	lui	t1,	%hi(w)
	lw	t0,	%lo(w)(t1)
	sw	t0,	116(sp)
	lw	t0,	112(sp)
	slli	t0,	t0,	2
	lw	t1,	116(sp)
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	lw	t0,	0(t0)
	sw	t0,	124(sp)
	lw	t0,	108(sp)
	lw	t1,	124(sp)
	slt	t0,	t0,	t1
	sw	t0,	128(sp)
	lw	t0,	128(sp)
	beqz	t0,	if.end2.1
	j	if.then2.1
if.then2.1:
	lw	t0,	56(sp)
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	sw	t0,	64(sp)
	lw	t0,	60(sp)
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	sw	t0,	56(sp)
	lw	t0,	64(sp)
	sw	t0,	140(sp)
	lw	t0,	140(sp)
	sw	t0,	60(sp)
	j	if.end2.1
if.end2.1:
	lw	t0,	56(sp)
	sw	t0,	144(sp)
	lui	t1,	%hi(r)
	lw	t0,	%lo(r)(t1)
	sw	t0,	148(sp)
	lw	t0,	144(sp)
	slli	t0,	t0,	2
	lw	t1,	148(sp)
	add	t0,	t0,	t1
	sw	t0,	152(sp)
	lw	t0,	56(sp)
	sw	t0,	156(sp)
	lui	t1,	%hi(r)
	lw	t0,	%lo(r)(t1)
	sw	t0,	160(sp)
	lw	t0,	156(sp)
	slli	t0,	t0,	2
	lw	t1,	160(sp)
	add	t0,	t0,	t1
	sw	t0,	164(sp)
	lw	t0,	164(sp)
	lw	t0,	0(t0)
	sw	t0,	168(sp)
	lw	t0,	60(sp)
	sw	t0,	172(sp)
	lw	a0,	168(sp)
	lw	a1,	172(sp)
	call	merge
	mv	t0,	a0
	sw	t0,	176(sp)
	lw	t0,	176(sp)
	lw	t1,	152(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	180(sp)
	lui	t1,	%hi(l)
	lw	t0,	%lo(l)(t1)
	sw	t0,	184(sp)
	lw	t0,	180(sp)
	slli	t0,	t0,	2
	lw	t1,	184(sp)
	add	t0,	t0,	t1
	sw	t0,	188(sp)
	lw	t0,	188(sp)
	lw	t0,	0(t0)
	sw	t0,	192(sp)
	lw	t0,	192(sp)
	sw	t0,	68(sp)
	lw	t0,	56(sp)
	sw	t0,	196(sp)
	lui	t1,	%hi(l)
	lw	t0,	%lo(l)(t1)
	sw	t0,	200(sp)
	lw	t0,	196(sp)
	slli	t0,	t0,	2
	lw	t1,	200(sp)
	add	t0,	t0,	t1
	sw	t0,	204(sp)
	lw	t0,	56(sp)
	sw	t0,	208(sp)
	lui	t1,	%hi(r)
	lw	t0,	%lo(r)(t1)
	sw	t0,	212(sp)
	lw	t0,	208(sp)
	slli	t0,	t0,	2
	lw	t1,	212(sp)
	add	t0,	t0,	t1
	sw	t0,	216(sp)
	lw	t0,	216(sp)
	lw	t0,	0(t0)
	sw	t0,	220(sp)
	lw	t0,	220(sp)
	lw	t1,	204(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	224(sp)
	lui	t1,	%hi(r)
	lw	t0,	%lo(r)(t1)
	sw	t0,	228(sp)
	lw	t0,	224(sp)
	slli	t0,	t0,	2
	lw	t1,	228(sp)
	add	t0,	t0,	t1
	sw	t0,	232(sp)
	lw	t0,	68(sp)
	sw	t0,	236(sp)
	lw	t0,	236(sp)
	lw	t1,	232(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	240(sp)
	lw	t0,	240(sp)
	sw	t0,	52(sp)
	j	exit.1
exit.1:
	lw	t0,	52(sp)
	sw	t0,	244(sp)
	lw	t0,	244(sp)
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
	addi	sp,	sp,	248
	ret
	.globl	main
main:
entry.2:
	addi	sp,	sp,	-492
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
	call	getInt
	mv	t0,	a0
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	lui	t1,	%hi(N)
	sw	t0,	%lo(N)(t1)
	call	getInt
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	lui	t1,	%hi(M)
	sw	t0,	%lo(M)(t1)
	call	getString
	mv	t0,	a0
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	lui	t1,	%hi(ch)
	sw	t0,	%lo(ch)(t1)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	80(sp)
	lui	t1,	%hi(M)
	lw	t0,	%lo(M)(t1)
	sw	t0,	84(sp)
	lw	t0,	80(sp)
	lw	t1,	84(sp)
	add	t0,	t0,	t1
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	li	t1	5
	add	t0,	t0,	t1
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	96(sp)
	lw	a0,	92(sp)
	lw	a1,	96(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	lui	t1,	%hi(l)
	sw	t0,	%lo(l)(t1)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	108(sp)
	lui	t1,	%hi(M)
	lw	t0,	%lo(M)(t1)
	sw	t0,	112(sp)
	lw	t0,	108(sp)
	lw	t1,	112(sp)
	add	t0,	t0,	t1
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	li	t1	5
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	124(sp)
	lw	a0,	120(sp)
	lw	a1,	124(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	128(sp)
	lw	t0,	128(sp)
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	lui	t1,	%hi(r)
	sw	t0,	%lo(r)(t1)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	136(sp)
	lui	t1,	%hi(M)
	lw	t0,	%lo(M)(t1)
	sw	t0,	140(sp)
	lw	t0,	136(sp)
	lw	t1,	140(sp)
	add	t0,	t0,	t1
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	li	t1	5
	add	t0,	t0,	t1
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	152(sp)
	lw	a0,	148(sp)
	lw	a1,	152(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	156(sp)
	lw	t0,	156(sp)
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	lui	t1,	%hi(w)
	sw	t0,	%lo(w)(t1)
	li	t0	1
	sw	t0,	56(sp)
	j	for.cond1.2
for.cond1.2:
	lw	t0,	56(sp)
	sw	t0,	164(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	168(sp)
	lw	t0,	164(sp)
	lw	t1,	168(sp)
	slt	t0,	t1,	t0
	xori	t0,	t0,	1
	sw	t0,	172(sp)
	lw	t0,	172(sp)
	beqz	t0,	for.end1.2
	j	for.body1.2
for.body1.2:
	lw	t0,	56(sp)
	sw	t0,	176(sp)
	lui	t1,	%hi(w)
	lw	t0,	%lo(w)(t1)
	sw	t0,	180(sp)
	lw	t0,	176(sp)
	slli	t0,	t0,	2
	lw	t1,	180(sp)
	add	t0,	t0,	t1
	sw	t0,	184(sp)
	call	getInt
	mv	t0,	a0
	sw	t0,	188(sp)
	lw	t0,	188(sp)
	lw	t1,	184(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	192(sp)
	lui	t1,	%hi(l)
	lw	t0,	%lo(l)(t1)
	sw	t0,	196(sp)
	lw	t0,	192(sp)
	slli	t0,	t0,	2
	lw	t1,	196(sp)
	add	t0,	t0,	t1
	sw	t0,	200(sp)
	li	t0	0
	lw	t1,	200(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	204(sp)
	lui	t1,	%hi(r)
	lw	t0,	%lo(r)(t1)
	sw	t0,	208(sp)
	lw	t0,	204(sp)
	slli	t0,	t0,	2
	lw	t1,	208(sp)
	add	t0,	t0,	t1
	sw	t0,	212(sp)
	li	t0	0
	lw	t1,	212(sp)
	sw	t0,	0(t1)
	j	for.inc1.2
for.inc1.2:
	lw	t0,	56(sp)
	sw	t0,	216(sp)
	lw	t0,	216(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	220(sp)
	lw	t0,	220(sp)
	sw	t0,	56(sp)
	j	for.cond1.2
for.end1.2:
	li	t0	1
	sw	t0,	56(sp)
	j	for.cond2.2
for.cond2.2:
	lw	t0,	56(sp)
	sw	t0,	224(sp)
	lui	t1,	%hi(M)
	lw	t0,	%lo(M)(t1)
	sw	t0,	228(sp)
	lw	t0,	224(sp)
	lw	t1,	228(sp)
	slt	t0,	t1,	t0
	xori	t0,	t0,	1
	sw	t0,	232(sp)
	lw	t0,	232(sp)
	beqz	t0,	for.end2.2
	j	for.body2.2
for.body2.2:
	lw	t0,	56(sp)
	sw	t0,	236(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	240(sp)
	lw	t0,	236(sp)
	lw	t1,	240(sp)
	add	t0,	t0,	t1
	sw	t0,	244(sp)
	lui	t1,	%hi(w)
	lw	t0,	%lo(w)(t1)
	sw	t0,	248(sp)
	lw	t0,	244(sp)
	slli	t0,	t0,	2
	lw	t1,	248(sp)
	add	t0,	t0,	t1
	sw	t0,	252(sp)
	lui	t1,	%hi(ch)
	lw	t0,	%lo(ch)(t1)
	sw	t0,	256(sp)
	lw	t0,	56(sp)
	sw	t0,	260(sp)
	lw	t0,	260(sp)
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	264(sp)
	lw	a0,	256(sp)
	lw	a1,	264(sp)
	call	string_ord
	mv	t0,	a0
	sw	t0,	268(sp)
	lw	t0,	268(sp)
	lw	t1,	252(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	272(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	276(sp)
	lw	t0,	272(sp)
	lw	t1,	276(sp)
	add	t0,	t0,	t1
	sw	t0,	280(sp)
	lui	t1,	%hi(l)
	lw	t0,	%lo(l)(t1)
	sw	t0,	284(sp)
	lw	t0,	280(sp)
	slli	t0,	t0,	2
	lw	t1,	284(sp)
	add	t0,	t0,	t1
	sw	t0,	288(sp)
	li	t0	0
	lw	t1,	288(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	292(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	296(sp)
	lw	t0,	292(sp)
	lw	t1,	296(sp)
	add	t0,	t0,	t1
	sw	t0,	300(sp)
	lui	t1,	%hi(r)
	lw	t0,	%lo(r)(t1)
	sw	t0,	304(sp)
	lw	t0,	300(sp)
	slli	t0,	t0,	2
	lw	t1,	304(sp)
	add	t0,	t0,	t1
	sw	t0,	308(sp)
	li	t0	0
	lw	t1,	308(sp)
	sw	t0,	0(t1)
	j	for.inc2.2
for.inc2.2:
	lw	t0,	56(sp)
	sw	t0,	312(sp)
	lw	t0,	312(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	316(sp)
	lw	t0,	316(sp)
	sw	t0,	56(sp)
	j	for.cond2.2
for.end2.2:
	li	t0	1
	sw	t0,	60(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	320(sp)
	lw	t0,	320(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	324(sp)
	lw	t0,	324(sp)
	sw	t0,	64(sp)
	li	t0	2
	sw	t0,	56(sp)
	j	for.cond3.2
for.cond3.2:
	lw	t0,	56(sp)
	sw	t0,	328(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	332(sp)
	lw	t0,	328(sp)
	lw	t1,	332(sp)
	slt	t0,	t1,	t0
	xori	t0,	t0,	1
	sw	t0,	336(sp)
	lw	t0,	336(sp)
	beqz	t0,	for.end3.2
	j	for.body3.2
for.body3.2:
	lw	t0,	60(sp)
	sw	t0,	340(sp)
	lw	t0,	56(sp)
	sw	t0,	344(sp)
	lw	a0,	340(sp)
	lw	a1,	344(sp)
	call	merge
	mv	t0,	a0
	sw	t0,	348(sp)
	lw	t0,	348(sp)
	sw	t0,	60(sp)
	j	for.inc3.2
for.inc3.2:
	lw	t0,	56(sp)
	sw	t0,	352(sp)
	lw	t0,	352(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	356(sp)
	lw	t0,	356(sp)
	sw	t0,	56(sp)
	j	for.cond3.2
for.end3.2:
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	360(sp)
	lw	t0,	360(sp)
	li	t1	2
	add	t0,	t0,	t1
	sw	t0,	364(sp)
	lw	t0,	364(sp)
	sw	t0,	56(sp)
	j	for.cond4.2
for.cond4.2:
	lw	t0,	56(sp)
	sw	t0,	368(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	372(sp)
	lui	t1,	%hi(M)
	lw	t0,	%lo(M)(t1)
	sw	t0,	376(sp)
	lw	t0,	372(sp)
	lw	t1,	376(sp)
	add	t0,	t0,	t1
	sw	t0,	380(sp)
	lw	t0,	368(sp)
	lw	t1,	380(sp)
	slt	t0,	t1,	t0
	xori	t0,	t0,	1
	sw	t0,	384(sp)
	lw	t0,	384(sp)
	beqz	t0,	for.end4.2
	j	for.body4.2
for.body4.2:
	lw	t0,	64(sp)
	sw	t0,	388(sp)
	lw	t0,	56(sp)
	sw	t0,	392(sp)
	lw	a0,	388(sp)
	lw	a1,	392(sp)
	call	merge
	mv	t0,	a0
	sw	t0,	396(sp)
	lw	t0,	396(sp)
	sw	t0,	64(sp)
	j	for.inc4.2
for.inc4.2:
	lw	t0,	56(sp)
	sw	t0,	400(sp)
	lw	t0,	400(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	404(sp)
	lw	t0,	404(sp)
	sw	t0,	56(sp)
	j	for.cond4.2
for.end4.2:
	lw	t0,	60(sp)
	sw	t0,	408(sp)
	lui	t1,	%hi(w)
	lw	t0,	%lo(w)(t1)
	sw	t0,	412(sp)
	lw	t0,	408(sp)
	slli	t0,	t0,	2
	lw	t1,	412(sp)
	add	t0,	t0,	t1
	sw	t0,	416(sp)
	lw	t0,	416(sp)
	lw	t0,	0(t0)
	sw	t0,	420(sp)
	lw	a0,	420(sp)
	call	toString
	mv	t0,	a0
	sw	t0,	424(sp)
	lw	a0,	424(sp)
	call	print
	lui	t0,	%hi(.str0)
	addi	t0,	t0,	%lo(.str0)
	sw	t0,	428(sp)
	lw	a0,	428(sp)
	call	print
	lui	t1,	%hi(ch)
	lw	t0,	%lo(ch)(t1)
	sw	t0,	432(sp)
	lw	t0,	64(sp)
	sw	t0,	436(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	440(sp)
	lw	t0,	436(sp)
	lw	t1,	440(sp)
	sub	t0,	t0,	t1
	sw	t0,	444(sp)
	lw	t0,	444(sp)
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	448(sp)
	lw	t0,	64(sp)
	sw	t0,	452(sp)
	lui	t1,	%hi(N)
	lw	t0,	%lo(N)(t1)
	sw	t0,	456(sp)
	lw	t0,	452(sp)
	lw	t1,	456(sp)
	sub	t0,	t0,	t1
	sw	t0,	460(sp)
	lw	a0,	432(sp)
	lw	a1,	448(sp)
	lw	a2,	460(sp)
	call	string_substring
	mv	t0,	a0
	sw	t0,	464(sp)
	lw	a0,	464(sp)
	call	print
	lui	t0,	%hi(.str1)
	addi	t0,	t0,	%lo(.str1)
	sw	t0,	468(sp)
	lw	a0,	468(sp)
	call	print
	lw	t0,	60(sp)
	sw	t0,	472(sp)
	lw	t0,	64(sp)
	sw	t0,	476(sp)
	lw	a0,	472(sp)
	lw	a1,	476(sp)
	call	merge
	mv	t0,	a0
	sw	t0,	480(sp)
	lw	a0,	480(sp)
	call	toString
	mv	t0,	a0
	sw	t0,	484(sp)
	lw	a0,	484(sp)
	call	println
	li	t0	0
	sw	t0,	52(sp)
	j	exit.2
exit.2:
	lw	t0,	52(sp)
	sw	t0,	488(sp)
	lw	t0,	488(sp)
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
	addi	sp,	sp,	492
	ret
