	.text
	.file	"IR.ll"
	.globl	kunkun                  # -- Begin function kunkun
	.p2align	2
	.type	kunkun,@function
kunkun:                                 # @kunkun
	.cfi_startproc
# %bb.0:                                # %entry
	lui	a0, %hi(.L.str0)
	addi	a0, a0, %lo(.L.str0)
	lui	a1, %hi(hello)
	sw	a0, %lo(hello)(a1)
	ret
.Lfunc_end0:
	.size	kunkun, .Lfunc_end0-kunkun
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
	mv	a0, zero
	addi	sp, sp, 16
	ret
.Lfunc_end1:
	.size	main, .Lfunc_end1-main
	.cfi_endproc
                                        # -- End function
	.globl	nothing                 # -- Begin function nothing
	.p2align	2
	.type	nothing,@function
nothing:                                # @nothing
	.cfi_startproc
# %bb.0:                                # %entry
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	a0, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end2:
	.size	nothing, .Lfunc_end2-nothing
	.cfi_endproc
                                        # -- End function
	.type	.L.str0,@object         # @.str0
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str0:
	.asciz	"hl"
	.size	.L.str0, 3

	.type	a,@object               # @a
	.section	.sbss,"aw",@nobits
	.globl	a
	.p2align	2
a:
	.word	0                       # 0x0
	.size	a, 4

	.type	hello,@object           # @hello
	.globl	hello
	.p2align	2
hello:
	.word	0
	.size	hello, 4

	.section	".note.GNU-stack","",@progbits
