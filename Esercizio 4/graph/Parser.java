

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    BufferedReader csvReader;
    public Parser(String path) throws FileNotFoundException{
        this.csvReader= new BufferedReader(new FileReader(path));
    }
public ArrayList<String[]> read() throws IOException{
    String row;
    ArrayList<String[]> rows= new ArrayList<>();
        while ((row = this.csvReader.readLine()) != null)
           rows.add(row.split(","));
    return rows;
 
}

public void close() throws IOException{
    this.csvReader.close();
}
}
