package controller;

import java.util.concurrent.Semaphore;

public class ThreadTrack extends Thread{
	private Semaphore semaphore, limCar;
	private int car, team;
	private static int ranking[][] = new int[2][14];
	private static int cont;
	
	public ThreadTrack(Semaphore semaphore, Semaphore limCar, int car, int team) {
		this.semaphore = semaphore;
		this.limCar = limCar;
		this.car = car;
		this.team = team;
	}

	@Override
	public void run() {
		try {
			limCar.acquire();
			semaphore.acquire();
			running();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Team#"+team+" Car #"+car+" got off track");
			semaphore.release();
			limCar.release();
		}
		if(cont==13) {
			ShowRanking();
		}else {
			cont++;
		}
	}
	
	public void running() {
		System.out.println("Team#"+team+" Car #"+car+" got on track");
		for(int i=0;i<3;i++) {
			int time = (int)(Math.random()*4000)+1000;
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println("Team#"+team+" Car #"+car+" Lap#"+(i+1)+" Time: "+time+"ms");
				if (i==0||(ranking[car][team]>time)) {
					ranking[car][team]=time;
				}
			}
		}
	}
	
	public void ShowRanking() {
		int rank[][] = new int[3][14];

		for(int c=0;c<7;c++) {
			rank[0][c]=c;
			rank[1][c]=1;
			rank[2][c]=ranking[0][c];
			rank[0][c+7]=c;
			rank[1][c+7]=2;
			rank[2][c+7]=ranking[1][c];
		}
		
		for(int i=0;i<13;i++) {
			for(int c=i;c<14;c++) {
				if(rank[2][i]>rank[2][c]) {
					int aux1=rank[0][i];
					int aux2=rank[1][i];
					int aux3=rank[2][i];
					rank[0][i]=rank[0][c];
					rank[1][i]=rank[1][c];
					rank[2][i]=rank[2][c];
					rank[0][c]=aux1;
					rank[1][c]=aux2;
					rank[2][c]=aux3;
				}
			}
		}
		
		for(int i=0;i<14;i++) {
			System.out.println("Team #"+rank[0][i]+" Car #"+ rank[1][i]+" shortest lap time:"+rank[2][i]+"ms");
		}
	}
}
