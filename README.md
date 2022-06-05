# Pre-requisites
* Java 1.8/1.11/1.15
* Maven

# Goal
Your job is to build a simple command line application, which does the following:

* Add course offering

         A course offering has course title, instructor and date. 
         It should also contain a minimum & maximum number of employees for the course offering. 
         
* Register for the course

          Employees can register for the courses. 
          
         If no. of employees registered for the course has reached the maximum, the result will be COURSE_FULL_ERROR. 
         
         Otherwise, result of registration will be ACCEPTED. 
         
* Cancel registration

         Employees can cancel their registration until the course allotment is completed. 
         
* Course allotment
         This feature allots employees to course offering, before the course offering date. 
         
         It should print a list of all the employees with their details along with their final course allotment status (Registration Number, Employee Name, Email, Course Offering ID, Course Name, Instructor, Date, Final Status). The list should be sorted based on the Registration number. 
         
         If sufficient registrations are not received then the course offering itself gets cancelled. 
         
         The employees who have registered will get confirmed unless the minimum number of registrations is not received. 
         
         Even if the course offering gets canceled due to the minimum number of employees not registered, the list should be printed. 


# Sample Input
ADD-COURSE-OFFERING DATASCIENCE BOB 05062022 1 3

REGISTERWOO@GMAIL.COM OFFERING-DATASCIENCE-BOB

REGISTERANDY@GMAIL.COM OFFERING-DATASCIENCE-BOB

ALLOTOFFERING-DATASCIENCE-BOB	OFFERING-DATASCIENCE-BOB

# Sample output
REG-COURSE-WOO-DATASCIENCE ACCEPTED

REG-COURSE-ANDY-DATASCIENCE ACCEPTED

REG-COURSE-ANDY-DATASCIENCE ANDY@GMAIL.COM OFFERING-DATASCIENCE-BOB DATASCIENCE BOB 05062022 CONFIRMED

REG-COURSE-WOO-DATASCIENCE WOO@GMAIL.COM OFFERING-DATASCIENCE-BOB DATASCIENCE BOB 05062022 CONFIRMED

# Assumptions

     If there is validation error in the input (data validation or mandatory fields missing) then it should print an error message INPUT_DATA_ERROR. 
     Employees can only cancel their registration until the course is allotted. 
     Instructor names are unique 
     Course names are unique 
     None of the input fields accept whitespace (whitespace acts as a delimiter between fields) 
     Course offering ID generated is a combination of OFFERING-<COURSENAME>-<INSTRUCTORNAME> 
     Registration ID generated is a combination of REG-COURSE-<EMPLOYEENAME>-<COURSENAME> 
     <EMPLOYEENAME> is extracted from email ID: everything before the @ sign in the email

# How to run the code

We have provided scripts to execute the code. 

Use `run.sh` if you are Linux/Unix/macOS Operating systems and `run.bat` if you are on Windows.  Both the files run the commands silently and prints only output from the input file `sample_input/input1.txt`. You are supposed to add the input commands in the file from the appropriate problem statement. 

Internally both the scripts run the following commands 

 * `mvn clean install -DskipTests assembly:single -q` - This will create a jar file `geektrust.jar` in the `target` folder.
 * `java -jar target/geektrust.jar sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument

 We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

 Use the pom.xml provided along with this project. Please change the main class entry (`<mainClass>com.example.geektrust.Main</mainClass>`) in the pom.xml if your main class has changed.

 # Running the code for multiple test cases

 Please fill `input1.txt` and `input2.txt` with the input commands and use those files in `run.bat` or `run.sh`. Replace `java -jar target/geektrust.jar sample_input/input1.txt` with `java -jar target/geektrust.jar sample_input/input2.txt` to run the test case from the second file. 

 # How to execute the unit tests

 `mvn clean test` will execute the unit test cases.
