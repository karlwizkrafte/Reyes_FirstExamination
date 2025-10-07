package cpe211.firstexamination.reyes;

import java.util.ArrayList;
import java.util.List;

public class StudentDataHandlerAPI {
    
    // Student Data
    public static class StudentData {

        private String name; // Full name
        private String addr; // Home Adress
        private int    glvl; // Grade Level
        private String gndr; // Gender
        private double gwa ; // General Weighted

        public StudentData(String name, String addr, int glvl, String gndr, double gwa) {

            this.name = name;
            this.addr = addr;
            this.glvl = glvl;
            this.gndr = gndr;
            this.gwa  = gwa ;

        }

        // (f1) FETCH DATA
        public String getName() { return name; }
        public String getAddr() { return addr; }
        public int    getGlvl() { return glvl; }
        public String getGndr() { return gndr; }
        public double getGwa()  { return gwa;  }

        // (f2) Manipulator Section

        public void setName(String name)    { this.name = name; }
        public void setAddr(String addr)    { this.addr = addr; }
        public void setGlvl(int glvl)       { this.glvl = glvl; }
        public void setGndr(String gndr)    { this.gndr = gndr; }
        public void setGwa(double gwa)      { this.gwa = gwa; }

        // (f3) Functional Logics

        public String getRemarks() {
            if (gwa >= 75) {
            return "PASSED";
            } else {
            return "FAILED";
            }
        }

    }

    // Student Manager Basic
    public static class StudMan {
        
        private List<StudentData> students;

        public StudMan() {
            this.students = new ArrayList<>();
        }

        public void addStudent(String fullName, String address, int gradeLevel, String gender, double gwa) {
            StudentData student = new StudentData(fullName, address, gradeLevel, gender, gwa);
            students.add(student);
        }

        public List<StudentData> getAllStudents() {
            return new ArrayList<>(students);
        }

        public StudentData getStudent(int index) {
            if (index >= 0 && index < students.size()) {
                return students.get(index);
            }
            return null;
        }

        public int getTotalStudents() {
            return students.size();
        }

        public boolean updateStudent(int index, String fullName, String address, int gradeLevel, String gender, double gwa) {
            if (index >= 0 && index < students.size()) {
                StudentData student = students.get(index);
                student.setName(fullName);
                student.setAddr(address);
                student.setGlvl(gradeLevel);
                student.setGndr(gender);
                student.setGwa(gwa);
                return true;
            }
            return false;
        }

    }

}
