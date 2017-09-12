package com.danibuiza.maven.firstexample;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		System.out.println(addition(1, 2));

		System.out.println(divide(1, 2));
	}

	public static int addition(int first, int second) {
		return first + second;
	}

	public static double divide(int first, int second) {
		if (second != 0) {
			return (double) first / (double) second;
		}
		return 0;
	}
}
