package com.Sort;

import java.util.Comparator;

import com.mySchool.Student;

public class SortbyName implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		return a.getName().compareTo(b.getName());
	} 
}
