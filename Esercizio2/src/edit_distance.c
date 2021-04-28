#include "edit_distance.h"


int ric_edit_distance(char* str1, char* str2);
char* rest(char* s1);
void push_min(char* str1, char* str2,int value, memory* mem);
int ric_edit_distance_mem( char* s1, char* s2,memory* mem);

int ceck_mem(char* str1, char* str2, memory* mem);


int ric_edit_distance(char* str1, char* str2){
        int lenght_str1,lenght_str2,max_lenght,output;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = strlen(str1);
        lenght_str2 = strlen(str2);
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        //caso in cui tolgo un elemento da entrambe 
        if (strncmp(str1,str2,1)==0) dnoop= ric_edit_distance(rest(str1),rest(str2));
        else dnoop = 9999999;

        //secondo caso
        dcanc = 1 + ric_edit_distance(str1,rest(str2));

        dins = 1 + ric_edit_distance(rest(str1),str2);

        int min=999999;
        if (dnoop<min)min = dnoop;
        if (dcanc<min)min = dcanc;
        if (dins<min)min = dins;

        return min;
}

char* rest(char* s1){
return s1 +1;
}



void push_min(char* str1, char* str2,int value, memory* mem){
        int lenght=(strlen(str1) + strlen(str2)+3);
        char* key;
        if( (key=malloc(sizeof(char)*lenght))==NULL) fprintf(stderr,"Error in allocating key\n");

        key=strcpy(key,str1);

        char* separetor = malloc(sizeof(char));
        separetor=".";
        key=strcat(key,separetor);
        free(separetor);

        key=strcat(key,str2);
        
        if(mem->num_elem>=mem->max_elem){
                printf("%d\n",mem->max_elem);
                mem->max_elem=(mem->max_elem)*2;
                if((mem->elem=realloc(mem->elem,(size_t)mem->max_elem*sizeof(cell)))==NULL){
                fprintf(stderr,"Error in allocating more memory for the cell\n");
            }
        }
        cell elem;
        elem.key = key;
        elem.values=value;  
        mem->elem[mem->num_elem] =elem;
        mem->num_elem++;    

              
}


int ceck_mem(char* str1, char* str2, memory* mem){
        int lenght2;
        int lenght=(strlen(str1) + strlen(str2)+3);
        char* key1 = malloc(sizeof(char)*lenght); 
        key1=strcpy(key1,str1);        
        char* key2 = malloc(sizeof(char)*lenght); 
        key2=strcpy(key2,str2);

        char* separetor = malloc(sizeof(char));
        separetor=".";
        key1=strcat(key1,separetor);
        key2=strcat(key2,separetor);
        free(separetor);

        key1=strcat(key1,str2);
        key2=strcat(key2,str1);

        lenght=strlen(key1);
        for (int i=0;i<mem->num_elem;i++){
                lenght2=strlen(key1);
                if (strncmp(mem->elem[i].key,key1,lenght)==0 && strncmp(mem->elem[i].key,key1,lenght2)==0 )
                        return mem->elem[i].values;
                if (strncmp(mem->elem[i].key,key2,lenght)==0 && strncmp(mem->elem[i].key,key2,lenght2)==0 ) 
                        return mem->elem[i].values;
                
        }
        return -1;
}

int ric_edit_distance_mem( char* str1, char* str2,memory* mem){
        int lenght_str1,lenght_str2,max_lenght,output;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = strlen(str1);
        lenght_str2 = strlen(str2);
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        if(output=ceck_mem(str1,str2,mem)!=-1) return output;
        //caso in cui tolgo un elemento da entrambe 
        if (strncmp(str1,str2,1)==0) dnoop= ric_edit_distance(rest(str1),rest(str2));
        else dnoop = 9999999;

        //secondo caso
        dcanc = 1 + ric_edit_distance(str1,rest(str2));

        dins = 1 + ric_edit_distance(rest(str1),str2);

        int min=999999;
        if (dnoop<min)min = dnoop;
        if (dcanc<min)min = dcanc;
        if (dins<min)min = dins;

        push_min(str1,str2,min,mem);

        return min;
}






