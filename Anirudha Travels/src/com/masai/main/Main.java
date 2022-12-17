package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("+-------------------------------------------+");
		System.out.println("| *******WELCOME TO ANIRUDHA TRAVELS******* |");
		System.out.println("+-------------------------------------------+");
		
		System.out.println("Select from following option");
		System.out.println("1. Admin");
		System.out.println("2. Customer");
		System.out.println("3. Exit Application.");
		int i = sc.nextInt();
		
		switch (i){
		case 1: Admin.main(args);
		break;
		case 2: CustomerMain.main(args);
		break;
		case 3: ExitApp.main(args);
		break;
		}

		
		sc.close();
	}


}
