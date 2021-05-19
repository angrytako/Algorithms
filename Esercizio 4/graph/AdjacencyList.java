package graph;
import java.lang.Object;
import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Laurentiu, Enrico
 */
public class AdjacencyList<T,S extends Comparable<S>>{
    private boolean direct;
    private Map<T, Arc<T,S>> graph;

    public AdjacencyList(){
        this.graph=new HashMap<T, Arc<T,S>>();
    }



    public void addingNode( T elem){
        //cerco se esiste
        if (!graph.containsKey(elem))
            graph.put(elem, null);
        /*    
        else genero errore */
    }
                           
    public void addingArc(T u,T v, S weight){
        //cerco se esiste
        if (ArcExist(u,v))   /*crea erore*/;
        else{                      
            Arc<T,S> elem = new Arc<T,S>(v,graph.get(u),weight);
            graph.put(u,elem);
        }
        
    }

    public boolean isDirect(){
        return direct;
    }

    public boolean nodeExist(T elem){
        return graph.containsKey(elem);
    }

    public boolean ArcExist(T u,T v){
        Arc<T,S> elem=graph.get(u); 
        while(elem!=null){
            if (elem.getElem().equals(v)) return true;
            elem=elem.getNext();
        }
        return false;
    }

  
    public void nodeDelete (T elem){
        graph.remove(elem);
    }

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
    }


    public int nodeNumber(){
        return graph.size();
    }

    
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

    public List<T> getAllNode(){
        List<T> allNode;      
        allNode = new ArrayList<T>(nodeNumber()); 
       
        for (T key : graph.keySet()) {
            allNode.add(key);
        }
        return allNode;
    }

    public List<Arc<T,S>> getAllArc(){
        List<Arc<T,S>> allArc;      
        allArc = new ArrayList<Arc<T,S>>(nodeNumber()); 
        for (Arc<T,S> arc : graph.values() ) {
            allArc.add(arc);
        }
        return allArc;
    
    }

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
