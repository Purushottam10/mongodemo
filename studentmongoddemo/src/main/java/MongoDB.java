import java.io.*;
import java.rmi.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Iterator;

import com.dz.model.Student;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;


/**
 *Operational Class
 */
public class MongoDB {
      private Student student;
      private BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
      private MongoClient mongoClient;
      private MongoDatabase mongoDatabase;
      private MongoCollection<Document> mongoCollection=null;
      private MongoCredential credential;

    /**
     * To Start the connection
     */

    public  MongoDB(){
        mongoClient = new MongoClient("localhost", 27017 );
        credential=MongoCredential.createCredential("admin ","admin","admin123".toCharArray());
        mongoDatabase = mongoClient.getDatabase("admin");
        mongoCollection = mongoDatabase.getCollection("student");
           }//constructor end
    /**
     * to add New Student
     */
    public void addStudent() {
          String name=null ;
          Integer roll_no=1;
          Integer age =0;

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

        //  System.out.println("sucess message   "+ mongoDatabase.getName()+"   "+mongoCollection.getNamespace());
          Document document=new Document("roll_no",student.getRoll_no())
                  .append("name",student.getName())
                  .append("age",student.getAge());
          mongoCollection.insertOne(document);
          System.out.println("data inserted ");


      }// addStudent method end




    /**
     * to display the record from database
     */
    public void display(){

        FindIterable<Document> cursor=null;
       try {
              cursor =mongoCollection.find();
        }catch (NullPointerException ex ){
           ex .printStackTrace();
       }
    //   to display from data base
                try{
           for(Document doc :cursor){
               System.out.println(doc.toJson());
           }
       }catch (NullPointerException ex ){
           ex.printStackTrace();
       }

    }//method end



    /**
     * show specific Detail
     */

    public void displayBYId (int roll_no){


        BasicDBObject searchQuery=new BasicDBObject();

        searchQuery.put("roll_no",roll_no);


        FindIterable<Document> cursor=mongoCollection.find(searchQuery);
          /*  mongoCollection.fi*/
        for(Document doc : cursor){
            System.out.println(doc.toJson());
        }

    }// displayById method end

    /**
     * Delete  record  by roll No
     */
    public void deleteById(int roll_no){
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("roll_no", roll_no);

       mongoCollection.deleteMany(searchQuery);
        System.out.println("record deleted");

    }//delete method end

    /**
     * Update record by id
     */
    public void updateById(int roll_no){
        BasicDBObject query = new BasicDBObject();
        query.put("roll_no", roll_no);

        String name=null ;
        Integer age =0;
        student = new Student();
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
           mongoCollection=mongoDatabase.getCollection("student");

           mongoCollection.updateOne(Filters.eq("roll_no",student.getRoll_no()), Updates.set("name",student.getName()));
           mongoCollection.updateOne(Filters.eq("roll_no",student.getRoll_no()),Updates.set("age",student.getAge()));

    }//update method end

}//class end
