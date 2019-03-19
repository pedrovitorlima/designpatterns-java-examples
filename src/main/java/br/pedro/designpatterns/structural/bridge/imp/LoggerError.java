package br.pedro.designpatterns.structural.bridge.imp;

public class LoggerError implements Logger{
	
	public void log(String message) {
		System.err.println(message);
	}
}
