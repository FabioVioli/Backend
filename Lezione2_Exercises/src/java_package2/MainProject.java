package java_package2;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sim prova = new Sim(333333333);
		
		prova.simInfo(prova);
		System.out.println("------------------------------------");
		prova.simRecharge(prova, 30);
		System.out.println("------------------------------------");
		prova.chiamate[0] = new Chiamate(1, 1);
		prova.chiamate[4] = new Chiamate(2, 1);
		prova.simInfo(prova);
		
		
//		System.out.println(prova.chiamate[0]);
//		System.out.println(prova.chiamate[1]);
//		System.out.println(prova.chiamate[2]);
//		System.out.println(prova.chiamate[3]);
//		System.out.println(prova.chiamate[4]);
		
		
		
	}

}
