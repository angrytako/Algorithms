#include <stdlib.h>
#include<string.h>
#define SUM_VOID(array, nrBits) ((void*)(((char*)array)+(nrBits)))
#define SUB_VOID(array, nrBits) (void*(((char*)array)-(nrBits)))

void sort(void* array,int (*compare)(void*,void*), int dimElem, int nrElem);