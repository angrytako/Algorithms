package graph;
import java.lang.Object;;

/**
 *
 * @author Laurentiu, Enrico
 */
public class   Arc<T,S extends Comparable<S>>{
    private T elem;
    private Arc<T,S> next;
    private S weight;
    
    
    public Arc(T elem,  Arc<T,S> next,  S  weight){
        this.elem=elem;
        this.next=next;
        this.weight=weight;
    }
    public T getElem() {
        return elem;
    }
    public Arc<T,S> getNext() {
        return next;
    }
    public void setNext(Arc<T,S> next) {
        this.next = next;
    }
    public  S getWeight() {
        return weight;
    }
    public void setWeight(S weight) {
        this.weight = weight;
    }

}