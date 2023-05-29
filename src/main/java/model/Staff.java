package model;

public class Staff {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone_number;
    private double salary;

    private int department_id;
    private String department_name;

    public Staff() {
    }
    public Staff(String name, String email, String address, String phone_number, double salary) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.salary = salary;
    }

    public Staff(int id,String name, String email, String address, String phone_number, double salary,String department_name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.salary = salary;
        this.department_name = department_name;
    }


    public Staff(String name, String email, String address, String phone_number, double salary,String department_name) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.salary = salary;
        this.department_name = department_name;
    }

    public Staff(int id, String name, String email, String address, String phone_number, double salary, int department_id, String department_name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.salary = salary;
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
