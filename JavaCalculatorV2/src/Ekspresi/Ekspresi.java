/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ekspresi;
import java.util.*;
        
/**
 * 
 * @author Julio
 */
public class Ekspresi {
	private final String input;
    private int size;
    private float value;
    private boolean bValue;
    private boolean isLogika;
    private boolean allRomawi;
    
    /**
     * Kelas Ekspresi, memiliki responsibility untuk mengolah suatu ekspresi inputan menjadi hasil perhitungan
     * @param S merupakan String Inputan
     */
    public Ekspresi(String S){
        input = S;
    }

    /**
     * Method untuk menentukan apakah suatu String merupakan angka arab atau bukan
     * @param S merupakan String
     * @return true jika string S merupakan angka Arab, false jika bukan
     */
    public boolean isNumArab(String S){
		boolean b = true;
    	int i=0;
    	if((S.charAt(0)=='-') || (S.charAt(0)=='+')){
    		if(S.length() > 1){
    			i++;
    		}
    	}
    	while(b && (i<S.length())){
    		boolean dotFound = false;
    		if(!(((S.charAt(i))=='1')||((S.charAt(i))=='2')||((S.charAt(i))=='3')||((S.charAt(i))=='4')||((S.charAt(i))=='5')||
                    ((S.charAt(i))=='6')||((S.charAt(i))=='7')||((S.charAt(i))=='8')||((S.charAt(i))=='9')||((S.charAt(i))=='0')||((S.charAt(i))=='.') && (!dotFound))){
    			b = false;
    		}
    		i++;
    	}
    	//System.out.println("z = " + S);
    	return b;
    	
    }
	
    /**
     * Method untuk menentukan apakah suatu String merupakan angka romawi atau bukan
     * @param S adalah String
     * @return true jika string S merupakan angka Romawi, false jika bukan
     */
    public boolean isNumRom(String S){
		boolean b=true;
		int i = 0;
		while(i < S.length()){
			if((Character.toLowerCase(S.charAt(i)) != 'i') && (Character.toLowerCase(S.charAt(i)) != 'v') && (Character.toLowerCase(S.charAt(i)) != 'x')
					&& (Character.toLowerCase(S.charAt(i)) != 'c') && (Character.toLowerCase(S.charAt(i)) != 'l')
					&& (Character.toLowerCase(S.charAt(i)) != 'd') && (Character.toLowerCase(S.charAt(i)) != 'm')){
					b = false;
					break;
				}
			i++;
		}
		return b;
	}
	
    /**
     * Method untuk menentukan apakah suatu String merupakan operan logika ('true' atau 'false')
     * @param S adalah String
     * @return true jika string S merupakan operan logika, false jika bukan
     */
    public boolean isLogical(String S){
        return ((S.equals("true"))||(S.equals("false")));
    }

    /**
     * Method untuk menentukan apakah suatu String merupakan operator
     * @param S adalah String
     * @return true jika string S merupakan operator, false jika bukan
     */
    public boolean isOperator(String S){
        return ((S.equals("+"))||(S.equals("-"))||(S.equals("*"))||(S.equals("/"))||(S.equals("mod"))||
                (S.equals("and"))||(S.equals("or"))||(S.equals("not"))||
                (S.equals("<"))||(S.equals("<="))||(S.equals("="))||(S.equals(">="))||(S.equals(">"))||(S.equals("div"))||
                (S.equals("<>")));
    }
    
