package Controller;

public class ThreadSeq extends Thread {
	private int n;
	
	public ThreadSeq(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		sequencia();
	}
	
	private void sequencia() {
		double um = -1;
		double res = 0;
		for(double i= 1 ; i <= n ; i++) {
			if(i%2!=0) {
				um*=-1;
				res+=(um/i);
			}
		}
		res=4*res;
		System.out.println(n + " " + res);
	}
}
