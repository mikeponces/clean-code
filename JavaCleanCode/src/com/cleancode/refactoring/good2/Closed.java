package com.cleancode.refactoring.good2;

import java.math.BigDecimal;
import java.util.function.Consumer;

//Account remains Closed regardless
public class Closed implements AccountState {

	@Override
	public AccountState verify() {
		return this;
	}

	@Override
	public AccountState close() {
		return this;
	}

	@Override
	public AccountState freeze() {
		return this;
	}

	@Override
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		return this;
	}

	@Override
	public AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
		return this;
	}

}
