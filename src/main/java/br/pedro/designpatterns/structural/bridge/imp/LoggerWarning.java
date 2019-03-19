package br.pedro.designpatterns.structural.bridge.imp;

public class LoggerWarning implements Logger{

	public void log(String message) {
		System.out.println(message);
	}
}
