	.text
	.file	"builtin.c"
	.globl	_print_                 # -- Begin function _print_
	.p2align	4, 0x90
	.type	_print_,@function
_print_:                                # @_print_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rsi
	movabsq	$.L.str, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end0:
	.size	_print_, .Lfunc_end0-_print_
	.cfi_endproc
                                        # -- End function
	.globl	_println_               # -- Begin function _println_
	.p2align	4, 0x90
	.type	_println_,@function
_println_:                              # @_println_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rsi
	movabsq	$.L.str.1, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end1:
	.size	_println_, .Lfunc_end1-_println_
	.cfi_endproc
                                        # -- End function
	.globl	_printInt_              # -- Begin function _printInt_
	.p2align	4, 0x90
	.type	_printInt_,@function
_printInt_:                             # @_printInt_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movl	-4(%rbp), %esi
	movabsq	$.L.str.2, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end2:
	.size	_printInt_, .Lfunc_end2-_printInt_
	.cfi_endproc
                                        # -- End function
	.globl	_printlnInt_            # -- Begin function _printlnInt_
	.p2align	4, 0x90
	.type	_printlnInt_,@function
_printlnInt_:                           # @_printlnInt_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movl	-4(%rbp), %esi
	movabsq	$.L.str.3, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end3:
	.size	_printlnInt_, .Lfunc_end3-_printlnInt_
	.cfi_endproc
                                        # -- End function
	.globl	_getString_             # -- Begin function _getString_
	.p2align	4, 0x90
	.type	_getString_,@function
_getString_:                            # @_getString_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	$256, %edi              # imm = 0x100
	callq	malloc
	movq	%rax, -8(%rbp)
	movq	-8(%rbp), %rsi
	movabsq	$.L.str, %rdi
	movb	$0, %al
	callq	__isoc99_scanf
	movq	-8(%rbp), %rax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end4:
	.size	_getString_, .Lfunc_end4-_getString_
	.cfi_endproc
                                        # -- End function
	.globl	_getInt_                # -- Begin function _getInt_
	.p2align	4, 0x90
	.type	_getInt_,@function
_getInt_:                               # @_getInt_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movabsq	$.L.str.2, %rdi
	leaq	-4(%rbp), %rsi
	movb	$0, %al
	callq	__isoc99_scanf
	movl	-4(%rbp), %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end5:
	.size	_getInt_, .Lfunc_end5-_getInt_
	.cfi_endproc
                                        # -- End function
	.globl	_toString_              # -- Begin function _toString_
	.p2align	4, 0x90
	.type	_toString_,@function
_toString_:                             # @_toString_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movl	$256, %edi              # imm = 0x100
	callq	malloc
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rdi
	movl	-4(%rbp), %edx
	movabsq	$.L.str.2, %rsi
	movb	$0, %al
	callq	sprintf
	movq	-16(%rbp), %rax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end6:
	.size	_toString_, .Lfunc_end6-_toString_
	.cfi_endproc
                                        # -- End function
	.globl	_malloc_                # -- Begin function _malloc_
	.p2align	4, 0x90
	.type	_malloc_,@function
_malloc_:                               # @_malloc_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$32, %rsp
	movl	%edi, -4(%rbp)
	movl	-4(%rbp), %eax
	addl	$4, %eax
	movslq	%eax, %rdi
	callq	malloc
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rax
	movq	%rax, -24(%rbp)
	movl	-4(%rbp), %eax
	movq	-24(%rbp), %rcx
	movl	%eax, (%rcx)
	movq	-16(%rbp), %rax
	addq	$4, %rax
	addq	$32, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end7:
	.size	_malloc_, .Lfunc_end7-_malloc_
	.cfi_endproc
                                        # -- End function
	.globl	_getArraySize_          # -- Begin function _getArraySize_
	.p2align	4, 0x90
	.type	_getArraySize_,@function
