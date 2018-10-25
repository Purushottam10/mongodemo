package com.dz.dao;

import com.dz.config.DBConnection;
import com.dz.model.Student;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Model and  Performe database operation
 */
public class StudentDAO {
      private  DBConnection connection;
    /**
     * @param  student
     * @return true if data added in the Data base
     */
    public void addStudent(Student student){
         connection=new DBConnection();

        if(student.getAge()==0){
            System.out.println("not valid Age ");
        }
   else {
            MongoDatabase mongoDatabase = connection.getConnection().getDatabase("admin");
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("student");
            Document document = new Document("roll_no", student.getRoll_no())
                    .append("name", student.getName())
                    .append("age", student.getAge());
            mongoCollection.insertOne(document);
            System.out.println("data inserted ");
        }
    }//addStudent Method End

    /**
     * to Display the list of Student from Database
     */
    public  List display(){
        connection =new DBConnection();
        connection.getConnection();

        MongoDatabase mongoDatabase=connection.getConnection().getDatabase("admin");
        MongoCollection<Document> mongoCollection=mongoDatabase.getCollection("student");
        FindIterable<Document> cursor=null;
          List<Document> studentList=(List<Document>) mongoCollection.find().into(new ArrayList<Document>());
           // cursor =mongoCollection.find();
            //return  cursor;
      return studentList;

        //   to display from data base

    }//Display Method end


    /**
     * Delete  record  by roll No
     */
    public void deleteById(int roll_no){
        connection =new DBConnection();
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("roll_no", roll_no);
        MongoDatabase mongoDatabase=connection.getConnection().getDatabase("admin");
        MongoCollection<Document> mongoCollection=mongoDatabase.getCollection("student");
        mongoCollection.deleteMany(searchQuery);
        System.out.println("record deleted");

    }//delete method end

    public void updateById(Student student){
        connection =new DBConnection();
        BasicDBObject query = new BasicDBObject();
        query.put("roll_no", student.getRoll_no());
        MongoDatabase mongoDatabase=connection.getConnection().getDatabase("admin");
        MongoCollection<Document> mongoCollection=mongoDatabase.getCollection("student");
        mongoCollection.updateOne(Filters.eq("roll_no",student.getRoll_no()), Updates.set("name",student.getName()));
        mongoCollection.updateOne(Filters.eq("roll_no",student.getRoll_no()),Updates.set("age",student.getAge()));
        System.out.println("database updated ");
    }//method end

}//class end
