COMPILAZIONE, CANCELLAZIONE Richiedono l'istallazione di ANT (library and command-line tool) -> https://ant.apache.org/ 
**COMPILAZIONE**
----PER COMPILARE LE CLASSI PER LA STRUTTURA DATI UnionFind NEL PACKAGE unionfind---
1) posizionarsi in .../Esercizio3
2) ant compile

----PER COMPILARE LE CLASSI PER LA STRUTTURA DATI UnionFind NEL PACKAGE unionfind in un .jar---
1) posizionarsi in .../Esercizio3
2) ant jar

----PER COMPILARE ANCHE LO UNIT TEST PER LA STRUTTURA DATI UnionFind NEL PACKAGE unionfind in un .jar eseguibile---
1) posizionarsi in .../Esercizio3
2) ant junit

***ESECUZIONE UNIT TESTS***

---PER ESEGUIRE unionfind/UnionFind_TestRunner---
1) posizionarsi in .../Esercizio3
2) ant junit
3) java -jar ./build/UnionFind_Test.jar
