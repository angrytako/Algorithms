package unionfind;
public class Node<T>{
    private T elem;
    private Node<T> next;
    private int rank;
    
    public Node(T elem,  Node<T> next){
        this.elem=elem;
        this.next=next;
        this.rank=0;
    }
    public T getElem() {
        return elem;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public Node<T> find(){
        if(this.next==null)
            return this;
        else {
            System.out.println(this.next.getElem());
            this.next=this.next.find();
            return this.next;
        }
    }
   

}