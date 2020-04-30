package bankApp;
import java.util.Scanner;


public class Account {
	// fields
	private int balance; 
	private int previousTransaction;
	private String customerName; 
	private String customerId;
	
	// constructor
	Account(String name, String id){
		this.customerName = name; 
		this.customerId = id;
		System.out.println("Welcome " + customerName + " "+ customerId + "\n");
		displayMenu();
	}
	
	// methods
	void deposit(int a) {
		if(a > 0) {
			balance = balance + a;
			previousTransaction = a;
		} else {
			System.out.println("Error. Amount deoposited must be greater than zero");
		}
	}
	
	void withdraw(int a) {
		if(a <= balance) {
			balance = balance - a;
			previousTransaction = -a;			
		} else {
			System.out.println("Error. Insufficient funds");

		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0){
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("no transactions to show");
		}
	}
	
	void displayMenu() {
		char answer = ' ';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Choose from Menu: \n A - Check balance \n B - Deposit \n C - Withdraw "
				+ "\n D - Previous transaction \n E - Exit \n");
		
		do {				
			answer = scanner.next().charAt(0);
			
			switch(answer){
				case 'A':
					System.out.println(">>>>>>>>>>Balance = "+ balance);
					displayMenu();
					break;
					
				case 'B':
					System.out.println(">>>>>>>>>>enter amount to deposit: ");
					int amount = scanner.nextInt();
					deposit(amount);
					displayMenu();
					break;
					
				case 'C':
					System.out.println(">>>>>>>>>>enter amount to withdraw: ");
					int amountW = scanner.nextInt();
					withdraw(amountW);
					displayMenu();
					break;
					
				case 'D':
					getPreviousTransaction();
					displayMenu();
					break;
					
				case 'E':
					System.out.println(">>>>>>>>>>exiting...Goodbye.");
					break;
				
				default:
					System.out.println(">>>>>>>>>>invalid choice! Try again");
					displayMenu();
					break;
			}
			
		}while(answer != 'E');
		
		
	}

}
