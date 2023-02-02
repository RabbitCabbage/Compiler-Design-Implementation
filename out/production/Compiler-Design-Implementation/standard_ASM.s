	.text
	.file	"IR.ll"
	.globl	kunkun_initialize_global_declarations # -- Begin function kunkun_initialize_global_declarations
	.p2align	2
	.type	kunkun_initialize_global_declarations,@function
kunkun_initialize_global_declarations:  # @kunkun_initialize_global_declarations
	.cfi_startproc
# %bb.0:                                # %entry
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	addi	a0, zero, 9
	addi	a1, zero, 72
	call	malloc_
	lui	a1, %hi(b)
	sw	a0, %lo(b)(a1)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end0:
	.size	kunkun_initialize_global_declarations, .Lfunc_end0-kunkun_initialize_global_declarations
	.cfi_endproc
                                        # -- End function
	.globl	main                    # -- Begin function main
	.p2align	2
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:                                # %entry
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	zero, 8(sp)
	call	kunkun_initialize_global_declarations
	lui	a0, %hi(b)
	lw	a0, %lo(b)(a0)
	call	getArraySize
	call	printInt
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end1:
	.size	main, .Lfunc_end1-main
	.cfi_endproc
                                        # -- End function
	.type	b,@object               # @b
	.section	.sbss,"aw",@nobits
	.globl	b
	.p2align	2
b:
	.word	0
	.size	b, 4

	.section	".note.GNU-stack","",@progbits
