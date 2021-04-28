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
    mem->max_elem=500;
    if ( (mem->elem= malloc(sizeof(cell)*mem->max_elem) )==NULL) fprintf(stderr,"Error in allocating cell1\n");
    mem->num_elem=0;
    

/*
   
    for(int i=0;i<10000;i++){
            printf("%d\n",i);
            push_min(dictionary[i],dictionary[9999],i,mem);
    }
   
printf("bloccato\n");

     for(int i=0;i<mem->num_elem;i++){
            printf("%s,%d\n",mem->elem[i].key,mem->elem[i].values);
        }
  


    

    printf("out:%d\n",ceck_mem(dictionary[9],dictionary[4],mem));
    printf("out:%d\n",ceck_mem(dictionary[200],dictionary[9999],mem));
        printf("out:%d\n",ceck_mem(dictionary[4444],dictionary[9999],mem));

*/

/*
    char s1[]="Quando";
    char s2[]="Q";
    distance=ric_edit_distance_mem(s1,s2,mem);    
    printf("Distance: %d",distance);

*/




    printf("start edit distance\n");
    for(int i=0;i<size;i++)
    {   
        while (strlen(correct_me[i].word)<=0) i++;
        printf("edit distance %s -->",correct_me[i].word);
        min=999999;
        for(int j=0;j<num_word;j++){ 
            //per ogni parola creo una nuova memoria
            free(mem->elem);
            free(mem);    
            if ((mem= malloc(sizeof(memory)))==NULL) {   
            fprintf(stderr,"Error in allocating memory for the struct mem\n");
            }
            mem->max_elem=500;
            if ( (mem->elem= malloc(sizeof(cell)*mem->max_elem) )==NULL) 
            fprintf(stderr,"Error in allocating cell1\n");
            mem->num_elem=0;

            distance=ric_edit_distance_mem(correct_me[i].word,dictionary[j],mem);    
            //bisogna salvare le parole più vicine 
            if (distance<min){
                min=distance;
                pos_min=j;
            } 
            fprintf(after,"%s --> %s =%d\n",correct_me[i].word,dictionary[j],distance); 
        }  
        printf("%s\n",dictionary[pos_min]);         
    }







}