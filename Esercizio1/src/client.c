//da aggiungere gli ifndef nei .h
//magari esporre struct generica nel .h
//dividere il codice in cartelle
//mettere il makefile apposto una volta fatto tutto ciò
//mettere gli include messi nei .h nei .c
//controllare che i return dei malloc non siano NULL
//aggiungere argv, argc
#include <stdio.h>
#include "sort.h"
#include "parser.h"
#include "validation.h"
#include <time.h>
#define SIZE(array) sizeof(array)/sizeof(*array)

int compare_records_by_field1(void *record1, void *record2);
int compare_records_by_field2(void *record1, void *record2);
int compare_records_by_field3(void *record1, void *record2);
int main (int argn, char **args){
    FILE* st, *after;
    Record* records, *testRecords;
    time_t beforeTime, afterTime;
    char input_path[30];
    if (argn<=1){
        printf("Warning, you have not provided an input file as argument\nDefault path assumed to be ../records.csv\n");
        sprintf(input_path,"../records.csv");
    }
    else{
        sprintf(input_path,"%s",args[1]);
    }
    int k=1;
    if((st=fopen(input_path,"r"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    if((after=fopen("result.csv","w"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }


    if((testRecords=malloc(NR_RECORDS*sizeof(*testRecords)))==NULL){
        fprintf(stderr,"Malloc error\n Unable to store records\n");
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
        k+=1;
    }
    //print_all_records(after,records);
    free(records);
    free(testRecords);

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