#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#ifndef MERGE_INSERT_BIN_SORT
#define MERGE_INSERT_BIN_SORT
#define SUM_VOID(array, nrBits) ((void*)(((char*)array)+(nrBits)))

/*va dato in in input il puntatore all'array, una funzione di tipo (*void, *void) che 
ritorna 1 se il primo elem > secondo elem, -1 se il primo elem < secondo elem, e 0 se sono uguali,
la dimensione di un singolo elemento dell'array e il nr di elementi dell'array*/
void sort(void* array, int (*compare)(void*,void*), int dimElem, int nrElem);
void bin_insert_sort(void* array, int (*compare)(void*,void*), int dimElem, int nrElem);
/*funzione esposta allo scopo di poter testare varie k facilmente, in maniera procedurale*/
void sort_k(void* array, int (*compare)(void*,void*), int dimElem, int nrElem, int k);
#endif