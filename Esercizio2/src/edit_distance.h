#ifndef EDIT_DISTANCE_H
#define EDIT_DISTANCE_H

#include <stdio.h>
#include <string.h>  
#include <stdlib.h>
#include <limits.h>



#define ERROR_DISTACE  INT_MAX
#define REST(x) (x +1) 



//versione ricorsiva base 
int ric_edit_distance( char* s1, char* s2 );


/*calcola la distanza tra due stringhe s1,s2 
Se è inferiore al minimo già calcolato in precedenza per la stringa s1*/
int dinamic_edit( char* s1, char* s2,int min);





#endif
