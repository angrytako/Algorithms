#include "edit_distance.h"


void push_min(char* str1, char* str2,int value, Memory* mem);
int ceck_mem(char* str1, char* str2, Memory* mem);
int hash(char* str1, char* str2);
int classic_edit_distance(char* str1, char* str2);
int dinamic_edit_distance( char* str1, char* str2,Memory* mem);

        
int ric_edit_distance(char* str1, char* str2){
        if (str1==NULL || str2==NULL) return ERROR_DISTACE; 
        else return classic_edit_distance(str1,str2);
}      

int classic_edit_distance(char* str1, char* str2){
       
        int lenght_str1,lenght_str2;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = (int)strlen(str1);
        lenght_str2 = (int)strlen(str2);
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        //caso in cui tolgo un elemento da entrambe 
        if (*str1==*str2) dnoop= classic_edit_distance(REST(str1),REST(str2));
        else dnoop = ERROR_DISTACE;

        //secondo caso
        dcanc = 1 + classic_edit_distance(str1,REST(str2));

        dins = 1 + classic_edit_distance(REST(str1),str2);
    
        //min
        if (dcanc<dnoop)dnoop = dcanc;
        if (dins<dnoop)dnoop = dins;
        return dnoop;
}

int ric_edit_distance_mem( char* str1, char* str2,Memory* mem){
        if (str1==NULL || str2==NULL || mem==NULL) return ERROR_DISTACE; 
        else return dinamic_edit_distance(str1,str2,mem);
}

int dinamic_edit_distance( char* str1, char* str2,Memory* mem){
        if (str1==NULL || str2==NULL || mem==NULL) return ERROR_DISTACE; 
        int lenght_str1,lenght_str2;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = (int)strlen(str1);
        lenght_str2 = (int)strlen(str2);
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        /*uso donoop come variabile di appoggio*/  
        dnoop=ceck_mem(str1,str2,mem);

        if(dnoop!=-1){
        return dnoop;
        } 
        //caso in cui tolgo un elemento da entrambe 
        if (*str1==*str2) dnoop= dinamic_edit_distance(REST(str1),REST(str2),mem);
        else dnoop = ERROR_DISTACE; 
        //secondo caso
        dcanc = 1 + dinamic_edit_distance(str1,REST(str2),mem);
        dins = 1 + dinamic_edit_distance(REST(str1),str2,mem);
        /*minimo*/
        if (dcanc<dnoop) dnoop = dcanc;
        if (dins<dnoop) dnoop = dins;
        /*salvo il minimo nell'array di struct*/
        push_min(str1,str2,dnoop,mem);
        return dnoop;
}


int hash(char* str1, char* str2){
        int pos=0;
        int length = (int)strlen(str1);
        for (int i=0;i<length;i++){ 
                pos = (pos * (str1[i])*i)%ELEM_MEMORY_TABLE;
        }
        length =(int) strlen(str2);
        for (int i=0;i<length;i++){ 
                pos = pos  + str2[i]+i+i;
        }
        return (pos%ELEM_MEMORY_TABLE);
}


void push_min(char* str1, char* str2,int value, Memory* mem){
       
        int pos=hash(str1,str2);

        if (mem->elem[pos].values==-1){
                mem->elem[pos].key1 = str1;
                mem->elem[pos].key2= str2;
                mem->elem[pos].values=value; 
                mem->elem[pos].next=NULL; 
        }
        else {
                Cell* elem=  &mem->elem[pos];
                while (elem->next!=NULL){
                        elem= elem->next;
                }
                elem->next=malloc(sizeof(Cell));
                elem= elem->next;

                elem->key1 = str1;
                elem->key2= str2;
                elem->values=value;  
                elem->next=NULL;
        }
}


int ceck_mem(char* str1, char* str2, Memory* mem){  

        int pos=hash(str1,str2);

        Cell* elem=  &mem->elem[pos];
        while(elem->next!=NULL){
                if (strcmp(elem->key1,str1)==0){
                        if (strcmp(elem->key2,str2)==0 ){
                        return elem->values;
                        }
                }
                elem= elem->next;       
        }
        return -1;
}


Memory* initializes_memory_edit_distance(Memory* mem){
        if ((mem= malloc(sizeof(Memory)))==NULL) {   
                fprintf(stderr,"Error in allocating memory for the struct mem\n");
                return NULL;
        }
        mem->maxElem=ELEM_MEMORY_TABLE;
        if ( (mem->elem= malloc(sizeof(Cell)*(unsigned int)mem->maxElem) )==NULL){
        fprintf(stderr,"Error in allocating cell1\n");
        return NULL;
        } 
        
        for (int i=0;i<ELEM_MEMORY_TABLE;i++){
                mem->elem[i].values=-1;
                mem->elem[i].next=NULL;
        }
        return mem;
}


void free_memory_edit_distance(Memory* mem){
        /*ciclo tutti gli elementi*/
        for(int i=0;i<mem->maxElem;i++)
        {
                /*se è stato aggiunto un elemento*/
                if (mem->elem[i].values>=0)
                {
                        Cell* elem;
                        while (mem->elem[i].next!=NULL)
                        {
                                elem=  &mem->elem[i];
                                while(elem->next->next!=NULL)
                                {
                                        elem=elem->next;
                                }
                                free(elem->next);
                                elem->next=NULL;
                        }
                        free(mem->elem[i].next);
                }
        }
        free(mem->elem);
        free(mem); 
}






