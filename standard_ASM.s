	.text
	.file	"IR.ll"
	.globl	kunkun                  # -- Begin function kunkun
	.p2align	2
	.type	kunkun,@function
kunkun:                                 # @kunkun
	.cfi_startproc
# %bb.0:                                # %entry
	lui	a0, %hi(he)
	addi	a1, zero, 9
	sw	a1, %lo(he)(a0)
	ret
.Lfunc_end0:
	.size	kunkun, .Lfunc_end0-kunkun
	.cfi_endproc
                                        # -- End function
	.globl	hello                   # -- Begin function hello
	.p2align	2
	.type	hello,@function
hello:                                  # @hello
	.cfi_startproc
# %bb.0:                                # %entry
	addi	sp, sp, -48
	.cfi_def_cfa_offset 48
	lw	t0, 56(sp)
	sw	a0, 40(sp)
	sw	a1, 36(sp)
	sw	a2, 32(sp)
	sw	a3, 28(sp)
	sw	a4, 24(sp)
	sw	a5, 20(sp)
	sw	a6, 16(sp)
	lw	a0, 48(sp)
	sw	a7, 12(sp)
	andi	a1, t0, 1
	sb	a1, 11(sp)
	sw	a0, 44(sp)
	lw	a0, 44(sp)
	addi	sp, sp, 48
	ret
.Lfunc_end1:
	.size	hello, .Lfunc_end1-hello
	.cfi_endproc
                                        # -- End function
	.globl	main                    # -- Begin function main
	.p2align	2
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:                                # %entry
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	.cfi_offset ra, -4
	sw	zero, 24(sp)
	call	kunkun
	lui	a0, %hi(he)
	lw	a2, %lo(he)(a0)
	lw	a3, 20(sp)
	sw	zero, 8(sp)
	sw	a3, 4(sp)
	addi	a1, zero, 99
	sw	a3, 0(sp)
	mv	a0, zero
	mv	a4, a3
	mv	a5, a3
	mv	a6, a3
	mv	a7, a3
	call	hello
	sw	a0, 20(sp)
	sw	zero, 24(sp)
	lw	a0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end2:
	.size	main, .Lfunc_end2-main
	.cfi_endproc
                                        # -- End function
	.type	he,@object              # @he
	.section	.sbss,"aw",@nobits
	.globl	he
	.p2align	2
he:
	.word	0                       # 0x0
	.size	he, 4

	.section	".note.GNU-stack","",@progbits
