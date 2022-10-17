package com.tm1.utility;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TerminalIDGenerator implements IdentifierGenerator {
	private static int counter = 1;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		int id = counter++;
		return "T" + id;
	}
}