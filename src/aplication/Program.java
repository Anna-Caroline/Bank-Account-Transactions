package aplication;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	
	public static void main(String[] args) {
		Account acc = new Account(1001, "Anna", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 1000.0, 500.0);
		
		//Upcasting: pegar um objeto do tipo BusinessAcount e atribuí-lo para uma variável do tipo Account:
		//A herança é uma relação é-um: uma BusinessAcount é também uma Account
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Luis", 100.0, 400.0);
		Account acc3 = new SavingsAccount(1002, "Alberto", 1000.0, 0.05);
		
		//Douwncasting: converter um objeto da superclasse para a subclasse
		
		BusinessAccount acc4 = (BusinessAccount)acc2;
		acc4.loan(100.0);
		
		//testando o downcasting:
		
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan!!");
		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!!");
		}
		// desconta a taxa de 5.0;
		acc1.withdraw(200.00);
		System.out.println(acc1.getBalance());
		
		//Override não desconta a taxa de 5.0;
		Account acc6 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		acc6.withdraw(200.0);
		System.out.println(acc6.getBalance());
		
		//Super:
		
		Account acc7 = new BusinessAccount(1002, "Anna", 2000.0, 500.0);
		acc7.withdraw(200.0);
		System.out.println(acc7.getBalance());
		
		//Polimorfismo: 
		//A associação do tipo específico com o tipo genérico é feita em tempo de execução (upcasting);
		
		
		Account x = new Account(2000, "Jussara", 500.0);
		Account y = new SavingsAccount(1500,"Joana", 1550.0, 0.03);
		
		x.withdraw(40.0);
		y.withdraw(200.0);
		
		System.out.println(x.getBalance());
		System.out.println(y.getBalance());
		
	}
}
