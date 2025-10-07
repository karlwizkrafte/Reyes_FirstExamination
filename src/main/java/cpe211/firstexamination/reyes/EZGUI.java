package cpe211.firstexamination.reyes;

import static cpe211.kvx.jcandyexamedition.Std.*;
import java.util.Scanner;

public class EZGUI {
    
    private StudentDataHandlerAPI.StudMan studMan;
    private Scanner scanner;
    
    public EZGUI() {
        this.studMan = new StudentDataHandlerAPI.StudMan();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        clear();
        println("STUDENT DATA MANAGEMENT SYSTEM");
        newl();
        
        while (true) {
            showMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    println("Exiting...");
                    newl();
                    return;
                default:
                    println("Invalid choice. Please try again.");
            }
            
            println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private void showMenu() {
        clear();
        println("BANBAN JUNIOR HIGHSCHOOL BASIC SYSTEM [VERSION 1]");
        newl();
        println("1. Add Student");
        println("2. View All Students");
        println("3. View Specific Student");
        println("4. Update Student");
        println("5. Exit");
        print("Enter your choice: ");
    }
    
    private int getChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void addStudent() {
        clear();
        println("ADD STUDENT");
        newl();

        print("Enter full name: ");
        String name = scanner.nextLine();
        
        print("Enter address: ");
        String address = scanner.nextLine();
        
        print("Enter grade level: ");
        int gradeLevel = Integer.parseInt(scanner.nextLine());
        
        print("Enter gender: ");
        String gender = scanner.nextLine();
        
        print("Enter GWA: ");
        double gwa = Double.parseDouble(scanner.nextLine());
        
        studMan.addStudent(name, address, gradeLevel, gender, gwa);
        println("Student added successfully!");
    }
    
    private void viewAllStudents() {
        clear();
        println("ALL STUDENTS");
        newl();
        
        if (studMan.getTotalStudents() == 0) {
            println("No students found.");
            return;
        }
        
        for (int i = 0; i < studMan.getTotalStudents(); i++) {
            StudentDataHandlerAPI.StudentData student = studMan.getStudent(i);
            printf("%d. %s - %s - Grade %d - %s - GWA: %.0f%% - %s%n", 
                i + 1, student.getName(), student.getAddr(), student.getGlvl(), 
                student.getGndr(), student.getGwa(), student.getRemarks());
        }
    }
    
    private void viewStudent() {
        clear();
        println("STUDENT VIEWER");
        newl();
        
        if (studMan.getTotalStudents() == 0) {
            println("No students found.");
            return;
        }
        
        printf("Enter student number (1-%d): ", studMan.getTotalStudents());
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        newl();
        StudentDataHandlerAPI.StudentData student = studMan.getStudent(index);
        if (student != null) {
            println("\033[1mFull Name:\033[0m " + student.getName());
            println("\033[1mAddress:\033[0m " + student.getAddr());
            println("\033[1mGrade Level:\033[0m " + student.getGlvl());
            println("\033[1mGender:\033[0m " + student.getGndr());
            printf("\033[1mGWA:\033[0m %.0f%%\n", student.getGwa());
            println("\033[1mRemarks:\033[0m " + student.getRemarks());
        } else {
            println("Student not found.");
        }
    }
    
    private void updateStudent() {
        clear();
        println("UPDATE STUDENT");
        newl();
        
        if (studMan.getTotalStudents() == 0) {
            println("No students found.");
            return;
        }
        
        printf("Enter student number to update (1-%d): ", studMan.getTotalStudents());
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        
        StudentDataHandlerAPI.StudentData student = studMan.getStudent(index);
        if (student == null) {
            println("Student not found.");
            return;
        }
        
        println("Current data: " + student.getName());
        print("Enter new full name: ");
        String name = scanner.nextLine();
        
        print("Enter new address: ");
        String address = scanner.nextLine();
        
        print("Enter new grade level: ");
        int gradeLevel = Integer.parseInt(scanner.nextLine());
        
        print("Enter new gender: ");
        String gender = scanner.nextLine();
        
        print("Enter new GWA: ");
        double gwa = Double.parseDouble(scanner.nextLine());
        
        if (studMan.updateStudent(index, name, address, gradeLevel, gender, gwa)) {
            println("Student updated successfully!");
        } else {
            println("Failed to update student.");
        }
    }
}
