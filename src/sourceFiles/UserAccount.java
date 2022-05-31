package sourceFiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserAccount implements Serializable {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private double balance;
	private static int accountNumber;
	private List<Transaction> bankStatement;
	private List<Item> purchases;
	
	public UserAccount() {
		bankStatement=new ArrayList<Transaction>();
		purchases = new ArrayList<Item>();
		accountNumber++;
	}

	public void setFirstName(String string) {
		// TODO Auto-generated method stub
		this.firstName=string;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}

	public void setLastName(String string) {
		// TODO Auto-generated method stub
		this.lastName=string;
		
	}

	public void setUserName(String string) {
		// TODO Auto-generated method stub
		this.userName=string;
		
	}

	public void setPassword(String string) {
		// TODO Auto-generated method stub
		this.password=string;
		
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public void deposit(double i) {
		// TODO Auto-generated method stub
		this.balance+=i;
		Transaction t = new Transaction();
		t.setAmount(i);
		t.setDescription("NONE");
		t.setType(0);
		this.bankStatement.add(t);
		
	}

	public double checkBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}

	public void withdraw(double i) {
		// TODO Auto-generated method stub
		this.balance-=i;
		Transaction t = new Transaction();
		t.setAmount(i);
		t.setDescription("NONE");
		t.setType(1);
		this.bankStatement.add(t);
		
	}

	public void transferMoney(Bank bank, String string, double i) {
		// TODO Auto-generated method stub
		this.balance-=i;
		bank.getAccount(string).deposit(i);
		Transaction t = new Transaction();
		t.setAmount(i);
		t.setDescription("NONE");
		t.setType(3);
		this.bankStatement.add(t);
		
	}

	public List<Transaction> getStatement() {
		// TODO Auto-generated method stub
		return this.bankStatement;
		
	}

	public void purchase(Item item) {
		// TODO Auto-generated method stub
		this.balance-=item.getPrice();
		this.purchases.add(item);
		Transaction t = new Transaction();
		t.setAmount(item.getPrice());
		t.setDescription("NONE");
		t.setType(2);
		this.bankStatement.add(t);
		
		
	}

	public int getAccountNumber() {
		// TODO Auto-generated method stub
		return this.accountNumber;
	}

}
