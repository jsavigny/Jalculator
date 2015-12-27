package Ekspresi;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

public class ArabTest {
    @SuppressWarnings("deprecation")
	@Test
    public void testMain() throws IOException {
    	ByteArrayOutputStream baos;
    	Arab a;
    	String result;
    	String s;
    	String s2;
    	String[] linesOfOutput;

        a = new Arab("10");
        s = String.format("%.2f",10.00);
        s2 = String.format("%.2f",a.getValue());
        assertEquals(s,s2);
        
        
    }
}