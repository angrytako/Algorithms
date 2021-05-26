COMPILAIZONE, CANCELLAZIONE Richiedono l'istallazione di ANT (library and command-line tool) -> https://ant.apache.org/ 

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