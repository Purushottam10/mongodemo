package com.dz;

import com.dz.dao.StudentService;
import com.dz.dao.StudentDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    /**
     * main method class
     */
    public static class Main {
        public static void main(String[] args) throws IOException {
            int choice = 0;
            int roll_no = 1;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StudentService mgdb = new StudentService();
            StudentDAO studentDAO = new StudentDAO();


            do {
                System.out.print("Enter your choice");
                System.out.println("\n1 for Insert \n2 for Display \n3 for Display By Id "
                        + "\n4 for Remove data  \n5 for Update data  \n6.Exit");
                try {
                    choice = Integer.parseInt(bufferedReader.readLine());
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                if (choice == 1) {
                    mgdb.addStudent();
                }//end of First if
                else if (choice == 2) {
                    mgdb.display();
                }//end of second if
                else if (choice == 3) {
                    System.out.println("enter Student Roll no");

                    try {
                        roll_no = Integer.parseInt(bufferedReader.readLine());
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                    mgdb.DisplayById(roll_no);
                }//end of if
                else if (choice == 4) {
                    System.out.println("enter Student Roll No ");

                    try {
                        roll_no = Integer.parseInt(bufferedReader.readLine());
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                    mgdb.deleteById(roll_no);
                }//end of if
                else if (choice == 5) {
                    System.out.println("enter Student Roll No ");

                    try {
                        roll_no = Integer.parseInt(bufferedReader.readLine());
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                    mgdb.updateById(roll_no);
                }//end of if
                else if (choice == 6) {
                    System.exit(0);
                } else {
                    System.out.println("it's a wrong choice ");
                }
            } while (true);

        }//main method end

    }//class end
}
