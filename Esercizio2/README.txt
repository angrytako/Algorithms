***COMPILAZIONE***
1) posizionarsi in .../Esercizio2
2) make all (nella directory corrente ci deve essere il Makefile opportuno)

***CANCELLAZIONE *.o e *.exe***
1) posizionarsi in .../Esercizio2
2) make clean (nella directory corrente ci deve essere il Makefile opportuno)

***ESECUZIONE***

--PER ESEGUIRE edit_distance---
1) Compilare --> per compilare solo il client utilizzare make client
2) I file correctme e dictionary si devono trovare nella cartella .../Esercizio2
3) posizionarsi in .../Esercizio2/bin
4) ./client.exe --> l'output comparirà sul file txt ".../Esercizio2/bin/result.txt"

---PER ESEGUIRE edit_distance_unit_test---
1) Compilare -> make test per compilare solo gli unit test
2) posizionarsi in .../Esercizio2/bin
3) ./test.exe



Per la momorizzazione delle esecuzioni precedenti è stata utilizzata un' array di
struct. Ogni struct è identiifcata dalle da due chiavi: key1=stringa 1, key2=stringa2.
