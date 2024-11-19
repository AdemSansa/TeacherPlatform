package tn.rnu.isetr.tp;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {

    private ArrayList<Teacher> teacherList;
    private ArrayList<String> teacherNames;

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;

        updateTeacherNames();
    }

    public ArrayList<String> getTeacherNames() {
        return teacherNames;
    }

    private void updateTeacherNames() {
        teacherNames = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            teacherNames.add(teacher.getName());
        }
    }
}