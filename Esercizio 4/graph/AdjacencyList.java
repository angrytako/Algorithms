package graph;
import java.lang.Object;
import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Laurentiu, Enrico.
 */
public class AdjacencyList<T,S extends Comparable<S>>{
    private boolean direct;
    private Map<T, Arc<T,S>> graph;

    /**
     * It creates an empty graph. 
     * @param type true->direct graph false->undirect graph
     */
    public AdjacencyList(boolean type){
        direct=type;
        this.graph=new HashMap<T, Arc<T,S>>();
    }


    /** 
     * It adding an element.
     * @param elem the element to add
     */
    public void addingNode( T elem){
        //cerco se esiste
        if (!nodeExist(elem))
            graph.put(elem, null);
        /*    
        else genero errore */
    }
    
    /** 
     * It adding an arc.
     * @param elem the element to add
     */
    public void addingArc(T u,T v, S weight){
        if (ArcExist(u,v))   /*crea erore*/;
        else{                      
            Arc<T,S> elem = new Arc<T,S>(v,graph.get(u),weight);
            graph.put(u,elem);
        }
        if (direct==false){
            if (ArcExist(v,u))   /*crea erore*/;
            else{                      
                Arc<T,S> elem = new Arc<T,S>(u,graph.get(v),weight);
                graph.put(v,elem);
            }
        }
        
    }

    /** 
     * It check if the graph is direct.
     * @return true if the graph id direct, else false
     */
    public boolean isDirect(){
        return direct;
    }

    /** 
     * It check if the graph contain an element.    
     * @param elem the element to check
     * @return true if the graph contain the element, else false
     */
    public boolean nodeExist(T elem){
        return graph.containsKey(elem);
    }

    /** 
     * It check if the graph contain an specific arc between two node.    
     * @param u first node of arc
     * @param v second node of arc
     * @return true if the graph contain the arc between the argoument node, else false
     */
    public boolean ArcExist(T u,T v){
        Arc<T,S> elem=graph.get(u); 
        while(elem!=null){
            if (elem.getElem().equals(v)) return true;
            elem=elem.getNext();
        }
        return false;
    }

    /** 
     * It delete une node
     * @param elem the elem to delate
     */
    public void nodeDelete (T elem){
        graph.remove(elem);
    }

    /** 
     * It delate one arc between tro arc.  
     * @param u first node of arc
     * @param v second node of arc
     */
    public void arcDelete (T u, T v){
        Arc<T,S> elem=graph.get(u); 
        if (elem==null) return;
        if (elem.getElem().equals(v)) elem.setNext(elem.getNext().getNext());

        while(elem.getNext()!=null){
            if (elem.getNext().equals(v)){
                elem.setNext(elem.getNext().getNext());
            }
            elem=elem.getNext();
        }
        if(direct==false){
        elem=graph.get(v); 
        if (elem==null) return;
        if (elem.getElem().equals(u)) elem.setNext(elem.getNext().getNext());

        while(elem.getNext()!=null){
            if (elem.getNext().equals(u)){
                elem.setNext(elem.getNext().getNext());
            }
            elem=elem.getNext();
        }
        }
    }

    /** 
     * It determination the number of node in the graph.
     * @return Number of node in the graph
     */
    public int nodeNumber(){
        return graph.size();
    }

    /** 
     * It determination the number of arc in the graph.
     * @return Number of arc in the graph
     */
    public int arcNumber(){
        int count=0;
        for (Arc<T,S> elem : graph.values() ) {
            while(elem!=null){
                count++;
                elem=elem.getNext();
            }
        }
        return count;

    }

    /** 
     * It Recovery all node of the graph.
     * @return List<T> of nodes
     */
    public List<T> getAllNode(){
        List<T> allNode;      
        allNode = new ArrayList<T>(nodeNumber()); 
       
        for (T key : graph.keySet()) {
            allNode.add(key);
        }
        return allNode;
    }

    /** 
     * It Recovery all arc of the graph.
     * @return List<Arc<T,S>> of nodes
     */
    public List<Arc<T,S>> getAllArc(){
        List<ArcList<T,S>> allArc;      
        allArc = new ArrayList<ArcList<T,S>>(arcNumber()); 
        for (Arc<T,S> arc : graph.values() ) {
            T nodoBase=arc.getElem();
            while(arc!=null){
                ArcList<T,S> elem= new ArcList(nodoBase,arc.getElem(),arc.getWeight());
                allArc.add(elem);
            }
        }
        return allArc;
    
    }

    /** 
     * It Recovery all node adjacent at specific node
     * @param node the node from which Recovery adjacent nodes
     * @return List<T> of node
     */
    public List<T> getAdjacentNode(T node){
          
        if(nodeExist(node)){
            List<T> allArc = new ArrayList<T>();
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
     * It Recovery the weight of specific arc.
     * @param u first node of arc
     * @param v second node of arc
     * @return S -> the weight of arc
     */
    public S getWeightArc(T u, T v)
    {
        if(nodeExist(u) && nodeExist(v))
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
