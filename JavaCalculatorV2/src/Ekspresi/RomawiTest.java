package Ekspresi;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

public class RomawiTest {
    @SuppressWarnings("deprecation")
	@Test
    public void testMain() throws IOException {
    	ByteArrayOutputStream baos;
    	Romawi r;
    	String result;
    	String s;
    	String s2;
    	String[] linesOfOutput;

        r = new Romawi("MCMXLV");
        s = String.format("%.2f",1945.00);
        s2 = String.format("%.2f",r.getValue());
        assertEquals(s,s2);
        
        
    }
}