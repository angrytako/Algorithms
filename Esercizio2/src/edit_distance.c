#include "edit_distance.h"


char* rest(char* s1);
void push_min(char* str1, char* str2,int value, memory* mem);
int ceck_mem(char* str1, char* str2, memory* mem);


int ric_edit_distance(char* str1, char* str2){
        if (str1==NULL || str2==NULL) return ERROR_DISTACE; 
        int lenght_str1,lenght_str2,max_lenght;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = strlen(str1);
        lenght_str2 = strlen(str2);
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        //caso in cui tolgo un elemento da entrambe 
        if (strncmp(str1,str2,1)==0) dnoop= ric_edit_distance(rest(str1),rest(str2));
        else dnoop = ERROR_DISTACE;

        //secondo caso
        dcanc = 1 + ric_edit_distance(str1,rest(str2));

        dins = 1 + ric_edit_distance(rest(str1),str2);

        //min
        if (dcanc<dnoop)dnoop = dcanc;
        if (dins<dnoop)dnoop = dins;
        return dnoop;
}

int ric_edit_distance_mem( char* str1, char* str2,memory* mem){
        if (str1==NULL || str2==NULL || mem==NULL) return ERROR_DISTACE; 
        int lenght_str1,lenght_str2;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = strlen(str1);
        lenght_str2 = strlen(str2);
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        dnoop=ceck_mem(str1,str2,mem);
        if(dnoop!=-1){
        return 1+dnoop;
        } 
        //caso in cui tolgo un elemento da entrambe 
        if (strncmp(str1,str2,1)==0){ 
                dnoop= ric_edit_distance_mem(rest(str1),rest(str2),mem);
        }
        else{
                dnoop = 99999;
        } 
        //secondo caso
        dcanc = 1 + ric_edit_distance_mem(str1,rest(str2),mem);
        dins = 1 + ric_edit_distance_mem(rest(str1),str2,mem);

        if (dcanc<dnoop){
                dnoop = dcanc;
        }
        if (dins<dnoop){
                dnoop = dins;
        }
        push_min(str1,str2,dnoop,mem);
        return dnoop;
}

char* rest(char* s1){
return s1 +1;
}



void push_min(char* str1, char* str2,int value, memory* mem){
      
        if(mem->num_elem>=mem->max_elem){
                printf("%d\n",mem->max_elem);
                mem->max_elem=(mem->max_elem)*2;
                if((mem->elem=realloc(mem->elem,(size_t)mem->max_elem*sizeof(cell)))==NULL){
                fprintf(stderr,"Error in allocating more memory for the cell\n");
            }
        }
        cell elem;
        elem.key1 = str1;
        elem.key2= str2;
        elem.values=value;  
        mem->elem[mem->num_elem] =elem;
        mem->num_elem++;    
              
}


int ceck_mem(char* str1, char* str2, memory* mem){  

        for (int i=0;i<mem->num_elem;i++){
                if (strcmp(mem->elem[i].key1,str1)==0 ){
                        if (strcmp(mem->elem[i].key2,str2)==0 ){
                        return mem->elem[i].values;   
                        }
                }        
        }
        return -1;
}


memory* initializes_memory(memory* mem){
        if ((mem= malloc(sizeof(memory)))==NULL) {   
        fprintf(stderr,"Error in allocating memory for the struct mem\n");
        return NULL;
        }
        mem->max_elem=ELEM_MEMORY_TABLE;
        if ( (mem->elem= malloc(sizeof(cell)*mem->max_elem) )==NULL){
        fprintf(stderr,"Error in allocating cell1\n");
        return NULL;
        } 
        mem->num_elem=0;
        return mem;
}





