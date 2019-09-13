package Controller;

import java.io.IOException;

public class ExecutarController {
	public ExecutarController(String prog) {
		try {
			Runtime.getRuntime().exec(prog);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
