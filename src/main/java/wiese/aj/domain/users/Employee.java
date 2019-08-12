package wiese.aj.domain.users;

import java.util.Objects;

public class Employee {
    private String employeeID;
    private String fName;
    private String lName;

    private Employee()
    {

    }

    public Employee(Builder builder){
        this.employeeID = builder.employeeID;
        this.fName = builder.fName;
        this.lName = builder.lName;
    }

    public String getEmployeeID(){
        return employeeID;
    }

    public String getFName(){
        return fName;
    }

    public String getLName(){
        return lName;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public static class Builder{
        private String employeeID;
        private String fName;
        private String lName;

        public Builder employeeID(String id){
            this.employeeID = id;
            return this;
        }

        public Builder fName(String first){
            this.fName = first;
            return this;
        }

        public Builder lName(String last){
            this.lName = last;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

    @Override
    public String toString(){
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", firstName='" + fName + '\''+
                ", lastName='" + lName + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID.equals(employee.employeeID);
    }

    @Override
    public int hashCode(){
        return Objects.hash(employeeID);
    }

}

