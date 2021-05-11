#ifndef EDIT_DISTANCE_H
#define EDIT_DISTANCE_H

#include <stdio.h>
#include <string.h>  
#include <stdlib.h>
#include <limits.h>



#define ELEM_MEMORY_TABLE 677
#define ERROR_DISTACE  INT_MAX
#define REST(x) (x +1) 

typedef struct Cell{ //per semplificare uso una doppia chiave per identificare un elemnto es casa,asa,1
    char* key1;   //casa
    char* key2;     //asa
    int values;        //1
    struct Cell* next;
} Cell;

typedef struct Memory{
    int maxElem;
    Cell* elem;
} Memory;



//versione ricorsiva base 
int ric_edit_distance( char* s1, char* s2 );


/*calcola la distanza tra le due stringhe utilizzanso al struct mem di appoggio
(utilizzare initializes_memory(memory* mem) per inizializzare la struct in modo corretto)*/
int ric_edit_distance_mem( char* s1, char* s2,Memory* mem);

//alloca la memoria e inizializza i campi della struct necessari per il funzionamento dell'applicazione
Memory* initializes_memory_edit_distance(Memory* mem);

//libera la memoria allocata dalla struct utilizzata dall'edit_distance
void free_memory_edit_distance(Memory* mem);
#endif
