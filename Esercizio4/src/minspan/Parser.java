package minspan;
import graph.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Parser {
    BufferedReader csvReader;
    public Parser(String path) throws FileNotFoundException{
        this.csvReader= new BufferedReader(new FileReader(path));
    }
public AdjacencyList<String,Double> parse() throws IOException,AdjacencyListException{
    String row;
    String[] tokens;
    AdjacencyList<String,Double> graph= new AdjacencyList<>(false);
        while ((row = this.csvReader.readLine()) != null){
           tokens=row.split(",");
           graph.addNode(tokens[0]);
           graph.addNode(tokens[1]);
           graph.addArc(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
        }
    return graph;
 
}

public void close() throws IOException{
    this.csvReader.close();
}
}
