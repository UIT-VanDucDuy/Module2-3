package main.java.module2.mvc.repo;

import main.java.module2.mvc.entity.Teacher;
import main.java.module2.mvc.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements ITeacherRepo {
    private final String File_Teacher_Path = "src/module2.mvc/data/teacher.csv";

    @Override
    public void add(Teacher teacher) {

    }

    @Override
    public boolean remove(Teacher teacher) {
        boolean isDeleted = false;
        List<Teacher> teacherList = getTeachers();
        for(int i = 0; i<teacherList.size(); i++){
            if (teacherList.get(i).getCode().equals(teacher.getCode())){
                teacherList.remove(i);
                isDeleted = true;
                break;
            }
        }
        List<String> StringList = new ArrayList<>();
        for(Teacher t : teacherList){
            StringList.add(t.toString());
        }
        ReadAndWriteFile.writeListToCSV(File_Teacher_Path,StringList,false);
        return isDeleted;
    }

    @Override
    public List<Teacher> getTeachers() {
        //        int id, String code, String name, int gender, String address,String subject
        List<Teacher> teacherListList = new ArrayList<>();
        List<String> StringList = ReadAndWriteFile.readFileCSV(File_Teacher_Path);
        String[] array=null;
        for(String line : StringList){
            array = line.split("\\s*,\\s*");
            Teacher teacher = new Teacher(Integer.parseInt(array[0]),
                    array[1],array[2],Integer.parseInt(array[3]),array[4],array[5]);
            teacherListList.add(teacher);
        }
        return teacherListList;
    }
}
