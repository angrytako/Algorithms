#include <stdio.h>
#include <string.h>  
#include <stdlib.h>


#define ELEM_MEMORY_TABLE 10000
#define ERROR_DISTACE  9999999

typedef struct { //per semplificare uso una doppia chiave per identificare un elemnto es casa,asa,1
    char* key1;   //casa
    char* key2;     //asa
    int values;        //1
} cell;

typedef struct {
    int num_elem;
    int max_elem;
    cell* elem;
} memory;



//versione ricorsiva base 
int ric_edit_distance( char* s1, char* s2 );


/*calcola la distanza tra le due stringhe utilizzanso al struct mem di appoggio
(utilizzare initializes_memory(memory* mem) per inizializzare la struct in modo corretto)*/
int ric_edit_distance_mem( char* s1, char* s2,memory* mem);

//alloca la memoria e inizializza i campi della struct necessari per il funzionamento dell'applicazione
memory* initializes_memory(memory* mem);
