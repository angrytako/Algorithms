COMPILAIZONE, CANCELLAZIONE Richiedono l'istallazione di ANT (library and command-line tool) -> https://ant.apache.org/ 

<<<<<<< HEAD

----PER COMPILARE LE CLASSI PER LA STRUTTURA DATI AdjacencyList e Kruskal nel PACKAGE graph---
1) posizionarsi in .../Esercizio4
2) creare una cartella "classes"
2)javac -cp ".\lib\junit-4.12.jar;\lib\hamcrest-core-1.3.jar;.\lib\UnionFind.jar" -d .\classes .\src\graph\*.java


---PER COMPILARE LE CLASSI PER GLI UNIT TEST NEL PACKAGE unionfind---
1) posizionarsi in .../Esercizio4
2)java -cp ".\lib\junit-4.12.jar;.\lib\UnionFind.jar;.\lib\hamcrest-core-1.3.jar;.\classes"  graph/AdjacencyListTestRunner (ATTENZIONE: i classpath devono essere separati da ";" come in Windows, non da ":" come in Unix, inoltre, occorre mettere l'elenco dei classpath fra apici semplici!)
***COMPILAZIONE***
---Tutto---
1) posizionarsi in .../Esercizio4
2) ANT all (nella directory corrente ci deve essere il file build.xml)
---MinSpan---
1) posizionarsi in .../Esercizio4
2) ANT jar (nella directory corrente ci deve essere il file build.xml)
---Unit test---
1) posizionarsi in .../Esercizio4
2) ANT junit (nella directory corrente ci deve essere il file build.xml)

--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---

QUESTE COMPILAIZONE, CANCELLAZIONE Richiedono l'istallazione di ANT (library and command-line tool) -> https://ant.apache.org/ 

***COMPILAZIONE***
---Tutto---
1) posizionarsi in .../Esercizio4
2) ANT all (nella directory corrente ci deve essere il file build.xml)
---MinSpan---
1) posizionarsi in .../Esercizio4
2) ANT jar (nella directory corrente ci deve essere il file build.xml)
---Unit test---
1) posizionarsi in .../Esercizio4
2) ANT junit (nella directory corrente ci deve essere il file build.xml)


***CANCELLAZIONE***
1) posizionarsi in .../Esercizio4
2) ANT clean (nella directory corrente ci deve essere il file build.xml)


***ESECUZIONE***
---PER ESEGUIRE MinSpan---
1) Compilare MinSpan (vedi paragrafo complilazione)
2) posizionarsi in .../Esercizio4/build
3) java -jar MinSpan.jar "path file"

---PER ESEGUIRE Unit test---
1) Compilare junit (vedi paragrafo complilazione)
2) posizionarsi in .../Esercizio4/build
3) java -jar GraphTests.jar 