package CommandProcessor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShowAllTest {
	@Test
	   public void test() {
	      ShowAll s = new ShowAll("Show All");
	      s.ExecuteCmd();
	      assertEquals("Proses Show All",s.GetOutput());
	   }
}
