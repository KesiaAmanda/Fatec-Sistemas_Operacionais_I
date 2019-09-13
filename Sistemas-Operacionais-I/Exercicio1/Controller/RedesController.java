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
				e.printStackTrace();
			}	
		return adaptadores;
	}
	
	public void ping (String os) {
		String comando = "";
		if (os.contains("Windows")) {
			comando = "ping www.google.com.br -n 10";
		}
		if (os.contains("Linux")) {
			comando = "ping www.google.com.br -c 10";
		}
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
						
			while(linha!=null) {
				if (os.contains("Windows")&&linha.contains("dia")) {
					String[] aux = linha.split(",");
					System.out.println(aux[2]);
				}
				if (os.contains("Linux")&&linha.contains("rtt")) {
					String[] aux = linha.split("/");
					System.out.println(aux[4]+"ms");
				}
				linha = buffer.readLine();
			}
			
			fluxo.close();
			leitor.close();
			buffer.close();
			 
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}