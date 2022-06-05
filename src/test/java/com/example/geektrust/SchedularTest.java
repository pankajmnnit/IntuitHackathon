package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class SchedularTest {
	HashMap<String, Course> courseDetails = new HashMap<String, Course>();
	String test1 = "ADD-COURSE-OFFERING DATASCIENCE BOB 05062022 3 5";
	String test2 = "REGISTER ANDY@GMAIL.COM OFFERING-DATASCIENCE-BOB";
	String[] args = test1.split(" ");
	@Test
	void testAddCourse() {
		Schedular sc = new Schedular();
		sc.addCourse(args,courseDetails);
		assertEquals(1,courseDetails.size());
	}
}

