#include "bin_search.h"
  
int bin_search_rec(char** array, char* elem, int i,int j);

int bin_search_rec(char** array, char* elem, int i,int j){
    if(i>j)
        return i;
    int k= (i+j)/2;
    if(strcmp(array[k],elem)<0){ //elem maggiore dell'elemento a metà (a[k]<elem)
        return bin_search_rec(array, elem, k+1,j); 
    }
    else if(strcmp(array[k],elem)>0){ //elem minore dell'elemento a metà (a[k]>elem)
        return bin_search_rec(array, elem, i,k-1); 
    }
    else  return k; // a[k]==elem
 }


int bin_search(char** array, char* elem, int nrElem){
    if(array==NULL || elem==NULL || nrElem<=0)
        return -1;
    return bin_search_rec(array, elem,0,nrElem-1);
    }


  
