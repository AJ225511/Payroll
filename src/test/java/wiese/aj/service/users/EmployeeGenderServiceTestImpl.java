package wiese.aj.service.users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiese.aj.domain.users.EmployeeGender;
import wiese.aj.factory.users.EmployeeGenderFactory;
import wiese.aj.service.users.impl.EmployeeGenderServiceImpl;

import static junit.framework.TestCase.*;

public class EmployeeGenderServiceTestImpl {
    private EmployeeGenderServiceImpl employeeEmployeeGenderService;

    @Before
    public void setUp() throws Exception {
        employeeEmployeeGenderService = EmployeeGenderServiceImpl.getService();
    }

    @Test
    public void getAll() {
        assertEquals(employeeEmployeeGenderService.getAll(),employeeEmployeeGenderService.getAll());
    }

    @Test
    public void create(){
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGenderService.create(employeeEmployeeGender);

        Assert.assertNotNull(employeeEmployeeGenderService.getAll());
        System.out.println(employeeEmployeeGender);

    }

    @Test
    public void read(){
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGenderService.create(employeeEmployeeGender);

        EmployeeGender existing = employeeEmployeeGenderService.read(employeeEmployeeGender.getEmpNum());
        assertNotNull(existing);
        System.out.println(existing);
    }

    @Test
    public void update(){
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGenderService.create(employeeEmployeeGender);

        EmployeeGender employeeEmployeeGender1 = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGender1.setEmpNum(employeeEmployeeGender.getEmpNum());
        employeeEmployeeGenderService.update(employeeEmployeeGender1);
        System.out.println("Original: \n"+employeeEmployeeGender);
        System.out.println("Updated: \n"+employeeEmployeeGender1);

        EmployeeGender employeeEmployeeGender2 = employeeEmployeeGenderService.read(employeeEmployeeGender1.getEmpNum());
        assertEquals(employeeEmployeeGender1, employeeEmployeeGender2);
    }

    @Test
    public void delete(){
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGenderService.create(employeeEmployeeGender);

        EmployeeGender existing = employeeEmployeeGenderService.read(employeeEmployeeGender.getEmpNum());
        assertNotNull(existing);

        employeeEmployeeGenderService.delete(employeeEmployeeGender.getEmpNum());
        EmployeeGender deleted = employeeEmployeeGenderService.read(employeeEmployeeGender.getEmpNum());
        assertNull(deleted);
        System.out.println(deleted);
    }
}
