#include "parser.h"
Record* parse_csv(FILE* st, int* nrElems);
void print_record(FILE *st, Record passage);
int get_field(FILE *st, char* buffer, char stop);
void print_all_records(FILE* st, Record* records,  int nrRecords);
void print_k_stats(FILE* st, int k, long time);

Record* parse_csv(FILE* st, int* nrElems){
    if(st==NULL)
        return NULL;
    int i=0;
    int currLength=1;    
    char buffer[RECORD_STR_SIZE];
    Record* records;
    if((records=malloc((size_t)currLength*sizeof(*records)))==NULL){
        fprintf(stderr,"Error in allocating memory for the records array\n");
            }
    while(1)
    {
    
        if(i>=currLength){
          //  printf("realloc %lld\n",currLength);
            currLength*=2;
            if((records=realloc(records,(size_t)currLength*sizeof(*records)))==NULL){
                fprintf(stderr,"Error in allocating memory for the records array\n");
            }
        }
        if(get_field(st,buffer,','))
            break;
        records[i].id=atoi(buffer);
        memset(buffer, 0,RECORD_STR_SIZE);

        get_field(st,buffer,',');
        strncpy(records[i].field1,buffer,RECORD_STR_SIZE);
        memset(buffer, 0,RECORD_STR_SIZE);

        get_field(st,buffer,',');
        records[i].field2=atoi(buffer);
        memset(buffer, 0,RECORD_STR_SIZE);

       if( get_field(st,buffer,'\n')){
            records[i].field3=(float) atof(buffer);
            memset(buffer, 0,RECORD_STR_SIZE);
            i++;
            break;
       }
       else{
           records[i].field3=(float) atof(buffer);
            memset(buffer, 0,RECORD_STR_SIZE);
            i++;
       }
        
    }
    *nrElems=i;
    return records;

}

int get_field(FILE *st, char* buffer, char stop){
    int intChar, j=0;
    while ((intChar=getc(st))!=stop)
        {   
            if(intChar==-1)
                return 1;
            buffer[j]=(char)intChar;
            j++;
        }
    buffer[j]=0;
    return 0;
}
void print_record(FILE *st, Record passage){
    fprintf(st,"%d,%s,%d,%f",passage.id,passage.field1,passage.field2,passage.field3);
}
void print_all_records(FILE* st, Record* records,  int nrRecords){
    int i;
    for(i=0;i<nrRecords;i++)
    {
        print_record(st,records[i]);
        fprintf(st,"\n");
    }
}
void print_k_stats(FILE* st, int k, long time){
    static char isFirstTime=1;
    if(isFirstTime){
        fprintf(st,"K,Time\n");
        isFirstTime=0;
    }
    fprintf(st,"%d,%li\n",k,time);
    fflush(st);
}