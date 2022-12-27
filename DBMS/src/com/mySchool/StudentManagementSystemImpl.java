package com.mySchool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.CustomException.InvalidChoiceException;
import com.Sort.SortByAge;
import com.Sort.SortByID;
import com.Sort.SortByMarks;
import com.Sort.SortbyName;


public class StudentManagementSystemImpl implements StudentManagementSystem {

	Map<String, Student> db = new LinkedHashMap<String, Student>();	
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void addStudent() {
		
		System.out.print("Enter Age ");
		int age = scan.nextInt();
		System.out.print("Enter Name ");
		String name = scan.next();
		System.out.print("Enter Marks ");
		int marks = scan.nextInt();
		
		Student s = new Student( age , name , marks );
		db.put(s.getId(), s);
		System.out.println('\n'+"Student details inserted");
		System.out.println("The Student ID is "+s.getId()+'\n');
		
	}

	@Override
	public void displayStudent() {
		
		System.out.print("Enter the Student ID");
		String id = scan.next();
		id = id.toUpperCase(); // if user enters lowercase it will convert to uppercase
		
		if(db.containsKey(id)) {
			Student obj = db.get(id);
			System.out.println("ID : "+obj.getId());
			System.out.println("AGE : "+obj.getAge());
			System.out.println("NAME : "+obj.getName());
			System.out.println("MARKS : "+obj.getMarks()+'\n');
//			System.out.println(obj);  
		}
		else {
			try {
				throw new InvalidChoiceException("Invalid ID");
			}
			catch(InvalidChoiceException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public void displayAllStudent() {
		
		Set<String> keys = db.keySet();       // JSP1 , JSP2
		System.out.println("Student details are: ");
		if(db.size()!=0) {
			for(String key:keys) {
				System.out.println(db.get(key));
			}System.out.println();
		}
		else {
			try {
				throw new InvalidChoiceException("Student Records is empty");
			}
			catch(InvalidChoiceException e) {
				System.out.println(e);
			}
		}
		
	}
	
	@Override
	public void removeStudent() {
		
		System.out.print("Enter the Student ID to remove : ");
		String id = scan.next();
		id = id.toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student removed"+'\n');
		}
		else {
			try {
				throw new InvalidChoiceException("Invalid ID");
			}
			catch(InvalidChoiceException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public void removeAllStudents() {
		
		System.out.println(db.size()+" Students are present");
		db.clear();
		System.out.println("All Student details removed"+'\n');
		
	}

	@Override
	public void updateStudent() {
		
		System.out.print("Enter the Student ID to update : ");
		String id = scan.next();
		id = id.toUpperCase();
		if(db.containsKey(id)) {
			
			System.out.println(" 1: Update all details \n 2: Update Age \n 3: Update Name \n 4: Update Marks ");
			int choice = scan.nextInt();
			Student obj = db.get(id);
			
			switch(choice) {
				
			case 1: 
				System.out.print('\n'+"Enter Age ");
				int age = scan.nextInt();
				System.out.print("Enter Name ");
				String name = scan.next();
				System.out.print("Enter Marks ");
				int marks = scan.nextInt();
				
				Student s = new Student( age , name , marks );
				s.setId(id);  //id should be same as the original id
				db.put(s.getId(), s);
				System.out.println('\n'+"Student details updated");
				System.out.println("The Student ID is "+s.getId()+'\n');
				break;
				
			case 2:				
				System.out.println("Enter the Age ");
				obj.setAge(scan.nextInt());
				System.out.println("Student Age updated");
				break;
				
			case 3:
				System.out.println("Enter the Name ");
				obj.setName(scan.next());
				System.out.println("Student Name updated");
				break;
			
			case 4:
				System.out.println("Enter the Marks ");
				obj.setMarks(scan.nextInt());
				System.out.println("Student Marks updated");
				break;
			}
				
		}
		else {
			try {
				throw new InvalidChoiceException("Invalid ID");
			}
			catch(InvalidChoiceException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public void countStudents() {
		
		System.out.println("Total number of Students : "+db.size()+'\n');
		
	}

	@Override
	public void sortStudents() {

		System.out.println(" 1: Sort by ID in ascending order");
		System.out.println(" 2: Sort by ID in descending order");
		System.out.println(" 3: Sort by Age "+'\n'+" 4: Sort by Name"+'\n'+" 5: Sort by marks"+'\n');
		System.out.print(" Enter your choice : ");
		int choice = scan.nextInt();
		System.out.println();
		
		List<Student> list = new ArrayList<Student>(db.values()); //get the values of db and store it inside ArrayList
		switch(choice) {

		case 1: 
			
			Collections.sort(list, new SortByID());
			display(list);
			break;
			
		case 2:
			
			Map<String, Student> ts2 = new TreeMap<String, Student>(Collections.reverseOrder()); //TreeMap with reverse order
			ts2.putAll(db);							// Putting db(LinkedHashMap) inside ts2(TreeMap)
			Set<String> keySet2 = ts2.keySet();
			for(String key:keySet2) {
				System.out.println(db.get(key));	//Getting db values in reverse order
			}
			break;
		
		case 3: 
			
			Collections.sort(list, new SortByAge());
			display(list);
			break;
			
		case 4:
			
			Collections.sort(list, new SortbyName());
			display(list);
			break;
			
		case 5:
			Collections.sort(list, new SortByMarks());
			display(list);
			break;
		}
	}

	public static void display(List<Student> l) {
		for(Student s:l) {
			System.out.println(s);
		}
	}
	
	
}
