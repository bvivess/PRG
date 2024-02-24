package teststaticvariable;
 
public class TestStaticVariable{  
    public static void main(String args[]){  
    Student s1 = new Student(111,"Karan");  
    Student s2 = new Student(222,"Aryan");  
    //
    Student.college = "PIMPAM";
    System.out.println(s1);
    s1.display();    
    s2.display();
    }  
} 