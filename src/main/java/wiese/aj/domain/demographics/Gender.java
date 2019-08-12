package wiese.aj.domain.demographics;

import java.util.Objects;

public class Gender {

    private String genderID;
    private String genderType;

    private Gender()
    {

    }

    public Gender(Builder builder){
        this.genderType = builder.genderType;
        this.genderID = builder.genderID;
    }

    public String getGenderID(){
        return genderID;
    }

    public String getGenderType(){
        return genderType;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public static class Builder{
        private String genderID;
        private String genderType;

        public Builder genderID(String id){
            this.genderID = id;
            return this;
        }

        public Builder genderType(String type){
            this.genderType = type;
            return this;
        }

        public Gender build(){
            return new Gender(this);
        }
    }

    @Override
    public String toString(){
        return "Gender{" +
                "genderID='" + genderID + '\'' +
                ", genderType='" + genderType + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return genderID.equals(gender.genderID);
    }

    @Override
    public int hashCode(){
        return Objects.hash(genderID);
    }

}
