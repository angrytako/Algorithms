package unionfind;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Laurentiu, Enrico
 */
public class UnionFind_TestRunner {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(UnionFindTests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  
    System.out.println(result.wasSuccessful());
    
  }
  
}
