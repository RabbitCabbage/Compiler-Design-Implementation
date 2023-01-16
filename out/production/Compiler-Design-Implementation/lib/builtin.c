#include <stdio.h>
#include <string.h>
#include <stdlib.h>
const int MAX_LEN = 256;
void print(char *str){printf("%s",str);}

void println(char *str){printf("%s\n",str);}

void printInt(int num){printf("%d",num);}

void printlnInt(int num){printf("%d\n",num);}

char *getString(){
    char *tmp = (char *)malloc(MAX_LEN);
    scanf("%s",tmp);
    return tmp;
}

int getInt(){
    int i;
    scanf("%d",&i);
    return i;
}

char *toString(int i){
    char *tmp = (char *) malloc(MAX_LEN);
    sprintf(tmp, "%d",i);
    return tmp;
}

char *malloc_(int length){
    char *tmp = (char *)malloc(4+length);
    int *size_ptr = (int *)tmp;
    *size_ptr = length;
    return tmp+4;
}

int getArraySize(char *array){
    int *size_ptr = (int*)(array - 4);
    return *size_ptr;
}

int string_length(char *str){return strlen(str);}

char *string_substring(char *str,int left,int right){
    char* substr = (char*)malloc(right - left + 1);
    for (int i = left; i < right; i++) {
        substr[i - left] = str[i];
    }
    substr[right - left] = '\0';
    return substr;
}

int string_parseInt(char *str){
    int i;
    sscanf(str, "%d", &i);
    return i;
}

int string_ord(char *str, int i){
    return (int)str[i];
}

char* string_concat(char *str1,char *str2){
    char *tmp = malloc(strlen(str1)+strlen(str2)+1);
    strcpy(tmp,str1);
    strcat(tmp,str2);
    return tmp;
}

char  string_equal(char *str1,char *str2){
    return strcmp(str1,str2)==0;
}

char string_nequal(char *str1,char *str2){
    return strcmp(str1,str2)!=0;
}

char string_lessthan(char *str1,char *str2){
    return strcmp(str1,str2)<0;
}

char string_greaterthan(char *str1,char *str2){
    return strcmp(str1,str2)>0;
}

char string_notgreaterthan(char *str1,char *str2){
    return strcmp(str1,str2)<=0;
}

char string_notlessthan(char *str1,char *str2){
    return strcmp(str1,str2)>=0;
}