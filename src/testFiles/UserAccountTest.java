package testFiles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sourceFiles.Bank;
import sourceFiles.UserAccount;

public class UserAccountTest {
	UserAccount user;
	Bank bank;

	@Before
	public void setUp() throws Exception {
		bank = new Bank();
		user= new UserAccount();
		user.setFirstName("Ahmed");
		user.setLastName("Mohamed");
		user.setUserName("ahmed113");
		user.setPassword("123456");
		user.deposit(1000);
		bank.addAccount(user);
	}

	@Test
	public void test1() {
		assertEquals("Ahmed",user.getFirstName());
		assertEquals("Mohamed",user.getLastName());
		assertEquals("ahmed113",user.getUserName());
		assertEquals("123456",user.getPassword());
		assertEquals(1,user.getAccountNumber());
		UserAccount user2= new UserAccount();
		assertEquals(2,user2.getAccountNumber());
		
		
	}
	@Test
	public void test2() {
		assertEquals(1000,user.checkBalance(),0);
		user.deposit(100.1);
		assertEquals(1100.1,user.checkBalance(),0);
		
	}
	@Test
	public void test3() {
		user.withdraw(500);
		assertEquals(500,user.checkBalance(),0);
		user.withdraw(50.1);
		assertEquals(449.9,user.checkBalance(),0);
		
	}
	@Test
	public void test4() {
		UserAccount user2 = new UserAccount();
		user2.setUserName("mohamed123");
		bank.addAccount(user2);
		user.transferMoney(bank,"mohamed123",200);
		user2.transferMoney(bank, user.getUserName(), 100);
		assertEquals(900,user.checkBalance(),0);
		assertEquals(100,user2.checkBalance(),0);
		
	}

}
