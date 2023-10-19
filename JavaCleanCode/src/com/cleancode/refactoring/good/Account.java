package com.cleancode.refactoring.good;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance;
	private AccountState state; // Closed, Unverified, Frozen, Active

	public Account(BigDecimal initialDeposit) {
		this.balance = initialDeposit;
		this.state = new Unverified();
	}

	public void verify() {
		this.state = state.verify();
	}

	public void close() {
		this.state = state.close();
	}

	public void freeze() {
		this.state = state.freeze();
	}

	public void deposit(BigDecimal amount) {
		this.state = state.deposit(amount, this::addToBalance);
	}

	public void withdraw(BigDecimal amount) {
		this.state = state.withdraw(amount, this::subtractFromBalance);
	}

	private void addToBalance(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	private void subtractFromBalance(BigDecimal amount) {
		this.balance = this.balance.subtract(amount);
	}

	public BigDecimal getBalance() {
		return balance;
	}
}
