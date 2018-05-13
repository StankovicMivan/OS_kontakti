package com.ftninformatika.vezbe04.primer03;

import java.io.IOException;
import java.util.Scanner;

public class Keyboard01 {
	public static void main(String[] args) throws IOException {
		
		String name;
		int height;
		
		//klasa Scanner se takodje moze koristiti za citanje sa tastature
		//ne radi samo sa stringovima
		Scanner sc = new Scanner(System.in); 
		System.out.print("Unesite svoje ime: ");
		name = sc.nextLine(); 
		System.out.println("Uneli ste: " + name);
		
		System.out.print("Unesite svoju visinu: ");
		//ovde je razlika
		height = sc.nextInt();
		System.out.println("Uneli ste: " + height);
		sc.nextLine(); //ciscenje ulaza i znaka \n
		
		/*
		System.out.print("Unesite svoj grad: ");
		String grad = sc.nextLine(); 
		System.out.println("Uneli ste: " + grad);
		*/
		
		System.out.print("Unesite svoj broj cipela (moze i sa .): ");
		float number = sc.nextFloat(); 
		System.out.println("Uneli ste: " + number);
		sc.nextLine(); //ciscenje ulaza i znaka \n
		
		sc.close();
		System.out.println("Kraj programa");
	}
}
