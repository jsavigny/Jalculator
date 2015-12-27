package Ekspresi;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class EkspresiTest {
    @Test
    public void testMain() throws IOException {
    	ByteArrayOutputStream baos;
    	 Ekspresi Eks;
    	String output;
    	String result;
    	String s;
    	String[] linesOfOutput;
    	
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("+ 5 3 ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("%.2f",8.00);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("(3 * 6) ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("%.2f",18.00);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("3 6 * ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("%.2f",18.00);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("and true false ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("false",linesOfOutput[0]);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("(true and false) ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("false",linesOfOutput[0]);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("true false and ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("false",linesOfOutput[0]);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("(true and false) ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("false",linesOfOutput[0]);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("< 3 5");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("true",linesOfOutput[0]);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("(3 < 4) ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("true",linesOfOutput[0]);
        assertEquals(s,linesOfOutput[0]);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Eks = new Ekspresi("3 4 > ");
        Eks.Execute();
        //Eks.printValue();
        result = Eks.getValue();
        System.out.println(result);
        baos.flush();
        output = new String(baos.toByteArray());
        linesOfOutput = output.split(//
                System.getProperty("line.separator"));
        s = String.format("false",linesOfOutput[0]);
        assertEquals(s,linesOfOutput[0]);
        
    }
}