package View;

import javax.swing.JOptionPane;

import Controller.Controle;

public class Principal {
	public static void main(String[] args) {
		Controle c = new Controle();
		
		String os = c.Sistema();
		
		c.leProcessos(os);
		
		int opc = 0;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("[1] - Atualizar lista de processos\n[2] - Matar processo pelo PID"
					+ "\n[3] - Matar processo pelo nome\n[9] - Sair"));
			
			switch (opc) {
			case 1:
				c.leProcessos(os);
				break;
			case 2:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("PID"));
				c.killpid(os, pid);
				break;
			case 3:
				String nome = JOptionPane.showInputDialog("Nome do processo");
				c.killim(os, nome);
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
