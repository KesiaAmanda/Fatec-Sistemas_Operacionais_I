package View;

import javax.swing.JOptionPane;

import Controller.RedesController;

public class Main {
	public static void main(String[] args) {
		String os = System.getProperty("os.name");
		RedesController redes = new RedesController();
		String adap = "";
		int opc = 0;
				
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("[1] - Mostrar adaptadores IPv4\n[2] - Ping Google\n[9] - Finalizar"));
			
			switch (opc) {
			case 1:
				adap = redes.ip(os);
				System.out.println(adap);
				break;
			case 2:
				redes.ping(os);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Fim!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida!");
				break;
			}
		}while(opc!=9);
	}
}
