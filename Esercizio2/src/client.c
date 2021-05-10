#include "parser.h"
#include "bin_search.h"
#include "edit_distance.h"


int main (){
/*dare la possibilità di input*/

    FILE* inputFile, *result , *fdictionary;
    WordAndExtras *correctMe;
    Memory* mem;
    char **dictionary;
    int inputWord,numWord,pos_min;
    int distance=0,min,firsCapital=0;


    if((inputFile=fopen("../correctme.txt","r"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    if((result=fopen("result.txt","w"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }
    if((fdictionary=fopen("../dictionary.txt","r"))==NULL){
        fprintf(stderr,"Unable to open input file!\n");
        return -1;
    }

    correctMe=parse_inspected_file(inputFile,&inputWord);
    dictionary=parse_dictionary(fdictionary,&numWord);
  
    
   

  
  

    //prima cerco una parola, se non c'è uso edit, se la trovo passo alla prossima
    printf("start edit distance:\n");
    /*for sulle parole di input ->(la frase da trasformare)*/
    for(int i=0;i<inputWord;i++)
    {
        printf("edit distance %s: ",correctMe[i].word);
        min=ERROR_DISTACE;
        
        if ( (*correctMe[i].word >='A') && (*correctMe[i].word<='Z')) {
               *correctMe[i].word=*correctMe[i].word+32;
               firsCapital = 1; 
            }
        //controllo se la parola esiste   /*aggiungere bynery search*/
        pos_min= bin_search(dictionary,correctMe[i].word,numWord);
        if (strcmp(correctMe[i].word,dictionary[pos_min])==0)   min=0;
        
  

        //cerco la parola più simile nel dizionario
        for(int j=0;(j<numWord && min!=0);j++){ 
            //per ogni parola creo una nuova memoria
            if (j!=0) free_memory_edit_distance(mem);
            mem=initializes_memory_edit_distance(mem);
        
            distance=ric_edit_distance_mem(correctMe[i].word,dictionary[j],mem);    
            //controllo se è la parola più vicina
            if (distance<min){
                min=distance;
                pos_min=j;
                printf(" %s->%d ||" ,dictionary[j],distance);
            }       
            //fprintf(result,"%s --> %s =%d\n",correctMe[i].word,dictionary[j],distance); 
        }  


        /* output della parola più vicina*/
        if (firsCapital==1)  *dictionary[pos_min]= *dictionary[pos_min]-32;
    
        printf(" %s->%i\n" ,dictionary[pos_min],min);
        fprintf(result,"%s%s",dictionary[pos_min],correctMe[i].extra);      
        if (firsCapital==1){
            *dictionary[pos_min]= *dictionary[pos_min]+32;
            firsCapital=0;
        }

    }



    free_memory_parser(dictionary,numWord,correctMe,inputWord);
    free_memory_edit_distance(mem);


}