
import java.lang.Object;;

/**
 *
 * @author Laurentiu, Enrico
 */
public class   FullArc<T,S extends Comparable<S>>{
    private T firtsNode;
    private T secondNode;
    private S weight;
    
    
    public FullArc(T firtsNode, T secondNode,  S  weight){
        this.firtsNode=firtsNode;
        this.secondNode=secondNode;
        this.weight=weight;
    }

    public T getFirtsNode() {
        return firtsNode;
    }
    public T getSecondNode() {
        return secondNode;
    }
    public  S getWeight() {
        return weight;
    }

}