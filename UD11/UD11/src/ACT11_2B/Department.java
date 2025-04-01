package ACT11_2B;

/**
 *
 * @author Administrador
 */
public class Department {
    private int department_id;
    private String departmentName;

    public Department(int department_id, String departmentName) {
        this.department_id = department_id;
        this.departmentName = departmentName;
    }
    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.department_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        return this.department_id == other.department_id;
    }
    
    @Override
    public String toString() {
        return "Department{" + "department_id=" + department_id + ", departmentName=" + departmentName + '}';
    }
    
}
