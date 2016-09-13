/**
 *Created by Chaelle M. Gabato
 */

public class Account{

	private int accountNumber = 0;
	private double balance = 0;

	public static void main(String[] args){
		Account a1 = new Account(123456, 212345.75);
		Account a2 = new Account(987654);
		System.out.println(a1);
		System.out.println(a2);

		a1.setBalance(123456.75f);
		a2.setBalance(987654.25f);
		System.out.println(a1);
		System.out.println(a2);

			
		a1.credit(2012);
		a1.debit(666666);
     	System.out.println(a1);  // run toString() to inspect the modified instance
     	a1.setBalance(123456.55);
   	   	System.out.println(a1); 
	}

	public Account(int x, double y){
		this(x);
		setBalance(y);
	}

	public Account(int x){
		accountNumber = x;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double x){
		balance = x;
	}

	public void credit(double amount){
		setBalance(balance + amount);
	}

	public void debit(double amount){
		if (balance >= amount)
			setBalance(balance - amount);
		else{
			throw new IllegalArgumentException("Amount Withdrawn exceeds the current balance");
		}
	}

	public String toString(){
		return String.format("A/C no:%d, Balance=$%.2f", this.accountNumber, this.balance);
	}
}