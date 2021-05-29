#include "edit_distance.h"


int classic_edit_distance(char* str1, char* str2);
int edit( char* str1, char* str2,int** mem,int min,int this, int lenght_str1,int lenght_str2);

int** initializes_memory_edit_distance(int str1, int str2);
void free_memory_edit_distance(int** mem,int str1);

        
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

int dinamic_edit( char* str1, char* str2,int min){
        if (str1==NULL || str2==NULL) return ERROR_DISTACE; 
        else
        {
                int lenght_str1 = (int)strlen(str1);
                int lenght_str2 = (int)strlen(str2);
                int** mem;
                mem = initializes_memory_edit_distance(lenght_str1,lenght_str2);
                int outPut = edit(str1,str2,mem,min,0,lenght_str1,lenght_str2);
                free_memory_edit_distance(mem,lenght_str1);
                return outPut;
        } 
}

int edit( char* str1, char* str2,int** mem,int min,int this, int lenght_str1,int lenght_str2){
        if (this>=min) return 100;
        int dnoop=0, dcanc=0,dins=0;
       
        if (lenght_str1==0) return lenght_str2;
        if (lenght_str2==0) return lenght_str1;
        
        /*uso donoop come variabile di appoggio*/  
        if (mem[lenght_str1-1][lenght_str2-1]>=0) return mem[lenght_str1-1][lenght_str2-1];

        //caso in cui tolgo un elemento da entrambe 
        if (*str1==*str2) dnoop= edit(REST(str1),REST(str2),mem,min,this,(lenght_str1-1),(lenght_str2-1));
        else dnoop = ERROR_DISTACE; 
        //secondo caso
        dcanc = 1 + edit(str1,REST(str2),mem,min,this+1,lenght_str1,(lenght_str2-1));
        dins = 1 + edit(REST(str1),str2,mem,min,this+1,(lenght_str1-1),lenght_str2);
        /*minimo*/
        if (dcanc<dnoop) dnoop = dcanc;
        if (dins<dnoop) dnoop = dins;


        /*salvo il minimo*/
        mem[lenght_str1-1][lenght_str2-1]=dnoop;
        return dnoop;
}




int** initializes_memory_edit_distance(int lenght_str1, int lenght_str2){
        int** mem;
        mem=malloc(sizeof(int*)*(unsigned int)(lenght_str1));

        for(int i=0;i<lenght_str1;i++){ 
                mem[i]=malloc(sizeof(int)*(unsigned int)(lenght_str2));
                mem[i]=  memset ( mem[i], -1, sizeof(int)*(unsigned int)(lenght_str2)  );
        }

        return mem;
}


void free_memory_edit_distance(int** mem,int lenght_str1){
        for(int i=0;i<lenght_str1;i++){ 
                free(mem[i]);
        }
        free(mem);
}

