package unionfind;
import java.util.*;
/**
 *
 * @author Laurentiu, Enrico
 * @param <T>: type of the elements in the sets
 */
public class UnionFind<T>{

        private Map<T, Node<T>> sets;

  /**
   * It creates an empty collection of sets.
   */
        public UnionFind(){
            this.sets=new HashMap<T, Node<T>>();
        }
    /**
     * It creates a new set containing one element
     * @param elem the element of the set
     * @throws UnionFindException if the inserted element is null
     */
        public void createSet (T elem) throws UnionFindException{
            if(elem==null)
                throw new UnionFindException("You cannot insert null element"); 
            sets.put(elem, new Node<T>(elem,null));
        }
        /**
         * It creates a new set, performing the union operation on the 
         * two sets containing the two elemets passed as parameters
         * @param elem1 first element, representing the first set
         * @param elem2 second element, representing the second set
         * @throws UnionFindException if it cannot find eather of the two inserted elements
         *                            among its sets
         */
        public void union (T elem1, T elem2) throws UnionFindException {
            Node<T> node1, node2;
            node1=sets.get(elem1);
            if(node1==null)
                throw new UnionFindException("Union of absent element-set"); 
            node1=node1.find();
            node2=sets.get(elem2);
            if(node2==null)
                throw new UnionFindException("Union of absent element-set");
            node2=node2.find();
            link(node1,node2);
        }
        /**
         * It finds the head element of the set containing the element passed as parameter
         * @param elem element whose set is being found
         * @return the head of the set containing the element passed as parameter
         *         If the element passed as a parameter is not in the collection,
         *         or it is null, it returns null
         */
        public T find(T elem) {
            /*this.sets.get(elem).find();
            if(!(this.sets.get(elem).getNext() == null || this.sets.get(elem).getNext().getNext() == null))
                throw new Error("Find does not update properly");*/
            Node<T> node;
            node=this.sets.get(elem);
            if(node==null)
                return null;
            return node.find().getElem();
        }
    
        private void link (Node<T> tree1, Node<T> tree2){
            int t1Rank, t2Rank;
            t1Rank=tree1.getRank();
            t2Rank=tree2.getRank();
            if(t1Rank>t2Rank)
                tree2.setNext(tree1);   
            else{
                if(t2Rank==t1Rank) 
                    tree2.setRank(t2Rank+1);
                tree1.setNext(tree2); 
            }
        }
}