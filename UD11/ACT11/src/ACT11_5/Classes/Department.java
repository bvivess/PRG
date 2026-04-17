package ACT11_5.Classes;

public class Department {
    private int departmentId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    private String departmentName;
    private int managerId;
    private int locationId;

    public Department(int departmentId, String departmentName, int managerId, int locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.departmentId;
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
        return this.departmentId == other.departmentId;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId=" + managerId + ", locationId=" + locationId + '}';
    }

}
