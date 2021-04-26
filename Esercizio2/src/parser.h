#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define WORD_SIZE 20
#define EXTRA_SIZE 10
/*serve per contenere anche la punteggiatura, e altri eventuali caratteri strani, che non appartengono 
alla parola, in modo da poter comparare le parole tra loro, e poi poter ricostruire il file uguale a prima*/
typedef struct WordAndExtras
{
    char* word;
    char* extra;
}WordAndExtras;

/*riceve in input il file dizionario, e l'indirizzo in memoria di un intero, dove scrivere
 il nr di parole (stringhe) in memoria, e ha come output un'array di stringhe.
 Ogni indice dell'array è una parola del dizionario*/
char** parse_dictionary(FILE* st, int* nrElems);

/*riceve in input il file correct me, e l'indirizzo in memoria di un intero, dove scrivere
 il nr di struct (parole + caratteri extra) in memoria, e ha come output un puntatore 
 a un'array di struct WordAndExtras*/
WordAndExtras* parse_inspected_file (FILE* st, int* nrElems);
