package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String nameDept = sc.nextLine();
		
		System.out.print("Dia do pagamento: ");
		int payDayDept = sc.nextInt();
		
		sc.nextLine();
		System.out.print("Email: ");
		String emailDept = sc.nextLine();
		
		System.out.print("Telefone: ");
		String phoneDept = sc.nextLine();
		
		Department dept = new Department(nameDept, payDayDept, new Address(emailDept, phoneDept));
		
		System.out.print("\nQuantos funcionários tem o departamento? ");
		int n = sc.nextInt();		
		System.out.println("");
		
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Dados do funcionário " + i + ": ");
			System.out.print("Nome: ");
			String nameEmp = sc.nextLine();
			
			System.out.print("Salário: ");
			double salaryEmp = sc.nextDouble();
			
			Employee employee = new Employee(nameEmp, salaryEmp);
			dept.addEmployee(employee);
		}
		
		showReport(dept);

		sc.close();
	}

	private static void showReport(Department dept) {
		StringBuilder sb = new StringBuilder();
		
		System.out.println("\nFOLHA DE PAGAMENTO:");
		sb.append("Departamento Vendas = R$ " + String.format("%.2f", dept.payroll()));
		sb.append("\nPagamento realizado no dia " + dept.getPayDay());
		sb.append("\nFuncionários:\n");
		for (Employee emp : dept.getEmployees() ) {
			sb.append(emp.getName() + "\n");
		}
		sb.append("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
		
		System.out.println(sb);
	}
}
