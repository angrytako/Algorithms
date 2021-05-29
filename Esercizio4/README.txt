****COMPILAZIONE***

----PER COMPILARE LE CLASSI PER LA STRUTTURA DATI AdjacencyList e Kruskal nel PACKAGE graph---
1) posizionarsi in .../Esercizio4
2) creare una cartella "classes"
2)javac -cp ".\lib\junit-4.12.jar;\lib\hamcrest-core-1.3.jar;.\lib\UnionFind.jar" -d .\classes .\src\graph\*.java


---PER COMPILARE LE CLASSI PER GLI UNIT TEST NEL PACKAGE unionfind---
1) posizionarsi in .../Esercizio4
2)java -cp ".\lib\junit-4.12.jar;.\lib\UnionFind.jar;.\lib\hamcrest-core-1.3.jar;.\classes"  graph/AdjacencyListTestRunner (ATTENZIONE: i classpath devono essere separati da ";" come in Windows, non da ":" come in Unix, inoltre, occorre mettere l'elenco dei classpath fra apici semplici!)


***ESECUZIONE***

---PER ESEGUIRE unionfind/UnionFind_TestRunner---
1) posizionarsi in .../Esercizio3/classes
2) java -cp '..;../lib/junit-4.12.jar;../lib/hamcrest-core-1.3.jar' UnionFind_TestRunner
