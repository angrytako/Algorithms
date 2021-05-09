#include "parser.h"
#include "edit_distance.h"


int main (){
    FILE* st, *after , *fdictionary;
    WordAndExtras *correct_me;
    char **dictionary;
    int size,num_word,pos_min;
    int distance=0,min=99999;

    if((st=fopen("../correctme.txt","r"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    if((after=fopen("result.txt","w"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    if((fdictionary=fopen("../dictionary.txt","r"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }

    correct_me=parse_inspected_file(st,&size);
    dictionary=parse_dictionary(fdictionary,&num_word);
    memory* mem;
    if ((mem= malloc(sizeof(memory)))==NULL) {   
        fprintf(stderr,"Error in allocating memory for the struct mem\n");
    }
   

  
  





//prima cerco una parola, se non c'è uso edit, se la trovo passo alla prossima

    printf("start edit distance\n");
    for(int i=0;i<size;i++)
    {
        printf("edit distance %s ->",correct_me[i].word);
        min=ERROR_DISTACE;

        //controllo se la parola esiste
         for(int j=0;(j<num_word && min!=0);j++){
             if (strcmp(correct_me[i].word,dictionary[j])==0){
                min=0;
                pos_min=j;
             }
         }

        //cerco la parola più simile
        for(int j=0;(j<num_word && min!=0);j++){ 
            //per ogni parola creo una nuova memoria
            free(mem->elem);
            free(mem);   
            mem=initializes_memory(mem);
            
            distance=ric_edit_distance_mem(correct_me[i].word,dictionary[j],mem);    
           
            if (distance<min){
                min=distance;
                pos_min=j;
                printf("%s,%d--" ,dictionary[j],distance);
            } 
                
            //fprintf(after,"%s --> %s =%d\n",correct_me[i].word,dictionary[j],distance); 
        }      
        printf("--%s,%d\n" ,dictionary[pos_min],min);
        fprintf(after,"%s",dictionary[pos_min]);
        fprintf(after,"%s",correct_me[i].extra);
    }



    //free memoria
/*
    free(mem->elem);
    free(mem);   
    for(int j=0;j<num_word;j++){ 
        free(dictionary[j]);
    }
    for(int i=0;i<size;i++){
        free(correct_me[i].extra);
        free(correct_me[i].word);
    }
    free(correct_me);
    free(dictionary);
*/

}