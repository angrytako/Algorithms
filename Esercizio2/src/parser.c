#include "parser.h"

char** parse_csv(FILE* st, int* nrElems); //661563 --> num elemement txt


char** parse_csv(FILE* st, int* nrElems){
    if(st==NULL)
        return NULL;
    FILE *fp;
     
    char** array;
    if((array=malloc(nrElems*sizeof(*char)))==NULL){
        fprintf(stderr,"Error in allocating memory for the records array\n");
    }

    if((fp=fopen(st)==NULL) {
		printf("Errore nell'apertura del file'");
		exit(1);
	}
    
    
    return array;
}

