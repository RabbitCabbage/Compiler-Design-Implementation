import os
from re import *
import subprocess

assert(os.getcwd()==r'D:\Desktop\Compiler-Design-Implementation\src')# Compiler的绝对路径
for path,pname,file in os.walk(r'..\testcases\sema'):#testcase相对Compiler的路径
    #print(path,file)
    for f in file:
        if not match(".*mx.*",f):
            #print(f)
            continue
        name=os.path.join(path,f)
        print(f"Testing {name}")
        ans=False
        with open(name,'r',encoding='utf8') as p:
            content=p.read()
            if(content.find("Verdict: Success")!=-1):
                ans=True
        ret=subprocess.run('java Compiler {}'.format(name),shell=True,stdout=subprocess.PIPE,stderr=subprocess.PIPE,timeout=1)
        if (ret.stderr and ans==True) or (not ret.stderr and ans==False):
            print("Wrong Guess. ans should be {}".format(ans))
        # else:
        #     print('Correct')
