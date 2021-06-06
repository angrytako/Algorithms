						(DA LINEA DI COMANDO)
----PER COMPILARE---
1) posizionarsi in .../Esercizio4
2) creare una cartella "classes"
2)javac -cp ".\lib\junit-4.12.jar;\lib\hamcrest-core-1.3.jar;.\lib\UnionFind.jar" -d .\classes .\src\graph\*.java 
3)javac -cp ".\classes;.\lib\UnionFind.jar" -d .\classes .\src\minspan\*.java

----PER ESEGUIRE MIN TREE----
1) compilare 
2) posizionarsi nella cartella classes
3) java -cp ".\;..\lib\UnionFind.jar"   minspan/MinTree "file path" (path del csv su cui eseguire Kruskal; l'ouput si troverà nella cartella di esecuzione)

----PER ESEGUIRE GLI UNIT TEST----
1) compilare
2) posizionarsi nella cartella classes
3) java -cp ".\;..\lib\junit-4.12.jar;..\lib\hamcrest-core-1.3.jar;..\lib\UnionFind.jar"   graph/GraphUnitTestsRunner

							
						   (CON ANT)

COMPILAZIONE, CANCELLAZIONE Richiedono l'istallazione di ANT (library and command-line tool) -> https://ant.apache.org/ 
***COMPILAZIONE***
---Tutto---
1) posizionarsi in .../Esercizio4
2) ant all (nella directory corrente ci deve essere il file build.xml)
---MinSpan---
1) posizionarsi in .../Esercizio4
2) ant jar (nella directory corrente ci deve essere il file build.xml)
---Unit test---
1) posizionarsi in .../Esercizio4
2) ant junit (nella directory corrente ci deve essere il file build.xml)

***CANCELLAZIONE***
1) posizionarsi in .../Esercizio4
2) ant clean (nella directory corrente ci deve essere il file build.xml)


***ESECUZIONE***
---PER ESEGUIRE MinSpan (KRUSKAL)---
1) Compilare MinSpan (vedi paragrafo complilazione)
2) posizionarsi in .../Esercizio4/build
3) java -jar MinSpan.jar "path file" ("path file" path del file su cui eseuguire l algoritmo di kruskal)

---PER ESEGUIRE Unit test---
1) Compilare junit (vedi paragrafo complilazione)
2) posizionarsi in .../Esercizio4/build
3) java -jar GraphTests.jar 