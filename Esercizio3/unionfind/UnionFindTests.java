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
  private UnionFind<Integer> unionFind;

  @Before
  public void createUnionFind(){
    this.unionFind = new UnionFind<Integer>();
  }

  @Test
  public void testCreateNull(){
    try{
        unionFind.createSet(null);
        assertTrue(null, false);
    }
    catch(UnionFindException e){
        assertTrue(null, true);
    }
  }

  @Test
  public void testCreate(){

  }
 

}
