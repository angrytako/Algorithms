#include<stdio.h>
#include"sort.h"
#include "parser.h"
#define SIZE(array) sizeof(array)/sizeof(*array)
#define MAX_STRING 50
int string_cmp(void *str1, void *str2);
int compare(void *num1, void* num2);
void print_strings(char*string, int num_strings);
void* copy_plus_one(void* array, void* elem, int sizeElem, int nrElem);
void print_array(int* array, int numElem);
int compareRecordsByField2(void *record1, void *record2);
int main (void){
    FILE* st, *after;
    Record* records;
    if((st=fopen("records.csv","r"))==NULL)
        printf("Errore apertura file!\n");
    after=fopen("results.csv","w");
    records=parse_csv(st);
    sort(records,compareRecordsByField2,sizeof(*records),NR_RECORDS);
    print_all_records(after,records);

}
int string_cmp(void *str1, void *str2){
    return strncmp((char*)str1,(char*)str2, MAX_STRING);
}
int compare(void *num1, void *num2){
    if(*(int*)num1>*(int*)num2)
        return 1;
    else if(*(int*)num1<*(int*)num2)
        return -1;
    else    
        return 0;
    }
int compareRecordsByField2(void *record1, void *record2){
    if(((Record*)record1)->field2>((Record*)record2)->field2)
        return 1;
    else if(((Record*)record1)->field2<((Record*)record2)->field2)
        return -1;
    else    
        return 0;
    }
void print_array(int* array, int numElem){
    int i;
    if(array==NULL || numElem<=0){
         printf("{ }\n");
        return;
    }
    if(numElem==1){
        printf("{ %d }\n",array[0]);
        return;
    }
    printf("{ %d",array[0]);
    for(i=1;i<numElem-1;i++)
        printf(",%d",array[i]);
    printf(",%d }\n",array[i]);
    return;
}
void* copy_plus_one(void* array, void* elem, int sizeElem, int nrElem){
    if(array==NULL || sizeElem<=0 || nrElem<=0)
        return NULL;
    void* sup;
    int i;
    sup=malloc(sizeElem*(nrElem+1));
    for(i=0;i<nrElem;i++)
        memcpy(SUM_VOID(sup,i*sizeElem),SUM_VOID(array,i*sizeElem),sizeElem);
    memcpy(SUM_VOID(sup,i*sizeElem),elem,sizeElem);
    return sup;
}
void print_strings(char*string, int num_strings ){
   if(string==NULL || num_strings<=0)
        return;
    int i;
    for(i=0;i<num_strings-1;i++){
        printf("%s ",string);
        string+=50;
    }
     printf("%s\n",string);
}