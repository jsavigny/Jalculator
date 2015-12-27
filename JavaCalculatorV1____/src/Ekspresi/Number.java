package Ekspresi;

public abstract class Number {
	protected static float val;

	public float getValue(){
		return val;
	}
	
	/*public void Tambah(Number N){
		this.val += N.val;
	}
	public void Kurang(Number N){
		this.val -= N.val;
	}
	public void Bagi(Number N){
		this.val /= N.val;
	}
	public void Kali(Number N){
		this.val *= N.val;
	}
	public void Div(Number N){
		int v = (int)this.val / (int)val;
		this.val = (float)v;
	}
	public void Mod(Number N){
		this.val = val%N.val;
	}*/
}