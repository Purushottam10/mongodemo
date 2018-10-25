package com.dz.service;

import java.io.IOException;

public interface StudentService {
    public void addStudent()throws IOException;
    public void display();
    public void DisplayById(int roll_no);
    public void deleteById(int roll_no);
    public void updateById(int roll_no)throws IOException;


}
