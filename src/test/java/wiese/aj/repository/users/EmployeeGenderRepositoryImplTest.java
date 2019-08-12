package wiese.aj.repository.users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiese.aj.domain.users.EmployeeGender;
import wiese.aj.factory.users.EmployeeGenderFactory;
import wiese.aj.repository.users.impl.EmployeeGenderRepositoryImpl;

import static junit.framework.TestCase.*;

public class EmployeeGenderRepositoryImplTest {

    private EmployeeGenderRepositoryImpl employeeEmployeeGenderRepository;

    @Before
    public void setUp() throws Exception {
        employeeEmployeeGenderRepository = EmployeeGenderRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
        assertEquals(employeeEmployeeGenderRepository.getAll(),employeeEmployeeGenderRepository.getAll());
    }

    @Test
    public void create(){
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGenderRepository.create(employeeEmployeeGender);

        Assert.assertNotNull(employeeEmployeeGenderRepository.getAll());
        System.out.println(employeeEmployeeGender);

    }

    @Test
    public void read(){
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGenderRepository.create(employeeEmployeeGender);

        EmployeeGender existing = employeeEmployeeGenderRepository.read(employeeEmployeeGender.getEmpNum());
        assertNotNull(existing);
        System.out.println(existing);
    }

    @Test
    public void update(){
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGenderRepository.create(employeeEmployeeGender);

        EmployeeGender employeeEmployeeGender1 = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGender1.setEmpNum(employeeEmployeeGender.getEmpNum());
        employeeEmployeeGenderRepository.update(employeeEmployeeGender1);
        System.out.println("Original: \n"+employeeEmployeeGender);
        System.out.println("Updated: \n"+employeeEmployeeGender1);

        EmployeeGender employeeEmployeeGender2 = employeeEmployeeGenderRepository.read(employeeEmployeeGender1.getEmpNum());
        assertEquals(employeeEmployeeGender1, employeeEmployeeGender2);
    }

    @Test
    public void delete(){
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.createEmployeeGender();
        employeeEmployeeGenderRepository.create(employeeEmployeeGender);

        EmployeeGender existing = employeeEmployeeGenderRepository.read(employeeEmployeeGender.getEmpNum());
        assertNotNull(existing);

        employeeEmployeeGenderRepository.delete(employeeEmployeeGender.getEmpNum());
        EmployeeGender deleted = employeeEmployeeGenderRepository.read(employeeEmployeeGender.getEmpNum());
        assertNull(deleted);
        System.out.println(deleted);
    }
}
