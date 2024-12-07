import java.util.Locale;
import java.util.Scanner;

public class Atletas {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String nome;
		String altetaMaisAlto = "";
		int qtdAtletas = 0;
		int qtdHomens = 0;
		int qtdMulheres = 0;
		char sexo;
		double altura = 0f;
		double peso = 0f;
		double somaPeso = 0f;		
		double alturaAux = 0f;
		double somaAltMulheres = 0f;		
		
		System.out.print("Qual a quantidade de atletas? ");
		qtdAtletas = sc.nextInt();
		
		if (qtdAtletas > 0) {
			for (int i = 0; i < qtdAtletas; i++) {
				System.out.println();
				System.out.println("Digite os dados do atleta numero: " + (i + 1));
				sc.nextLine();
				
				System.out.print("Nome: ");
				nome = sc.nextLine();
				
				System.out.print("Sexo: ");
				do {				
					sexo = sc.next().charAt(0);
					if (sexo != 'F' && sexo != 'M')
						System.out.print("Valor invalido! Favor digitar F ou M: ");				
				} while (sexo != 'F' && sexo != 'M');
				
				System.out.print("Altura: ");
				do {
					altura = sc.nextDouble();				
					if (altura <= 0)
						System.out.print("Valor invalido! Favor digitar um valor positivo: ");			
				} while (altura <= 0);
				
				System.out.print("Peso: ");
				do {
					peso = sc.nextDouble();				
					if (peso <= 0)
						System.out.print("Valor invalido! Favor digitar um valor positivo: ");			
				} while (peso <= 0);
				
				somaPeso += peso;
				
				if (altura > alturaAux) {
					alturaAux = altura;
					altetaMaisAlto = nome;
				}
				
				if (sexo == 'M') {
					qtdHomens++;
				}
				
				if (sexo == 'F') {
					somaAltMulheres += altura;
					qtdMulheres++;
				}
			}
			
			System.out.println();
			System.out.println("RELATÓRIO:");
			System.out.printf("Peso médio dos atletas: %.2f%n", (somaPeso / qtdAtletas));
			System.out.printf("Atleta mais alto: %s%n", altetaMaisAlto);
			System.out.printf("Porcentagem de homens:  %.1f %%%n", ((double)qtdHomens / (double)qtdAtletas) * 100);	
			
			if (qtdMulheres > 0)
				System.out.printf("Altura média das mulheres: %.2f%n", (somaAltMulheres / qtdMulheres));
			else
				System.out.println("Não há mulheres cadastradas");
		}
		
		sc.close();
	}

}
