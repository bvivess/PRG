package ACT7_1C;

import java.util.ArrayList;

class SkilledEmployee extends Employee {
    private ArrayList<Employee> skillList;

    public SkilledEmployee(String name, String jobTitle, String level) {
        super(name,jobTitle, level);
        this.skillList = new ArrayList<>();
    }
    
    public boolean addEmployee(Employee e) {
        if (this.skillList.contains(e))
            return false;
        else {
            this.skillList.add(e);
            return true;
        }
    }
    
    public boolean removeEmployee(Employee e) {
        return this.skillList.remove(e);
    }
    
    @Override
    public String toString() {
        String text = "Manager {" + super.toString() + ", Employee List=";
        for (Employee e : this.skillList)
            text = text + "\n\t" + e.toString();
        return text + "}";
    }
    
}

