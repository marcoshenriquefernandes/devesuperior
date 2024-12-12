package app;

import java.util.Scanner;
import entities.Champion;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Champion champion1 = null;
		Champion champion2 = null;
		String texto;
		int rounds;
		
		for (int i = 0; i < 2; i++) {
			texto = (i == 0) ? "primeiro" : "segundo";
			
			System.out.printf("Digite os dados do %s campeão: %n", texto);
			System.out.print("Nome: ");
			String name = sc.next();
			
			System.out.print("Vida inicial: ");
			int life = sc.nextInt();
			
			System.out.print("Ataque: ");
			int attack = sc.nextInt();
			
			System.out.print("Armadura: ");
			int armor = sc.nextInt();
			
			if (i == 0)
				champion1 = new Champion(name, life, attack, armor);
			else
				champion2 = new Champion(name, life, attack, armor);
			
			System.out.println();
		}
		
		System.out.print("Quantos turnos você deseja executar? ");
		rounds = sc.nextInt();
		
		System.out.println();
		for (int i = 1; i <= rounds; i++) {
		    champion2.takeDamage(champion1);
		    champion1.takeDamage(champion2);
		    
			System.out.println("Resultado do turno: " + i);
			System.out.println(champion1.status());
			System.out.println(champion2.status());
			System.out.println();
			
			if (champion1.getLife() <= 0 || champion2.getLife() <= 0) {
				break;
			}
		}
		
		System.out.println("FIM DO COMBATE");
		sc.close();

	}

}
