package graph;
import java.util.ArrayList;
import java.util.Collections;
import unionfind.UnionFind;
import unionfind.UnionFindException;

/**
 *
 * @author Laurentiu, Enrico
 * @param <T>: type of the elements that act as nodes. 
 * @param <S>: type of the weights of the arcs containing the nodes. 
 * It must extend comparable
 */
public class Kruskal<T,S extends Comparable<S>>{
    private AdjacencyList<T,S> graph;
    private AdjacencyList<T,S> minForest;
    /**
     * It saves a reference to a graph, so that it can compute the minimum spanning tree or forest
     * when the corresponding function is called.
     * @param graph the input graph for the minimum spanning tree or forest.
     */
    public Kruskal(AdjacencyList<T,S> graph) throws AdjacencyListException{
        if(graph==null)
            throw new AdjacencyListException("You cannot initialize Kruskal with a null graph");
        this.graph=graph;
        this.minForest=null;
    }
  
    AdjacencyList<T,S> getGraph(){
        return this.graph;
    }
    AdjacencyList<T,S> getMinForest(){
        return this.minForest;
    }
          /** 
     * It returns the minimum spanning tree or forrest, in the format
     * of a graph, of the graph that the class has been initialized with.
     * The spanning forest is also saved internally in the class.
     * 
     * @throws AdjacencyListException if any of the operations on the two internal graphs fail.
     * @throws UnionFindExceptionif any union-find operation fails.
     */
    public AdjacencyList<T,S> minSpanForest() throws AdjacencyListException, UnionFindException{
        this.minForest=new AdjacencyList<>(false);
        UnionFind<T> sets=new UnionFind<>();
        ArrayList<T> nodes;
        ArrayList<FullArc<T,S>> arcs;
        nodes=graph.getAllNodes();
        for (T node : nodes) {
             sets.createSet(node);
             this.minForest.addNode(node);
             //System.out.println(city);
     }
        arcs=graph.getAllArcs();
        Collections.sort(arcs, new MyComparator<T,S>());
        for (FullArc<T,S> arc : arcs) {
             T node1, node2;
             node1=sets.find(arc.getFirstNode());
             node2=sets.find(arc.getSecondNode());

             if(node1.equals(node2)==false){
                 sets.union(node1, node2);
                 this.minForest.addArc(node1, node2, arc.getWeight());
             }}
        return this.minForest;
    }
}
