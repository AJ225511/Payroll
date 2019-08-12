package wiese.aj.factory.users;

import wiese.aj.domain.users.EmployeeGender;
import wiese.aj.util.Misc;

public class EmployeeGenderFactory {
    public static EmployeeGender createEmployeeGender(){
        return new EmployeeGender.Builder()
                .empNum(Misc.generateId())
                .genderID(Misc.generateId())
                .build();
    }
}
