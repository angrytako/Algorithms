
#include <stdio.h>
#include <string.h>  
#include <stdlib.h>


typedef struct {
    char* key;
    int values;
} cell;

typedef struct {
    int num_elem;
    int max_elem;
    cell* elem;
} memory;

//calcola la  distanza tra le parole conteenute nel primo array e quelle contenute nel secondo
//void edit_distance(WordAndExtras* correctme,int size, char** dictionary,int num_word);

//versione ricorsiva base 
int ric_edit_distance( char* s1, char* s2 );


//prima di fare un oprazione controlla di non averla già fatta prima
//devo vedere in che modo memorizzare l'operazione
int ric_edit_distance_mem( char* s1, char* s2,memory* mem);

// ritorna la stringa senza il primo carattere casa --> asa
char* rest(char* s1);

//aggiunge elemento alla lista di elementi memorizzati
void push_min(char* str1, char* str2,int value, memory* mem);

//controlla l'esistenza di un elemento in memoria
int ceck_mem(char* str1, char* str2, memory* mem);

