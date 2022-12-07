; ModuleID = 'builtin.c'
source_filename = "builtin.c"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

@MAX_LEN = dso_local constant i32 256, align 4
@.str = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.str.1 = private unnamed_addr constant [4 x i8] c"%s\0A\00", align 1
@.str.2 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.3 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @_print_(i8* %str) #0 {
entry:
  %str.addr = alloca i8*, align 8
  store i8* %str, i8** %str.addr, align 8
  %0 = load i8*, i8** %str.addr, align 8
  %call = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i8* %0)
  ret void
}

declare dso_local i32 @printf(i8*, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @_println_(i8* %str) #0 {
entry:
  %str.addr = alloca i8*, align 8
  store i8* %str, i8** %str.addr, align 8
  %0 = load i8*, i8** %str.addr, align 8
  %call = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.1, i64 0, i64 0), i8* %0)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @_printInt_(i32 %num) #0 {
entry:
  %num.addr = alloca i32, align 4
  store i32 %num, i32* %num.addr, align 4
  %0 = load i32, i32* %num.addr, align 4
  %call = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32 %0)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @_printlnInt_(i32 %num) #0 {
entry:
  %num.addr = alloca i32, align 4
  store i32 %num, i32* %num.addr, align 4
  %0 = load i32, i32* %num.addr, align 4
  %call = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.3, i64 0, i64 0), i32 %0)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_getString_() #0 {
entry:
  %tmp = alloca i8*, align 8
  %call = call noalias i8* @malloc(i64 256) #4
  store i8* %call, i8** %tmp, align 8
  %0 = load i8*, i8** %tmp, align 8
  %call1 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i8* %0)
  %1 = load i8*, i8** %tmp, align 8
  ret i8* %1
}

; Function Attrs: nounwind
declare dso_local noalias i8* @malloc(i64) #2

declare dso_local i32 @__isoc99_scanf(i8*, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_getInt_() #0 {
entry:
  %i = alloca i32, align 4
  %call = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32* %i)
  %0 = load i32, i32* %i, align 4
  ret i32 %0
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_toString_(i32 %i) #0 {
entry:
  %i.addr = alloca i32, align 4
  %tmp = alloca i8*, align 8
  store i32 %i, i32* %i.addr, align 4
  %call = call noalias i8* @malloc(i64 256) #4
  store i8* %call, i8** %tmp, align 8
  %0 = load i8*, i8** %tmp, align 8
  %1 = load i32, i32* %i.addr, align 4
  %call1 = call i32 (i8*, i8*, ...) @sprintf(i8* %0, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32 %1) #4
  %2 = load i8*, i8** %tmp, align 8
  ret i8* %2
}

; Function Attrs: nounwind
declare dso_local i32 @sprintf(i8*, i8*, ...) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_malloc_(i32 %length) #0 {
entry:
  %length.addr = alloca i32, align 4
  %tmp = alloca i8*, align 8
  %size_ptr = alloca i32*, align 8
  store i32 %length, i32* %length.addr, align 4
  %0 = load i32, i32* %length.addr, align 4
  %add = add nsw i32 4, %0
  %conv = sext i32 %add to i64
  %call = call noalias i8* @malloc(i64 %conv) #4
  store i8* %call, i8** %tmp, align 8
  %1 = load i8*, i8** %tmp, align 8
  %2 = bitcast i8* %1 to i32*
  store i32* %2, i32** %size_ptr, align 8
  %3 = load i32, i32* %length.addr, align 4
  %4 = load i32*, i32** %size_ptr, align 8
  store i32 %3, i32* %4, align 4
  %5 = load i8*, i8** %tmp, align 8
  %add.ptr = getelementptr inbounds i8, i8* %5, i64 4
  ret i8* %add.ptr
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_getArraySize_(i8* %array) #0 {
entry:
  %array.addr = alloca i8*, align 8
  %size_ptr = alloca i32*, align 8
  store i8* %array, i8** %array.addr, align 8
  %0 = load i8*, i8** %array.addr, align 8
  %add.ptr = getelementptr inbounds i8, i8* %0, i64 -4
  %1 = bitcast i8* %add.ptr to i32*
  store i32* %1, i32** %size_ptr, align 8
  %2 = load i32*, i32** %size_ptr, align 8
  %3 = load i32, i32* %2, align 4
  ret i32 %3
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_string_length(i8* %str) #0 {
entry:
  %str.addr = alloca i8*, align 8
  store i8* %str, i8** %str.addr, align 8
  %0 = load i8*, i8** %str.addr, align 8
  %call = call i64 @strlen(i8* %0) #5
  %conv = trunc i64 %call to i32
  ret i32 %conv
}

