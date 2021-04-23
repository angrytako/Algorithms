#include "sort.h"
#define K 1
void sort_k(void* array, int (*compare)(void*,void*), int dimElem, int nrElem, int k);
void sort(void* array,int (*compare)(void*,void*), int dimElem, int nrElem);
void merge_sort_k(void* array,int (*compare)(void*,void*), int dimElem, int i, int j, int k);
void merge(void* array,int (*compare)(void*,void*), int dimElem,int i, int j, int k);
void bin_insert_sort(void* array,int (*compare)(void*,void*), int dimElem, int nrElem);
void insert_last_elem(void* array, int dimElem, int nrElem,int index);
int bin_search(void* array, void* elem, int (*compare)(void*,void*), int dimElem, int nrElem);
int bin_search_rec(void* array, void* elem, int (*compare)(void*,void*),
                   int dimElem, int i,int j);       


int bin_search_rec(void* array, void* elem, int (*compare)(void*,void*),
                   int dimElem, int i,int j){
    if(i>j)
        return i;
    int k= (i+j)/2;
    if((*compare)(SUM_VOID(array,k*dimElem),elem)==-1){ //elem maggiore dell'elemento a metà (a[k]<elem)
        return bin_search_rec(array, elem, compare, dimElem, k+1,j); 
    }
    else if((*compare)(SUM_VOID(array,k*dimElem),elem)==+1){ //elem minore dell'elemento a metà (a[k]>elem)
        return bin_search_rec(array, elem, compare, dimElem, i,k-1); 
    }
    else  return k; // a[k]==elem
 }


int bin_search(void* array, void* elem, int (*compare)(void*,void*), int dimElem, int nrElem){
    if(array==NULL || elem==NULL || compare==NULL || dimElem<=0 || nrElem<=0)
        return -1;
    return bin_search_rec(array, elem,compare,dimElem,0,nrElem-1);}


  //andrà inserita la dim totale dopo la selezione
 //si assume che elem stia nell'ultima casella dell'array passata
 void insert_last_elem(void* array, int dimElem, int nrElem,int index){
    if(array==NULL || dimElem<=0 || nrElem<=0 || index<0)
        return;
    void *sup, *lastElem=SUM_VOID(array,(nrElem-1)*dimElem);//lastElem=a[nrElem-1]
    int i;
    if((sup = malloc((size_t) dimElem))==NULL){
        fprintf(stderr, "Malloc error\nUnable to create support element\n");
        return;
    }
    memcpy(sup, SUM_VOID(array,index*dimElem),(size_t)dimElem); // sup=a[index]
    memcpy(SUM_VOID(array,index*dimElem),lastElem,(size_t)dimElem); // a[index]=lastElem
    for(i=index+1;i<nrElem;i++){                            //i=index+1
        memcpy(lastElem,SUM_VOID(array,i*dimElem),(size_t)dimElem); // lastElem=a[i]
        memcpy(SUM_VOID(array,i*dimElem),sup,(size_t)dimElem);  // a[i]=sup;
        memcpy(sup,lastElem,(size_t)dimElem);                   //sup=lastElem
    }
    free(sup);
    return;
 }

void bin_insert_sort(void* array, int (*compare)(void*,void*), int dimElem, int nrElem){
    if(array==NULL || compare==NULL || dimElem<=0 || nrElem<=1)
        return;
    int i, index;
    for(i=1;i<nrElem;i++){
        index=bin_search(array, SUM_VOID(array,(i*dimElem)),compare,dimElem,i);
        insert_last_elem(array,dimElem,i+1,index);
    }
 }

 //si assume che i<k e che i-j e h-k contengano tutti gli elem tra i-k, senza sovrapposizione
 void merge(void* array,int (*compare)(void*,void*), int dimElem, int i, int j, int k){
    int h=j+1;
    if(array==NULL || compare==NULL || dimElem<=0 || i>j || h>k || i>k)
        return;
    int nrElem = j-i + k-h +2, iterSup;
    int first = i;
    void *supArr;
    if((supArr=malloc((size_t)(nrElem*dimElem)))==NULL){
        fprintf(stderr, "Malloc error in merge\nUnable to create support array\n");
        return;
    }
    for(iterSup=0;iterSup<nrElem;iterSup++)
    {
        if(i>j){ /*caso in cui il primo sotto array è stato esaurito
                   dato che i doveva essere almeno = a j per ipotesi, se sono qui 
                    allora c'è ancora rimasto l altro sottoarray, altrimenti iterSup sarebbe = nrElem*/
            memcpy(SUM_VOID(supArr, iterSup*dimElem),SUM_VOID(array,h*dimElem),(size_t)dimElem);
            h++;
        }
        else if(h>k){ //stesso ragionamento fatto sopra
            memcpy(SUM_VOID(supArr, iterSup*dimElem),SUM_VOID(array,i*dimElem),(size_t)dimElem);
            i++;
        }
        else{   //caso generico, in cui entrambi hanno ancora almeno un elemento
            if((*compare)(SUM_VOID(array,i*dimElem),SUM_VOID(array,h*dimElem))==-1) {//elem_i<elem_h
                memcpy(SUM_VOID(supArr, iterSup*dimElem),SUM_VOID(array,i*dimElem),(size_t)dimElem);
                i++;
            }
            else{//elem_h<=elem_i
                memcpy(SUM_VOID(supArr, iterSup*dimElem),SUM_VOID(array,h*dimElem),(size_t)dimElem);
                h++;
            }
        }
        
    }
   memcpy(SUM_VOID(array,first*dimElem),supArr,(size_t)(dimElem*nrElem));
   free(supArr);
   return;
 }

//si assume i>j nella prima chiamata a questa funzione
void merge_sort_k(void* array,int (*compare)(void*,void*), int dimElem, int i, int j, int k){
    if((j-i)<k)
        bin_insert_sort(SUM_VOID(array,i*dimElem),compare,dimElem,(j-i+1));
    else{
        int half=(j+i)/2;
        merge_sort_k(array,compare,dimElem,i,half,k);
        merge_sort_k(array,compare,dimElem,half+1,j,k);
        merge(array,compare,dimElem,i,half,j);
    }
}

void sort(void* array,int (*compare)(void*,void*), int dimElem, int nrElem){
    if(array==NULL || compare==NULL || dimElem<=0 || nrElem<=0)
        return;
    merge_sort_k(array,compare,dimElem,0,nrElem-1,K);
}

void sort_k(void* array, int (*compare)(void*,void*), int dimElem, int nrElem, int k){
    if(array==NULL || compare==NULL || dimElem<=0 || nrElem<=0 || k<1)
        return;
    merge_sort_k(array,compare,dimElem,0,nrElem-1,k);
}
