package com.dz.dao;

import java.io.*;

import com.dz.model.Student;
import com.mongodb.client.FindIterable;
import org.bson.Document;


/**
 *Operational Class
 */
public class MongoDB {

      private Student student;
      private BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
      private StudetnDAO studentDao;

    /**
     * To Start the connection
     */

  
    public void addStudent() {
          String name=null ;
          Integer roll_no=1;
          Integer age =0;

           studentDao =new StudetnDAO();
          student = new Student();
          System.out.println("enter the student Roll NO ");
          try{
              roll_no=Integer.parseInt(bufferedReader.readLine());
          }catch (IOException e){
              e.printStackTrace();
          }
          System.out.println("enter the Student Name");

             try{ name=bufferedReader.readLine();

          System.out.println("enter the age of student ");

              age=Integer.parseInt( bufferedReader.readLine());

          }catch (IOException ex){
              ex.printStackTrace();
          }
          student.setRoll_no(roll_no);
          student.setName(name);
          student.setAge(age);

       studentDao.addStudent(student);

      }// addStudent method end


public void display(){

        studentDao =new StudetnDAO();
        FindIterable<Document> cursor   = studentDao.display();
      try{
          for(Document doc :cursor){

            System.out.println(doc.toJson());
        }
    }catch (NullPointerException ex ){
        ex.printStackTrace();
    }

}// method end


    /**
     * show specific Detail
     */
public void DisplayById(int roll_no){

    studentDao =new StudetnDAO();

    FindIterable<Document> cursor = studentDao.DisplayById(roll_no);
    for (Document doc : cursor) {
        System.out.print("hello world in mongo Db ");
        System.out.println(doc.toJson());
    }

}
//method end


    public void deleteById(int roll_no){
          studentDao =new StudetnDAO();
          studentDao.deleteById(roll_no);
    }//method end
    /**
     * Update record by id
     */
    public void updateById(int roll_no) throws  IOException{
      /*
*/
       studentDao =new StudetnDAO();
        String name=null ;
        Integer age =0;
        student = new Student();
        System.out.println("enter the Student Name");
        name=bufferedReader.readLine();


        try{
            System.out.println("enter the age of student ");
            age=Integer.parseInt( bufferedReader.readLine());

        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        student.setRoll_no(roll_no);
        student.setName(name);
        student.setAge(age);
        studentDao.updateById(roll_no,student);


    }//update method end


}//class end
