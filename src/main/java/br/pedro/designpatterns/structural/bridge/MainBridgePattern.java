package br.pedro.designpatterns.structural.bridge;

import br.pedro.designpatterns.structural.bridge.imp.LoggerError;
import br.pedro.designpatterns.structural.bridge.imp.SimpleAccount;

/**
 * Intent: Decouple an abstraction from its implementation so that the two
 * can vary independently. Bridge pattern uses DI.
 * Applicability: In S[O]LID implementations. To a class be compliance with open/close principle,
 * we need to decouple the implementation of dependencies inside another class.
 * Examples: ---
 * **/
public class MainBridgePattern {

	public static void main(String[] args) {
		startMainBridgeExample();
	}

	private static void startMainBridgeExample() {
		SimpleAccount account = new SimpleAccount();
		
		account.deposit(100.0);
		account.witdraw(90);
		
		//We can change the log at runtime
		if (account.isBalanceLow()) {
			account.setLogger(new LoggerError());
		}
		
		account.witdraw(10);
		
	}
}
