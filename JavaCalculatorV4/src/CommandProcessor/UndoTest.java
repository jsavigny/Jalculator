package CommandProcessor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UndoTest {
	@Test
	   public void test() {
	      Undo s = new Undo("Undo<3>");
	      s.ExecuteCmd();
	      assertEquals("Proses Undo 3",s.GetOutput());
	   }
}
