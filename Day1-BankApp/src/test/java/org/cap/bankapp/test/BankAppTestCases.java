package org.cap.bankapp.test;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AccountServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BankAppTestCases {

	@Mock
private AccountDao accountDao;
	@Mock
private AccountServiceImpl accountService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		 accountService = new AccountServiceImpl(accountDao);
	}
	 
	@After
	public void tearDown() {
		
		
	}
	
	@Test
	public void test_add_Account_with_valid() throws InvalidInitialAmountException{
		Customer customer = new Customer();
		Account account = new Account();
		account.setCustomer(customer);
		account.setAmount(1500);
		//Declaration
		Mockito.when(accountDao.createAccount(account)).thenReturn(true);
		
		Account new_account = accountService.addAccount(customer, 1500);
		
		Mockito.verify(accountDao).createAccount(account);
		
		//assertEquals(1500,new_account);
		
	}
	
/*	@Test
	public void test_deposit() {
	
		Account account = new Account();
		account.setAccountNo(100);
		Customer customer = new Customer();
		customer.setCustName("Ravi");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAmount(5000);
		int accountNo = 0;
		
		Mockito.when(accountDao.findAccountById(accountNo)).thenReturn(account);
		
		Account new_deposit_account = accountService.deposit(100, 5000);
		
		Mockito.verify(accountDao).findAccountById(100);
		
		//assertEquals(1500,new_deposit_account);
		
	}*/
}
 