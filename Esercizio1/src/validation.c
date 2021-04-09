#include "validation.h"

char validate(void* array, int (*compare)(void*,void*), int dimElem, int nrElem){
    if(array==NULL || compare==NULL || dimElem<=0 || nrElem<=0)
        return 0;
    int resultCmp;
    for(int i=1; i<nrElem-1;i++){
        resultCmp=compare(SUM_VOID(array,i*dimElem),SUM_VOID(array,(i+1)*dimElem));
        if(resultCmp==1){
            fprintf(stderr,"Problema all elemento nr %d \n",i);
            return 0;
        }
    }
    return 1;
}