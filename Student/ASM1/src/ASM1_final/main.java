/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM1_final;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        StudentInformationSystem student = new StudentInformationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new student");
            System.out.println("2. View all students");
            System.out.println("3. Sort students by marks");
            System.out.println("4. Search for a student by ID");
            System.out.println("5. Edit a student's details");
            System.out.println("6. Delete a student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            // Handling non-integer inputs
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear the invalid input
                System.out.print("Enter your choice: ");
            }
            
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    addStudent(student, scanner);
                    break;
                case 2:
                    student.printStudents();
                    break;
                case 3:
                    student.sortStudents();
                    System.out.println("\nSorted Students by Marks:");
                    student.printStudents();
                    break;
                case 4:
                    searchStudentById(student, scanner);
                    break;
                case 5:
                    editStudent(student, scanner);
                    break;
                case 6:
                    deleteStudent(student, scanner);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void addStudent(StudentInformationSystem student, Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        student.addStudent(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void searchStudentById(StudentInformationSystem student, Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        String searchId = scanner.nextLine();
        Student foundStudent = student.searchStudentById(searchId);
        if (foundStudent != null) {
            System.out.println("Found Student - ID: " + foundStudent.getId() + ", Name: " + foundStudent.getName() + ", Marks: " + foundStudent.getMarks() + ", Ranking: " + foundStudent.getRanking());
        } else {
            System.out.println("Student not found.");
        }
    }

private static void editStudent(StudentInformationSystem student, Scanner scanner) {
    System.out.print("Enter Student ID to edit: ");
    String editId = scanner.nextLine();
    Student studentToEdit = student.searchStudentById(editId);
    
    if (studentToEdit == null) {
        System.out.println("Student not found. Returning to menu.");
        return;  // Exit the method and return to the menu
    }

    System.out.print("Enter new Student Name: ");
    String newName = scanner.nextLine();
    System.out.print("Enter new Student Marks: ");
    double newMarks = scanner.nextDouble();
    scanner.nextLine();  // Consume newline

    student.editStudent(editId, newName, newMarks);
    System.out.println("Student details updated.");
}


    private static void deleteStudent(StudentInformationSystem student, Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        String deleteId = scanner.nextLine();
        if (student.deleteStudent(deleteId)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
