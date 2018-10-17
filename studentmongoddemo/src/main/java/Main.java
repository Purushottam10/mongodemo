import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

/**
 * main method class
 */
public class Main {
    public static void main(String [] args ){

    MongoDB mgdb=new MongoDB();
     mgdb.addStudent();

     //   mgdb.addData();
       mgdb.display();




    }
}
