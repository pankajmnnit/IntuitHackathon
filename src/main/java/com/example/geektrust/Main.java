package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] arg) {
		HashMap<String, Course> courseDetails = new HashMap<String, Course>();
		Schedular schedularService = new Schedular();
		try {
			// the file to be opened for reading
			FileInputStream fis = new FileInputStream(arg[0]);
			Scanner sc = new Scanner(fis); // file to be scanned
			// List<String>args = new ArrayList<String>();
			while (sc.hasNextLine()) {
				String[] args = sc.nextLine().split(" ");
				// add course offerings
				String operation = args[0];
				switch(operation){
				case "ADD-COURSE-OFFERING":
					schedularService.addCourse(args, courseDetails);
					break;
					
				case "REGISTER":
					schedularService.registerStudent(args, courseDetails);
					break;
				case "ALLOT":
					schedularService.alloctCourse(args, courseDetails);
					break;
				case "CANCEL":
					schedularService.cancelCourse(args, courseDetails);
					break;		
				}

			}
			sc.close(); // closes the scanner
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
