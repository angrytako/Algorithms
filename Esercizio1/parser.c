#include "parser.h"
Record* parse_csv(FILE* st);
void print_record(FILE *st, Record passage);
void get_field(FILE *st, char* buffer, char stop);
void print_all_records(FILE* st, Record* records);
Record* parse_csv(FILE* st){
    int i;    
    char buffer[50];
    Record* records;
    records=malloc(NR_RECORDS*sizeof(*records));
    for(i=0;i<NR_RECORDS;i++)
    {
        get_field(st,buffer,',');
        records[i].id=atoi(buffer);
        memset(buffer, 0,50);

        get_field(st,buffer,',');
        strncpy(records[i].field1,buffer,50);
        memset(buffer, 0,50);

        get_field(st,buffer,',');
        records[i].field2=atoi(buffer);
        memset(buffer, 0,50);

        get_field(st,buffer,'\n');
        records[i].field3=atof(buffer);
        memset(buffer, 0,50);
    }
    return records;

}
void get_field(FILE *st, char* buffer, char stop){
    int intChar, j=0;
    while ((intChar=getc(st))!=stop)
        {
            buffer[j]=(char)intChar;
            j++;
        }
    buffer[j]=0;
}
void print_record(FILE *st, Record passage){
    fprintf(st,"%10d: field1: %15s | field2: %10d | field3: %10f",passage.id,passage.field1,passage.field2,passage.field3);
}
void print_all_records(FILE* st, Record* records){
    int i;
    for(i=0;i<NR_RECORDS;i++)
    {
        print_record(st,records[i]);
        fprintf(st,"\n");
    }
}