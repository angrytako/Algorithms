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
public class GraphUnitTests {
  private AdjacencyList<String,Integer> adjacencyList;
  private AdjacencyList<String,Integer> nonDirectedList;
  private AdjacencyList<Integer,String> genericAdjacencyList;  
  private AdjacencyList<Integer,Integer> nonDirectedIntegerList;
  private Kruskal<Integer,Integer> kruskalInteger;
  private Kruskal<String,Integer> kruskalString;


  @Before
  public void AdjacencyList(){
    this.adjacencyList = new AdjacencyList<String,Integer>(true);
    this.genericAdjacencyList = new AdjacencyList<Integer,String>(true);
    this.nonDirectedList = new AdjacencyList<String,Integer>(false);
    this.nonDirectedIntegerList=new AdjacencyList<Integer,Integer>(false);

  } 

 
  @Test
  public void testAddingArcDirect(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    try{
        adjacencyList.addArc("Torino","Milano",200);
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }
  @Test
  public void testAddingArcUndirect(){
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    try{
        nonDirectedList.addArc("Torino","Milano",200);
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }

  @Test 
  public void testUnionFindDirect(){
    assertTrue("The graf is not direct",adjacencyList.isDirected());
  }
  @Test 
  public void testUnionFindUndirect(){
    assertFalse("The graf is direct",nonDirectedList.isDirected());
  }

  @Test 
  public void testNodeExistDirect(){
    adjacencyList.addNode("Torino");
    assertTrue("it don't find the node",adjacencyList.nodeExists("Torino"));
  }  
  @Test 
  public void testNodeExistUndirect(){
    nonDirectedList.addNode("Torino");
    assertTrue("it don't find the node",nonDirectedList.nodeExists("Torino"));
  }

  @Test 
  public void tastArcExistDirect1(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    try{
        adjacencyList.addArc("Torino","Milano",200);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the arc",adjacencyList.ArcExists("Torino","Milano"));
  }
  @Test 
  public void tastArcExistUndirect1(){
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    try{
        nonDirectedList.addArc("Torino","Milano",200);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the arc",nonDirectedList.ArcExists("Torino","Milano"));
  }
  @Test 
  public void tastArcExistDirect2(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    assertFalse("it find arc but it not exist",adjacencyList.ArcExists("Torino","Milano"));
  }
  @Test 
  public void tastArcExistUndirect2(){
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    assertFalse("it find arc but it not exist",nonDirectedList.ArcExists("Torino","Milano"));
  }

//node delete
  @Test 
  public void testNodeDeleteDirect1(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    adjacencyList.nodeDelete("Torino");
    assertTrue(!adjacencyList.nodeExists("Torino") );
  } 
  @Test 
  public void testNodeDeleteUndirect1(){
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.nodeDelete("Torino");
    assertTrue(!nonDirectedList.nodeExists("Torino") );
  }
  @Test 
  public void testNodeDeleteDirect2(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    adjacencyList.addNode("Genova");
    adjacencyList.addNode("Pinerolo");
    try{
      adjacencyList.addArc("Torino","Milano",200);
      adjacencyList.addArc("Torino","Genova",275);
      adjacencyList.addArc("Torino","Pinerolo",50); 
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    adjacencyList.nodeDelete("Torino");
    assertFalse("The arc continues to exist",adjacencyList.ArcExists("Torino","Genova") );
    assertFalse("Another arc not more exist",adjacencyList.ArcExists("Torino","Pinerolo") );
  } 
  @Test 
  public void testNodeDeleteUndirect2(){
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.addNode("Genova");
    nonDirectedList.addNode("Pinerolo");
    try{
        nonDirectedList.addArc("Torino","Milano",200);
        nonDirectedList.addArc("Torino","Genova",275);
        nonDirectedList.addArc("Torino","Pinerolo",50); 
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    nonDirectedList.nodeDelete("Torino");
    assertFalse("The arc continues to exist",nonDirectedList.ArcExists("Torino","Genova") );
    assertFalse("Another arc not more exist",nonDirectedList.ArcExists("Torino","Pinerolo") );
  }


 //arc delete
  @Test 
  public void testArcDeleteDirect1(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    try{
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
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    try{
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
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    adjacencyList.addNode("Genova");
    adjacencyList.addNode("Pinerolo");
    try{
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
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.addNode("Genova");
    nonDirectedList.addNode("Pinerolo");
    try{
        
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


  //Node number
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
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    adjacencyList.addNode("Genova");
 
    assertTrue("node number wrong",adjacencyList.numberNodes()==3);
  }
  @Test 
  public void testNodeNumberUndirect2(){
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.addNode("Genova");
    assertTrue("node number wrong",nonDirectedList.numberNodes()==3);
  } 
  
  
  //Arc number
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
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    adjacencyList.addNode("Genova");
    adjacencyList.addNode("Pinerolo");
    try{
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
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.addNode("Genova");
    nonDirectedList.addNode("Pinerolo");
    try{
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
  

  //get all node
  @Test 
  public void testGetNodeDirect(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    adjacencyList.addNode("Genova");
    adjacencyList.addNode("Pinerolo");
    ArrayList<String> allNodes = adjacencyList.getAllNodes();
    if(allNodes.indexOf("Torino")==-1 || allNodes.indexOf("Milano")==-1 || 
    allNodes.indexOf("Genova")==-1 || allNodes.indexOf("Pinerolo")==-1)
    assertTrue("Miss nodes in getAllNodes",false);
    else assertTrue(true);
  }
  @Test 
  public void testGetNodeUndirect(){
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.addNode("Genova");
    nonDirectedList.addNode("Pinerolo");
    ArrayList<String> allNodes = nonDirectedList.getAllNodes();
    if(allNodes.indexOf("Torino")==-1 || allNodes.indexOf("Milano")==-1 || 
    allNodes.indexOf("Genova")==-1 || allNodes.indexOf("Pinerolo")==-1)
    assertTrue("Miss nodes in getAllNodes",false);
    else assertTrue(true);
  }


  //get all arc
  @Test 
  public void testGetArcDirect(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    adjacencyList.addNode("Genova");
    adjacencyList.addNode("Pinerolo");
    try{
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
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.addNode("Genova");
    nonDirectedList.addNode("Pinerolo");
    try{
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




  //get Adjacent Node
  @Test 
  public void testGetAdjacentNodeDirect(){
    adjacencyList.addNode("Torino");
    adjacencyList.addNode("Milano");
    adjacencyList.addNode("Genova");
    adjacencyList.addNode("Pinerolo");
    try{
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
    nonDirectedList.addNode("Torino");
    nonDirectedList.addNode("Milano");
    nonDirectedList.addNode("Genova");
    nonDirectedList.addNode("Pinerolo");
    try{
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

//get WeightArc
@Test 
public void testgetWeightArcDirect(){
  adjacencyList.addNode("Torino");
  adjacencyList.addNode("Milano");
  adjacencyList.addNode("Pinerolo");
  adjacencyList.addNode("Genova");
  try{
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
  nonDirectedList.addNode("Torino");
  nonDirectedList.addNode("Milano");
  nonDirectedList.addNode("Pinerolo");
  nonDirectedList.addNode("Genova");
  try{
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
} 
@Test 
public void testgetWeightArcGeneric(){
  genericAdjacencyList.addNode(1); 
  genericAdjacencyList.addNode(2);
  genericAdjacencyList.addNode(3);
  genericAdjacencyList.addNode(4);
  try{
    genericAdjacencyList.addArc(1,2,"pera");
    genericAdjacencyList.addArc(1,4,"mela");
    genericAdjacencyList.addArc(3,4,"albicocca");
  }
  catch(AdjacencyListException error){
      assertTrue(error.toString(),false);
  }
  assertTrue("wrong weight",genericAdjacencyList.getWeightArc(1,2)=="pera");
  assertTrue("it find weight of inversed arc",genericAdjacencyList.getWeightArc(2,1)==null);
  assertTrue("wrong weight",genericAdjacencyList.getWeightArc(1,4)=="mela");
  assertTrue("wrong weight",genericAdjacencyList.getWeightArc(3,4)=="albicocca");
  assertTrue("it find weight of inversed arc",genericAdjacencyList.getWeightArc(4,3)==null);
  assertTrue("it find weight but weight not exist",genericAdjacencyList.getWeightArc(2,3)==null);
} 


@Test 
public void testKruskalNull(){
  try{
      kruskalInteger=new Kruskal<>(null);
      assertTrue("Kruskal is null",false);
  }
  catch(AdjacencyListException error){
      assertTrue(true);
  }
} 

  @Test 
  public void testKruskalEmptyGraph(){
    try{
        kruskalInteger=new Kruskal<>(nonDirectedIntegerList);
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  } 
  
    @Test 
    public void testKruskalEmptyGraphMinForest(){
      try{
          kruskalInteger=new Kruskal<>(nonDirectedIntegerList);
         
          assertTrue("The size of the minForest of empty graph is: " 
          +kruskalInteger.minSpanForest().getAllArcs().size(),
          kruskalInteger.minSpanForest().getAllArcs().size()==0);
      }
      catch(Exception error){
          assertTrue(error.toString(),false);
      }
    }


    @Test 
    public void testKruskalNormal(){
      nonDirectedList.addNode("Torino");
      nonDirectedList.addNode("Milano");
      nonDirectedList.addNode("Pinerolo");
      nonDirectedList.addNode("Genova");
      try{
        nonDirectedList.addArc("Torino","Milano",200);
        nonDirectedList.addArc("Pinerolo","Genova",50);
        nonDirectedList.addArc("Torino","Pinerolo",320);
        nonDirectedList.addArc("Genova","Torino",275);
        nonDirectedList.addArc("Milano","Genova",150);
      }
      catch(AdjacencyListException error){
          assertTrue(error.toString(),false);
      }
    try{
      Kruskal<String,Integer> kruskal=new Kruskal<>(nonDirectedList);
      nonDirectedList=kruskal.minSpanForest();
    }catch(Exception error){
      assertTrue(error.toString(),false);
    }
      ArrayList<FullArc<String,Integer>> arcs = nonDirectedList.getAllArcs();
      assertTrue("wrong num arc",arcs.size()==3);
      for (FullArc<String,Integer> arc : arcs) {
        if(arc.getWeight()==150) {
          assertTrue("wrong 1 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getFirstNode()  =="Milano" ||  arc.getFirstNode() == "Genova" );
          assertTrue("wrong 1 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getSecondNode()  =="Milano" ||  arc.getSecondNode() == "Genova" );
        }
        if(arc.getWeight()==200) {
          assertTrue("wrong 2 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getFirstNode()  =="Milano" ||  arc.getFirstNode() == "Torino" );
          assertTrue("wrong 2 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getSecondNode()  =="Milano" ||arc.getSecondNode() == "Torino");
        } 
        if(arc.getWeight()==50) {
          assertTrue("wrong 3 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getFirstNode()  =="Pinerolo" ||  arc.getFirstNode() == "Genova" );
          assertTrue("wrong 3 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getSecondNode()  =="Pinerolo" ||  arc.getSecondNode() == "Genova" );
        }
      }
    } 
    
    @Test 
    public void testKruskalNormalDisconnected(){
      nonDirectedList.addNode("Torino");
      nonDirectedList.addNode("Milano");
      nonDirectedList.addNode("Pinerolo");
      nonDirectedList.addNode("Genova");
      nonDirectedList.addNode("Aosta");
      try{
        nonDirectedList.addArc("Torino","Milano",200);
        nonDirectedList.addArc("Pinerolo","Genova",199);
        nonDirectedList.addArc("Aosta","Pinerolo",250);

        nonDirectedList.addArc("Aosta","Genova",350);
        nonDirectedList.addArc("Milano","Genova",444);
        nonDirectedList.addArc("Torino","Pinerolo",444);
        nonDirectedList.addArc("Milano","Pinerolo",444);
        nonDirectedList.addArc("Aosta","Milano",444);
      }
      catch(AdjacencyListException error){
          assertTrue(error.toString(),false);
      }
    try{
      Kruskal<String,Integer> kruskal=new Kruskal<>(nonDirectedList);
      nonDirectedList=kruskal.minSpanForest();
    }catch(Exception error){
      assertTrue(error.toString(),false);
    }
      ArrayList<FullArc<String,Integer>> arcs = nonDirectedList.getAllArcs();
      assertTrue("wrong num arc",arcs.size()==4);
      for (FullArc<String,Integer> arc : arcs) {
        if(arc.getWeight()==199) {
          assertTrue("wrong 1 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getFirstNode()  =="Pinerolo" ||  arc.getFirstNode() == "Genova" );
          assertTrue("wrong 1 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getSecondNode()  =="Pinerolo" ||  arc.getSecondNode() == "Genova" );
        }
        if(arc.getWeight()==200) {
          assertTrue("wrong 2 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getFirstNode()  =="Milano" ||  arc.getFirstNode() == "Torino" );
          assertTrue("wrong 2 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getSecondNode()  =="Milano" ||arc.getSecondNode() == "Torino");
        } 
        if(arc.getWeight()==250) {
          assertTrue("wrong 3 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getFirstNode()  =="Pinerolo" ||  arc.getFirstNode() == "Aosta" );
          assertTrue("wrong 3 arc "+arc.getFirstNode()+arc.getSecondNode(), 
          arc.getSecondNode()  =="Pinerolo" ||  arc.getSecondNode() == "Aosta" );
        }
      }
    }


}
