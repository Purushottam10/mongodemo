import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * main method class
 */
public class Main {
    public static void main(String [] args ) throws IOException {
        int choice = 0;
        int roll_no=1;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    MongoDB mgdb=new MongoDB();

       do{
           System.out.print("Enter your choice");
           System.out.println("\n1 for Insert \n2 for Display \n3 for Display By Id "
                   + "\n4 for Remove data  \n5 for Update data  \n6.Exit");
           try {
               choice=Integer.parseInt(bufferedReader.readLine());
           }catch (NumberFormatException ex ){
               ex.printStackTrace();
           }
           if(choice==1){
               mgdb.addStudent();
           }//end of First if
           else if (choice==2){
               mgdb.display();
           }//end of second if
           else if (choice==3){
               System.out .println("enter Student id ");

               try{
               roll_no=Integer.parseInt(bufferedReader.readLine());
               }catch (NumberFormatException ex){
                   ex.printStackTrace();
               }
           mgdb.displayBYId(roll_no);
           }//end of if
           else if (choice==4) {
               System.out.println("enter Student Roll No ");

               try {
                   roll_no = Integer.parseInt(bufferedReader.readLine());
               } catch (NumberFormatException ex) {
                   ex.printStackTrace();
               }
               mgdb.deleteById(roll_no);
           }//end of if
           else if (choice==5) {
               System.out.println("enter Student Roll No ");

               try {
                   roll_no = Integer.parseInt(bufferedReader.readLine());
               } catch (NumberFormatException ex) {
                   ex.printStackTrace();
               }
               mgdb.updateById(roll_no);
           }//end of if
           else  if(choice==6){
               System.exit(0);
           }
           else {
               System.out.println("it's a wrong choice ");
           }
       }while(true);

    }//main method end

}//class end
