package com.example.geektrust;
import java.util.ArrayList;
import java.util.List;

class Course {
	String cid;
	String name;
	String instr;
	int max;
	int min;
	int count;
	List<Student> students;
	boolean over;
	String date;
	String tcid;

	public Course(String cid, String name, String instr, int max, int min, boolean over, String date, int count,
			String tcid) {
		super();
		this.cid = cid;
		this.name = name;
		this.instr = instr;
		this.max = max;
		this.min = min;
		this.over = over;
		this.date = date;
		this.count = count;
		students = new ArrayList<>();
		this.tcid = tcid;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void removeStudent(String name) {
		for (int i = 0; i < students.size(); i++) {
			if ((students.get(i).name).equals(name)) {
				students.remove(i);
			}
		}
	}

}