_getArraySize_:                         # @_getArraySize_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -16(%rbp)
	movq	-16(%rbp), %rax
	addq	$-4, %rax
	movq	%rax, -8(%rbp)
	movq	-8(%rbp), %rax
	movl	(%rax), %eax
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end8:
	.size	_getArraySize_, .Lfunc_end8-_getArraySize_
	.cfi_endproc
                                        # -- End function
	.globl	_string_length          # -- Begin function _string_length
	.p2align	4, 0x90
	.type	_string_length,@function
_string_length:                         # @_string_length
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rdi
	callq	strlen
                                        # kill: def $eax killed $eax killed $rax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end9:
	.size	_string_length, .Lfunc_end9-_string_length
	.cfi_endproc
                                        # -- End function
	.globl	_string_substring_      # -- Begin function _string_substring_
	.p2align	4, 0x90
	.type	_string_substring_,@function
_string_substring_:                     # @_string_substring_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$32, %rsp
	movq	%rdi, -32(%rbp)
	movl	%esi, -8(%rbp)
	movl	%edx, -12(%rbp)
	movl	-12(%rbp), %eax
	subl	-8(%rbp), %eax
	addl	$1, %eax
	movslq	%eax, %rdi
	callq	malloc
	movq	%rax, -24(%rbp)
	movl	-8(%rbp), %eax
	movl	%eax, -4(%rbp)
.LBB10_1:                               # %for.cond
                                        # =>This Inner Loop Header: Depth=1
	movl	-4(%rbp), %eax
	cmpl	-12(%rbp), %eax
	jge	.LBB10_4
# %bb.2:                                # %for.body
                                        #   in Loop: Header=BB10_1 Depth=1
	movq	-32(%rbp), %rax
	movslq	-4(%rbp), %rcx
	movb	(%rax,%rcx), %al
	movq	-24(%rbp), %rcx
	movl	-4(%rbp), %edx
	subl	-8(%rbp), %edx
	movslq	%edx, %rdx
	movb	%al, (%rcx,%rdx)
