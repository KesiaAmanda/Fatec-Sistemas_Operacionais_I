package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controle {
	public Controle() {
		super();
	}
	
	public String Sistema() {
		return System.getProperty("os.name");
	}
	
	public void leProcessos (String sist) {
		String comando = "";
		if (sist.contains("Windows")) {
			comando = "TASKLIST /FO TABLE";
		}if(sist.contains("Linux")) {
			comando = "ps -e";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha!=null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			fluxo.close();
			leitor.close();
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void killpid (String so, int pid) {
		StringBuffer buffer = new StringBuffer();
		if (so.contains("Windows")) {
			buffer.append("TASKKILL /PID " + pid);
		}if(so.contains("Linux")) {
			buffer.append("kill " + pid);
		}
		
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void killim (String so, String nome) {
		StringBuffer buffer = new StringBuffer();
		if(so.contains("Windows")) {
			buffer.append("TASKKILL /IM "+nome);
		}if(so.contains("Linux")) {
			buffer.append("killall "+nome);
		}
		
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
