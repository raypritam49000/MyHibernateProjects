package com.hibernate.main.crudhibernate;

import com.hibernate.main.dao.TeacherDao;
import com.hibernate.main.dto.TeacherDto;
import com.hibernate.main.model.Teacher;

public class AppMain {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        TeacherDto.insertTeacher(teacher);
        TeacherDto.updateTeacher(teacher);
        TeacherDao.getTeacher(teacher);
        TeacherDto.deleteTeacher(teacher);
        
    }
}
