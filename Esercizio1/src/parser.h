#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#ifndef CSV_PARSER

#define CSV_PARSER
#define NR_RECORDS 20000000
#define RECORD_STR_SIZE 15
typedef struct Record{
    int id;
    char field1[RECORD_STR_SIZE];
    int field2;
    float field3;
}Record;

/*trasforma il file csv passato in input in un array di struct Record, 
dove ogni Record è una riga del csv*/
Record* parse_csv(FILE* st);
/*stampa su file (o su schermo se passato stdout) il contenuto di un record*/
void print_record(FILE *st, Record passage);
/*stampa su file (o su schermo se passato stdout) l'array di records, che si assume sia
di 20 000 000 di struct*/
void print_all_records(FILE* st, Record* records);
/*crea file csv per salvare le stat del tempo e le k*/
void print_k_stats(FILE* st, int k, time_t time);
#endif