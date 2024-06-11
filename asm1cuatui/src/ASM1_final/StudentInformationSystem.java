/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM1_final;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Hieu 
 */
public class StudentInformationSystem {
    private List<Student> students;

    public StudentInformationSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent(String id, String name, double marks) {
        Optional<Student> studentOpt = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        studentOpt.ifPresent(student -> {
            student.setName(name);
            student.setMarks(marks);
        });
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
    }

    public Student searchStudentById(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Student> getStudents() {
        return students;
    }
}