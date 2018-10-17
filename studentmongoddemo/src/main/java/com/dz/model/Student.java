package com.dz.model;



/**
 * Pojo class
 */
public class Student {
    private String name ;
    private  int  roll_no;
    private int age ;

    public Student(){

    }
/* public Student(int roll_no, String name, int age){
     setRoll_no(roll_no);
     setName(name);
     setAge(age);
 }*/
    /**
     *
     * @return name
     */
    public String getName() {

        return name;
    }

    /**
     *
     * @param name
     * @return local value
     */
    public void setName(String name) {
        this.name = name;

    }

    /**
     *
     * @return roll_no
     */
    public int getRoll_no() {
        return roll_no;
    }

    /**
     *
     * @param roll_no
     * @return local roll_no
     */
    public void  setRoll_no(int roll_no) {
        this.roll_no = roll_no;

    }

    /**
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     * @return lacal age
     */
    public void setAge(int age) {
        this.age = age;

    }
    /**
     * @Override toSting
     */
    @Override
    public  String toString(){
        return  name+" "+age;
    }

}
