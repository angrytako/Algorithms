#include <stdlib.h>
#include <stdio.h>
#define SUM_VOID(array, nrBits) ((void*)(((char*)array)+(nrBits)))
char validate(void* array, int (*compare)(void*,void*), int dimElem, int nrElem);