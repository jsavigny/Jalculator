package CommandProcessor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SaveTest {
	@Test
	   public void test() {
	      Save s = new Save("Save");
	      s.ExecuteCmd();
	      assertEquals("Proses Save",s.GetOutput());
	   }
}
