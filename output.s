	.data
	.globl	n1
n1:
	.word	0
	.globl	m1
m1:
	.word	0
	.globl	g
g:
	.word	0
	.globl	INF
INF:
	.word	0
	.globl	.str0
.str0:
	.asciz	"-1"
	.globl	.str1
.str1:
	.asciz	" "
	.globl	.str2
.str2:
	.asciz	""
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
	li	t0	10000000
	lui	t1,	%hi(INF)
	sw	t0,	%lo(INF)(t1)
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
	.globl	init
init:
entry.1:
	addi	sp,	sp,	-144
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
	call	getInt
	mv	t0,	a0
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	lui	t1,	%hi(n1)
	sw	t0,	%lo(n1)(t1)
	call	getInt
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	lui	t1,	%hi(m1)
	sw	t0,	%lo(m1)(t1)
	li	a0	0
	li	a1	16
	call	malloc_
	mv	t0,	a0
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	lui	t1,	%hi(g)
	sw	t0,	%lo(g)(t1)
	lui	t1,	%hi(g)
	lw	t0,	%lo(g)(t1)
	sw	t0,	84(sp)
	lui	t1,	%hi(n1)
	lw	t0,	%lo(n1)(t1)
	sw	t0,	88(sp)
	lui	t1,	%hi(m1)
	lw	t0,	%lo(m1)(t1)
	sw	t0,	92(sp)
	lw	a0,	84(sp)
	lw	a1,	88(sp)
	lw	a2,	92(sp)
	call	init1
	li	t0	0
	sw	t0,	52(sp)
	j	for.cond6.1
for.cond6.1:
	lw	t0,	52(sp)
	sw	t0,	96(sp)
	lui	t1,	%hi(m1)
	lw	t0,	%lo(m1)(t1)
	sw	t0,	100(sp)
	lw	t0,	96(sp)
	lw	t1,	100(sp)
	slt	t0,	t0,	t1
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	beqz	t0,	for.end6.1
	j	for.body6.1
for.body6.1:
	call	getInt
	mv	t0,	a0
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	sw	t0,	56(sp)
	call	getInt
	mv	t0,	a0
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	sw	t0,	60(sp)
	call	getInt
	mv	t0,	a0
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	sw	t0,	64(sp)
	lui	t1,	%hi(g)
	lw	t0,	%lo(g)(t1)
	sw	t0,	120(sp)
	lw	t0,	56(sp)
	sw	t0,	124(sp)
	lw	t0,	60(sp)
	sw	t0,	128(sp)
	lw	t0,	64(sp)
	sw	t0,	132(sp)
	lw	a0,	120(sp)
	lw	a1,	124(sp)
	lw	a2,	128(sp)
	lw	a3,	132(sp)
	call	addEdge
	j	for.inc6.1
for.inc6.1:
	lw	t0,	52(sp)
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	140(sp)
	lw	t0,	140(sp)
	sw	t0,	52(sp)
	j	for.cond6.1
for.end6.1:
	j	exit.1
exit.1:
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
	addi	sp,	sp,	144
	ret
	.globl	dijkstra