    /**
     * Method untuk menghitung Ekspresi Postfix 
     * @param calcStack merupakan Stack of String, stack untuk melakukan perhitungan
     * @param tokens merupakan Array(Vector) of String, berisi token-token ekspresi yang akan dihitung
     */
    public void CalculatePostfix(Stack<String> calcStack, Vector<String> tokens){
    	allRomawi = true;
    	for (int i=0; i<tokens.size();i++){
            //System.out.println(tokens.get(i)); 
            if (isNumArab(tokens.get(i))||isNumRom(tokens.get(i))||isLogical(tokens.get(i))){
            	String token = tokens.get(i);
            	if(token.charAt(0) == '+'){
            		StringBuilder str = new StringBuilder(tokens.get(i));
            	    str.deleteCharAt(0);
            	    token = str.toString();
            	}
            	if (isNumArab(token)){
            		allRomawi = false;
            		Arab arab = new Arab(token);
            		token = String.valueOf(arab.getValue());
            	} else if (isNumRom(token)){
            		Romawi romawi = new Romawi(token);
            		token = String.valueOf(romawi.getValue());
            	}
            	calcStack.push(token);
            } else if (isOperator(tokens.get(i))){
                if (isNumArab(calcStack.peek())){
                    float b = Float.parseFloat(calcStack.pop());
                    float a = Float.parseFloat(calcStack.pop());
                    if (tokens.get(i).equals("+")){
                        value=a+b; 
                    } else if (tokens.get(i).equals("-")){
                        value= a-b;
                    } else if (tokens.get(i).equals("*")){
                        value= a*b;
                    } else if (tokens.get(i).equals("/")){
                        value= a/b;
                    } else if (tokens.get(i).equals("div")){
                    	int val = (int)a/(int)b;
                        value= (float)val;
                    } else if (tokens.get(i).equals("mod")){
                        value= a%b;
                    } else if (tokens.get(i).equals(">")){
                        bValue= a > b;
                        isLogika=true;
                    } else if (tokens.get(i).equals(">=")){
                        bValue= a <= b;
                        isLogika=true;
                    } else if (tokens.get(i).equals("=")){
                        bValue= a == b;
                        isLogika=true;
                    } else if (tokens.get(i).equals("<")){
                        bValue= a < b;
                        isLogika=true;
                    } else if (tokens.get(i).equals("<=")){
                        bValue= a <= b;
                        isLogika=true;
                    } else if (tokens.get(i).equals("<>")){
                        bValue= a != b;
                        isLogika=true;
                    }
					float tVal = value;
                    if(isLogika){
						if(bValue){
							calcStack.push("true");
						} else {
							calcStack.push("false");
						}
					} else {
						calcStack.push(String.valueOf(tVal));
					}
                } else if (tokens.get(i).equals("not")){
                    boolean b = Boolean.valueOf(calcStack.pop());
                    bValue= !b;
                    isLogika=true;
                    if(bValue){
						calcStack.push("true");
					} else {
						calcStack.push("false");
					}
                } else {
                    boolean b = Boolean.valueOf(calcStack.pop());
                    boolean a = Boolean.valueOf(calcStack.pop());
                    if (tokens.get(i).equals("and")){
                        bValue=a&&b;
                        isLogika=true;
                        if(bValue){
							calcStack.push("true");
						} else {
							calcStack.push("false");
						}
                    } else if (tokens.get(i).equals("or")){
                        bValue= a||b;
                        isLogika=true;
                        if(bValue){
							calcStack.push("true");
						} else {
							calcStack.push("false");
						}
                    }  else if (tokens.get(i).equals("xor")){
                        bValue= a^b;
                        isLogika=true;
                        if(bValue){
							calcStack.push("true");
						} else {
							calcStack.push("false");
						}
                    } 
                } 
            }
        }
    }
    
    /**
     * Method untuk menghitung Ekspresi Prefix yang sudah di convert menjadi postfix
     * @param calcStack merupakan Stack of String, stack untuk melakukan perhitungan
     * @param tokens merupakan Array(Vector) of String, berisi token-token ekspresi yang akan dihitung
     */
    public void CalculatePrefix(Stack<String> calcStack, Vector<String> tokens){
    	allRomawi = true;
    	for (int i=0; i<tokens.size();i++){
            //System.out.println(tokens.get(i)); 
            if (isNumArab(tokens.get(i))||isNumRom(tokens.get(i))||isLogical(tokens.get(i))){
            	String token = tokens.get(i);
            	if(token.charAt(0) == '+'){
            		StringBuilder str = new StringBuilder(tokens.get(i));
            	    str.deleteCharAt(0);
            	    token = str.toString();
            	}
            	if (isNumArab(token)){
            		allRomawi = false;
            		Arab arab = new Arab(token);
            		token = String.valueOf(arab.getValue());
            	} else if (isNumRom(token)){
            		Romawi romawi = new Romawi(token);
            		token = String.valueOf(romawi.getValue());
            	}
            	calcStack.push(token);
            } else if (isOperator(tokens.get(i))){
                if (isNumArab(calcStack.peek())){
                    float b = Float.parseFloat(calcStack.pop());
                    float a = Float.parseFloat(calcStack.pop());
                    if (tokens.get(i).equals("+")){
                        value=a+b; 
                    } else if (tokens.get(i).equals("-")){
                        value= -(a-b);
                    } else if (tokens.get(i).equals("*")){
                        value= a*b;
                    } else if (tokens.get(i).equals("/")){
                        value= b/a;
                    } else if (tokens.get(i).equals("div")){
                    	int val = (int)a/(int)b;
                        value= (float)val;
                    } else if (tokens.get(i).equals("mod")){
                        value= b%a;
                    } else if (tokens.get(i).equals(">")){
                        bValue= b > a;
                        isLogika=true;
                    } else if (tokens.get(i).equals(">=")){
                        bValue= b <= a;
                        isLogika=true;
                    } else if (tokens.get(i).equals("=")){
                        bValue= a == b;
                        isLogika=true;
                    } else if (tokens.get(i).equals("<")){
                        bValue= b < a;
                        isLogika=true;
                    } else if (tokens.get(i).equals("<=")){
                        bValue= b <= a;
                        isLogika=true;
                    } else if (tokens.get(i).equals("<>")){
                        bValue= a != b;
                        isLogika=true;
                    }
					float tVal = value;
                    if(isLogika){
						if(bValue){
							calcStack.push("true");
						} else {
							calcStack.push("false");
						}
					} else {
						calcStack.push(String.valueOf(tVal));
					}
                } else if (tokens.get(i).equals("not")){
                    boolean b = Boolean.valueOf(calcStack.pop());
                    bValue= !b;
                    isLogika=true;
                    if(bValue){
						calcStack.push("true");
					} else {
						calcStack.push("false");
					}
                } else {
                    boolean b = Boolean.valueOf(calcStack.pop());
                    boolean a = Boolean.valueOf(calcStack.pop());
                    if (tokens.get(i).equals("and")){
                        bValue=a&&b;
                        isLogika=true;
                        if(bValue){
							calcStack.push("true");
						} else {
							calcStack.push("false");
						}
                    } else if (tokens.get(i).equals("or")){
                        bValue= a||b;
                        isLogika=true;
                        if(bValue){
							calcStack.push("true");
						} else {
							calcStack.push("false");
						}
                    }  else if (tokens.get(i).equals("xor")){
                        bValue= a^b;
                        isLogika=true;
                        if(bValue){
							calcStack.push("true");
						} else {
							calcStack.push("false");
						}
                    } 
                } 
            }
        }
    }
    
