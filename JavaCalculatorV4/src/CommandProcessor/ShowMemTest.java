package CommandProcessor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShowMemTest {
	@Test
	   public void test() {
	      ShowMem s = new ShowMem("ShowMem<5>");
	      s.ExecuteCmd();
	      assertEquals("Proses ShowMem 5",s.GetOutput());
	   }
}
