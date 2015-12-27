package CommandProcessor;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class CommandTest {
    @Test
    public void testMain() throws IOException {
    	ByteArrayOutputStream baos;
    	Command Cmd;
    	String output;
    	String[] linesOfOutput;
    	
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Cmd = new Command("Save");
        Cmd.Execute();
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        assertEquals("Proses Save",linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Cmd = new Command("Show All");
        Cmd.Execute();
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        assertEquals("Proses Show All",linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Cmd = new Command("ShowMem<2>");
        Cmd.Execute();
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        assertEquals("Proses ShowMem 2",linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Cmd = new Command("Undo<2>");
        Cmd.Execute();
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        assertEquals("Proses Undo 2",linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Cmd = new Command("Redo<2>");
        Cmd.Execute();
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        assertEquals("Proses Redo 2",linesOfOutput[0]);
    }

}