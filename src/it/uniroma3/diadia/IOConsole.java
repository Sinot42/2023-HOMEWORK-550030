package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO{
	
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
		//controlli artigianali prima della consegna
		//System.out.println("\n\nPIPPO\n\n");
	}
	
	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
//		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		try {
			scannerDiLinee.nextLine();
		}catch(NullPointerException e){
			scannerDiLinee.close();
		}
		return riga;
	}
}
