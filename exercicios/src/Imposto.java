import java.util.Locale;
import java.util.Scanner;

public class Imposto {	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double rendaAnual;
		double rendaServico;
		double rendaCapial;
		double gastosMedicos;
		double gastosEducacao;
		double salario;
		double totalIrSalarial;
		double totalIrServico;
		double totalIrCapital;
		double totalGastos;
		double totalIrBruto;
		double totalDedutivel;
		double totalAbatimento;

		System.out.printf("-- Calculo Imposto de Renda -- %n%n");		
		System.out.print("Renda anual com sálario: R$ ");
		rendaAnual = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: R$ ");
		rendaServico = sc.nextDouble();	
		System.out.print("Renda anual com ganho de capital: R$ ");
		rendaCapial = sc.nextDouble();	
		System.out.print("Gastos médicos: R$ ");
		gastosMedicos = sc.nextDouble();		
		System.out.print("Gastos educacionais: R$ ");
		gastosEducacao = sc.nextDouble();	
		
		salario = rendaAnual / 12;
		
		if (salario > 3000 && salario <= 5000 )
			totalIrSalarial = rendaAnual * 0.10; 
		else if (salario > 5000) 
			totalIrSalarial = rendaAnual * 0.20;
		else 
			totalIrSalarial = rendaAnual * 0.0;
		
		totalIrServico  = (rendaServico > 0) ? rendaServico * 0.15 : rendaServico * 0.0;		
		totalIrCapital  = (rendaCapial > 0) ? rendaCapial * 0.20 : rendaCapial * 0.0;
		totalGastos	    = (gastosMedicos + gastosEducacao);
		totalIrBruto    = (totalIrSalarial + totalIrServico + totalIrCapital);
		totalDedutivel  = (totalIrBruto * 0.30);
		totalAbatimento = (totalGastos < totalDedutivel) ? totalGastos : totalDedutivel;
				
		System.out.printf("%n-- Relatório de Imposto de Renda -- %n");
		System.out.printf("%n   -- Consolidado de Renda -- %n");
		System.out.printf("      Imposto sobre salário: R$ %.2f%n", totalIrSalarial);
		System.out.printf("      Imposto sobre serviços: R$ %.2f%n", totalIrServico);
		System.out.printf("      Imposto sobre ganho de capital: R$ %.2f%n", totalIrCapital);
		
		System.out.printf("%n   -- Deduções -- %n");
		System.out.printf("      Máximo dedutível: R$ %.2f%n", totalDedutivel);
		System.out.printf("      Gastos dedutíveis: R$ %.2f%n", totalGastos);
		
		System.out.printf("%n   -- Resumo -- %n");
		System.out.printf("      Imposto bruto total: R$ %.2f%n", totalIrBruto);
		System.out.printf("      Abatimento: R$ %.2f%n", totalAbatimento);
		System.out.printf("      Imposto devido: R$ %.2f%n", (totalIrBruto - totalAbatimento));
		
		sc.close();
	}

}