dijkstra:
entry.2:
	addi	sp,	sp,	-556
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
	lui	t1,	%hi(n1)
	lw	t0,	%lo(n1)(t1)
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	a0,	104(sp)
	lw	a1,	108(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	sw	t0,	116(sp)
	lw	t0,	116(sp)
	sw	t0,	60(sp)
	lui	t1,	%hi(n1)
	lw	t0,	%lo(n1)(t1)
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
	sw	t0,	64(sp)
	li	t0	0
	sw	t0,	68(sp)
	j	for.cond7.2
for.cond7.2:
	lw	t0,	68(sp)
	sw	t0,	136(sp)
	lui	t1,	%hi(n1)
	lw	t0,	%lo(n1)(t1)
	sw	t0,	140(sp)
	lw	t0,	136(sp)
	lw	t1,	140(sp)
	slt	t0,	t0,	t1
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	beqz	t0,	for.end7.2
	j	for.body7.2
for.body7.2:
	lw	t0,	68(sp)
	sw	t0,	148(sp)
	lw	t0,	64(sp)
	sw	t0,	152(sp)
	lw	t0,	148(sp)
	slli	t0,	t0,	2
	lw	t1,	152(sp)
	add	t0,	t0,	t1
	sw	t0,	156(sp)
	lui	t1,	%hi(INF)
	lw	t0,	%lo(INF)(t1)
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	lw	t1,	156(sp)
	sw	t0,	0(t1)
	lw	t0,	68(sp)
	sw	t0,	164(sp)
	lw	t0,	60(sp)
	sw	t0,	168(sp)
	lw	t0,	164(sp)
	slli	t0,	t0,	2
	lw	t1,	168(sp)
	add	t0,	t0,	t1
	sw	t0,	172(sp)
	li	t0	0
	lw	t1,	172(sp)
	sw	t0,	0(t1)
	j	for.inc7.2
for.inc7.2:
	lw	t0,	68(sp)
	sw	t0,	176(sp)
	lw	t0,	176(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	180(sp)
	lw	t0,	180(sp)
	sw	t0,	68(sp)
	j	for.cond7.2
for.end7.2:
	lw	t0,	56(sp)
	sw	t0,	184(sp)
	lw	t0,	64(sp)
	sw	t0,	188(sp)
	lw	t0,	184(sp)
	slli	t0,	t0,	2
	lw	t1,	188(sp)
	add	t0,	t0,	t1
	sw	t0,	192(sp)
	li	t0	0
	lw	t1,	192(sp)
	sw	t0,	0(t1)
	li	a0	0
	li	a1	4
	call	malloc_
	mv	t0,	a0
	sw	t0,	196(sp)
	lw	t0,	196(sp)
	sw	t0,	200(sp)
	lw	a0,	200(sp)
	call	Heap_Node
	mv	t0,	a0
	sw	t0,	204(sp)
	lw	t0,	204(sp)
	sw	t0,	72(sp)
	li	a0	0
	li	a1	8
	call	malloc_
	mv	t0,	a0
	sw	t0,	208(sp)
	lw	t0,	208(sp)
	sw	t0,	212(sp)
	lw	t0,	212(sp)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	216(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	216(sp)
	add	t0,	t0,	t1
	sw	t0,	220(sp)
	li	t0	0
	lw	t1,	220(sp)
	sw	t0,	0(t1)
	lw	t0,	76(sp)
	sw	t0,	224(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	224(sp)
	add	t0,	t0,	t1
	sw	t0,	228(sp)
	lw	t0,	56(sp)
	sw	t0,	232(sp)
	lw	t0,	232(sp)
	lw	t1,	228(sp)
	sw	t0,	0(t1)
	lw	t0,	72(sp)
	sw	t0,	236(sp)
	lw	t0,	76(sp)
	sw	t0,	240(sp)
	lw	a0,	236(sp)
	lw	a1,	240(sp)
	call	push
	j	while.cond8.2
while.cond8.2:
	lw	t0,	72(sp)
	sw	t0,	244(sp)
	lw	a0,	244(sp)
	call	size1
	mv	t0,	a0
	sw	t0,	248(sp)
	lw	t0,	248(sp)
	li	t1	0
	sub	t0,	t0,	t1
	snez	t0,	t0
	sw	t0,	252(sp)
	lw	t0,	252(sp)
	beqz	t0,	while.end8.2
	j	while.body8.2
while.body8.2:
	lw	t0,	72(sp)
	sw	t0,	256(sp)
	lw	a0,	256(sp)
	call	pop
	mv	t0,	a0
	sw	t0,	260(sp)
	lw	t0,	260(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	sw	t0,	264(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	264(sp)
	add	t0,	t0,	t1
	sw	t0,	268(sp)
	lw	t0,	268(sp)
	lw	t0,	0(t0)
	sw	t0,	272(sp)
	lw	t0,	272(sp)
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	276(sp)
	lw	t0,	60(sp)
	sw	t0,	280(sp)
	lw	t0,	276(sp)
	slli	t0,	t0,	2
	lw	t1,	280(sp)
	add	t0,	t0,	t1
	sw	t0,	284(sp)
	lw	t0,	284(sp)
	lw	t0,	0(t0)
	sw	t0,	288(sp)
	lw	t0,	288(sp)
	li	t1	1
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	292(sp)
	lw	t0,	292(sp)
	beqz	t0,	if.end7.2
	j	if.then7.2
if.then7.2:
	j	while.cond8.2
if.end7.2:
	lw	t0,	84(sp)
	sw	t0,	296(sp)
	lw	t0,	60(sp)
	sw	t0,	300(sp)
	lw	t0,	296(sp)
	slli	t0,	t0,	2
	lw	t1,	300(sp)
	add	t0,	t0,	t1
	sw	t0,	304(sp)
	li	t0	1
	lw	t1,	304(sp)
	sw	t0,	0(t1)
	lw	t0,	84(sp)
	sw	t0,	308(sp)
	lui	t1,	%hi(g)
	lw	t0,	%lo(g)(t1)
	sw	t0,	312(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	312(sp)
	add	t0,	t0,	t1
	sw	t0,	316(sp)
	lw	t0,	316(sp)
	lw	t0,	0(t0)
	sw	t0,	320(sp)
	lw	t0,	308(sp)
	slli	t0,	t0,	2
	lw	t1,	320(sp)
	add	t0,	t0,	t1
	sw	t0,	324(sp)
	lw	t0,	324(sp)
	lw	t0,	0(t0)
	sw	t0,	328(sp)
	lw	t0,	328(sp)
	sw	t0,	88(sp)
	j	for.cond9.2
for.cond9.2:
	lw	t0,	88(sp)
	sw	t0,	332(sp)
	li	t0	0
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	336(sp)
	lw	t0,	332(sp)
	lw	t1,	336(sp)
	sub	t0,	t0,	t1
	snez	t0,	t0
	sw	t0,	340(sp)
	lw	t0,	340(sp)
	beqz	t0,	for.end9.2
	j	for.body9.2
for.body9.2:
	lw	t0,	88(sp)
	sw	t0,	344(sp)
	lui	t1,	%hi(g)
	lw	t0,	%lo(g)(t1)
	sw	t0,	348(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	348(sp)
	add	t0,	t0,	t1
	sw	t0,	352(sp)
	lw	t0,	352(sp)
	lw	t0,	0(t0)
	sw	t0,	356(sp)
	lw	t0,	344(sp)
	slli	t0,	t0,	2
	lw	t1,	356(sp)
	add	t0,	t0,	t1
	sw	t0,	360(sp)
	lw	t0,	360(sp)
	lw	t0,	0(t0)
	sw	t0,	364(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	364(sp)
	add	t0,	t0,	t1
	sw	t0,	368(sp)
	lw	t0,	368(sp)
	lw	t0,	0(t0)
	sw	t0,	372(sp)
	lw	t0,	372(sp)
	sw	t0,	92(sp)
	lw	t0,	88(sp)
	sw	t0,	376(sp)
	lui	t1,	%hi(g)
	lw	t0,	%lo(g)(t1)
	sw	t0,	380(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	380(sp)
	add	t0,	t0,	t1
	sw	t0,	384(sp)
	lw	t0,	384(sp)
	lw	t0,	0(t0)
	sw	t0,	388(sp)
	lw	t0,	376(sp)
	slli	t0,	t0,	2
	lw	t1,	388(sp)
	add	t0,	t0,	t1
	sw	t0,	392(sp)
	lw	t0,	392(sp)
	lw	t0,	0(t0)
	sw	t0,	396(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	396(sp)
	add	t0,	t0,	t1
	sw	t0,	400(sp)
	lw	t0,	400(sp)
	lw	t0,	0(t0)
	sw	t0,	404(sp)
	lw	t0,	404(sp)
	sw	t0,	96(sp)
	lw	t0,	84(sp)
	sw	t0,	408(sp)
	lw	t0,	64(sp)
	sw	t0,	412(sp)
	lw	t0,	408(sp)
	slli	t0,	t0,	2
	lw	t1,	412(sp)
	add	t0,	t0,	t1
	sw	t0,	416(sp)
	lw	t0,	416(sp)
	lw	t0,	0(t0)
	sw	t0,	420(sp)
	lw	t0,	96(sp)
	sw	t0,	424(sp)
	lw	t0,	420(sp)
	lw	t1,	424(sp)
	add	t0,	t0,	t1
	sw	t0,	428(sp)
	lw	t0,	428(sp)
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	sw	t0,	432(sp)
	lw	t0,	92(sp)
	sw	t0,	436(sp)
	lw	t0,	64(sp)
	sw	t0,	440(sp)
	lw	t0,	436(sp)
	slli	t0,	t0,	2
	lw	t1,	440(sp)
	add	t0,	t0,	t1
	sw	t0,	444(sp)
	lw	t0,	444(sp)
	lw	t0,	0(t0)
	sw	t0,	448(sp)
	lw	t0,	432(sp)
	lw	t1,	448(sp)
	slt	t0,	t0,	t1
	xori	t0,	t0,	1
	sw	t0,	452(sp)
	lw	t0,	452(sp)
	beqz	t0,	if.end8.2
	j	if.then8.2
if.then8.2:
	j	for.inc9.2
if.end8.2:
	lw	t0,	92(sp)
	sw	t0,	456(sp)
	lw	t0,	64(sp)
	sw	t0,	460(sp)
	lw	t0,	456(sp)
	slli	t0,	t0,	2
	lw	t1,	460(sp)
	add	t0,	t0,	t1
	sw	t0,	464(sp)
	lw	t0,	100(sp)
	sw	t0,	468(sp)
	lw	t0,	468(sp)
	lw	t1,	464(sp)
	sw	t0,	0(t1)
	li	a0	0
	li	a1	8
	call	malloc_
	mv	t0,	a0
	sw	t0,	472(sp)
	lw	t0,	472(sp)
	sw	t0,	476(sp)
	lw	t0,	476(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	sw	t0,	480(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	480(sp)
	add	t0,	t0,	t1
	sw	t0,	484(sp)
	lw	t0,	92(sp)
	sw	t0,	488(sp)
	lw	t0,	488(sp)
	lw	t1,	484(sp)
	sw	t0,	0(t1)
	lw	t0,	80(sp)
	sw	t0,	492(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	492(sp)
	add	t0,	t0,	t1
	sw	t0,	496(sp)
	lw	t0,	92(sp)
	sw	t0,	500(sp)
	lw	t0,	64(sp)
	sw	t0,	504(sp)
	lw	t0,	500(sp)
	slli	t0,	t0,	2
	lw	t1,	504(sp)
	add	t0,	t0,	t1
	sw	t0,	508(sp)
	lw	t0,	508(sp)
	lw	t0,	0(t0)
	sw	t0,	512(sp)
	lw	t0,	512(sp)
	lw	t1,	496(sp)
	sw	t0,	0(t1)
	lw	t0,	72(sp)
	sw	t0,	516(sp)
	lw	t0,	80(sp)
	sw	t0,	520(sp)
	lw	a0,	516(sp)
	lw	a1,	520(sp)
	call	push
	j	for.inc9.2
for.inc9.2:
	lw	t0,	88(sp)
	sw	t0,	524(sp)
	lui	t1,	%hi(g)
	lw	t0,	%lo(g)(t1)
	sw	t0,	528(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	528(sp)
	add	t0,	t0,	t1
	sw	t0,	532(sp)
	lw	t0,	532(sp)
	lw	t0,	0(t0)
	sw	t0,	536(sp)
	lw	t0,	524(sp)
	slli	t0,	t0,	2
	lw	t1,	536(sp)
	add	t0,	t0,	t1
	sw	t0,	540(sp)
	lw	t0,	540(sp)
	lw	t0,	0(t0)
	sw	t0,	544(sp)
	lw	t0,	544(sp)
	sw	t0,	88(sp)
	j	for.cond9.2
for.end9.2:
	j	while.cond8.2
while.end8.2:
	lw	t0,	64(sp)
	sw	t0,	548(sp)
	lw	t0,	548(sp)
	sw	t0,	52(sp)
	j	exit.2
exit.2:
	lw	t0,	52(sp)
	sw	t0,	552(sp)
	lw	t0,	552(sp)
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
	addi	sp,	sp,	556
	ret
	.globl	main
main:
entry.3:
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
	call	init
	li	t0	0
	sw	t0,	56(sp)
	j	for.cond10.3
for.cond10.3:
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	lui	t1,	%hi(n1)
	lw	t0,	%lo(n1)(t1)
	sw	t0,	72(sp)
	lw	t0,	68(sp)
	lw	t1,	72(sp)
	slt	t0,	t0,	t1
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	beqz	t0,	for.end10.3
	j	for.body10.3
for.body10.3:
	lw	t0,	56(sp)
	sw	t0,	80(sp)
	lw	a0,	80(sp)
	call	dijkstra
	mv	t0,	a0
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	64(sp)
	li	t0	0
	sw	t0,	60(sp)
	j	for.cond11.3
for.cond11.3:
	lw	t0,	60(sp)
	sw	t0,	88(sp)
	lui	t1,	%hi(n1)
	lw	t0,	%lo(n1)(t1)
	sw	t0,	92(sp)
	lw	t0,	88(sp)
	lw	t1,	92(sp)
	slt	t0,	t0,	t1
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	beqz	t0,	for.end11.3
	j	for.body11.3
for.body11.3:
	lw	t0,	60(sp)
	sw	t0,	100(sp)
	lw	t0,	64(sp)
	sw	t0,	104(sp)
	lw	t0,	100(sp)
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	lw	t0,	0(t0)
	sw	t0,	112(sp)
	lui	t1,	%hi(INF)
	lw	t0,	%lo(INF)(t1)
	sw	t0,	116(sp)
	lw	t0,	112(sp)
	lw	t1,	116(sp)
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	beqz	t0,	if.else9.3
	j	if.then9.3
if.then9.3:
	lui	t0,	%hi(.str0)
	addi	t0,	t0,	%lo(.str0)
	sw	t0,	124(sp)
	lw	a0,	124(sp)
	call	print
	j	if.end9.3
if.else9.3:
	lw	t0,	60(sp)
	sw	t0,	128(sp)
	lw	t0,	64(sp)
	sw	t0,	132(sp)
	lw	t0,	128(sp)
	slli	t0,	t0,	2
	lw	t1,	132(sp)
	add	t0,	t0,	t1
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	lw	t0,	0(t0)
	sw	t0,	140(sp)
	lw	a0,	140(sp)
	call	toString
	mv	t0,	a0
	sw	t0,	144(sp)
	lw	a0,	144(sp)
	call	print
	j	if.end9.3
if.end9.3:
	lui	t0,	%hi(.str1)
	addi	t0,	t0,	%lo(.str1)
	sw	t0,	148(sp)
	lw	a0,	148(sp)
	call	print
	j	for.inc11.3
for.inc11.3:
	lw	t0,	60(sp)
	sw	t0,	152(sp)
	lw	t0,	152(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	156(sp)
	lw	t0,	156(sp)
	sw	t0,	60(sp)
	j	for.cond11.3
for.end11.3:
	lui	t0,	%hi(.str2)
	addi	t0,	t0,	%lo(.str2)
	sw	t0,	160(sp)
	lw	a0,	160(sp)
	call	println
	j	for.inc10.3
for.inc10.3:
	lw	t0,	56(sp)
	sw	t0,	164(sp)
	lw	t0,	164(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	168(sp)
	lw	t0,	168(sp)
	sw	t0,	56(sp)
	j	for.cond10.3
for.end10.3:
	li	t0	0
	sw	t0,	52(sp)
	j	exit.3
exit.3:
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
	.globl	init1
init1:
entry.4:
	addi	sp,	sp,	-236
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
	lw	t0,	52(sp)
	sw	t0,	68(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	60(sp)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	80(sp)
	lw	a0,	76(sp)
	lw	a1,	80(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	lw	t1,	72(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	92(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	92(sp)
	add	t0,	t0,	t1
	sw	t0,	96(sp)
	lw	t0,	60(sp)
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	104(sp)
	lw	a0,	100(sp)
	lw	a1,	104(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	lw	t1,	96(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	116(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	116(sp)
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	56(sp)
	sw	t0,	124(sp)
	lw	t0,	124(sp)
	li	t1	4
	mul	t0,	t0,	t1
	sw	t0,	128(sp)
	lw	a0,	124(sp)
	lw	a1,	128(sp)
	call	malloc_
	mv	t0,	a0
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	lw	t1,	120(sp)
	sw	t0,	0(t1)
	li	t0	0
	sw	t0,	64(sp)
	j	for.cond1.4
for.cond1.4:
	lw	t0,	64(sp)
	sw	t0,	140(sp)
	lw	t0,	60(sp)
	sw	t0,	144(sp)
	lw	t0,	140(sp)
	lw	t1,	144(sp)
	slt	t0,	t0,	t1
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	beqz	t0,	for.end1.4
	j	for.body1.4
for.body1.4:
	lw	t0,	64(sp)
	sw	t0,	152(sp)
	lw	t0,	52(sp)
	sw	t0,	156(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	156(sp)
	add	t0,	t0,	t1
	sw	t0,	160(sp)
	lw	t0,	160(sp)
	lw	t0,	0(t0)
	sw	t0,	164(sp)
	lw	t0,	152(sp)
	slli	t0,	t0,	2
	lw	t1,	164(sp)
	add	t0,	t0,	t1
	sw	t0,	168(sp)
	li	t0	0
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	172(sp)
	lw	t0,	172(sp)
	lw	t1,	168(sp)
	sw	t0,	0(t1)
	j	for.inc1.4
for.inc1.4:
	lw	t0,	64(sp)
	sw	t0,	176(sp)
	lw	t0,	176(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	180(sp)
	lw	t0,	180(sp)
	sw	t0,	64(sp)
	j	for.cond1.4
for.end1.4:
	li	t0	0
	sw	t0,	64(sp)
	j	for.cond2.4
for.cond2.4:
	lw	t0,	64(sp)
	sw	t0,	184(sp)
	lw	t0,	56(sp)
	sw	t0,	188(sp)
	lw	t0,	184(sp)
	lw	t1,	188(sp)
	slt	t0,	t0,	t1
	sw	t0,	192(sp)
	lw	t0,	192(sp)
	beqz	t0,	for.end2.4
	j	for.body2.4
for.body2.4:
	lw	t0,	64(sp)
	sw	t0,	196(sp)
	lw	t0,	52(sp)
	sw	t0,	200(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	200(sp)
	add	t0,	t0,	t1
	sw	t0,	204(sp)
	lw	t0,	204(sp)
	lw	t0,	0(t0)
	sw	t0,	208(sp)
	lw	t0,	196(sp)
	slli	t0,	t0,	2
	lw	t1,	208(sp)
	add	t0,	t0,	t1
	sw	t0,	212(sp)
	li	t0	0
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	216(sp)
	lw	t0,	216(sp)
	lw	t1,	212(sp)
	sw	t0,	0(t1)
	j	for.inc2.4
for.inc2.4:
	lw	t0,	64(sp)
	sw	t0,	220(sp)
	lw	t0,	220(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	224(sp)
	lw	t0,	224(sp)
	sw	t0,	64(sp)
	j	for.cond2.4
for.end2.4:
	lw	t0,	52(sp)
	sw	t0,	228(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	228(sp)
	add	t0,	t0,	t1
	sw	t0,	232(sp)
	li	t0	0
	lw	t1,	232(sp)
	sw	t0,	0(t1)
	j	exit.4
exit.4:
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
	addi	sp,	sp,	236
	ret
	.globl	addEdge
addEdge:
entry.5:
	addi	sp,	sp,	-256
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
	li	a0	0
	li	a1	12
	call	malloc_
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	sw	t0,	80(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	80(sp)
	add	t0,	t0,	t1
	sw	t0,	84(sp)
	lw	t0,	56(sp)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	lw	t1,	84(sp)
	sw	t0,	0(t1)
	lw	t0,	68(sp)
	sw	t0,	92(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	92(sp)
	add	t0,	t0,	t1
	sw	t0,	96(sp)
	lw	t0,	60(sp)
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	lw	t1,	96(sp)
	sw	t0,	0(t1)
	lw	t0,	68(sp)
	sw	t0,	104(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	64(sp)
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	lw	t1,	108(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	116(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	116(sp)
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	lw	t0,	0(t0)
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
	lw	t0,	68(sp)
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	lw	t1,	140(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	148(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	148(sp)
	add	t0,	t0,	t1
	sw	t0,	152(sp)
	lw	t0,	152(sp)
	lw	t0,	0(t0)
	sw	t0,	156(sp)
	lw	t0,	52(sp)
	sw	t0,	160(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	160(sp)
	add	t0,	t0,	t1
	sw	t0,	164(sp)
	lw	t0,	164(sp)
	lw	t0,	0(t0)
	sw	t0,	168(sp)
	lw	t0,	156(sp)
	slli	t0,	t0,	2
	lw	t1,	168(sp)
	add	t0,	t0,	t1
	sw	t0,	172(sp)
	lw	t0,	56(sp)
	sw	t0,	176(sp)
	lw	t0,	52(sp)
	sw	t0,	180(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	180(sp)
	add	t0,	t0,	t1
	sw	t0,	184(sp)
	lw	t0,	184(sp)
	lw	t0,	0(t0)
	sw	t0,	188(sp)
	lw	t0,	176(sp)
	slli	t0,	t0,	2
	lw	t1,	188(sp)
	add	t0,	t0,	t1
	sw	t0,	192(sp)
	lw	t0,	192(sp)
	lw	t0,	0(t0)
	sw	t0,	196(sp)
	lw	t0,	196(sp)
	lw	t1,	172(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	200(sp)
	lw	t0,	52(sp)
	sw	t0,	204(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	204(sp)
	add	t0,	t0,	t1
	sw	t0,	208(sp)
	lw	t0,	208(sp)
	lw	t0,	0(t0)
	sw	t0,	212(sp)
	lw	t0,	200(sp)
	slli	t0,	t0,	2
	lw	t1,	212(sp)
	add	t0,	t0,	t1
	sw	t0,	216(sp)
	lw	t0,	52(sp)
	sw	t0,	220(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	220(sp)
	add	t0,	t0,	t1
	sw	t0,	224(sp)
	lw	t0,	224(sp)
	lw	t0,	0(t0)
	sw	t0,	228(sp)
	lw	t0,	228(sp)
	lw	t1,	216(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	232(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	232(sp)
	add	t0,	t0,	t1
	sw	t0,	236(sp)
	lw	t0,	236(sp)
	lw	t0,	0(t0)
	sw	t0,	240(sp)
	lw	t0,	240(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	244(sp)
	lw	t0,	52(sp)
	sw	t0,	248(sp)
	li	t0	3
	slli	t0,	t0,	2
	lw	t1,	248(sp)
	add	t0,	t0,	t1
	sw	t0,	252(sp)
	lw	t0,	244(sp)
	lw	t1,	252(sp)
	sw	t0,	0(t1)
	j	exit.5
exit.5:
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
	addi	sp,	sp,	256
	ret
	.globl	nVertices
nVertices:
entry.6:
	addi	sp,	sp,	-92
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
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	li	t0	2
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	lw	t0,	0(t0)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	80(sp)
	lw	a0,	80(sp)
	call	getArraySize
	mv	t0,	a0
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	52(sp)
	j	exit.6
exit.6:
	lw	t0,	52(sp)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
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
	addi	sp,	sp,	92
	ret
	.globl	nEdges
nEdges:
entry.7:
	addi	sp,	sp,	-92
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
	sw	t0,	80(sp)
	lw	a0,	80(sp)
	call	getArraySize
	mv	t0,	a0
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	52(sp)
	j	exit.7
exit.7:
	lw	t0,	52(sp)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
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
	addi	sp,	sp,	92
	ret
	.globl	Array_Node
Array_Node:
entry.8:
	addi	sp,	sp,	-92
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
	lw	t0,	56(sp)
	sw	t0,	60(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	li	t0	0
	lw	t1,	64(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	li	a0	16
	li	a1	64
	call	malloc_
	mv	t0,	a0
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	lw	t1,	72(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	52(sp)
	j	exit.8
exit.8:
	lw	t0,	52(sp)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
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
	addi	sp,	sp,	92
	ret
	.globl	push_back
push_back:
entry.9:
	addi	sp,	sp,	-160
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
	lw	t0,	52(sp)
	sw	t0,	60(sp)
	lw	a0,	60(sp)
	call	size
	mv	t0,	a0
	sw	t0,	64(sp)
	lw	t0,	52(sp)
	sw	t0,	68(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	52(sp)
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
	lw	t0,	64(sp)
	lw	t1,	92(sp)
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	beqz	t0,	if.end0.9
	j	if.then0.9
if.then0.9:
	lw	t0,	52(sp)
	sw	t0,	100(sp)
	lw	a0,	100(sp)
	call	doubleStorage
	j	if.end0.9
if.end0.9:
	lw	t0,	52(sp)
	sw	t0,	104(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	lw	t0,	0(t0)
	sw	t0,	112(sp)
	lw	t0,	52(sp)
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
	lw	t0,	56(sp)
	sw	t0,	132(sp)
	lw	t0,	132(sp)
	lw	t1,	128(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	136(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	136(sp)
	add	t0,	t0,	t1
	sw	t0,	140(sp)
	lw	t0,	140(sp)
	lw	t0,	0(t0)
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	148(sp)
	lw	t0,	52(sp)
	sw	t0,	152(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	152(sp)
	add	t0,	t0,	t1
	sw	t0,	156(sp)
	lw	t0,	148(sp)
	lw	t1,	156(sp)
	sw	t0,	0(t1)
	j	exit.9
exit.9:
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
	addi	sp,	sp,	160
	ret
	.globl	pop_back
pop_back:
entry.10:
	addi	sp,	sp,	-120
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
	lw	t0,	56(sp)
	sw	t0,	60(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	lw	t0,	0(t0)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	56(sp)
	sw	t0,	76(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	76(sp)
	add	t0,	t0,	t1
	sw	t0,	80(sp)
	lw	t0,	72(sp)
	lw	t1,	80(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	84(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	84(sp)
	add	t0,	t0,	t1
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	lw	t0,	0(t0)
	sw	t0,	92(sp)
	lw	t0,	56(sp)
	sw	t0,	96(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	96(sp)
	add	t0,	t0,	t1
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	lw	t0,	0(t0)
	sw	t0,	104(sp)
	lw	t0,	92(sp)
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	lw	t0,	0(t0)
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	sw	t0,	52(sp)
	j	exit.10
exit.10:
	lw	t0,	52(sp)
	sw	t0,	116(sp)
	lw	t0,	116(sp)
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
	addi	sp,	sp,	120
	ret
	.globl	back
back:
entry.11:
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
	lw	t0,	56(sp)
	sw	t0,	60(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	lw	t0,	0(t0)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	72(sp)
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
	lw	t0,	72(sp)
	slli	t0,	t0,	2
	lw	t1,	84(sp)
	add	t0,	t0,	t1
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	lw	t0,	0(t0)
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	sw	t0,	52(sp)
	j	exit.11
exit.11:
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
	.globl	front
front:
entry.12:
	addi	sp,	sp,	-84
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
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	lw	t0,	0(t0)
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	52(sp)
	j	exit.12
exit.12:
	lw	t0,	52(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
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
	addi	sp,	sp,	84
	ret
	.globl	size
size:
entry.13:
	addi	sp,	sp,	-76
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
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	lw	t0,	0(t0)
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	sw	t0,	52(sp)
	j	exit.13
exit.13:
	lw	t0,	52(sp)
	sw	t0,	72(sp)
	lw	t0,	72(sp)
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
	addi	sp,	sp,	76
	ret
	.globl	resize
resize:
entry.14:
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
	sw	a0,	52(sp)
	sw	a1,	56(sp)
	j	while.cond3.14
while.cond3.14:
	lw	t0,	52(sp)
	sw	t0,	60(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	lw	t0,	52(sp)
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
	sw	t0,	80(sp)
	lw	a0,	80(sp)
	call	getArraySize
	mv	t0,	a0
	sw	t0,	84(sp)
	lw	t0,	56(sp)
	sw	t0,	88(sp)
	lw	t0,	84(sp)
	lw	t1,	88(sp)
	slt	t0,	t0,	t1
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	beqz	t0,	while.end3.14
	j	while.body3.14
while.body3.14:
	lw	t0,	52(sp)
	sw	t0,	96(sp)
	lw	a0,	96(sp)
	call	doubleStorage
	j	while.cond3.14
while.end3.14:
	lw	t0,	52(sp)
	sw	t0,	100(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	100(sp)
	add	t0,	t0,	t1
	sw	t0,	104(sp)
	lw	t0,	56(sp)
	sw	t0,	108(sp)
	lw	t0,	108(sp)
	lw	t1,	104(sp)
	sw	t0,	0(t1)
	j	exit.14
exit.14:
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
	.globl	get
get:
entry.15:
	addi	sp,	sp,	-92
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
	lw	t0,	60(sp)
	sw	t0,	64(sp)
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
	lw	t0,	64(sp)
	slli	t0,	t0,	2
	lw	t1,	76(sp)
	add	t0,	t0,	t1
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	lw	t0,	0(t0)
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	52(sp)
	j	exit.15
exit.15:
	lw	t0,	52(sp)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
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
	addi	sp,	sp,	92
	ret
	.globl	set
set:
entry.16:
	addi	sp,	sp,	-88
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
	lw	t0,	56(sp)
	sw	t0,	64(sp)
	lw	t0,	52(sp)
	sw	t0,	68(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	lw	t0,	0(t0)
	sw	t0,	76(sp)
	lw	t0,	64(sp)
	slli	t0,	t0,	2
	lw	t1,	76(sp)
	add	t0,	t0,	t1
	sw	t0,	80(sp)
	lw	t0,	60(sp)
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	lw	t1,	80(sp)
	sw	t0,	0(t1)
	j	exit.16
exit.16:
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
	addi	sp,	sp,	88
	ret
	.globl	swap
swap:
entry.17:
	addi	sp,	sp,	-160
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
	lw	t0,	56(sp)
	sw	t0,	68(sp)
	lw	t0,	52(sp)
	sw	t0,	72(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	72(sp)
	add	t0,	t0,	t1
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	lw	t0,	0(t0)
	sw	t0,	80(sp)
	lw	t0,	68(sp)
	slli	t0,	t0,	2
	lw	t1,	80(sp)
	add	t0,	t0,	t1
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	lw	t0,	0(t0)
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	sw	t0,	64(sp)
	lw	t0,	56(sp)
	sw	t0,	92(sp)
	lw	t0,	52(sp)
	sw	t0,	96(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	96(sp)
	add	t0,	t0,	t1
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	lw	t0,	0(t0)
	sw	t0,	104(sp)
	lw	t0,	92(sp)
	slli	t0,	t0,	2
	lw	t1,	104(sp)
	add	t0,	t0,	t1
	sw	t0,	108(sp)
	lw	t0,	60(sp)
	sw	t0,	112(sp)
	lw	t0,	52(sp)
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
	lw	t0,	132(sp)
	lw	t1,	108(sp)
	sw	t0,	0(t1)
	lw	t0,	60(sp)
	sw	t0,	136(sp)
	lw	t0,	52(sp)
	sw	t0,	140(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	140(sp)
	add	t0,	t0,	t1
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	lw	t0,	0(t0)
	sw	t0,	148(sp)
	lw	t0,	136(sp)
	slli	t0,	t0,	2
	lw	t1,	148(sp)
	add	t0,	t0,	t1
	sw	t0,	152(sp)
	lw	t0,	64(sp)
	sw	t0,	156(sp)
	lw	t0,	156(sp)
	lw	t1,	152(sp)
	sw	t0,	0(t1)
	j	exit.17
exit.17:
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
	addi	sp,	sp,	160
	ret
	.globl	doubleStorage
doubleStorage:
entry.18:
	addi	sp,	sp,	-228
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
	lw	t0,	52(sp)
	sw	t0,	64(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	64(sp)
	add	t0,	t0,	t1
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	lw	t0,	0(t0)
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	56(sp)
	lw	t0,	52(sp)
	sw	t0,	76(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	76(sp)
	add	t0,	t0,	t1
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	lw	t0,	0(t0)
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	sw	t0,	60(sp)
	lw	t0,	52(sp)
	sw	t0,	88(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	88(sp)
	add	t0,	t0,	t1
	sw	t0,	92(sp)
	lw	t0,	56(sp)
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	sw	t0,	100(sp)
	lw	a0,	100(sp)
	call	getArraySize
	mv	t0,	a0
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	li	t1	2
	mul	t0,	t0,	t1
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
	lw	t1,	92(sp)
	sw	t0,	0(t1)
	lw	t0,	52(sp)
	sw	t0,	124(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	124(sp)
	add	t0,	t0,	t1
	sw	t0,	128(sp)
	li	t0	0
	lw	t1,	128(sp)
	sw	t0,	0(t1)
	j	for.cond4.18
for.cond4.18:
	lw	t0,	52(sp)
	sw	t0,	132(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	132(sp)
	add	t0,	t0,	t1
	sw	t0,	136(sp)
	lw	t0,	136(sp)
	lw	t0,	0(t0)
	sw	t0,	140(sp)
	lw	t0,	60(sp)
	sw	t0,	144(sp)
	lw	t0,	140(sp)
	lw	t1,	144(sp)
	sub	t0,	t0,	t1
	snez	t0,	t0
	sw	t0,	148(sp)
	lw	t0,	148(sp)
	beqz	t0,	for.end4.18
	j	for.body4.18
for.body4.18:
	lw	t0,	52(sp)
	sw	t0,	152(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	152(sp)
	add	t0,	t0,	t1
	sw	t0,	156(sp)
	lw	t0,	156(sp)
	lw	t0,	0(t0)
	sw	t0,	160(sp)
	lw	t0,	52(sp)
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
	lw	t0,	52(sp)
	sw	t0,	180(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	180(sp)
	add	t0,	t0,	t1
	sw	t0,	184(sp)
	lw	t0,	184(sp)
	lw	t0,	0(t0)
	sw	t0,	188(sp)
	lw	t0,	56(sp)
	sw	t0,	192(sp)
	lw	t0,	188(sp)
	slli	t0,	t0,	2
	lw	t1,	192(sp)
	add	t0,	t0,	t1
	sw	t0,	196(sp)
	lw	t0,	196(sp)
	lw	t0,	0(t0)
	sw	t0,	200(sp)
	lw	t0,	200(sp)
	lw	t1,	176(sp)
	sw	t0,	0(t1)
	j	for.inc4.18
for.inc4.18:
	lw	t0,	52(sp)
	sw	t0,	204(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	204(sp)
	add	t0,	t0,	t1
	sw	t0,	208(sp)
	lw	t0,	208(sp)
	lw	t0,	0(t0)
	sw	t0,	212(sp)
	lw	t0,	212(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	216(sp)
	lw	t0,	52(sp)
	sw	t0,	220(sp)
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	220(sp)
	add	t0,	t0,	t1
	sw	t0,	224(sp)
	lw	t0,	216(sp)
	lw	t1,	224(sp)
	sw	t0,	0(t1)
	j	for.cond4.18
for.end4.18:
	j	exit.18
exit.18:
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
	addi	sp,	sp,	228
	ret
	.globl	Heap_Node
Heap_Node:
entry.19:
	addi	sp,	sp,	-88
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
	lw	t0,	56(sp)
	sw	t0,	60(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	li	a0	0
	li	a1	8
	call	malloc_
	mv	t0,	a0
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	sw	t0,	72(sp)
	lw	a0,	72(sp)
	call	Array_Node
	mv	t0,	a0
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	lw	t1,	64(sp)
	sw	t0,	0(t1)
	lw	t0,	56(sp)
	sw	t0,	80(sp)
	lw	t0,	80(sp)
	sw	t0,	52(sp)
	j	exit.19
exit.19:
	lw	t0,	52(sp)
	sw	t0,	84(sp)
	lw	t0,	84(sp)
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
	addi	sp,	sp,	88
	ret
	.globl	push
push:
entry.20:
	addi	sp,	sp,	-192
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
	lw	t0,	52(sp)
	sw	t0,	68(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	68(sp)
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	lw	t0,	0(t0)
	sw	t0,	76(sp)
	lw	t0,	56(sp)
	sw	t0,	80(sp)
	lw	a0,	76(sp)
	lw	a1,	80(sp)
	call	push_back
	lw	t0,	52(sp)
	sw	t0,	84(sp)
	lw	a0,	84(sp)
	call	size1
	mv	t0,	a0
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	92(sp)
	lw	t0,	92(sp)
	sw	t0,	60(sp)
	j	while.cond5.20
while.cond5.20:
	lw	t0,	60(sp)
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	li	t1	0
	slt	t0,	t1,	t0
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	beqz	t0,	while.end5.20
	j	while.body5.20
while.body5.20:
	lw	t0,	52(sp)
	sw	t0,	104(sp)
	lw	t0,	60(sp)
	sw	t0,	108(sp)
	lw	a0,	104(sp)
	lw	a1,	108(sp)
	call	pnt
	mv	t0,	a0
	sw	t0,	112(sp)
	lw	t0,	112(sp)
	sw	t0,	64(sp)
	lw	t0,	52(sp)
	sw	t0,	116(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	116(sp)
	add	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	lw	t0,	0(t0)
	sw	t0,	124(sp)
	lw	t0,	64(sp)
	sw	t0,	128(sp)
	lw	a0,	124(sp)
	lw	a1,	128(sp)
	call	get
	mv	t0,	a0
	sw	t0,	132(sp)
	lw	a0,	132(sp)
	call	key_
	mv	t0,	a0
	sw	t0,	136(sp)
	lw	t0,	52(sp)
	sw	t0,	140(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	140(sp)
	add	t0,	t0,	t1
	sw	t0,	144(sp)
	lw	t0,	144(sp)
	lw	t0,	0(t0)
	sw	t0,	148(sp)
	lw	t0,	60(sp)
	sw	t0,	152(sp)
	lw	a0,	148(sp)
	lw	a1,	152(sp)
	call	get
	mv	t0,	a0
	sw	t0,	156(sp)
	lw	a0,	156(sp)
	call	key_
	mv	t0,	a0
	sw	t0,	160(sp)
	lw	t0,	136(sp)
	lw	t1,	160(sp)
	slt	t0,	t0,	t1
	xori	t0,	t0,	1
	sw	t0,	164(sp)
	lw	t0,	164(sp)
	beqz	t0,	if.end1.20
	j	if.then1.20
if.then1.20:
	j	while.end5.20
if.end1.20:
	lw	t0,	52(sp)
	sw	t0,	168(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	168(sp)
	add	t0,	t0,	t1
	sw	t0,	172(sp)
	lw	t0,	172(sp)
	lw	t0,	0(t0)
	sw	t0,	176(sp)
	lw	t0,	64(sp)
	sw	t0,	180(sp)
	lw	t0,	60(sp)
	sw	t0,	184(sp)
	lw	a0,	176(sp)
	lw	a1,	180(sp)
	lw	a2,	184(sp)
	call	swap
	lw	t0,	64(sp)
	sw	t0,	188(sp)
	lw	t0,	188(sp)
	sw	t0,	60(sp)
	j	while.cond5.20
while.end5.20:
	j	exit.20
exit.20:
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
	addi	sp,	sp,	192
	ret
	.globl	pop
pop:
entry.21:
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
	lw	t0,	56(sp)
	sw	t0,	64(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	64(sp)
	add	t0,	t0,	t1
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	lw	t0,	0(t0)
	sw	t0,	72(sp)
	lw	a0,	72(sp)
	call	front
	mv	t0,	a0
	sw	t0,	76(sp)
	lw	t0,	76(sp)
	sw	t0,	60(sp)
	lw	t0,	56(sp)
	sw	t0,	80(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	80(sp)
	add	t0,	t0,	t1
	sw	t0,	84(sp)
	lw	t0,	84(sp)
	lw	t0,	0(t0)
	sw	t0,	88(sp)
	lw	t0,	56(sp)
	sw	t0,	92(sp)
	lw	a0,	92(sp)
	call	size1
	mv	t0,	a0
	sw	t0,	96(sp)
	lw	t0,	96(sp)
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	100(sp)
	lw	a0,	88(sp)
	li	a1	0
	lw	a2,	100(sp)
	call	swap
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
	lw	a0,	112(sp)
	call	pop_back
	mv	t0,	a0
	sw	t0,	116(sp)
	lw	t0,	56(sp)
	sw	t0,	120(sp)
	lw	a0,	120(sp)
	li	a1	0
	call	maxHeapify
	lw	t0,	60(sp)
	sw	t0,	124(sp)
	lw	t0,	124(sp)
	sw	t0,	52(sp)
	j	exit.21
exit.21:
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
	.globl	top
top:
entry.22:
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
	lw	a0,	68(sp)
	call	front
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	52(sp)
	j	exit.22
exit.22:
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
	.globl	size1
size1:
entry.23:
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
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	lw	t0,	0(t0)
	sw	t0,	68(sp)
	lw	a0,	68(sp)
	call	size
	mv	t0,	a0
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	52(sp)
	j	exit.23
exit.23:
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
	.globl	lchild
lchild:
entry.24:
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
	sw	a1,	60(sp)
	li	t0	0
	sw	t0,	52(sp)
	lw	t0,	60(sp)
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	li	t1	2
	mul	t0,	t0,	t1
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	li	t1	1
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	52(sp)
	j	exit.24
exit.24:
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
	.globl	rchild
rchild:
entry.25:
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
	sw	a1,	60(sp)
	li	t0	0
	sw	t0,	52(sp)
	lw	t0,	60(sp)
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	li	t1	2
	mul	t0,	t0,	t1
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	li	t1	2
	add	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	52(sp)
	j	exit.25
exit.25:
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
	.globl	pnt
pnt:
entry.26:
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
	sw	a1,	60(sp)
	li	t0	0
	sw	t0,	52(sp)
	lw	t0,	60(sp)
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	li	t1	1
	sub	t0,	t0,	t1
	sw	t0,	68(sp)
	lw	t0,	68(sp)
	li	t1	2
	div	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	52(sp)
	j	exit.26
exit.26:
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
	.globl	maxHeapify
maxHeapify:
entry.27:
	addi	sp,	sp,	-300
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
	lw	t0,	52(sp)
	sw	t0,	80(sp)
	lw	t0,	56(sp)
	sw	t0,	84(sp)
	lw	a0,	80(sp)
	lw	a1,	84(sp)
	call	lchild
	mv	t0,	a0
	sw	t0,	88(sp)
	lw	t0,	88(sp)
	sw	t0,	60(sp)
	lw	t0,	52(sp)
	sw	t0,	92(sp)
	lw	t0,	56(sp)
	sw	t0,	96(sp)
	lw	a0,	92(sp)
	lw	a1,	96(sp)
	call	rchild
	mv	t0,	a0
	sw	t0,	100(sp)
	lw	t0,	100(sp)
	sw	t0,	64(sp)
	lw	t0,	56(sp)
	sw	t0,	104(sp)
	lw	t0,	104(sp)
	sw	t0,	68(sp)
	lw	t0,	60(sp)
	sw	t0,	108(sp)
	lw	t0,	52(sp)
	sw	t0,	112(sp)
	lw	a0,	112(sp)
	call	size1
	mv	t0,	a0
	sw	t0,	116(sp)
	lw	t0,	108(sp)
	lw	t1,	116(sp)
	slt	t0,	t0,	t1
	sw	t0,	120(sp)
	lw	t0,	120(sp)
	beqz	t0,	if.else2.27
	j	if.then2.27
if.then2.27:
	lw	t0,	52(sp)
	sw	t0,	124(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	124(sp)
	add	t0,	t0,	t1
	sw	t0,	128(sp)
	lw	t0,	128(sp)
	lw	t0,	0(t0)
	sw	t0,	132(sp)
	lw	t0,	60(sp)
	sw	t0,	136(sp)
	lw	a0,	132(sp)
	lw	a1,	136(sp)
	call	get
	mv	t0,	a0
	sw	t0,	140(sp)
	lw	a0,	140(sp)
	call	key_
	mv	t0,	a0
	sw	t0,	144(sp)
	lw	t0,	52(sp)
	sw	t0,	148(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	148(sp)
	add	t0,	t0,	t1
	sw	t0,	152(sp)
	lw	t0,	152(sp)
	lw	t0,	0(t0)
	sw	t0,	156(sp)
	lw	t0,	68(sp)
	sw	t0,	160(sp)
	lw	a0,	156(sp)
	lw	a1,	160(sp)
	call	get
	mv	t0,	a0
	sw	t0,	164(sp)
	lw	a0,	164(sp)
	call	key_
	mv	t0,	a0
	sw	t0,	168(sp)
	lw	t0,	144(sp)
	lw	t1,	168(sp)
	slt	t0,	t1,	t0
	sw	t0,	172(sp)
	lw	t0,	172(sp)
	sw	t0,	72(sp)
	j	if.end2.27
if.else2.27:
	li	t0	0
	sw	t0,	72(sp)
	j	if.end2.27
if.end2.27:
	lw	t0,	72(sp)
	sw	t0,	176(sp)
	lw	t0,	176(sp)
	beqz	t0,	if.end3.27
	j	if.then3.27
if.then3.27:
	lw	t0,	60(sp)
	sw	t0,	180(sp)
	lw	t0,	180(sp)
	sw	t0,	68(sp)
	j	if.end3.27
if.end3.27:
	lw	t0,	64(sp)
	sw	t0,	184(sp)
	lw	t0,	52(sp)
	sw	t0,	188(sp)
	lw	a0,	188(sp)
	call	size1
	mv	t0,	a0
	sw	t0,	192(sp)
	lw	t0,	184(sp)
	lw	t1,	192(sp)
	slt	t0,	t0,	t1
	sw	t0,	196(sp)
	lw	t0,	196(sp)
	beqz	t0,	if.else4.27
	j	if.then4.27
if.then4.27:
	lw	t0,	52(sp)
	sw	t0,	200(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	200(sp)
	add	t0,	t0,	t1
	sw	t0,	204(sp)
	lw	t0,	204(sp)
	lw	t0,	0(t0)
	sw	t0,	208(sp)
	lw	t0,	64(sp)
	sw	t0,	212(sp)
	lw	a0,	208(sp)
	lw	a1,	212(sp)
	call	get
	mv	t0,	a0
	sw	t0,	216(sp)
	lw	a0,	216(sp)
	call	key_
	mv	t0,	a0
	sw	t0,	220(sp)
	lw	t0,	52(sp)
	sw	t0,	224(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	224(sp)
	add	t0,	t0,	t1
	sw	t0,	228(sp)
	lw	t0,	228(sp)
	lw	t0,	0(t0)
	sw	t0,	232(sp)
	lw	t0,	68(sp)
	sw	t0,	236(sp)
	lw	a0,	232(sp)
	lw	a1,	236(sp)
	call	get
	mv	t0,	a0
	sw	t0,	240(sp)
	lw	a0,	240(sp)
	call	key_
	mv	t0,	a0
	sw	t0,	244(sp)
	lw	t0,	220(sp)
	lw	t1,	244(sp)
	slt	t0,	t1,	t0
	sw	t0,	248(sp)
	lw	t0,	248(sp)
	sw	t0,	76(sp)
	j	if.end4.27
if.else4.27:
	li	t0	0
	sw	t0,	76(sp)
	j	if.end4.27
if.end4.27:
	lw	t0,	76(sp)
	sw	t0,	252(sp)
	lw	t0,	252(sp)
	beqz	t0,	if.end5.27
	j	if.then5.27
if.then5.27:
	lw	t0,	64(sp)
	sw	t0,	256(sp)
	lw	t0,	256(sp)
	sw	t0,	68(sp)
	j	if.end5.27
if.end5.27:
	lw	t0,	68(sp)
	sw	t0,	260(sp)
	lw	t0,	56(sp)
	sw	t0,	264(sp)
	lw	t0,	260(sp)
	lw	t1,	264(sp)
	sub	t0,	t0,	t1
	seqz	t0,	t0
	sw	t0,	268(sp)
	lw	t0,	268(sp)
	beqz	t0,	if.end6.27
	j	if.then6.27
if.then6.27:
	j	exit.27
if.end6.27:
	lw	t0,	52(sp)
	sw	t0,	272(sp)
	li	t0	0
	slli	t0,	t0,	2
	lw	t1,	272(sp)
	add	t0,	t0,	t1
	sw	t0,	276(sp)
	lw	t0,	276(sp)
	lw	t0,	0(t0)
	sw	t0,	280(sp)
	lw	t0,	56(sp)
	sw	t0,	284(sp)
	lw	t0,	68(sp)
	sw	t0,	288(sp)
	lw	a0,	280(sp)
	lw	a1,	284(sp)
	lw	a2,	288(sp)
	call	swap
	lw	t0,	52(sp)
	sw	t0,	292(sp)
	lw	t0,	68(sp)
	sw	t0,	296(sp)
	lw	a0,	292(sp)
	lw	a1,	296(sp)
	call	maxHeapify
	j	exit.27
exit.27:
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
	addi	sp,	sp,	300
	ret
	.globl	key_
key_:
entry.28:
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
	li	t0	1
	slli	t0,	t0,	2
	lw	t1,	60(sp)
	add	t0,	t0,	t1
	sw	t0,	64(sp)
	lw	t0,	64(sp)
	lw	t0,	0(t0)
	sw	t0,	68(sp)
	li	t0	0
	lw	t1,	68(sp)
	sub	t0,	t0,	t1
	sw	t0,	72(sp)
	lw	t0,	72(sp)
	sw	t0,	52(sp)
	j	exit.28
exit.28:
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
