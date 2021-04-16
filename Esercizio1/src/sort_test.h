/*.h da includere nel file dello unit testing. Contiene i prototipi di tutte le funzioni che 
    si possono voler testare */
#ifndef SORT_UNIT_TESTS

#define SORT_UNIT_TESTS
int bin_search(void* array, void* elem, int (*compare)(void*,void*), int dimElem, int nrElem);

void insert_last_elem(void* array, int dimElem, int nrElem,int index);

void bin_insert_sort(void* array,int (*compare)(void*,void*), int dimElem, int nrElem);

void merge(void* array,int (*compare)(void*,void*), int dimElem,int i, int j, int k);

void sort_k(void* array, int (*compare)(void*,void*), int dimElem, int nrElem, int k);

#endif








