package com.example.geektrust;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Schedular {
	
	public void registerStudent(String[] args, HashMap<String, Course> courseDetails) {
		if (args.length != Constants.REG_LEN) {
			printDataError();
		} else {
			String mailId = args[1];
			String courseInfo = args[2];
			String[] details = courseInfo.split(Constants.DASH);
			String courseName = details[1];

			// check if seats are not full and course is not alloted
			Course course = courseDetails.get(courseName);
			int currentCount = course.count;
			int maxCount = course.max;
			// System.out.println(maxCount);
			
			if (currentCount + 1 > maxCount) {
				System.out.println(Constants.COURSE_FULL_ERROR);
			} else {
				// increment head count of corresponding course
				courseDetails.get(courseName).count++;
				String[] split = mailId.split(Constants.MAIL_AST);
				String name = split[0];
				String sid = Constants.REG_COURSE + name + Constants.DASH + courseName;
				// REG-COURSE-ANDY-DATASCIENCE
				Student student = new Student(name, mailId, sid);
				// added student to corresponding course
				courseDetails.get(courseName).addStudent(student);
				// REG-COURSE-BOBY-PYTHON
				System.out.println(Constants.REG_COURSE + name + "-" + courseName + " " + Constants.ACCEPTED);
			}

		}
	}
	
	public void printDataError() {
		System.out.println(Constants.DATA_ERROR);
	}
	
	
	public void addCourse(String[] args, HashMap<String, Course> courseDetails) {
		if (args.length != Constants.ADD_LEN) {
			System.out.println(Constants.DATA_ERROR);
		} else {
			String courseName = args[1];
			String instructor = args[2];
			String date = args[3];
			int min = Integer.parseInt(args[4]);
			int max = Integer.parseInt(args[5]);
			if (courseDetails.containsKey(courseName)) {
				printDataError();
			} else {
				String cid =  Constants.OFFER + courseName + Constants.DASH + instructor; // unqiue course id
				String tcid = courseName + "-" + instructor;
				Course newCourse = new Course(cid, courseName, cid, max, min, false, date, 0, tcid);
				courseDetails.put(courseName, newCourse); // adding a new course
				System.out.println(cid);
			}

		}
	}
	
	public void alloctCourse(String[] args, HashMap<String, Course> courseDetails) {
		if (args.length != Constants.ALL_LEN) {
			printDataError();
		} else {
			
			String info = args[1];
			String[] allotdetails = info.split(Constants.DASH);
			String courseName = allotdetails[1];
			String instructorName = allotdetails[2];
			Course currCourse = courseDetails.get(courseName);
			currCourse.over = true; // end course offering
			String date = currCourse.date;
			String course = currCourse.name;
			
			List<Student> students = currCourse.students;
			// Collections.sort(students, new DateFileSorter());
			Collections.sort(students, (p1, p2) -> p1.sid.compareTo(p2.sid));
			for (int i = 0; i < students.size(); i++) {
				String sid = students.get(i).sid;
				String mailId = students.get(i).mailid;
				String status;
				if(currCourse.count<currCourse.min) {
					status = Constants.CANCEL;
				}
				else {
					status = Constants.CONFIRM;
				}
				System.out.println(sid + " " + mailId + " " + info + " " + course + " " + instructorName + " " + date + " "
						+ status);
			}

		}
	}
	
	public void cancelCourse(String[] args, HashMap<String, Course> courseDetails) {
		if (args.length != Constants.CAN_LEN) {
			printDataError();
		} else {
			String offering = args[1];
			String[] details = offering.split(Constants.DASH);
			String course = details[3];
			String studentName = details[2];
			// System.out.println(courseName);
			if (courseDetails.get(course).over == false) {
				// not over yet we can cancel
				courseDetails.get(course).removeStudent(studentName);
				System.out.println(offering + Constants.CANCEL_A);

			} else {
				// REG-COURSE-ANDY-JAVA CANCEL_REJECTED
				System.out.println(offering + Constants.CANCEL_R);
			}

		}
	}

}
