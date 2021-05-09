#include "edit_distance.h"


void push_min(char* str1, char* str2,int value, Memory* mem);
int ceck_mem(char* str1, char* str2, Memory* mem);


int ric_edit_distance(char* str1, char* str2){
        if (str1==NULL || str2==NULL) return ERROR_DISTACE; 
        int lenght_str1,lenght_str2;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = strlen(str1);
        lenght_str2 = strlen(str2);
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        //caso in cui tolgo un elemento da entrambe 
        if (*str1==*str2) dnoop= ric_edit_distance(REST(str1),REST(str2));
        else dnoop = ERROR_DISTACE;

        //secondo caso
        dcanc = 1 + ric_edit_distance(str1,REST(str2));

        dins = 1 + ric_edit_distance(REST(str1),str2);
    
        //min
        if (dcanc<dnoop)dnoop = dcanc;
        if (dins<dnoop)dnoop = dins;
        return dnoop;
}

int ric_edit_distance_mem( char* str1, char* str2,Memory* mem){
        if (str1==NULL || str2==NULL || mem==NULL) return ERROR_DISTACE; 
        int lenght_str1,lenght_str2;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = strlen(str1);
        lenght_str2 = strlen(str2);
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        /*uso donoop come variabile di appoggio*/
        dnoop=ceck_mem(str1,str2,mem);
        
        if(dnoop!=-1){
        return dnoop;
        } 
        //caso in cui tolgo un elemento da entrambe 
        if (*str1==*str2) dnoop= ric_edit_distance_mem(REST(str1),REST(str2),mem);
        else dnoop = ERROR_DISTACE; 
        //secondo caso
        dcanc = 1 + ric_edit_distance_mem(str1,REST(str2),mem);
        dins = 1 + ric_edit_distance_mem(REST(str1),str2,mem);
        /*minimo*/
        if (dcanc<dnoop) dnoop = dcanc;
        if (dins<dnoop) dnoop = dins;
        /*salvo il minimo nell'array di struct*/
        push_min(str1,str2,dnoop,mem);
        return dnoop;
}





void push_min(char* str1, char* str2,int value, Memory* mem){
      
        if(mem->num_elem>=mem->max_elem){
                mem->max_elem=(mem->max_elem)*2;
                if((mem->elem=realloc(mem->elem,(size_t)mem->max_elem*sizeof(Cell)))==NULL){
                 fprintf(stderr,"Error in allocating more memory for the cell\n");
            }
        }
        
        mem->elem[mem->num_elem].key1 = str1;
        mem->elem[mem->num_elem].key2= str2;
        mem->elem[mem->num_elem].values=value;  
        
        mem->num_elem++;    
              
}


int ceck_mem(char* str1, char* str2, Memory* mem){  

        for (int i=0;i<mem->num_elem;i++){
                if (strcmp(mem->elem[i].key1,str1)==0 ){
                        if (strcmp(mem->elem[i].key2,str2)==0 ){
                        return mem->elem[i].values;   
                        }
                }        
        }
        return -1;
}


Memory* initializes_memory(Memory* mem){
        if ((mem= malloc(sizeof(Memory)))==NULL) {   
                fprintf(stderr,"Error in allocating memory for the struct mem\n");
                return NULL;
        }
        mem->max_elem=ELEM_MEMORY_TABLE;
        if ( (mem->elem= malloc(sizeof(Cell)*mem->max_elem) )==NULL){
        fprintf(stderr,"Error in allocating cell1\n");
        return NULL;
        } 
        mem->num_elem=0;
        return mem;
}





