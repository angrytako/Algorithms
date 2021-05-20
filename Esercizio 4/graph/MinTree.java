

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import unionfind.UnionFind;

public class MinTree {
    public static void main(String[] args){
        try {
            File output = new File("./result.txt");
            FileWriter write =new FileWriter(output);
            UnionFind<String> sets=new UnionFind<>();
            ArrayList<String> nodes;
            ArrayList<String[]> parsedArcs;
            ArrayList<FullArc<String,Double>> arcs;
            AdjacencyList<String,Double> graph = new AdjacencyList<>(false);
            AdjacencyList<String,Double> minTree = new AdjacencyList<>(false);
            Parser csv=new Parser("./italian_dist_graph.csv");
            parsedArcs=csv.read();
            csv.close();
            for (String[] row : parsedArcs) { 		      
                graph.addingNode(row[0]);
                graph.addingNode(row[1]);
                graph.addingArc(row[0], row[1], Double.parseDouble(row[2]));
           }
           nodes=graph.getAllNode();
           for (String city : nodes) {
            sets.createSet(city);
            minTree.addingNode(city);
            //System.out.println(city);
        }
           arcs=graph.getAllArc();
           Collections.sort(arcs, new MyComparator<String,Double>());
           for (FullArc<String,Double> arc : arcs) {
                String city1, city2;
                city1=sets.find(arc.getFirtsNode());
                city2=sets.find(arc.getSecondNode());
                if(city1.compareTo(city2)!=0){
                    sets.union(city1, city2);
                    minTree.addingArc(city1, city2, arc.getWeight());
                }
            //System.out.println(row.getWeight());
        }

        arcs=minTree.getAllArc();
        for (FullArc<String,Double> arc : arcs) {
            write.write(arc.getFirtsNode()+","+  arc.getSecondNode()+ ","+ arc.getWeight()+ '\n');
        }

    } catch(Exception e){
        System.out.println("Error!!!!");
    }

    } 
}
