package java_package;

public class Rettangolo {
	int altezza;
	int larghezza;
	
	public Rettangolo (int altezza, int larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
		
	}

	public void stampaRettangolo(Rettangolo rettangolo){
		int areaRett = rettangolo.altezza*rettangolo.larghezza;
		System.out.println("Area Rettangolo 1: " + areaRett);
		
		int perRett = (rettangolo.altezza + rettangolo.larghezza)*2;
		System.out.println("Perimetro Rettangolo 1: " + perRett);
	}
	
	public void stampaDueRettangoli(Rettangolo rettangolo1, Rettangolo rettangolo2) {
		int areaRett1 = rettangolo1.altezza*rettangolo1.larghezza;
		System.out.println("Area Rettangolo 1: " + areaRett1);
		
		int perRett1 = (rettangolo1.altezza + rettangolo1.larghezza)*2;
		System.out.println("Perimetro Rettangolo 1: " + perRett1);
		
		int areaRett2 = rettangolo1.altezza*rettangolo2.larghezza;
		System.out.println("Area Rettangolo 2: " + areaRett2);
		
		int perRett2 = (rettangolo2.altezza + rettangolo2.larghezza)*2;
		System.out.println("Perimetro Rettangolo 2: " + perRett2);
		
		int areaDueRett = areaRett1 + areaRett2;
		System.out.println("Area Due Rettangoli: " + areaDueRett);
		int perimDueRett = perRett1 + perRett2;
		System.out.println("Perimetro due Rettangoli: " + perimDueRett);
	}
}
