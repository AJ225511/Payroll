package wiese.aj.factory.users;

import org.junit.Test;
import wiese.aj.domain.users.Employee;

import static junit.framework.TestCase.assertNotNull;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee(){

        Employee e = EmployeeFactory.createEmployee("AJ", "Wiese");
        assertNotNull(e);
    }
}
