#include "parser.h"

int get_word(FILE *st, char* buffer);
int get_word_and_extras(FILE *st, WordAndExtras* structBuffer);
char** parse_dictionary(FILE* st, int* nrElems);
WordAndExtras* parse_inspected_file (FILE* st, int* nrElems);


char** parse_dictionary(FILE* st, int* nrElems){
    if(st==NULL)
        return NULL;
    int i=0;
    int maxNumElem=1024;    
    char buffer[WORD_SIZE];
    char** dictionary;
    if((dictionary=malloc((size_t)maxNumElem*sizeof(*dictionary)))==NULL){
        fprintf(stderr,"Error in allocating memory for the dictionary\n");
            }
    while(1)
    {
    
        if(i>=maxNumElem){
          //  printf("realloc %lld\n",maxNumElem);
            maxNumElem*=2;
            if((dictionary=realloc(dictionary,(size_t)maxNumElem*sizeof(*dictionary)))==NULL){
                fprintf(stderr,"Error in allocating more memory for the dictionary\n");
            }
        }
        if(get_word(st,buffer)){
            if(strlen(buffer)==0)
                 break;
            else {
                dictionary[i]=malloc(WORD_SIZE);
                strncpy(dictionary[i],buffer,WORD_SIZE);
                i++;
                break;
            }
        }
           
        dictionary[i]=malloc(WORD_SIZE);
        strncpy(dictionary[i],buffer,WORD_SIZE);
        memset(buffer, 0,WORD_SIZE);
        i++;
    }
    *nrElems=i;
    return dictionary;

}

WordAndExtras* parse_inspected_file (FILE* st, int* nrElems){
     if(st==NULL)
        return NULL;
    int i=0;
    int maxNumElem=1024;    
    WordAndExtras structBuffer;
    WordAndExtras *toBeInspected;

    if((structBuffer.word=malloc(WORD_SIZE))==NULL){
        fprintf(stderr,"Error in allocating memory for the buffer\n");
    }
    if((structBuffer.extra=malloc(EXTRA_SIZE))==NULL){
        fprintf(stderr,"Error in allocating memory for the buffer\n");
    }
    if((toBeInspected=malloc((size_t)maxNumElem*sizeof(*toBeInspected)))==NULL){
        fprintf(stderr,"Error in allocating memory for the file to be inspected\n");
            }
    while(1)
    {
    
        if(i>=maxNumElem){
            maxNumElem*=2;
            if((toBeInspected=realloc(toBeInspected,(size_t)maxNumElem*sizeof(*toBeInspected)))==NULL){
                fprintf(stderr,"Error in allocating more memory for the file to be inspected\n");
            }
        }
        if(get_word_and_extras(st,&structBuffer)){
            if(strlen(structBuffer.word)==0)
                break;
            else{
                toBeInspected[i].word=malloc(WORD_SIZE);
                toBeInspected[i].extra=malloc(EXTRA_SIZE);
                strncpy(toBeInspected[i].word,structBuffer.word,WORD_SIZE);
                strncpy(toBeInspected[i].extra,structBuffer.extra,EXTRA_SIZE);
                i++;
                break;
            }
        }
            toBeInspected[i].word=malloc(WORD_SIZE);
            toBeInspected[i].extra=malloc(EXTRA_SIZE);
            strncpy(toBeInspected[i].word,structBuffer.word,WORD_SIZE);
            strncpy(toBeInspected[i].extra,structBuffer.extra,EXTRA_SIZE);
            memset(structBuffer.word, 0,WORD_SIZE);
            memset(structBuffer.extra, 0,EXTRA_SIZE);
            i++;
    }
    *nrElems=i;
    free(structBuffer.word);
    free(structBuffer.extra);
    return toBeInspected;
}

int get_word(FILE *st, char* buffer){
    int intChar, j=0;
    while ((intChar=getc(st))!='\n')
        {   
            if(intChar==-1)
                return 1;
            buffer[j]=(char)intChar;
            j++;
        }
    buffer[j]=0;
    return 0;
}

int get_word_and_extras(FILE *st, WordAndExtras* structBuffer){
    static int lastLetter=-1;
    int intChar, j=1;
    if(lastLetter!=-1){
        structBuffer->word[0]=(char)lastLetter;
    }
       
    else
        j=0;
    while (1){ 
        intChar=getc(st);
        if(!(((char)intChar>='A' && (char)intChar<='Z') || ((char)intChar>='a' && (char)intChar<='z')) || intChar==-1) break;
            structBuffer->word[j]=(char)intChar;
                j++;
        }
    structBuffer->word[j]=0;
    if(intChar==-1)
            return 1;
    else
        structBuffer->extra[0]=(char)intChar;
    j=1;
    while(1){
        intChar=getc(st);
        if(((char)intChar>='A' && (char)intChar<='Z') || ((char)intChar>='a' && (char)intChar<='z'))
            break;
        if(intChar==-1)
            return 1;
        structBuffer->extra[j]=(char)intChar;
            j++;
     }
    structBuffer->extra[j]=0;
    lastLetter=intChar;
 
    return 0;
}



void free_memory_parser(char** dictionary, int numWord, WordAndExtras* correctMe,int numElemCorrectMe){  
    for(int j=0;j<numWord;j++){ 
        free(dictionary[j]);
    }
    for(int i=0;i<numElemCorrectMe;i++){
        free(correctMe[i].extra);
        free(correctMe[i].word);
    }
    free(correctMe);
    free(dictionary);
}