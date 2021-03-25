#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define NR_RECORDS 20000000
typedef struct Record{
    int id;
    char field1[50];
    int field2;
    float field3;
}Record;

Record* parse_csv(FILE* st);

void print_record(FILE *st, Record passage);

void print_all_records(FILE* st, Record* records);