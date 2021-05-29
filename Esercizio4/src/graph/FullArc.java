package graph;
import java.lang.Object;;

/**
 *
 * @author Laurentiu, Enrico
 */
public class   FullArc<T,S extends Comparable<S>>{
    private T firstNode;
    private T secondNode;
    private S weight;
    
    
    public FullArc(T firstNode, T secondNode,  S  weight){
        this.firstNode=firstNode;
        this.secondNode=secondNode;
        this.weight=weight;
    }

    public T getFirstNode() {
        return firstNode;
    }
    public T getSecondNode() {
        return secondNode;
    }
    public  S getWeight() {
        return weight;
    }

    public boolean equals(FullArc<T,S> y){
        if (this.firstNode.equals(y.getFirstNode())==false) return false;
        if (this.secondNode.equals(y.getSecondNode())==false) return false;
        if (this.weight.equals(y.getWeight())==false) return false;
        return true;
    }

}