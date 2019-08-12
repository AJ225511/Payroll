package wiese.aj.domain.users;

public class EmployeeGender {
    private String genderID;
    private String empNum;

    private EmployeeGender(){

    }

    public EmployeeGender(Builder builder){
        this.empNum = builder.empNum;
        this.genderID = builder.genderID;
    }

    public String getEmpNum(){
        return empNum;
    }

    public String getRaceID(){
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    public static class Builder{
        private String genderID;
        private String empNum;

        public Builder genderID(String id){
            this.genderID = id;
            return this;
        }

        public Builder empNum(String empNu){
            this.empNum = empNu;
            return this;
        }

        public EmployeeGender build(){
            return new EmployeeGender(this);
        }
    }

    @Override
    public String toString(){
        return "EmployeeGender{" +
                "genderID='" + genderID + '\'' +
                ", employeeNumber='" + empNum + '\''+
                '}';
    }
}
