***COMPILAZIONE TUTTO***
1) posizionarsi in .../Esercizio1
2) make all (nella directory corrente ci deve essere il Makefile opportuno)

***COMPILAZIONE CLIENT***
1) posizionarsi in .../Esercizio1
2) make client (nella directory corrente ci deve essere il Makefile opportuno)

***COMPILAZIONE TEST***
1) posizionarsi in .../Esercizio1
2) make test (nella directory corrente ci deve essere il Makefile opportuno)

***CANCELLAZIONE *.o e *.exe***
1) posizionarsi in .../Esercizio1
2) make clean (nella directory corrente ci deve essere il Makefile opportuno)

***ESECUZIONE***
--PER ESEGUIRE l'algoritmo di sorting su un csv---
1) Compilare --> per compilare solo il client utilizzare make client
2) posizionarsi in .../Esercizio1/bin
3) ./client.exe  "path_name" 
Se si lascia vuoto path_name, verrà assunto che il file su cui si voglia fare sorting sia ../records.csv

---PER ESEGUIRE sort_unit_test---
1) Compilare -> make test per compilare solo gli unit test
2) posizionarsi in .../Esercizio1/bin
3) ./sort_unit_test.exe


