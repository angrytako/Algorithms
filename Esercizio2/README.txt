***COMPILAZIONE TUTTO***
1) posizionarsi in .../Esercizio2
2) make all (nella directory corrente ci deve essere il Makefile opportuno)

***COMPILAZIONE CLIENT***
1) posizionarsi in .../Esercizio2
2) make client (nella directory corrente ci deve essere il Makefile opportuno)

***COMPILAZIONE TEST***
1) posizionarsi in .../Esercizio2
2) make test (nella directory corrente ci deve essere il Makefile opportuno)

---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----

***CANCELLAZIONE *.o e *.exe***
1) posizionarsi in .../Esercizio2
2) make clean (nella directory corrente ci deve essere il Makefile opportuno)

***ESECUZIONE***
--PER ESEGUIRE edit_distance---
1) Compilare --> per compilare solo il client utilizzare make client
2) posizionarsi in .../Esercizio2/bin
3) ./client (path1) (path2) 
path1 = file txt da correggere -> .../Esercizio2/correctme.txt di default
path2 = file txt del dizzionario -> .../Esercizio2/dictionary.txt di default

---PER ESEGUIRE edit_distance_unit_test---
1) Compilare -> make test per compilare solo gli unit test
2) posizionarsi in .../Esercizio2/bin
3) ./test



