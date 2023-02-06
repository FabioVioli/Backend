package exercise3;

public class ContoOnLine extends ContoCorrente {
	double maxPrelievo;

	ContoOnLine(String titolare, double saldo, double maxP) {
		super(titolare, saldo);
		this.maxPrelievo = maxP;
	}

	void stampaSaldo() {

		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}

	void preleva(double x) {
		
//		if (x <= maxPrelievo) {
//			super.preleva(x);
//		}
		
		try
		{	if (x <= maxPrelievo) {
			super.preleva(x);
			
		}else if(x > maxPrelievo)
		     {
		          throw new BancaException();
		     }
		}
		catch(BancaException ex)
		{
		      System.out.println("il prelievo non è disponibile");
		}
		
	
	}
}
