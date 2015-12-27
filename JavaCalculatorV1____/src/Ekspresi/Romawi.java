package Ekspresi;

public class Romawi extends Number{
	public Romawi(String s){
		String s_asli = s;
		if((s.charAt(0) == '+') || (s.charAt(0) == '-')){
    		StringBuilder str = new StringBuilder(s);
    	    str.deleteCharAt(0);
    	    s = str.toString();
		}
		val=0;
	    if (s.charAt(0)!='-'){
	        int LEN=s.length();
	        for (int i = 0; i < LEN; i++){
	            if (Character.toUpperCase(s.charAt(i)) == 'I' && i != LEN-1){
	                if      (Character.toUpperCase(s.charAt(i+1)) == 'V') { val +=    4; ++i; }
	                else if (Character.toUpperCase(s.charAt(i+1)) == 'X') { val +=    9; ++i; }
	                else                    { val +=    1;      }
	            }
	            else if (Character.toUpperCase(s.charAt(i)) == 'X' && i != LEN-1){
	                if      (Character.toUpperCase(s.charAt(i+1)) == 'L') { val +=   40; ++i; }
	                else if (Character.toUpperCase(s.charAt(i+1)) == 'C') { val +=   90; ++i; }
	                else                    { val +=   10;      }
	            }
	            else if (Character.toUpperCase(s.charAt(i)) == 'C' && i != LEN-1){
	                if      (Character.toUpperCase(s.charAt(i+1)) == 'D') { val +=  400; ++i; }
	                else if (Character.toUpperCase(s.charAt(i+1)) == 'M') { val +=  900; ++i; }
	                else                    { val +=  100;      }
	            }
	              else if (Character.toUpperCase(s.charAt(i)) == 'I')      { val +=    1; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'V')      { val +=    5; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'X')      { val +=   10; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'L')      { val +=   50; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'C')      { val +=  100; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'D')      { val +=  500; }
	              else if (Character.toUpperCase(Character.toUpperCase(s.charAt(i))) == 'M')      { val += 1000; }
	        }
	    } else {
	        int LEN=s.length();
	        for (int i = 1; i < LEN; i++){
	            if (Character.toUpperCase(s.charAt(i)) == 'I' && i != LEN-1){
	                if      (s.charAt(i+1) == 'V') { val +=    4; ++i; }
	                else if (s.charAt(i+1) == 'X') { val +=    9; ++i; }
	                else                    { val +=    1;      }
	            }
	            else if (Character.toUpperCase(s.charAt(i)) == 'X' && i != LEN-1){
	                if      (s.charAt(i+1) == 'L') { val +=   40; ++i; }
	                else if (s.charAt(i+1) == 'C') { val +=   90; ++i; }
	                else                    { val +=   10;      }
	            }
	            else if (Character.toUpperCase(s.charAt(i)) == 'C' && i != LEN-1){
	                if      (s.charAt(i+1) == 'D') { val +=  400; ++i; }
	                else if (s.charAt(i+1) == 'M') { val +=  900; ++i; }
	                else                    { val +=  100;      }
	            }
	              else if (Character.toUpperCase(s.charAt(i)) == 'I')      { val +=    1; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'V')      { val +=    5; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'X')      { val +=   10; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'L')      { val +=   50; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'C')      { val +=  100; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'D')      { val +=  500; }
	              else if (Character.toUpperCase(s.charAt(i)) == 'M')      { val += 1000; }
	        }
	    }
	    if(s_asli.charAt(0) == '-'){
	    	val = -val;
	    }
	}
	
	
	public static String GetRom(float val){
		class romandata_t{
			romandata_t(int val, String numeral){
				this.val = val;
				this.numeral = numeral;
			}
			 int val;
			 String numeral;
		}
		String result="";
		int valInt = (int)val;
		if(valInt<0){
			result+="-";
			valInt = -valInt;
		}
		romandata_t[] romandata = new romandata_t[15];
		romandata[0] = new  romandata_t(1000,"M");
		romandata[1] = new  romandata_t(900, "CM");
		romandata[2] = new  romandata_t(500, "D");
		romandata[3] = new  romandata_t(400, "CD");
		romandata[4] = new  romandata_t(100, "C");
		romandata[5] = new  romandata_t(90, "XC");
		romandata[6] = new  romandata_t(50, "L");
		romandata[7] = new  romandata_t(40, "XL");
		romandata[8] = new  romandata_t(10, "X");
		romandata[9] = new  romandata_t(9, "IX");
		romandata[10] = new  romandata_t(5, "V");
		romandata[11] = new  romandata_t(4, "IV");
		romandata[12] = new  romandata_t(1, "I");
		romandata[13] = new  romandata_t(0, null);

		  int i=0;
		  while(valInt>0){
			  if(valInt>=romandata[i].val){
				  result += romandata[i].numeral;
				  valInt -= romandata[i].val;
			  } else {
				  i++;
			  }
		  }
		  return result;
		}
	
}
