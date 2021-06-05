//finire unit test
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
    Record* records;
    int nrRecords;
    char input_path[30];
    int mode=-1;
    int (*compare_functions[3])(void*,void*);
    compare_functions[0]=compare_records_by_field1;
    compare_functions[1]=compare_records_by_field2;
    compare_functions[2]=compare_records_by_field3;
    if (argn<=1){
        printf("Warning, you have not provided an input file as argument\nDefault path assumed to be ../records.csv\n");
        sprintf(input_path,"../records.csv");
    }
    else{
        sprintf(input_path,"%s",args[1]);
    }
    if((st=fopen(input_path,"r"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    if((after=fopen("result.csv","w"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    while(mode<1 || mode>3){
        printf("Insert the number of the field to sort by:");
        fflush(stdout);
        scanf("%d",&mode);
        if(mode<1 || mode>3)
            fprintf(stderr,"The number inserted needs to be between 0 and 4\n");

    }
    printf("Loading file in memory...\n");
    records=parse_csv(st, &nrRecords);
    
        printf("Sorting with %d records!\n", nrRecords);
        sort(records,compare_functions[mode-1],sizeof(*records),nrRecords);
        printf("Sort completed!\n");
        if(validate(records,compare_functions[mode-1],sizeof(*records),nrRecords))
            printf("Valid sort!!\n");
        else {
            printf("Invalid sort!!\n");
            print_all_records(after,records,nrRecords);
            printf("Writing to file...\nResult in /bin/result.csv\n ");
            return -1;
        }
        printf("Writing to file...\nResult in /bin/result.csv\n ");

    print_all_records(after,records,nrRecords);
    free(records);

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