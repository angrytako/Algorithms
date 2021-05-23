package graph;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Laurentiu, Enrico
 */
public class AdjacencyListTest {
  private AdjacencyList<String,Integer> adjacencyList;
  private AdjacencyList<String,Integer> nonDirectedList;
  private AdjacencyList<Integer,Integer> nonDirectedIntegerList;
  private Kruskal<Integer,Integer> kruskalInteger;
  private Kruskal<String,Integer> kruskalString;


  @Before
  public void AdjacencyList(){
    this.adjacencyList = new AdjacencyList<String,Integer>(true);
    this.nonDirectedList = new AdjacencyList<String,Integer>(false);
    this.nonDirectedIntegerList=new AdjacencyList<Integer,Integer>(false);

  } 
/*
  @Test
  public void testAddingNodeDirect(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }
  @Test
  public void testAddingNodeUndirect(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }

  @Test
  public void testAddingArcDirect(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addArc("Torino","Milano",200);
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }
  @Test
  public void testAddingArcUndirect(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addArc("Torino","Milano",200);
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }

  @Test 
  public void testUnionFindDirect(){
    assertTrue("The graf is not direct",adjacencyList.isDirect());
  }
  @Test 
  public void testUnionFindUndirect(){
    assertFalse("The graf is direct",nonDirectedList.isDirect());
  }

  @Test 
  public void testNodeExistDirect(){
    try{
        adjacencyList.addNode("Torino");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the node",adjacencyList.nodeExists("Torino"));
  }  
  @Test 
  public void testNodeExistUndirect(){
    try{
        nonDirectedList.addNode("Torino");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the node",nonDirectedList.nodeExists("Torino"));
  }

  @Test 
  public void tastArcExistDirect1(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addArc("Torino","Milano",200);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the arc",adjacencyList.ArcExists("Torino","Milano"));
  }
  @Test 
  public void tastArcExistUndirect1(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addArc("Torino","Milano",200);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the arc",nonDirectedList.ArcExists("Torino","Milano"));
  }
  @Test 
  public void tastArcExistDirect2(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("it find arc but it not exist",adjacencyList.ArcExists("Torino","Milano"));
  }
  @Test 
  public void tastArcExistUndirect2(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("it find arc but it not exist",nonDirectedList.ArcExists("Torino","Milano"));
  }


  @Test 
  public void testNodeDeleteDirect(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    adjacencyList.nodeDelete("Torino");
    assertTrue(!adjacencyList.nodeExists("Torino") );
  } 
  @Test 
  public void testNodeDeleteUndirect(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    nonDirectedList.nodeDelete("Torino");
    assertTrue(!nonDirectedList.nodeExists("Torino") );
  }

 /*arc delete
  @Test 
  public void testArcDeleteDirect1(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addArc("Torino","Milano",200);
        adjacencyList.arcDelete("Torino","Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("The arc continues to exist",adjacencyList.ArcExists("Torino","Milano") );
  } 
  @Test 
  public void testArcDeleteUndirect1(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addArc("Torino","Milano",200);
        nonDirectedList.arcDelete("Torino","Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("The arc continues to exist",nonDirectedList.ArcExists("Torino","Milano") );
  }


  @Test 
  public void testArcDeleteDirect2(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addNode("Genova");
        adjacencyList.addNode("Pinerolo");
        adjacencyList.addArc("Torino","Milano",200);
        adjacencyList.addArc("Torino","Genova",275);
        adjacencyList.addArc("Torino","Pinerolo",50);
        adjacencyList.arcDelete("Torino","Genova");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("The arc continues to exist",adjacencyList.ArcExists("Torino","Genova") );
    assertTrue("Another arc not more exist",adjacencyList.ArcExists("Torino","Pinerolo") );
  } 
  @Test 
  public void testArcDeleteUndirect2(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addNode("Genova");
        nonDirectedList.addNode("Pinerolo");
        nonDirectedList.addArc("Torino","Milano",200);
        nonDirectedList.addArc("Torino","Genova",275);
        nonDirectedList.addArc("Torino","Pinerolo",50);
        nonDirectedList.arcDelete("Torino","Genova");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("The arc continues to exist",nonDirectedList.ArcExists("Torino","Genova") );
    assertTrue("Another arc not more exist",nonDirectedList.ArcExists("Torino","Pinerolo") );
  }


  /*Node number
  @Test 
  public void testNodeNumberDirect1(){
    assertTrue("node number wrong",adjacencyList.numberNodes()==0);
  }
  @Test 
  public void testNodeNumberUndirect1(){
    assertTrue("node number wrong",nonDirectedList.numberNodes()==0);
  }
  @Test 
  public void testNodeNumberDirect2(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addNode("Genova");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("node number wrong",adjacencyList.numberNodes()==3);
  }
  @Test 
  public void testNodeNumberUndirect2(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addNode("Genova");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("node number wrong",nonDirectedList.numberNodes()==3);
  } 
  
  
  /*Arc number
  @Test 
  public void testArcNumberDirect1(){
    assertTrue("arc number wrong",adjacencyList.numberArcs()==0);
  }
  @Test 
  public void testArcNumberUndirect1(){
    assertTrue("arc number wrong",nonDirectedList.numberArcs()==0);
  }
  @Test 
  public void testArcNumberDirect2(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addNode("Genova");
        adjacencyList.addNode("Pinerolo");
        adjacencyList.addArc("Torino","Milano",200);
        adjacencyList.addArc("Torino","Genova",275);
        adjacencyList.addArc("Torino","Pinerolo",50);
        adjacencyList.addArc("Genova","Milano",251);
        adjacencyList.addArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("arc number wrong",adjacencyList.numberArcs()==5);
  }
  @Test 
  public void testArcNumberUndirect2(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addNode("Genova");
        nonDirectedList.addNode("Pinerolo");
        nonDirectedList.addArc("Torino","Milano",200);
        nonDirectedList.addArc("Torino","Genova",275);
        nonDirectedList.addArc("Torino","Pinerolo",50);
        nonDirectedList.addArc("Genova","Milano",251);
        nonDirectedList.addArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("arc number wrong",nonDirectedList.numberArcs()==5);
  }
  

  /*get all node
  @Test 
  public void testGetNodeDirect(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addNode("Genova");
        adjacencyList.addNode("Pinerolo");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<String> allNodes = adjacencyList.getAllNodes();
    if(allNodes.indexOf("Torino")==-1 || allNodes.indexOf("Milano")==-1 || 
    allNodes.indexOf("Genova")==-1 || allNodes.indexOf("Pinerolo")==-1)
    assertTrue("Miss nodes in getAllNodes",false);
    else assertTrue(true);
  }
  @Test 
  public void testGetNodeUndirect(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addNode("Genova");
        nonDirectedList.addNode("Pinerolo");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<String> allNodes = nonDirectedList.getAllNodes();
    if(allNodes.indexOf("Torino")==-1 || allNodes.indexOf("Milano")==-1 || 
    allNodes.indexOf("Genova")==-1 || allNodes.indexOf("Pinerolo")==-1)
    assertTrue("Miss nodes in getAllNodes",false);
    else assertTrue(true);
  }


  /*get all arc
  @Test 
  public void testGetArcDirect(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addNode("Genova");
        adjacencyList.addNode("Pinerolo");
        adjacencyList.addArc("Torino","Milano",200);
        adjacencyList.addArc("Torino","Genova",275);
        adjacencyList.addArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<FullArc<String,Integer>> allArc = adjacencyList.getAllArcs();
    int count=allArc.size();
    for (int i=0; i<allArc.size();i++){
        if ( allArc.get(i).equals(new FullArc<String,Integer>("Torino","Milano",200)) ) count--;
    }
    for (int i=0; i<allArc.size();i++){
        if ( allArc.get(i).equals(new FullArc<String,Integer>("Torino","Genova",275)) ) count--;
    }
    for (int i=0; i<allArc.size();i++){
        if ( allArc.get(i).equals(new FullArc<String,Integer>("Pinerolo","Genova",150)) ) count--;
    }
    assertFalse("the graph contain more arc",count>0);
    assertFalse("the graph contain less arc",count<0);
  }
  @Test 
  public void testGetArcUndirect(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addNode("Genova");
        nonDirectedList.addNode("Pinerolo");
        nonDirectedList.addArc("Torino","Milano",200);
        nonDirectedList.addArc("Torino","Genova",275);
        nonDirectedList.addArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<FullArc<String,Integer>> allArc = nonDirectedList.getAllArcs();
    int count=allArc.size();
    for (int i=0; i<allArc.size();i++){
        if ( allArc.get(i).equals(new FullArc<String,Integer>("Torino","Milano",200)) ) count--;
    }
    for (int i=0; i<allArc.size();i++){
        if ( allArc.get(i).equals(new FullArc<String,Integer>("Torino","Genova",275)) ) count--;
    }
    for (int i=0; i<allArc.size();i++){
        if ( allArc.get(i).equals(new FullArc<String,Integer>("Pinerolo","Genova",150)) ) count--;
    }
    assertFalse("the graph contain more arc",count>0);
    assertFalse("the graph contain less arc",count<0);
  }




  /*get Adjacent Node
  @Test 
  public void testGetAdjacentNodeDirect(){
    try{
        adjacencyList.addNode("Torino");
        adjacencyList.addNode("Milano");
        adjacencyList.addNode("Genova");
        adjacencyList.addNode("Pinerolo");
        adjacencyList.addArc("Torino","Milano",200);
        adjacencyList.addArc("Torino","Genova",275);
        adjacencyList.addArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<String> adjacentNode = adjacencyList.getAdjacentNode("Torino");
    if(adjacentNode.indexOf("Milano")==-1 || adjacentNode.indexOf("Genova")==-1)  
    assertTrue("less adjacent Node",false);
    if(adjacentNode.size()!=2) {
        assertFalse("outpunt contain less node",adjacentNode.size()<0);
        assertFalse("outpunt contain more node",adjacentNode.size()>0);
    }   
  } 
  @Test 
  public void testGetAdjacentNodeUndirect(){
    try{
        nonDirectedList.addNode("Torino");
        nonDirectedList.addNode("Milano");
        nonDirectedList.addNode("Genova");
        nonDirectedList.addNode("Pinerolo");
        nonDirectedList.addArc("Torino","Milano",200);
        nonDirectedList.addArc("Torino","Genova",275);
        nonDirectedList.addArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<String> adjacentNode = nonDirectedList.getAdjacentNode("Torino");
    if(adjacentNode.indexOf("Milano")==-1 || adjacentNode.indexOf("Genova")==-1)  
    assertTrue("less adjacent Node",false);
    if(adjacentNode.size()!=2) {
        assertFalse("outpunt contain less node",adjacentNode.size()<0);
        assertFalse("outpunt contain more node",adjacentNode.size()>0);
    }   
  }

/*get WeightArc
@Test 
public void testgetWeightArcDirect(){
  try{
      adjacencyList.addNode("Torino");
      adjacencyList.addNode("Milano");
      adjacencyList.addNode("Pinerolo");
      adjacencyList.addNode("Genova");
      adjacencyList.addArc("Torino","Milano",200);
      adjacencyList.addArc("Torino","Genova",275);
      adjacencyList.addArc("Pinerolo","Genova",150);
  }
  catch(AdjacencyListException error){
      assertTrue(error.toString(),false);
  }
  assertTrue("wrong weight",adjacencyList.getWeightArc("Torino","Milano")==200);
  assertTrue("it find weight of inversed arc",adjacencyList.getWeightArc("Milano","Torino")==null);
  assertTrue("wrong weight",adjacencyList.getWeightArc("Torino","Genova")==275);
  assertTrue("wrong weight",adjacencyList.getWeightArc("Pinerolo","Genova")==150);
  assertTrue("it find weight of inversed arc",adjacencyList.getWeightArc("Genova","Pinerolo")==null);
  assertTrue("it find weight but weight not exist",adjacencyList.getWeightArc("Milano","Pinerolo")==null);
} 
@Test 
public void testgetWeightArcUndirect(){
  try{
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.addNode("Pinerolo");
    nonDirectedList.addNode("Genova");
    nonDirectedList.addArc("Torino","Milano",200);
    nonDirectedList.addArc("Torino","Genova",275);
    nonDirectedList.addArc("Pinerolo","Genova",150);
  }
  catch(AdjacencyListException error){
      assertTrue(error.toString(),false);
  }
  assertTrue("wrong weight",nonDirectedList.getWeightArc("Torino","Milano")==200);
  assertTrue("it can't find weight of inversed arc",nonDirectedList.getWeightArc("Milano","Torino")==200);
  assertTrue("wrong weight",nonDirectedList.getWeightArc("Torino","Genova")==275);
  assertTrue("wrong weight",nonDirectedList.getWeightArc("Pinerolo","Genova")==150);
  assertTrue("it can't find weight of inversed arc",nonDirectedList.getWeightArc("Genova","Pinerolo")==150);
  assertTrue("it finds the weight even if the weight does not exist",nonDirectedList.getWeightArc("Milano","Pinerolo")==null);
} */

@Test 
public void testKruskalNull(){
  try{
      kruskalInteger=new Kruskal(null);
      assertTrue(null,false);
  }
  catch(AdjacencyListException error){
      assertTrue(error.toString(),true);
  }} 

  @Test 
  public void testKruskalEmptyGraph(){
    try{
        kruskalInteger=new Kruskal(nonDirectedIntegerList);
        assertTrue(null,true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }} 
  
    @Test 
    public void testKruskalEmptyGraphMinForest(){
      try{
          kruskalInteger=new Kruskal(nonDirectedIntegerList);
         
          assertTrue("The size of the minForest of empty graph is: " 
          +kruskalInteger.minSpanForest().getAllArcs().size(),
          kruskalInteger.minSpanForest().getAllArcs().size()==0);
      }
      catch(Exception error){
          assertTrue(error.toString(),false);
      }}
}
