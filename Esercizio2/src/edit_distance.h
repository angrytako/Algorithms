
#include <stdio.h>
#include <string.h>


//calcola la  distanza tra le parole conteenute nel primo array e quelle contenute nel secondo
//void edit_distance(WordAndExtras* correctme,int size, char** dictionary,int num_word);

//versione ricorsiva base 
int ric_edit_distance( char* s1, char* s2 );

int ric_edit_distance_mem( char* s1, char* s2 );

// ritorna la stringa senza il primo carattere casa --> asa
char* rest(char* s1);