package com.masai.main;

import java.util.Scanner;

import com.masai.main.Main;
import com.masai.usecases.*;

public class Admin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select from following option");
		System.out.println("1. Login");
		System.out.println("99. Main Menu");
		int i = sc.nextInt();
		
		switch(i) {
		case 1: LoginAdmin.main(args);
		break;
		case 99: Main.main(args);
		break;
		}
		
		sc.close();
	}

}
