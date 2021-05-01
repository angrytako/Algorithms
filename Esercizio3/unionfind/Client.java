public class Client {
    public static void main(String[] args){
        UnionFind<String> test= new UnionFind<>();
        String[] tests =new String[] {"", "Set1","Set2","Set3","Set4","Set5", "Set6"};
        test.insert(tests[1]);
        test.insert(tests[2]);
        test.insert(tests[3]);
        test.insert(tests[4]);
        test.insert(tests[5]);
        test.insert(tests[6]);

        test.union(tests[1],tests[2]);  
        test.union(tests[5],tests[6]);  
        test.union(tests[5],tests[1]);  /*set2 set1 set5*/ 
        System.out.println("The head of set5 is "+ test.find(tests[5]));
        test.union(tests[4],tests[3]); /*set3 set4*/ 

        test.union(tests[1],tests[3]);
        
        System.out.println("The head is "+ test.find(tests[3]));
        test.find(tests[1]); 
        System.out.println();
        test.find(tests[2]); 
        System.out.println();
        test.find(tests[3]); 
        System.out.println();
        test.find(tests[4]); 
        System.out.println();
        test.find(tests[1]); 
        test.find(tests[2]); 
        test.find(tests[3]); 
        test.find(tests[4]); 
        test.find(tests[5]); 
        test.find(tests[1]); 
        test.find(tests[2]); 
        test.find(tests[3]); 
        test.find(tests[4]); 
        test.find(tests[5]); 
        test.find(tests[1]); 
        test.find(tests[2]); 
        test.find(tests[3]); 
        test.find(tests[4]); 
        test.find(tests[5]); 
        test.find(tests[1]); 
        test.find(tests[2]); 
        test.find(tests[3]); 
        test.find(tests[4]); 
        test.find(tests[5]); 
        test.find(tests[1]); 
        test.find(tests[2]); 
        test.find(tests[3]); 
        test.find(tests[4]); 
        test.find(tests[5]); 
        test.find(tests[1]); 
        test.find(tests[2]); 
        test.find(tests[3]); 
        test.find(tests[4]); 
        test.find(tests[5]); 
        test.find(tests[1]); 
        test.find(tests[2]); 
        test.find(tests[3]); 
        test.find(tests[4]); 
        test.find(tests[5]); 

    }
}