    /**
     * Method untuk mengeksekusi ekspresi yang diberikan menjadi hasil perhitungan
     */
    public void Execute(){
        isLogika=false;
        Vector<String> tokens;
        Stack<String> calcStack = new Stack<>();
        String input2;
        input2 = input.replaceAll("\\(","\\ ( ");
        input2 = input2.replaceAll("\\)","\\ ) ");
        input2 = input2.trim().replaceAll(" +", " ");
        //String [] Atokens = input2.split("(?<=[^\\.a-zA-Z\\d])|(?=[^\\.a-zA-Z\\d])");
        String [] Atokens = input2.split(" ");
        Vector<String> toktemp = new Vector<>(Arrays.asList(Atokens));
        tokens = new Vector<>();
        for (int i=0; i<toktemp.size();i++){
            if (!toktemp.get(i).equals(" ")){
                tokens.add(toktemp.get(i));
            }
        }
        if (isOperator(tokens.get(0))){ //Prefix
            //System.out.println("Prefix");
        	Collections.reverse(tokens);
        	CalculatePrefix(calcStack, tokens);
        } else if (isNumArab(tokens.get(0))||isNumRom(tokens.get(0))||isLogical(tokens.get(0))){ //Postfix
            //System.out.println("Postfix");
            CalculatePostfix(calcStack, tokens);
        } else { //Infix
            //System.out.println("Infix");
            Stack<String> opStack = new Stack<>();
            Vector<String> postTokens = new Vector<>();
            String temp = new String();
            //int pIndex=0;
            for (int i=0; i<tokens.size();i++){ //Convert ke Postfix
                if (isNumArab(tokens.get(i))||isNumRom(tokens.get(i))||isLogical(tokens.get(i))){
                    postTokens.add(tokens.get(i));
                } else {
                    if (opStack.empty()||opStack.peek().equals("(")){
                        opStack.push(tokens.get(i));
                    } else if (tokens.get(i).equals("(")){
                        opStack.push(tokens.get(i));
                    } else if (tokens.get(i).equals(")")){
                        while (!opStack.peek().equals("(")){
                            temp= opStack.pop();
                            postTokens.add(temp);
                        }
                        opStack.pop();
                    } else {
                        opStack.push(tokens.get(i));
                    }
                }
            }
            tokens = null;
            tokens = postTokens;
            CalculatePostfix(calcStack, tokens);
        }
        if (isLogika){
            if (bValue) {
                value=1;
            } else if (!bValue) {
                value=0;
            }
        } else {
            value=Float.parseFloat(calcStack.pop());
        }
    }
    
    /**
     * Method untuk mendapatkan value (hasil) dari perhitungan
     * @return value
     */
    public String getValue(){
    	if (isLogika){
            if (bValue){
                return "true";
            } else {
            	return "false";
            }
        } else {
        	String s;
        	if(allRomawi){
        		s = Romawi.GetRom(value);
        	} else {
	        	s = String.format("%.2f",value);
        	}
        	return s;
        }
    }

    /**
     * Method untuk menampilkan value(hasil) dari perhitungan
     */
    public void printValue(){
        System.out.println(getValue());
    }

    /**
     * Method untuk menampilkan ekspresi + hasilnya
     * @return String ekspresi + value;
     */
    public String getFullEkspesi(){
    	
    	return input + " = " + getValue();
    }
}

