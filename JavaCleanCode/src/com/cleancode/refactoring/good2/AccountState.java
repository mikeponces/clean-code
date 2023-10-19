package com.cleancode.refactoring.good2;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AccountState {

	AccountState verify();

	AccountState close();

	AccountState freeze();

	AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);

	AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance);

}
