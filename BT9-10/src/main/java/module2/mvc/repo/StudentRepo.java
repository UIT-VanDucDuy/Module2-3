package main.java.module2.mvc.repo;

import main.java.module2.mvc.entity.Student;
import main.java.module2.mvc.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo {
    private final String File_Student_Path = "src/module2.mvc/data/student.csv";
    @Override
    public void add(Student student) {
        List<String> listStudent= new ArrayList<>();
        listStudent.add(student.toString());
        ReadAndWriteFile.writeListToCSV(File_Student_Path,listStudent,true);

    }

    @Override
    public boolean delete(Student student) {
        boolean isDeleted = false;
        List<Student> studentsList = getStudents();
        for(int i = 0; i<studentsList.size(); i++){
            if (studentsList.get(i).getCode().equals(student.getCode())){
                studentsList.remove(i);
                isDeleted = true;
                break;
            }
        }
        List<String> StringList = new ArrayList<>();
        for(Student s : studentsList){
            StringList.add(s.toString());
        }
        ReadAndWriteFile.writeListToCSV(File_Student_Path,StringList,false);
        return isDeleted;
    }

    @Override
    public List<Student> getStudents() {
//        int id, String code, String name, int gender, String address,long score,String classCode
        List<Student> studentsList = new ArrayList<>();
        List<String> StringList = ReadAndWriteFile.readFileCSV(File_Student_Path);
        String[] array=null;
        for(String line : StringList){
            array = line.split("\\s*,\\s*");
            Student student = new Student(Integer.parseInt(array[0]),
                    array[1],array[2],Integer.parseInt(array[3]),array[4],Long.parseLong(array[5]),array[6]);
            studentsList.add(student);
        }
        return studentsList;
    }
}
