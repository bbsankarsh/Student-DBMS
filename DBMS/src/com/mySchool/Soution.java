package com.mySchool;

import java.util.Scanner;

import com.CustomException.InvalidChoiceException;

public class Soution {

	public static void main(String[] args) {

		System.out.println();
		StudentManagementSystem s = new StudentManagementSystemImpl();
		System.out.println("Student Data Base Management System");
		System.out.println("-----------------------------------");

		while(true) {

			Scanner scan = new Scanner(System.in);

			System.out.println(" 1: Add Student \n 2: Display Students \n 3: Display all Students"
					+ "\n 4: Remove Student \n 5: Remove all Students \n 6: Update Students"
					+ "\n 7: Count Students \n 8: Sort Students \n 9: Exit");

			System.out.print(" Enter your choice : ");
			int choice = scan.nextInt();
			System.out.println();

			switch(choice) {

			case 1: s.addStudent();
			break;

			case 2:s.displayStudent();
			break;

			case 3:s.displayAllStudent();
			break;

			case 4: s.removeStudent();
			break;

			case 5: s.removeAllStudents();
			break;

			case 6: s.updateStudent();
			break;

			case 7: s.countStudents();
			break;

			case 8: s.sortStudents();
			break;

			case 9: System.out.println("Thank you");
			System.exit(0);

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e) {
					System.out.println(e.toString());
				}
			}
			System.out.println("-----------------------------------");

		}
	}
}