; Function Attrs: nounwind readonly
declare dso_local i64 @strlen(i8*) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_string_substring_(i8* %str, i32 %left, i32 %right) #0 {
entry:
  %str.addr = alloca i8*, align 8
  %left.addr = alloca i32, align 4
  %right.addr = alloca i32, align 4
  %substr = alloca i8*, align 8
  %i = alloca i32, align 4
  store i8* %str, i8** %str.addr, align 8
  store i32 %left, i32* %left.addr, align 4
  store i32 %right, i32* %right.addr, align 4
  %0 = load i32, i32* %right.addr, align 4
  %1 = load i32, i32* %left.addr, align 4
  %sub = sub nsw i32 %0, %1
  %add = add nsw i32 %sub, 1
  %conv = sext i32 %add to i64
  %call = call noalias i8* @malloc(i64 %conv) #4
  store i8* %call, i8** %substr, align 8
  %2 = load i32, i32* %left.addr, align 4
  store i32 %2, i32* %i, align 4
  br label %for.cond

for.cond:                                         ; preds = %for.inc, %entry
  %3 = load i32, i32* %i, align 4
  %4 = load i32, i32* %right.addr, align 4
  %cmp = icmp slt i32 %3, %4
  br i1 %cmp, label %for.body, label %for.end

for.body:                                         ; preds = %for.cond
  %5 = load i8*, i8** %str.addr, align 8
  %6 = load i32, i32* %i, align 4
  %idxprom = sext i32 %6 to i64
  %arrayidx = getelementptr inbounds i8, i8* %5, i64 %idxprom
  %7 = load i8, i8* %arrayidx, align 1
  %8 = load i8*, i8** %substr, align 8
  %9 = load i32, i32* %i, align 4
  %10 = load i32, i32* %left.addr, align 4
  %sub2 = sub nsw i32 %9, %10
  %idxprom3 = sext i32 %sub2 to i64
  %arrayidx4 = getelementptr inbounds i8, i8* %8, i64 %idxprom3
  store i8 %7, i8* %arrayidx4, align 1
  br label %for.inc

for.inc:                                          ; preds = %for.body
  %11 = load i32, i32* %i, align 4
  %inc = add nsw i32 %11, 1
  store i32 %inc, i32* %i, align 4
  br label %for.cond

for.end:                                          ; preds = %for.cond
  %12 = load i8*, i8** %substr, align 8
  %13 = load i32, i32* %right.addr, align 4
  %14 = load i32, i32* %left.addr, align 4
  %sub5 = sub nsw i32 %13, %14
  %idxprom6 = sext i32 %sub5 to i64
  %arrayidx7 = getelementptr inbounds i8, i8* %12, i64 %idxprom6
  store i8 0, i8* %arrayidx7, align 1
  %15 = load i8*, i8** %substr, align 8
  ret i8* %15
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_string_parseInt_(i8* %str) #0 {
entry:
  %str.addr = alloca i8*, align 8
  %i = alloca i32, align 4
  store i8* %str, i8** %str.addr, align 8
  %0 = load i8*, i8** %str.addr, align 8
  %call = call i32 (i8*, i8*, ...) @__isoc99_sscanf(i8* %0, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32* %i) #4
  %1 = load i32, i32* %i, align 4
  ret i32 %1
}

; Function Attrs: nounwind
declare dso_local i32 @__isoc99_sscanf(i8*, i8*, ...) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_string_ord_(i8* %str, i32 %i) #0 {
entry:
  %str.addr = alloca i8*, align 8
  %i.addr = alloca i32, align 4
  store i8* %str, i8** %str.addr, align 8
  store i32 %i, i32* %i.addr, align 4
  %0 = load i8*, i8** %str.addr, align 8
  %1 = load i32, i32* %i.addr, align 4
  %idxprom = sext i32 %1 to i64
  %arrayidx = getelementptr inbounds i8, i8* %0, i64 %idxprom
  %2 = load i8, i8* %arrayidx, align 1
  %conv = sext i8 %2 to i32
  ret i32 %conv
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_string_concat(i8* %str1, i8* %str2) #0 {
entry:
  %str1.addr = alloca i8*, align 8
  %str2.addr = alloca i8*, align 8
  %tmp = alloca i8*, align 8
  store i8* %str1, i8** %str1.addr, align 8
  store i8* %str2, i8** %str2.addr, align 8
  %0 = load i8*, i8** %str1.addr, align 8
  %call = call i64 @strlen(i8* %0) #5
  %1 = load i8*, i8** %str2.addr, align 8
  %call1 = call i64 @strlen(i8* %1) #5
  %add = add i64 %call, %call1
  %add2 = add i64 %add, 1
  %call3 = call noalias i8* @malloc(i64 %add2) #4
  store i8* %call3, i8** %tmp, align 8
  %2 = load i8*, i8** %tmp, align 8
  %3 = load i8*, i8** %str1.addr, align 8
  %call4 = call i8* @strcpy(i8* %2, i8* %3) #4
  %4 = load i8*, i8** %tmp, align 8
  %5 = load i8*, i8** %str2.addr, align 8
  %call5 = call i8* @strcat(i8* %4, i8* %5) #4
  %6 = load i8*, i8** %tmp, align 8
  ret i8* %6
}

