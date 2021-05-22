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
  private AdjacencyList<String,Integer> undiectList;


  @Before
  public void AdjacencyList(){
    this.adjacencyList = new AdjacencyList<String,Integer>(true);
    this.undiectList = new AdjacencyList<String,Integer>(false);

  } 

  @Test
  public void testAddingNodeDirect(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }
  @Test
  public void testAddingNodeUndirect(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }

  @Test
  public void testAddingArcDirect(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingArc("Torino","Milano",200);
        assertTrue(true);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
  }
  @Test
  public void testAddingArcUndirect(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingArc("Torino","Milano",200);
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
    assertFalse("The graf is direct",undiectList.isDirect());
  }

  @Test 
  public void testNodeExistDirect(){
    try{
        adjacencyList.addingNode("Torino");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the node",adjacencyList.nodeExist("Torino"));
  }  
  @Test 
  public void testNodeExistUndirect(){
    try{
        undiectList.addingNode("Torino");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the node",undiectList.nodeExist("Torino"));
  }

  @Test 
  public void tastArcExistDirect1(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingArc("Torino","Milano",200);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the arc",adjacencyList.ArcExist("Torino","Milano"));
  }
  @Test 
  public void tastArcExistUndirect1(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingArc("Torino","Milano",200);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("it don't find the arc",undiectList.ArcExist("Torino","Milano"));
  }
  @Test 
  public void tastArcExistDirect2(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("it find arc but it not exist",adjacencyList.ArcExist("Torino","Milano"));
  }
  @Test 
  public void tastArcExistUndirect2(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("it find arc but it not exist",undiectList.ArcExist("Torino","Milano"));
  }


  @Test 
  public void testNodeDeleteDirect(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    adjacencyList.nodeDelete("Torino");
    assertTrue(!adjacencyList.nodeExist("Torino") );
  } 
  @Test 
  public void testNodeDeleteUndirect(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    undiectList.nodeDelete("Torino");
    assertTrue(!undiectList.nodeExist("Torino") );
  }

 /*arc delete*/
  @Test 
  public void testArcDeleteDirect1(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingArc("Torino","Milano",200);
        adjacencyList.arcDelete("Torino","Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("The arc continues to exist",adjacencyList.ArcExist("Torino","Milano") );
  } 
  @Test 
  public void testArcDeleteUndirect1(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingArc("Torino","Milano",200);
        undiectList.arcDelete("Torino","Milano");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("The arc continues to exist",undiectList.ArcExist("Torino","Milano") );
  }


  @Test 
  public void testArcDeleteDirect2(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingNode("Genova");
        adjacencyList.addingNode("Pinerolo");
        adjacencyList.addingArc("Torino","Milano",200);
        adjacencyList.addingArc("Torino","Genova",275);
        adjacencyList.addingArc("Torino","Pinerolo",50);
        adjacencyList.arcDelete("Torino","Genova");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("The arc continues to exist",adjacencyList.ArcExist("Torino","Genova") );
    assertTrue("Another arc not more exist",adjacencyList.ArcExist("Torino","Pinerolo") );
  } 
  @Test 
  public void testArcDeleteUndirect2(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingNode("Genova");
        undiectList.addingNode("Pinerolo");
        undiectList.addingArc("Torino","Milano",200);
        undiectList.addingArc("Torino","Genova",275);
        undiectList.addingArc("Torino","Pinerolo",50);
        undiectList.arcDelete("Torino","Genova");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertFalse("The arc continues to exist",undiectList.ArcExist("Torino","Genova") );
    assertTrue("Another arc not more exist",undiectList.ArcExist("Torino","Pinerolo") );
  }


  /*Node number*/
  @Test 
  public void testNodeNumberDirect1(){
    assertTrue("node number wrong",adjacencyList.nodeNumber()==0);
  }
  @Test 
  public void testNodeNumberUndirect1(){
    assertTrue("node number wrong",undiectList.nodeNumber()==0);
  }
  @Test 
  public void testNodeNumberDirect2(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingNode("Genova");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("node number wrong",adjacencyList.nodeNumber()==3);
  }
  @Test 
  public void testNodeNumberUndirect2(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingNode("Genova");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("node number wrong",undiectList.nodeNumber()==3);
  } 
  
  
  /*Arc number*/
  @Test 
  public void testArcNumberDirect1(){
    assertTrue("arc number wrong",adjacencyList.arcNumber()==0);
  }
  @Test 
  public void testArcNumberUndirect1(){
    assertTrue("arc number wrong",undiectList.arcNumber()==0);
  }
  @Test 
  public void testArcNumberDirect2(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingNode("Genova");
        adjacencyList.addingNode("Pinerolo");
        adjacencyList.addingArc("Torino","Milano",200);
        adjacencyList.addingArc("Torino","Genova",275);
        adjacencyList.addingArc("Torino","Pinerolo",50);
        adjacencyList.addingArc("Genova","Milano",251);
        adjacencyList.addingArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("arc number wrong",adjacencyList.arcNumber()==5);
  }
  @Test 
  public void testArcNumberUndirect2(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingNode("Genova");
        undiectList.addingNode("Pinerolo");
        undiectList.addingArc("Torino","Milano",200);
        undiectList.addingArc("Torino","Genova",275);
        undiectList.addingArc("Torino","Pinerolo",50);
        undiectList.addingArc("Genova","Milano",251);
        undiectList.addingArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    assertTrue("arc number wrong",undiectList.arcNumber()==5);
  }
  

  /*get all node*/
  @Test 
  public void testGetNodeDirect(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingNode("Genova");
        adjacencyList.addingNode("Pinerolo");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<String> allNodes = adjacencyList.getAllNode();
    if(allNodes.indexOf("Torino")==-1 || allNodes.indexOf("Milano")==-1 || 
    allNodes.indexOf("Genova")==-1 || allNodes.indexOf("Pinerolo")==-1)
    assertTrue("Miss nodes in getAllNode",false);
    else assertTrue(true);
  }
  @Test 
  public void testGetNodeUndirect(){
    try{
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingNode("Genova");
        undiectList.addingNode("Pinerolo");
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<String> allNodes = undiectList.getAllNode();
    if(allNodes.indexOf("Torino")==-1 || allNodes.indexOf("Milano")==-1 || 
    allNodes.indexOf("Genova")==-1 || allNodes.indexOf("Pinerolo")==-1)
    assertTrue("Miss nodes in getAllNode",false);
    else assertTrue(true);
  }


  /*get all arc*/
  @Test 
  public void testGetArcDirect(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingNode("Genova");
        adjacencyList.addingNode("Pinerolo");
        adjacencyList.addingArc("Torino","Milano",200);
        adjacencyList.addingArc("Torino","Genova",275);
        adjacencyList.addingArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<FullArc<String,Integer>> allArc = adjacencyList.getAllArc();
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
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingNode("Genova");
        undiectList.addingNode("Pinerolo");
        undiectList.addingArc("Torino","Milano",200);
        undiectList.addingArc("Torino","Genova",275);
        undiectList.addingArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<FullArc<String,Integer>> allArc = undiectList.getAllArc();
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




  /*get Adjacent Node*/
  @Test 
  public void testGetAdjacentNodeDirect(){
    try{
        adjacencyList.addingNode("Torino");
        adjacencyList.addingNode("Milano");
        adjacencyList.addingNode("Genova");
        adjacencyList.addingNode("Pinerolo");
        adjacencyList.addingArc("Torino","Milano",200);
        adjacencyList.addingArc("Torino","Genova",275);
        adjacencyList.addingArc("Pinerolo","Genova",150);
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
        undiectList.addingNode("Torino");
        undiectList.addingNode("Milano");
        undiectList.addingNode("Genova");
        undiectList.addingNode("Pinerolo");
        undiectList.addingArc("Torino","Milano",200);
        undiectList.addingArc("Torino","Genova",275);
        undiectList.addingArc("Pinerolo","Genova",150);
    }
    catch(AdjacencyListException error){
        assertTrue(error.toString(),false);
    }
    ArrayList<String> adjacentNode = undiectList.getAdjacentNode("Torino");
    if(adjacentNode.indexOf("Milano")==-1 || adjacentNode.indexOf("Genova")==-1)  
    assertTrue("less adjacent Node",false);
    if(adjacentNode.size()!=2) {
        assertFalse("outpunt contain less node",adjacentNode.size()<0);
        assertFalse("outpunt contain more node",adjacentNode.size()>0);
    }   
  }

/*get WeightArc*/
@Test 
public void testgetWeightArcDirect(){
  try{
      adjacencyList.addingNode("Torino");
      adjacencyList.addingNode("Milano");
      adjacencyList.addingNode("Pinerolo");
      adjacencyList.addingNode("Genova");
      adjacencyList.addingArc("Torino","Milano",200);
      adjacencyList.addingArc("Torino","Genova",275);
      adjacencyList.addingArc("Pinerolo","Genova",150);
  }
  catch(AdjacencyListException error){
      assertTrue(error.toString(),false);
  }
  assertTrue("wrang weight",adjacencyList.getWeightArc("Torino","Milano")==200);
  assertTrue("it find weight of inversed arc",adjacencyList.getWeightArc("Milano","Torino")==null);
  assertTrue("wrang weight",adjacencyList.getWeightArc("Torino","Genova")==275);
  assertTrue("wrang weight",adjacencyList.getWeightArc("Pinerolo","Genova")==150);
  assertTrue("it find weight of inversed arc",adjacencyList.getWeightArc("Genova","Pinerolo")==null);
  assertTrue("it find weight but weight not exist",adjacencyList.getWeightArc("Milano","Pinerolo")==null);
} 
@Test 
public void testgetWeightArcUndirect(){
  try{
    undiectList.addingNode("Torino");
    undiectList.addingNode("Milano");
    undiectList.addingNode("Pinerolo");
    undiectList.addingNode("Genova");
    undiectList.addingArc("Torino","Milano",200);
    undiectList.addingArc("Torino","Genova",275);
    undiectList.addingArc("Pinerolo","Genova",150);
  }
  catch(AdjacencyListException error){
      assertTrue(error.toString(),false);
  }
  assertTrue("wrang weight",undiectList.getWeightArc("Torino","Milano")==200);
  assertTrue("it can't find weight of inversed arc",undiectList.getWeightArc("Milano","Torino")==200);
  assertTrue("wrang weight",undiectList.getWeightArc("Torino","Genova")==275);
  assertTrue("wrang weight",undiectList.getWeightArc("Pinerolo","Genova")==150);
  assertTrue("it acn't find weight of inversed arc",undiectList.getWeightArc("Genova","Pinerolo")==150);
  assertTrue("it find weight but weight not exist",undiectList.getWeightArc("Milano","Pinerolo")==null);
} 













}
