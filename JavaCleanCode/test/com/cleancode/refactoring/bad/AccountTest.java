package com.cleancode.refactoring.bad;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AccountTest {

	@Test
	public void depositClosedAccount() {
		Account account = new Account(BigDecimal.TEN);
		account.close();
		
		account.deposit(BigDecimal.TEN);
		
		assertEquals(account.getBalance(), BigDecimal.ZERO);
	}

	@Test
	public void depositFrozenAccount() {
		Account account = new Account(BigDecimal.ZERO);
		account.freeze();
		
		account.deposit(BigDecimal.TEN);
		
		assertEquals(account.getBalance(), BigDecimal.TEN);
	}
	
	@Test
	public void withdrawClosedAccount() {
		Account account = new Account(BigDecimal.TEN);
		account.close();
		
		account.withdraw(BigDecimal.TEN);
		
		assertEquals(account.getBalance(), BigDecimal.ZERO);
	}
	
	@Test
	public void withdrawUnverifiedAccount() {
		Account account = new Account(BigDecimal.TEN);
		
		account.withdraw(BigDecimal.TEN);
		
		assertEquals(account.getBalance(), BigDecimal.TEN);
	}
	
	@Test
	public void withdrawVerifiedAccount() {
		Account account = new Account(BigDecimal.TEN);
		account.verify();
		
		account.withdraw(BigDecimal.TEN);
		
		assertEquals(account.getBalance(), BigDecimal.ZERO);
	}
	
	@Test
	public void withdrawFrozenVerifiedAccount() {
		Account account = new Account(BigDecimal.TEN);
		account.verify();
		account.freeze();
		
		account.withdraw(BigDecimal.TEN);
		
		assertEquals(account.getBalance(), BigDecimal.ZERO);
	}
}
