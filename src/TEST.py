import os
from re import *
import subprocess
print(os.getcwd())
#assert(os.getcwd()==r'mnt/d/desktop/Compiler-Design-Implementation/src')# Compiler的绝对路径
print(os.path.exists(r'D:\Desktop\Compiler-Design-Implementation\testcase\sema'))
for path,pname,file in os.walk(r'D:\Desktop\Compiler-Design-Implementation\testcase\sema'):#testcase相对Compiler的路径
    print(path,file)
    for f in file:
        if not match(".*mx$",f):
            #print(f)
            continue
        name=os.path.join(path,f)
        print(name)
        ret=subprocess.run('java Compiler {}'.format(name),shell=True,stdout=subprocess.PIPE,stderr=subprocess.PIPE,timeout=1)
        print(ret.stderr)