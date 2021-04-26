#include "parser.h"

#include "edit_distance.h"


int main (){
    FILE* st, *after , *fdictionary;
    WordAndExtras *correct_me;
    char **dictionary;
    int size,num_word;
    int distance=0;

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


/*
    char s1[]="Quando";
    char s2[]="Q";
    distance=ric_edit_distance(s1,s2);    
    printf("Distance: %d",distance);
*/


    printf("start edit distance\n");
    for(int i=0;i<size;i++)
    {   
        while (strlen(correct_me[i].word)<=0) i++;
        printf("edit distance %s\n",correct_me[i].word);
        for(int j=0;j<num_word;j++){   
            distance=ric_edit_distance(correct_me[i].word,dictionary[j]);    
            fprintf(after,"%s --> %s =%d\n",correct_me[i].word,dictionary[j],distance); 
        }           
    }





/* per controllare che prenda bene le parole da togliere 
    for(int i=0;i<num_word;i++){  
        for(int j=0;j<strlen(dictionary[i]);j++){
            printf("%c\n",dictionary[i][j]);
        }
        printf("\n\n");
    }
*/


   for(int i=0;i<size;i++){
       /*grazie alla struct, è molto facile ricostruire il file originario
        e allo stesso tempo sono separate le parole, sulle quali si andrà a
        lavorare, e il resto*/
       fprintf(after,"%s%s",correct_me[i].word,correct_me[i].extra);
   }
}