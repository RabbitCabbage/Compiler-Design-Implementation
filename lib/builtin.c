#include <stdio.h>
#include <string.h>
#include <stdlib.h>
const int MAX_LEN = 256;
void _print_(char *str){printf("%s",str);}

void _println_(char *str){printf("%s\n",str);}

void _printInt_(int num){printf("%d",num);}

void _printlnInt_(int num){printf("%d\n",num);}

char *_getString_(){
    char *tmp = (char *)malloc(MAX_LEN);
    scanf("%s",tmp);
    return tmp;
}

int _getInt_(){
    int i;
    scanf("%d",&i);
    return i;
}

char *_toString_(int i){
    char *tmp = (char *) malloc(MAX_LEN);
    sprintf(tmp, "%d",i);
    return tmp;
}

char *_malloc_(int length){
    char *tmp = (char *)malloc(4+length);
    int *size_ptr = (int *)tmp;
    *size_ptr = length;
    return tmp+4;
}

int _getArraySize_(char *array){
    int *size_ptr = (int*)(array - 4);
    return *size_ptr;
}

int _string_length(char *str){return strlen(str);}

char *_string_substring_(char *str,int left,int right){
    char* substr = (char*)malloc(right - left + 1);
    for (int i = left; i < right; i++) {
        substr[i - left] = str[i];
    }
    substr[right - left] = '\0';
    return substr;
}

int _string_parseInt_(char *str){
    int i;
    sscanf(str, "%d", &i);
    return i;
}

int _string_ord_(char *str, int i){
    return (int)str[i];
}

char* _string_concat(char *str1,char *str2){
    char *tmp = malloc(strlen(str1)+strlen(str2)+1);
    strcpy(tmp,str1);
    strcat(tmp,str2);
    return tmp;
}

char  _string_equal_(char *str1,char *str2){
    return strcmp(str1,str2)==0;
}

char _string_nequal_(char *str1,char *str2){
    return strcmp(str1,str2)!=0;
}

char _string_lessthan_(char *str1,char *str2){
    return strcmp(str1,str2)<0;
}

char _string_greaterthan_(char *str1,char *str2){
    return strcmp(str1,str2)>0;
}

char _string_notgreaterthan_(char *str1,char *str2){
    return strcmp(str1,str2)<=0;
}

char _string_notlessthan_(char *str1,char *str2){
    return strcmp(str1,str2)>=0;
}