# %bb.3:                                # %for.inc
                                        #   in Loop: Header=BB10_1 Depth=1
	movl	-4(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -4(%rbp)
	jmp	.LBB10_1
.LBB10_4:                               # %for.end
	movq	-24(%rbp), %rax
	movl	-12(%rbp), %ecx
	subl	-8(%rbp), %ecx
	movslq	%ecx, %rcx
	movb	$0, (%rax,%rcx)
	movq	-24(%rbp), %rax
	addq	$32, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end10:
	.size	_string_substring_, .Lfunc_end10-_string_substring_
	.cfi_endproc
                                        # -- End function
	.globl	_string_parseInt_       # -- Begin function _string_parseInt_
	.p2align	4, 0x90
	.type	_string_parseInt_,@function
_string_parseInt_:                      # @_string_parseInt_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	-16(%rbp), %rdi
	movabsq	$.L.str.2, %rsi
	leaq	-4(%rbp), %rdx
	movb	$0, %al
	callq	__isoc99_sscanf
	movl	-4(%rbp), %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end11:
	.size	_string_parseInt_, .Lfunc_end11-_string_parseInt_
	.cfi_endproc
                                        # -- End function
	.globl	_string_ord_            # -- Begin function _string_ord_
	.p2align	4, 0x90
	.type	_string_ord_,@function
_string_ord_:                           # @_string_ord_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -16(%rbp)
	movl	%esi, -4(%rbp)
	movq	-16(%rbp), %rax
	movslq	-4(%rbp), %rcx
	movsbl	(%rax,%rcx), %eax
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end12:
	.size	_string_ord_, .Lfunc_end12-_string_ord_
	.cfi_endproc
                                        # -- End function
	.globl	_string_concat          # -- Begin function _string_concat
	.p2align	4, 0x90
	.type	_string_concat,@function
_string_concat:                         # @_string_concat
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	subq	$24, %rsp
	.cfi_offset %rbx, -24
	movq	%rdi, -32(%rbp)
	movq	%rsi, -24(%rbp)
	movq	-32(%rbp), %rdi
	callq	strlen
	movq	%rax, %rbx
	movq	-24(%rbp), %rdi
	callq	strlen
	addq	%rax, %rbx
	addq	$1, %rbx
	movq	%rbx, %rdi
	callq	malloc
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rdi
	movq	-32(%rbp), %rsi
	callq	strcpy
	movq	-16(%rbp), %rdi
	movq	-24(%rbp), %rsi
	callq	strcat
	movq	-16(%rbp), %rax
	addq	$24, %rsp
	popq	%rbx
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end13:
	.size	_string_concat, .Lfunc_end13-_string_concat
	.cfi_endproc
                                        # -- End function
	.globl	_string_equal_          # -- Begin function _string_equal_
	.p2align	4, 0x90
	.type	_string_equal_,@function
_string_equal_:                         # @_string_equal_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	sete	%al
	andb	$1, %al
	movzbl	%al, %eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end14:
	.size	_string_equal_, .Lfunc_end14-_string_equal_
	.cfi_endproc
                                        # -- End function
	.globl	_string_nequal_         # -- Begin function _string_nequal_
	.p2align	4, 0x90
	.type	_string_nequal_,@function
_string_nequal_:                        # @_string_nequal_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setne	%al
	andb	$1, %al
	movzbl	%al, %eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end15:
	.size	_string_nequal_, .Lfunc_end15-_string_nequal_
	.cfi_endproc
                                        # -- End function
	.globl	_string_lessthan_       # -- Begin function _string_lessthan_
	.p2align	4, 0x90
	.type	_string_lessthan_,@function
_string_lessthan_:                      # @_string_lessthan_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setl	%al
	andb	$1, %al
	movzbl	%al, %eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end16:
	.size	_string_lessthan_, .Lfunc_end16-_string_lessthan_
	.cfi_endproc
                                        # -- End function
	.globl	_string_greaterthan_    # -- Begin function _string_greaterthan_
	.p2align	4, 0x90
	.type	_string_greaterthan_,@function
_string_greaterthan_:                   # @_string_greaterthan_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setg	%al
	andb	$1, %al
	movzbl	%al, %eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end17:
	.size	_string_greaterthan_, .Lfunc_end17-_string_greaterthan_
	.cfi_endproc
                                        # -- End function
	.globl	_string_notgreaterthan_ # -- Begin function _string_notgreaterthan_
	.p2align	4, 0x90
	.type	_string_notgreaterthan_,@function
_string_notgreaterthan_:                # @_string_notgreaterthan_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setle	%al
	andb	$1, %al
	movzbl	%al, %eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end18:
	.size	_string_notgreaterthan_, .Lfunc_end18-_string_notgreaterthan_
	.cfi_endproc
                                        # -- End function
	.globl	_string_notlessthan_    # -- Begin function _string_notlessthan_
	.p2align	4, 0x90
	.type	_string_notlessthan_,@function
_string_notlessthan_:                   # @_string_notlessthan_
	.cfi_startproc
# %bb.0:                                # %entry
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -16(%rbp)
	movq	%rsi, -8(%rbp)
	movq	-16(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setge	%al
	andb	$1, %al
	movzbl	%al, %eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end19:
	.size	_string_notlessthan_, .Lfunc_end19-_string_notlessthan_
	.cfi_endproc
                                        # -- End function
	.type	MAX_LEN,@object         # @MAX_LEN
	.section	.rodata,"a",@progbits
	.globl	MAX_LEN
	.p2align	2
MAX_LEN:
	.long	256                     # 0x100
	.size	MAX_LEN, 4

	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.1,@object        # @.str.1
.L.str.1:
	.asciz	"%s\n"
	.size	.L.str.1, 4

	.type	.L.str.2,@object        # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object        # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
