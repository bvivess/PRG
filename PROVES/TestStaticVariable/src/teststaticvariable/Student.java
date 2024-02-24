package teststaticvariable;

class Student{  
    int rollno;//instance variable  
    String name;  
    static String college ="ITS";//static variable  
    
    //constructor  
    Student(int r, String n){  
        rollno = r;  
        name = n;  
    }  
      
    void display (){
            System.out.println(rollno+" "+name+" "+college);
    }
} 