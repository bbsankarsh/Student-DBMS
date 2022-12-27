package com.mySchool;

public class Student  {
	
	private String id;
	private int age;
	private String name;
	private int marks;
	
	static int count=1;

	public Student(int age, String name, int marks) {
		super();
		this.id = "JSP"+count;
		this.age = age;
		this.name = name;
		this.marks = marks;
		count++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		count--;  // when we set the original id during update student 
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks + "]";
	}

	
	
	
	
	
}
