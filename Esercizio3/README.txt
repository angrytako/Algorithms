****COMPILAZIONE***

----PER COMPILARE LE CLASSI PER LA STRUTTURA DATI UnionFind NEL PACKAGE unionfind---
1) posizionarsi in .../Esercizio3
2) javac -d ./classes unionfind/UnionFind.java


---PER COMPILARE LE CLASSI PER GLI UNIT TEST NEL PACKAGE unionfind---
1) posizionarsi in .../Esercizio3
2) javac -d ./classes -cp '.;./lib/junit-4.12.jar;./lib/hamcrest-core-1.3.jar' unionfind/*.java (ATTENZIONE: i classpath devono essere separati da ";" come in Windows, non da ":" come in Unix, inoltre, occorre mettere l'elenco dei classpath fra apici semplici!)


***ESECUZIONE***

---PER ESEGUIRE unionfind/UnionFind_TestRunner---
1) posizionarsi in .../Esercizio3/classes
2) java -cp '..;../lib/junit-4.12.jar;../lib/hamcrest-core-1.3.jar' UnionFind_TestRunner
