	.text
	.file	"IR.ll"
	.globl	kunkun_initialize_global_declarations # -- Begin function kunkun_initialize_global_declarations
	.p2align	2
	.type	kunkun_initialize_global_declarations,@function
kunkun_initialize_global_declarations:  # @kunkun_initialize_global_declarations
	.cfi_startproc
# %bb.0:                                # %entry
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
	addi	a1, zero, 8
	mv	a0, zero
	call	malloc_
	sw	a0, 4(sp)
	mv	a0, zero
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end1:
	.size	main, .Lfunc_end1-main
	.cfi_endproc
                                        # -- End function
	.globl	init                    # -- Begin function init
	.p2align	2
	.type	init,@function
init:                                   # @init
	.cfi_startproc
# %bb.0:                                # %entry
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lui	a0, %hi(.L.str0)
	addi	a0, a0, %lo(.L.str0)
	call	print
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end2:
	.size	init, .Lfunc_end2-init
	.cfi_endproc
                                        # -- End function
	.type	.L.str0,@object         # @.str0
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str0:
	.asciz	"init"
	.size	.L.str0, 5

	.section	".note.GNU-stack","",@progbits
