package wiese.aj.factory.users;

import wiese.aj.domain.users.Employee;
import wiese.aj.util.Misc;

public class EmployeeFactory {
    public static Employee createEmployee(String f, String l){
        return new Employee.Builder()
                .employeeID(Misc.generateId())
                .fName(f)
                .lName(l)
                .build();
    }
}
