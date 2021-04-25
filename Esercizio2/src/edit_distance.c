#include "edit_distance.h"





int ric_edit_distance(char* str1, char* str2){
        int lenght_str1,lenght_str2,max_lenght,output;
        int dnoop=0, dcanc=0,dins=0;
       
        lenght_str1 = strlen(str1);
        lenght_str2 = strlen(str2);
        if (lenght_str1==0) return lenght_str1;
        if (lenght_str2==0) return lenght_str2;
        
        //caso in cui tolgo un elemento da entrambe 
        if (lenght_str1>lenght_str2)max_lenght=lenght_str1;
        else max_lenght=lenght_str2;
        if (strncmp(str1,str2,max_lenght)==0) ric_edit_distance(rest(str1),rest(str2));
        else dnoop = -1;

        //secondo caso
        dcanc = 1 + ric_edit_distance(str1,rest(str2));

        dins = 1 + ric_edit_distance(rest(str1),str2);

        //retutn min(dnoop dins dcanc)
        if (dcanc<dins) output= dcanc;
        else output = dins;
        if (dnoop==-1) return output;
        else if (output<=dnoop) return output;
        else return dnoop;
        
}