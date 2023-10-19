package com.cleancode.refactoring.good2;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Frozen implements AccountState {

	@Override
	public AccountState verify() {
		return this;
	}

	@Override
	public AccountState close() {
		return new Closed();
	}

	@Override
	public AccountState freeze() {
		return this;
	}

	@Override
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		addToBalance.accept(amount);
		return new Active();
	}

	@Override
	public AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
		subtractFromBalance.accept(amount);
		return new Active();
	}

}
