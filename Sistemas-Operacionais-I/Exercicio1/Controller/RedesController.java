package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String ip(String os) {
		String adaptadores = "", comando = "", adap = "", nameip = "";
		if (os.contains("Windows")) {
			comando = "ipconfig";
			adap = "Adapt";
			nameip = "IPv4";
			
		}
		if(os.contains("Linux")){
			comando = "ifconfig";
			adap = "flags";
			nameip = "inet ";
		}
			try {
				Process p = Runtime.getRuntime().exec(comando);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				String mem[] = null;
				
				while(linha!=null) {
					if(linha.contains(adap)) {
						mem = linha.split(":");
					}
					if(linha.contains(nameip)) {
						if (os.contains("Linux")) {
							adaptadores+= mem[0] + "\n";
							mem = linha.split("netmask");
							adaptadores+= mem[0] + "\n";
						}if(os.contains("Windows")) {
							adaptadores+= mem[0] + "\n" + linha + "\n";
						}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		return adaptadores;
	}
	
	public void ping (String os) {
		String comando = "", com = "";
		if (os.contains("Windows")) {
			comando = "ping -t www.google.com.br";
			com="o=";
		}
		if (os.contains("Linux")) {
			comando = "ping www.google.com.br";
			com="e=";
		}
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			double ac = 0;
			
			linha = buffer.readLine();
			
			for(int i=0;i<10;i++){
				linha = buffer.readLine();
				int pri = linha.lastIndexOf(com);
				int ult = linha.lastIndexOf("m");
				linha = linha.substring(pri+2,ult);
				ac+= Double.parseDouble(linha);
			}
			
			System.out.println("Ping com www.google.com.br: "+ac/10+" ms");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
	}
}
