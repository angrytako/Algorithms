package minspan;
import graph.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
public class MinTree {
    public static void main(String[] args){
        try {
            if(args.length==0)
            {
                System.out.println("Missing argument\nPlease call this process with the path to the file containing the graph as an argument");
                return;
            }
            AdjacencyList<String,Double> graph;
            AdjacencyList<String,Double> minForest;
            ArrayList<FullArc<String,Double>> arcs;
            File output = new File("./result.csv");
            FileWriter write =new FileWriter(output);
            Parser csv=new Parser(args[0]);
            Kruskal<String,Double> kruskal;
            graph=csv.parse();
            csv.close();
            kruskal=new Kruskal<>(graph);
            minForest=kruskal.minSpanForest();
            arcs=minForest.getAllArcs();
        
        for (FullArc<String,Double> arc : arcs) {
            write.write(arc.getFirstNode()+","+  arc.getSecondNode()+ ","+ arc.getWeight()+ '\n');
        }
        double totDistance=0;
        for (FullArc<String,Double> arc : arcs) totDistance+=arc.getWeight();
        write.write("total distance: "+String.format("%.3f",totDistance) + " m"+'\n');
        write.flush();
        write.close();
    }catch(Exception e){
        System.out.println(e);
        return;
    }

    } 
}
