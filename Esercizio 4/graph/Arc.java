
import java.lang.Object;;

/**
 *
 * @author Laurentiu, Enrico
 */
public class   Arc<T,S extends Comparable<S>>{
    private T elem;
    private Arc<T,S> next;
    private S weight;
    private boolean fake;
    
    /** 
     * Costruttor for arc in directed graph
     * @param elem the second node of the arch
     * @param next pointer to next arc in the list
     * @param weight wheight of arc
     */
    public Arc(T elem,  Arc<T,S> next,  S  weight){
        this.elem=elem;
        this.next=next;
        this.weight=weight;
        this.fake = false;
    }
    /** 
     * Costruttor for arc in undirect graph
     * @param elem the second node of the arch
     * @param next pointer to next arc in the list
     * @param weight wheight of arc
     * @param fake true if the arc id un duplicate, else false
     */
    public Arc(T elem,  Arc<T,S> next,  S  weight, boolean fake){
        this.elem=elem;
        this.next=next;
        this.weight=weight;
        this.fake=fake;
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
    /**
     * @return true if is dublicate arc
     */
    public  boolean isFake() {
        return fake;
    }


}