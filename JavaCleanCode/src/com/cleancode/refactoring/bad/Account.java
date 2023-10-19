package com.cleancode.refactoring.bad;

import java.math.BigDecimal;

public class Account {
	private boolean isVerified;
	private boolean isClosed;
	private boolean isFrozen;
	private BigDecimal balance;

	public Account(BigDecimal initialDeposit) {
		this.balance = initialDeposit;
	}

	public void verify() {
		this.isVerified = true;
	}

	public void close() {
		this.isClosed = true;
		this.balance = BigDecimal.ZERO;
	}

	public void freeze() {
		if (isClosed) {
			return;
		}
		if (!isVerified) {
			return;
		}
		this.isFrozen = true;
	}

	public void deposit(BigDecimal amount) {
		if (isClosed) {
			return;
		} 
		if(isFrozen) {
			this.isFrozen = false;
		}
		this.balance = this.balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		if(this.isClosed) {
			return;
		}
		if(!this.isVerified) {
			return;
		}
        if(isFrozen) {
            this.isFrozen = false;
        }
		this.balance = this.balance.subtract(amount);
	}

	public BigDecimal getBalance() {
		return balance;
	}
}
