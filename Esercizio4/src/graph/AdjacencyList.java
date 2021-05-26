package graph;
import java.lang.Object;
import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Laurentiu, Enrico
 * @param <T>: type of the elements that act as nodes. 
 * @param <S>: type of the weights of the arcs containing the nodes. 
 * It must extend comparable
 */
public class AdjacencyList<T,S extends Comparable<S>>{
    private Map<T, Arc<T,S>> graph;
    private boolean directed;
    private int numberArcs;

    /**
     * It creates an empty graph. 
     * @param type The type of the graph: true->directed graph, false->non-directed graph
     */
    public AdjacencyList(boolean directed){
        this.directed=directed;
        this.graph=new HashMap<T, Arc<T,S>>();
        this.numberArcs=0;
    }


    /** 
     * It adds a new node in the graph.
     * @param elem the element contained in the node. If the node already exists 
     *it does nothing.
     */
    public void addNode ( T elem){
        if (!nodeExists(elem))
            graph.put(elem, null);
    }
    
    /** 
     * It adds an arc. If the arc already exists it does nothing.
     * @param u the first node of the arc.
     * @param v the second node of the arc.
     * @param weight the weight of the arc.
     * @throws AdjacencyListException if eather nodes u,v, or bouth, do not exist.
     */
    public void addArc(T u,T v, S weight) throws AdjacencyListException {
        if (!nodeExists(u) || !nodeExists(v))   throw new AdjacencyListException("One, or bouth, of the nodes in the arc do not exisit");
        if (ArcExists(u,v)) return;
        else{                      
            Arc<T,S> elem = new Arc<T,S>(v,graph.get(u),weight); 
            graph.put(u,elem);
            this.numberArcs++;
        }
        if (directed==false){                    
                Arc<T,S> elem = new Arc<T,S>(u,graph.get(v),weight,true);
                graph.put(v,elem);
        }
        
    }

    /** 
     * It checks if the graph is directed.
     * @return true if the graph id directed, false otherwise
     */
    public boolean isDirected(){
        return directed;
    }

    /** 
     * It checks if the graph contains an element.    
     * @param elem the element to check.
     * @return true if the graph contains the element, false otherwise.
     */
    public boolean nodeExists(T elem){
        return graph.containsKey(elem);
    }

    /** 
     * It checks if the graph contains a specific arc between two nodes.    
     * @param u first node of the arc.
     * @param v second node of the arc.
     * @return true if the graph contains the arc between the two nodes, false otherwise.
     */
    public boolean ArcExists(T u,T v){
        Arc<T,S> elem=graph.get(u); 
        while(elem!=null){
            if (elem.getElem().equals(v)) return true;
            elem=elem.getNext();
        }
        return false;
    }

    /** 
     * It deletes a node. If the node does not exist it does nothing.
     * @param elem the element to delete
     */
    public void nodeDelete (T elem){
        if (nodeExists(elem)){
            Arc<T,S> arcNode = graph.get(elem); 
                while (arcNode!=null){
                    try {
                        arcDelete(elem,arcNode.getElem());
                    }catch(AdjacencyListException error){
                        System.out.println("Error! This error can't exist");
                    }
                    arcNode=arcNode.getNext();
                }
            graph.remove(elem);
        }
    }



     /** 
     * It deletes an arc between two nodes.  
     * @param u first node of arc.
     * @param v second node of arc.
     * @throws AdjacencyListException if eather nodes u,v, or bouth, do not exist.
     */
    public void arcDelete (T u, T v) throws AdjacencyListException {
        if(directed==false) arcDelete(u,v,false);
        else arcDelete(u,v,true);
    }

    private void arcDelete (T u, T v, boolean clearSecondArc) throws AdjacencyListException {
        Arc<T,S> elem=graph.get(u); 
        if (elem==null) throw new AdjacencyListException("Arc does not  exisit");
        if (elem.getElem().equals(v)) {
            graph.replace(u, elem.getNext());
            if(clearSecondArc==false) arcDelete(v,u,true);
            else numberArcs--;
            return;
        }

        while(elem.getNext()!=null){
            if (elem.getNext().getElem().equals(v)){
                elem.setNext(elem.getNext().getNext());
                if(clearSecondArc==false) arcDelete(v,u,true);
                else numberArcs--;
                return;
            }
            elem=elem.getNext(); 
        }
        throw new AdjacencyListException("Arc does not exisit");
    }


    /** 
     * @return Number of nodes in the graph.
     */
    public int numberNodes(){
        return graph.size();
    }

    /** 
     * @return Number of arcs in the graph.
     */
    public int numberArcs(){
        return numberArcs;
    }

    /** 
     * @return an ArrayList containing all the nodes in the graph.
     */
    public ArrayList<T> getAllNodes(){
        ArrayList<T> allNodes;      
        allNodes = new ArrayList<T>(numberNodes()); 
       
        for (T key : graph.keySet()) {
            allNodes.add(key);
        }
        return allNodes;
    }

    /** 
     * @return an ArrayList containing all the arcs in the graph.
     */
    public ArrayList<FullArc<T,S>> getAllArcs(){
        ArrayList<FullArc<T,S>> allArc = new ArrayList<FullArc<T,S>>(numberArcs());
        for(Map.Entry<T,Arc<T,S>> pair : graph.entrySet()){
            T baseNode=pair.getKey();
            Arc<T,S> arc =pair.getValue();
                while(arc!=null){
                    if (!arc.isFake()) allArc.add(new FullArc<>(baseNode,arc.getElem(),arc.getWeight()));
                    arc=arc.getNext();
                }

        }  return allArc;
    }

    /** 
     * It returns the adjacency list of a node.
     * @param node the node of the adjacency list.
     * @return an ArrayList containing all the arcs that connect the node to the other nodes in the graph.
     */
    public ArrayList<T> getAdjacentNode(T node){
          
        if(nodeExists(node)){
            ArrayList<T> allArc = new ArrayList<T>();
            Arc<T,S> elem = graph.get(node);

            while(elem!=null){
                allArc.add(elem.getElem());
                elem=elem.getNext();
            }
            return allArc;
        }else{
            return null;
        }
    }

    /** 
     * It returns the weight of an arc arc.
     * @param u first node of the arc.
     * @param v second node of the arc.
     * @return the weight of the arc, if the arc exists, null otherwise.
     */
    public S getWeightArc(T u, T v)
    {
        if(nodeExists(u) && nodeExists(v))
        {
            Arc<T,S> elem = graph.get(u);
            while(elem!=null)
            {
                if(elem.getElem().equals(v))
                {
                    return elem.getWeight();
                }
                elem=elem.getNext();
            }return null;

        }else return null;
    }






}
