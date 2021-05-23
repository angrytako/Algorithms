package graph;
import graph.*;
import java.util.Comparator;
    public class MyComparator<T,S extends Comparable<S>> implements Comparator<FullArc<T,S>> {
        @Override
        public int compare(FullArc<T,S> a1, FullArc<T,S> a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }