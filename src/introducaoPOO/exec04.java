package introducaoPOO;

public class exec04 {

	public static void main(String[] args) {

		String nomeEmpresa = "McDonalds Serviços Incorporados";
		nomeEmpresa = nomeEmpresa.substring(0, 25);

		short tSalarios = 860;

		final byte qDias = 15;

		float[] notasAlu = new float[5];
		for (int i = 0; i < 5; i++) {
			notasAlu[i] = 0;

		}
		
		Carro c1 = new Carro();
		c1.placaC = "ABC-1234";
		c1.chassiC = "abcabc";
		c1.modeloC = "novo";
		c1.anoC = 1950;
		c1.corC = "vermelha";
		c1.nomeDonoC = "Jailson";

		double numOuro = 1.61803399;

		String[] nomesAlu = new String[10];
		for (int i = 0; i < 10; i++) {
			nomesAlu[i] = "a";
		}


		byte qTenis = 6;


	}

}

class Carro {

	String placaC = "";
	String chassiC = "";
	String modeloC = "";
	short anoC = 0;
	String corC = "";
	String nomeDonoC = "";

}