package unionfind;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Laurentiu, Enrico
 */
public class UnionFindTests {
  private UnionFind<Integer> unionFindInteger;
  private UnionFind<String> unionFindString;

  @Before
  public void createUnionFind(){
    this.unionFindInteger = new UnionFind<Integer>();
    this.unionFindString = new UnionFind<String>();
  }
/*test creazione set*/ 
  @Test
  public void testCreateNull(){
    try{
        unionFindInteger.createSet(null);
        assertTrue(null, false);
    }
    catch(UnionFindException e){
        assertTrue(null, true);
    }
  }

  @Test
  public void testCreateDouble(){
    try{
      unionFindString.createSet("null");
      unionFindString.createSet("null");
      assertEquals(unionFindString.find("null"),"null");
  }
  catch(UnionFindException e){
      assertTrue(null, false);
  }
  }
 
  @Test
  public void testCreateTwoDistinct(){
    try{
      unionFindString.createSet("ciao");
      unionFindString.createSet("cia");
      assertFalse(unionFindString.find("ciao").equals(unionFindString.find("cia")));
  }
  catch(UnionFindException e){
      assertTrue(null, false);
  }
  }

/*test find set */
@Test
public void testFindNull(){
    assertEquals(unionFindInteger.find(null),null);
}
@Test
public void testFindNotInSet(){
    assertEquals(unionFindString.find("parola"),null);
}
/*test union sets */
@Test
public void testUnionBouthNull(){
  try{
    unionFindString.union(null,null);
    assertTrue(null, false);
}
catch(UnionFindException e){
    assertTrue(null, true);
}}
@Test
public void testUnionSxNull(){
  try{
    unionFindInteger.createSet(1);
    unionFindInteger.union(1, null);
    assertTrue(null, false);
}
catch(UnionFindException e){
    assertTrue(null, true);
}}
@Test
public void testUnionDxNull(){
  try{
    unionFindString.createSet("msm");
    unionFindString.union(null,"msm");
    assertTrue(null, false);
}
catch(UnionFindException e){
    assertTrue(null, true);
}}

@Test
public void testUnionSxNotInSet(){
  try{
    unionFindInteger.createSet(12);
    unionFindInteger.union(1, 12);
    assertTrue(null, false);
}
catch(UnionFindException e){
    assertTrue(null, true);
}}
@Test
public void testUnionDxNotInSet(){
  try{
    unionFindInteger.createSet(-321);
    unionFindInteger.union(-321, 321);
    assertTrue(null, false);
}
catch(UnionFindException e){
    assertTrue(null, true);
}}

@Test
public void testUnionBouthNotInSet(){
  try{
    unionFindString.union("union", "find");
    assertTrue(null, false);
}
catch(UnionFindException e){
    assertTrue(null, true);
}}

@Test
public void testUnionWithSelfNotInSet(){
  try{
    unionFindInteger.union(1211, 1211);
    assertEquals((int)unionFindInteger.find(1211),1211);
}
catch(UnionFindException e){
    assertTrue(null, true);
}}

@Test
public void testUnionWithSelfPresent(){
  try{
    unionFindInteger.createSet(11);
    unionFindInteger.union(11, 11);
    assertEquals((int)unionFindInteger.find(11),11);
}catch(UnionFindException e){
  assertTrue(null, false);
}}
@Test
public void testUnionWithDifferentSet(){
  try{
    unionFindString.createSet("heyya");
    unionFindString.createSet("Oooo");
    unionFindString.union("heyya", "Oooo");
    assertEquals(unionFindString.find("heyya"),unionFindString.find("Oooo"));
}catch(UnionFindException e){
  assertTrue(null, false);
}}

@Test
public void testUnionWithSameSet(){
  try{
    unionFindString.createSet("241");
    unionFindString.createSet("sort");
    unionFindString.union("241", "sort");
    unionFindString.union("241", "sort");
    assertEquals(unionFindString.find("241"),unionFindString.find("sort"));
}
catch(UnionFindException e){
    assertTrue(null, false);
}}

@Test
public void testUnionSetsMoreThenOneElem(){
  try{
    unionFindString.createSet("65");
    unionFindString.createSet("21");
    unionFindString.createSet("90");
    unionFindString.createSet("40");
    unionFindString.union("65", "21");
    unionFindString.union("90", "40");
    unionFindString.union("65", "90");
    assertEquals(unionFindString.find("21"),unionFindString.find("40"));
}
catch(UnionFindException e){
    assertTrue(null, false);
}}

@Test
public void testUnionWithRank(){
  try{
    Integer expectedHead;
    unionFindInteger.createSet(65);
    unionFindInteger.createSet(21);
    unionFindInteger.createSet(90);
    unionFindInteger.createSet(40);
    unionFindInteger.createSet(-21);
    unionFindInteger.createSet(-100);
    unionFindInteger.union(65, 21);
    unionFindInteger.union(90, 40);
    unionFindInteger.union(65, 90);
    expectedHead=unionFindInteger.find(90);
    unionFindInteger.union(-21, -100);
    unionFindInteger.union(65, -100);
    assertEquals(expectedHead,unionFindInteger.find(-100));
}
catch(UnionFindException e){
    assertTrue(null, false);
}}


}