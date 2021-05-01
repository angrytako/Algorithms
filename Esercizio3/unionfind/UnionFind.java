import java.util.*;
class UnionFind<T>{

    private Map< T, Node<T> > sets;
        public UnionFind(){
            this.sets=new HashMap<T, Node<T>>();
        }
        public void insert (T elem){
            sets.put(elem, new Node<T>(elem,null));
        }
        public void union (T elem1, T elem2){
            link(sets.get(elem1).find(), sets.get(elem2).find());
        }
        public T find(T elem){
            /*this.sets.get(elem).find();
            if(!(this.sets.get(elem).getNext() == null || this.sets.get(elem).getNext().getNext() == null))
                throw new Error("Find does not update properly");*/
            return this.sets.get(elem).find().getElem();
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