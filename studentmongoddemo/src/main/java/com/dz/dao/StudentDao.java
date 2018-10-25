package com.dz.dao;

import com.dz.model.Student;

import java.util.List;

public interface StudentDao {
    public void addStudent(Student student);
    public List display();
    public void deleteById(int roll_no);
    public void updateById(Student student);

}
