package CommandProcessor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RedoTest {
	@Test
	   public void test() {
	      Redo s = new Redo("Redo<3>");
	      s.ExecuteCmd();
	      assertEquals("Proses Redo 3",s.GetOutput());
	   }
}
