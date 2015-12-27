package Ekspresi;

public class Arab extends Number {
	public Arab(String s){
		if(s.charAt(0) == '+'){
    		StringBuilder str = new StringBuilder(s);
    	    str.deleteCharAt(0);
    	    val = Float.parseFloat(str.toString());
		} else {
    		val = Float.parseFloat(s);
    	}
	}
}
