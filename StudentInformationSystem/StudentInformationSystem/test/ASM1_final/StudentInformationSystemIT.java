package ASM1_final;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class StudentInformationSystemIT {
    
    private StudentInformationSystem system;
    
    @BeforeEach
    public void setUp() {
        system = new StudentInformationSystem();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("S001", "John Doe", 8.5);
        system.addStudent(student);
        assertEquals(1, system.getStudents().size());
        assertEquals(student, system.getStudents().get(0));
    }

    @Test
    public void testEditStudent() {
        Student originalStudent = new Student("S001", "John Doe", 8.5);
        system.addStudent(originalStudent);
        
        // Edit the student without changing the ID
        system.editStudent("S001", "Jane Doe", 9.0);
        Student editedStudent = system.searchStudentById("S001");
        assertNotNull(editedStudent);
        assertEquals("Jane Doe", editedStudent.getName());
        assertEquals(9.0, editedStudent.getMarks());
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("S001", "John Doe", 8.5);
        system.addStudent(student);
        boolean result = system.deleteStudent("S001");
        assertTrue(result);
        assertNull(system.searchStudentById("S001"));
    }

    @Test
    public void testSortStudents() {
        system.addStudent(new Student("S002", "Alice Smith", 7.0));
        system.addStudent(new Student("S003", "Bob Brown", 9.0));
        system.addStudent(new Student("S001", "John Doe", 8.5));
        
        system.sortStudents();
        List<Student> sortedStudents = system.getStudents();
        assertEquals("S002", sortedStudents.get(0).getId()); // Alice Smith
        assertEquals("S001", sortedStudents.get(1).getId()); // John Doe
        assertEquals("S003", sortedStudents.get(2).getId()); // Bob Brown
    }

    @Test
    public void testSearchStudentById() {
        Student student = new Student("S001", "John Doe", 8.5);
        system.addStudent(student);
        Student foundStudent = system.searchStudentById("S001");
        assertNotNull(foundStudent);
        assertEquals("John Doe", foundStudent.getName());
    }

    @Test
    public void testGetStudents() {
        Student student1 = new Student("S001", "John Doe", 8.5);
        Student student2 = new Student("S002", "Alice Smith", 7.0);
        system.addStudent(student1);
        system.addStudent(student2);
        List<Student> students = system.getStudents();
        assertEquals(2, students.size());
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    public void testPrintStudents() {
        Student student1 = new Student("S001", "John Doe", 8.5);
        Student student2 = new Student("S002", "Alice Smith", 7.0);
        system.addStudent(student1);
        system.addStudent(student2);
        // This method will print to the console, and verifying it may involve capturing output.
        // For simplicity, the output verification is omitted.
        system.printStudents();
    }
}
