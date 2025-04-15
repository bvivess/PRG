package ACT11_5;

public class Department {
    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;

    public Department(int departmentId, String departmentName, int managerId, int locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

}
