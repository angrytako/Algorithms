//da aggiungere gli ifndef nei .h
//magari esporre struct generica nel .h
//dividere il codice in cartelle
//mettere il makefile apposto una volta fatto tutto ciò
//mettere gli include messi nei .h nei .c
//controllare che i return dei malloc non siano NULL
//aggiungere argv, argc
#include<stdio.h>
#include"sort.h"
#include "parser.h"
#include "validation.h"
#include <time.h>
#define SIZE(array) sizeof(array)/sizeof(*array)
#define MAX_STRING 50
int string_cmp(void *str1, void *str2);
int compare(void *num1, void* num2);
void print_strings(char*string, int num_strings);
void* copy_plus_one(void* array, void* elem, int sizeElem, int nrElem);
void print_array(int* array, int numElem);
int compare_records_by_field1(void *record1, void *record2);
int compare_records_by_field2(void *record1, void *record2);
int compare_records_by_field3(void *record1, void *record2);
int main (void){
    FILE* st, *after;
    Record* records, *testRecords;
    time_t beforeTime, afterTime;
    int k=1;
    if((st=fopen("../records.csv","r"))==NULL){
        fprintf(stderr,"Errore apertura file dei records!\n");
        return -1;
    }
    if((after=fopen("results.csv","w"))==NULL){
        fprintf(stderr,"Errore apertura file risultati!\n");
        return -1;
    }


    if((testRecords=malloc(NR_RECORDS*sizeof(*testRecords)))==NULL){
        fprintf(stderr,"Errore malloc\n");
        return -1;
    }
    records=parse_csv(st);
    while(1){
        memcpy(testRecords,records,NR_RECORDS*sizeof(*testRecords));
        beforeTime=time(NULL);
        printf("Elaborazione con k %d iniziata!\n", k);
        sort_k(testRecords,compare_records_by_field2,sizeof(*testRecords),NR_RECORDS,k);
        afterTime=time(NULL) -beforeTime;
        if(validate(testRecords,compare_records_by_field2,sizeof(*testRecords),NR_RECORDS))
            printf("Sort valido!!\n");
        else {
             printf("Sort non valido!!\n");
             print_all_records(after,testRecords);
             return -1;
        }
        printf("Elaborazione con k %d finita in %I64u\n ", k,afterTime);
        print_k_stats(after,k,afterTime);
        k*=2;
    }
    //print_all_records(after,records);

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
int compare_records_by_field1(void *record1, void *record2){
    return strncmp(((Record*)record1)->field1,((Record*)record2)->field1, RECORD_STR_SIZE);
}
int compare_records_by_field2(void *record1, void *record2){
    if(((Record*)record1)->field2>((Record*)record2)->field2)
        return 1;
    else if(((Record*)record1)->field2<((Record*)record2)->field2)
        return -1;
    else    
        return 0;
    }

int compare_records_by_field3(void *record1, void *record2){
    if(((Record*)record1)->field3>((Record*)record2)->field3)
        return 1;
    else if(((Record*)record1)->field3 < ((Record*)record2)->field3)
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