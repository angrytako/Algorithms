#include "parser.h"

#include "edit_distance.h"


int main (){
    FILE* st, *after;
    WordAndExtras *correct_me;
    int size;
    if((st=fopen("../correctme.txt","r"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    if((after=fopen("result.txt","w"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    correct_me=parse_inspected_file(st,&size);
   for(int i=0;i<size;i++){
       /*grazie alla struct, è molto facile ricostruire il file originario
        e allo stesso tempo sono separate le parole, sulle quali si andrà a
        lavorare, e il resto*/
       fprintf(after,"%s%s",correct_me[i].word,correct_me[i].extra);
   }
}