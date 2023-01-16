	.text
	.file	"builtin.c"
	.globl	print                   # -- Begin function print
	.p2align	4, 0x90
	.type	print,@function
print:                                  # @print
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
	.size	print, .Lfunc_end0-print
	.cfi_endproc
                                        # -- End function
	.globl	println                 # -- Begin function println
	.p2align	4, 0x90
	.type	println,@function
println:                                # @println
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
	.size	println, .Lfunc_end1-println
	.cfi_endproc
                                        # -- End function
	.globl	printInt                # -- Begin function printInt
	.p2align	4, 0x90
	.type	printInt,@function
printInt:                               # @printInt
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
	.size	printInt, .Lfunc_end2-printInt
	.cfi_endproc
                                        # -- End function
	.globl	printlnInt              # -- Begin function printlnInt
	.p2align	4, 0x90
	.type	printlnInt,@function
printlnInt:                             # @printlnInt
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
	.size	printlnInt, .Lfunc_end3-printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	getString               # -- Begin function getString
	.p2align	4, 0x90
	.type	getString,@function
getString:                              # @getString
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
	.size	getString, .Lfunc_end4-getString
	.cfi_endproc
                                        # -- End function
	.globl	getInt                  # -- Begin function getInt
	.p2align	4, 0x90
	.type	getInt,@function
getInt:                                 # @getInt
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
	.size	getInt, .Lfunc_end5-getInt
	.cfi_endproc
                                        # -- End function
	.globl	toString                # -- Begin function toString
	.p2align	4, 0x90
	.type	toString,@function
toString:                               # @toString
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
	.size	toString, .Lfunc_end6-toString
	.cfi_endproc
                                        # -- End function
	.globl	malloc_                 # -- Begin function malloc_
	.p2align	4, 0x90
	.type	malloc_,@function
malloc_:                                # @malloc_
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
	.size	malloc_, .Lfunc_end7-malloc_
	.cfi_endproc
                                        # -- End function
	.globl	getArraySize            # -- Begin function getArraySize
	.p2align	4, 0x90
	.type	getArraySize,@function
getArraySize:                           # @getArraySize
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
	.size	getArraySize, .Lfunc_end8-getArraySize
	.cfi_endproc
                                        # -- End function
	.globl	string_length           # -- Begin function string_length
	.p2align	4, 0x90
	.type	string_length,@function
string_length:                          # @string_length
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
	.size	string_length, .Lfunc_end9-string_length
	.cfi_endproc
                                        # -- End function
	.globl	string_substring        # -- Begin function string_substring
	.p2align	4, 0x90
	.type	string_substring,@function
string_substring:                       # @string_substring
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
	.size	string_substring, .Lfunc_end10-string_substring
	.cfi_endproc
                                        # -- End function
	.globl	string_parseInt         # -- Begin function string_parseInt
	.p2align	4, 0x90
	.type	string_parseInt,@function
string_parseInt:                        # @string_parseInt
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
	.size	string_parseInt, .Lfunc_end11-string_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	string_ord              # -- Begin function string_ord
	.p2align	4, 0x90
	.type	string_ord,@function
string_ord:                             # @string_ord
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
	.size	string_ord, .Lfunc_end12-string_ord
	.cfi_endproc
                                        # -- End function
	.globl	string_concat           # -- Begin function string_concat
	.p2align	4, 0x90
	.type	string_concat,@function
string_concat:                          # @string_concat
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
	.size	string_concat, .Lfunc_end13-string_concat
	.cfi_endproc
                                        # -- End function
	.globl	string_equal            # -- Begin function string_equal
	.p2align	4, 0x90
	.type	string_equal,@function
string_equal:                           # @string_equal
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
	.size	string_equal, .Lfunc_end14-string_equal
	.cfi_endproc
                                        # -- End function
	.globl	string_nequal           # -- Begin function string_nequal
	.p2align	4, 0x90
	.type	string_nequal,@function
string_nequal:                          # @string_nequal
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
	.size	string_nequal, .Lfunc_end15-string_nequal
	.cfi_endproc
                                        # -- End function
	.globl	string_lessthan         # -- Begin function string_lessthan
	.p2align	4, 0x90
	.type	string_lessthan,@function
string_lessthan:                        # @string_lessthan
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
	.size	string_lessthan, .Lfunc_end16-string_lessthan
	.cfi_endproc
                                        # -- End function
	.globl	string_greaterthan      # -- Begin function string_greaterthan
	.p2align	4, 0x90
	.type	string_greaterthan,@function
string_greaterthan:                     # @string_greaterthan
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
	.size	string_greaterthan, .Lfunc_end17-string_greaterthan
	.cfi_endproc
                                        # -- End function
	.globl	string_notgreaterthan   # -- Begin function string_notgreaterthan
	.p2align	4, 0x90
	.type	string_notgreaterthan,@function
string_notgreaterthan:                  # @string_notgreaterthan
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
	.size	string_notgreaterthan, .Lfunc_end18-string_notgreaterthan
	.cfi_endproc
                                        # -- End function
	.globl	string_notlessthan      # -- Begin function string_notlessthan
	.p2align	4, 0x90
	.type	string_notlessthan,@function
string_notlessthan:                     # @string_notlessthan
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
	.size	string_notlessthan, .Lfunc_end19-string_notlessthan
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
