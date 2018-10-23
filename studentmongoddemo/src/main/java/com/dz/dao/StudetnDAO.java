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

/**
 * Data Access Model to Performe
 */
public class StudetnDAO {
      private  DBConnection connection;
    /**
     * @param  student
     * @return true if data added in the Data base
     */
    public void addStudent(Student student){
         connection=new DBConnection();



           MongoDatabase mongoDatabase=connection.getConnection().getDatabase("admin");
           MongoCollection<Document> mongoCollection=mongoDatabase.getCollection("student");
           System.out.println(student.getRoll_no()+" "+student.getAge()+"  "+student.getName());
                 Document document=new Document("roll_no",student.getRoll_no())
                .append("name",student.getName())
                .append("age",student.getAge());
                 mongoCollection.insertOne(document);
       System.out.println("data inserted ");

    }//addStudent Method End

    /**
     * to Display the list of Student from Database
     */
    public  FindIterable display(){
        connection =new DBConnection();
        connection.getConnection();

        MongoDatabase mongoDatabase=connection.getConnection().getDatabase("admin");
        MongoCollection<Document> mongoCollection=mongoDatabase.getCollection("student");
        FindIterable<Document> cursor=null;

            cursor =mongoCollection.find();
            return  cursor;


        //   to display from data base

    }//Display Method end

    /**
     *
     * @param roll_no
     */
    public FindIterable<Document> DisplayById (int roll_no){

         connection=new DBConnection();
        BasicDBObject searchQuery=new BasicDBObject();

        searchQuery.put("roll_no",roll_no);

        MongoDatabase mongoDatabase=connection.getConnection().getDatabase("admin");
        MongoCollection<Document> mongoCollection=mongoDatabase.getCollection("student");
        FindIterable<Document> cursor=mongoCollection.find(searchQuery);
       return  cursor;


    }// displayById method end
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

    public void updateById(int roll_no,Student student){
        connection =new DBConnection();
        BasicDBObject query = new BasicDBObject();
        query.put("roll_no", roll_no);
        MongoDatabase mongoDatabase=connection.getConnection().getDatabase("admin");
        MongoCollection<Document> mongoCollection=mongoDatabase.getCollection("student");
        mongoCollection.updateOne(Filters.eq("roll_no",student.getRoll_no()), Updates.set("name ",student.getName()));
        mongoCollection.updateOne(Filters.eq("roll_no",student.getRoll_no()),Updates.set("age",student.getAge()));
        System.out.println("database updated ");
    }//method end

}//class end
