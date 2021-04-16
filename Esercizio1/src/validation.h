#include <stdlib.h>
#include <stdio.h>
#include "sort.h"

#ifndef SORT_VALIDATION
#define SORT_VALIDATION
char validate(void* array, int (*compare)(void*,void*), int dimElem, int nrElem);
#endif