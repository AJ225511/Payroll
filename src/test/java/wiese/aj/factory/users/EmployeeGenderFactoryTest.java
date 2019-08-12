package wiese.aj.factory.users;

import org.junit.Test;
import wiese.aj.domain.users.EmployeeGender;

import static junit.framework.TestCase.assertNotNull;

public class EmployeeGenderFactoryTest {

    @Test
    public void getEmpGender(){

        EmployeeGender eG = EmployeeGenderFactory.createEmployeeGender();
        assertNotNull(eG);
    }
}
