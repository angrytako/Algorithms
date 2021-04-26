#include "edit_distance.h"


int ric_edit_distance(char* str1, char* str2);
char* rest(char* s1);

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