; Function Attrs: nounwind
declare dso_local i8* @strcpy(i8*, i8*) #2

; Function Attrs: nounwind
declare dso_local i8* @strcat(i8*, i8*) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_string_equal_(i8* %str1, i8* %str2) #0 {
entry:
  %str1.addr = alloca i8*, align 8
  %str2.addr = alloca i8*, align 8
  store i8* %str1, i8** %str1.addr, align 8
  store i8* %str2, i8** %str2.addr, align 8
  %0 = load i8*, i8** %str1.addr, align 8
  %1 = load i8*, i8** %str2.addr, align 8
  %call = call i32 @strcmp(i8* %0, i8* %1) #5
  %cmp = icmp eq i32 %call, 0
  %conv = zext i1 %cmp to i32
  %conv1 = trunc i32 %conv to i8
  ret i8 %conv1
}

; Function Attrs: nounwind readonly
declare dso_local i32 @strcmp(i8*, i8*) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_string_nequal_(i8* %str1, i8* %str2) #0 {
entry:
  %str1.addr = alloca i8*, align 8
  %str2.addr = alloca i8*, align 8
  store i8* %str1, i8** %str1.addr, align 8
  store i8* %str2, i8** %str2.addr, align 8
  %0 = load i8*, i8** %str1.addr, align 8
  %1 = load i8*, i8** %str2.addr, align 8
  %call = call i32 @strcmp(i8* %0, i8* %1) #5
  %cmp = icmp ne i32 %call, 0
  %conv = zext i1 %cmp to i32
  %conv1 = trunc i32 %conv to i8
  ret i8 %conv1
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_string_lessthan_(i8* %str1, i8* %str2) #0 {
entry:
  %str1.addr = alloca i8*, align 8
  %str2.addr = alloca i8*, align 8
  store i8* %str1, i8** %str1.addr, align 8
  store i8* %str2, i8** %str2.addr, align 8
  %0 = load i8*, i8** %str1.addr, align 8
  %1 = load i8*, i8** %str2.addr, align 8
  %call = call i32 @strcmp(i8* %0, i8* %1) #5
  %cmp = icmp slt i32 %call, 0
  %conv = zext i1 %cmp to i32
  %conv1 = trunc i32 %conv to i8
  ret i8 %conv1
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_string_greaterthan_(i8* %str1, i8* %str2) #0 {
entry:
  %str1.addr = alloca i8*, align 8
  %str2.addr = alloca i8*, align 8
  store i8* %str1, i8** %str1.addr, align 8
  store i8* %str2, i8** %str2.addr, align 8
  %0 = load i8*, i8** %str1.addr, align 8
  %1 = load i8*, i8** %str2.addr, align 8
  %call = call i32 @strcmp(i8* %0, i8* %1) #5
  %cmp = icmp sgt i32 %call, 0
  %conv = zext i1 %cmp to i32
  %conv1 = trunc i32 %conv to i8
  ret i8 %conv1
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_string_notgreaterthan_(i8* %str1, i8* %str2) #0 {
entry:
  %str1.addr = alloca i8*, align 8
  %str2.addr = alloca i8*, align 8
  store i8* %str1, i8** %str1.addr, align 8
  store i8* %str2, i8** %str2.addr, align 8
  %0 = load i8*, i8** %str1.addr, align 8
  %1 = load i8*, i8** %str2.addr, align 8
  %call = call i32 @strcmp(i8* %0, i8* %1) #5
  %cmp = icmp sle i32 %call, 0
  %conv = zext i1 %cmp to i32
  %conv1 = trunc i32 %conv to i8
  ret i8 %conv1
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_string_notlessthan_(i8* %str1, i8* %str2) #0 {
entry:
  %str1.addr = alloca i8*, align 8
  %str2.addr = alloca i8*, align 8
  store i8* %str1, i8** %str1.addr, align 8
  store i8* %str2, i8** %str2.addr, align 8
  %0 = load i8*, i8** %str1.addr, align 8
  %1 = load i8*, i8** %str2.addr, align 8
  %call = call i32 @strcmp(i8* %0, i8* %1) #5
  %cmp = icmp sge i32 %call, 0
  %conv = zext i1 %cmp to i32
  %conv1 = trunc i32 %conv to i8
  ret i8 %conv1
}

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #2 = { nounwind "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #3 = { nounwind readonly "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #4 = { nounwind }
attributes #5 = { nounwind readonly }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 10.0.0-4ubuntu1 "}
