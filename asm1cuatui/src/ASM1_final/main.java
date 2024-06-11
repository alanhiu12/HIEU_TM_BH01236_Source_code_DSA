/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM1_final;
import java.util.Scanner;
/**
 *
 * @author Hieu
 */
public class main {
    public static void main(String[] args) {
        StudentInformationSystem sis = new StudentInformationSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            sis.addStudent(new Student(id, name, marks));
        }

        System.out.println("\nStudent Details and Rankings:");
        for (Student student : sis.getStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Marks: " + student.getMarks() + ", Ranking: " + student.getRanking());
        }

        // Example of sorting students by marks
        sis.sortStudents();
        System.out.println("\nSorted Students by Marks:");
        for (Student student : sis.getStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Marks: " + student.getMarks() + ", Ranking: " + student.getRanking());
        }

        // Example of searching for a student by ID
        System.out.print("\nEnter Student ID to search: ");
        String searchId = scanner.nextLine();
        Student foundStudent = sis.searchStudentById(searchId);
        if (foundStudent != null) {
            System.out.println("Found Student - ID: " + foundStudent.getId() + ", Name: " + foundStudent.getName() + ", Marks: " + foundStudent.getMarks() + ", Ranking: " + foundStudent.getRanking());
        } else {
            System.out.println("Student not found.");
        }

        scanner.close();
    }
}
