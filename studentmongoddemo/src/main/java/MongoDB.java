import java.io.*;
import java.rmi.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Iterator;

import com.dz.model.Student;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import javax.xml.transform.dom.DOMLocator;


/**
 *
 */
public class MongoDB {
      private Student student;
      private BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
      private MongoClient mongoClient;
      private MongoDatabase mongoDatabase;
      private MongoCollection<Document> mongoCollection=null;
      private MongoCredential credential;
    /**
     * to add New Student
     */
    public void addStudent() {
          String name=null ;
          Integer roll_no=1;
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
          connectionDB();
          mongoDatabase = mongoClient.getDatabase("admin");
          mongoCollection = mongoDatabase.getCollection("student");
        //  System.out.println("sucess message   "+ mongoDatabase.getName()+"   "+mongoCollection.getNamespace());
          Document document=new Document("roll_no",student.getRoll_no())
                  .append("name",student.getName())
                  .append("age",student.getAge());
          mongoCollection.insertOne(document);
          System.out.println("data inserted ");


      }// addStudent method end

    /**
     * to create a connection
     */
      public  void connectionDB() {
          /**
           * connect to Mongo Data base
           */
        //  MongoClientURI uri=new MongoClientURI();

          mongoClient = new MongoClient("localhost", 27017 );
          credential=MongoCredential.createCredential("admin ","admin","admin123".toCharArray());
      }//method end



    /**
     * to display the record from database
     */
    public void display(){
        connectionDB();// open the connection

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

    public void displayBYId (int roll){
        connectionDB();
        String roll_no=Integer.toString(roll);
        BasicDBObject searchQuery=new BasicDBObject();
        searchQuery.put("roll_no",roll_no);

        FindIterable<Document> cursor=mongoCollection.find(searchQuery);

        for(Document doc : cursor){
            System.out.println(doc.get(roll_no));
        }

    }//method end

}//class end
