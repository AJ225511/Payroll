package wiese.aj.repository.users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiese.aj.domain.users.Employee;
import wiese.aj.factory.users.EmployeeFactory;
import wiese.aj.repository.users.impl.EmployeeRepositoryImpl;

import static junit.framework.TestCase.*;

public class EmployeeRepositoryImplTest {

    private EmployeeRepositoryImpl employeeRepository;

    @Before
    public void setUp() throws Exception {
        employeeRepository = EmployeeRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
        assertEquals(employeeRepository.getAll(),employeeRepository.getAll());
    }

    @Test
    public void create(){
        Employee employee = EmployeeFactory.createEmployee("AJ", "Wiese");
        employeeRepository.create(employee);

        Assert.assertNotNull(employeeRepository.getAll());
        System.out.println(employee);

    }

    @Test
    public void read(){
        Employee employee = EmployeeFactory.createEmployee("AJ", "Wiese");
        employeeRepository.create(employee);

        Employee existing = employeeRepository.read(employee.getEmployeeID());
        assertNotNull(existing);
        System.out.println(existing);
    }

    @Test
    public void update(){
        Employee employee = EmployeeFactory.createEmployee("AJ", "Wiese");
        employeeRepository.create(employee);

        Employee employee1 = EmployeeFactory.createEmployee("JJ", "Lasta");
        employee1.setEmployeeID(employee.getEmployeeID());
        employeeRepository.update(employee1);
        System.out.println("Original: \n"+employee);
        System.out.println("Updated: \n"+employee1);

        Employee employee2 = employeeRepository.read(employee1.getEmployeeID());
        assertEquals(employee1, employee2);
    }

    @Test
    public void delete(){
        Employee employee = EmployeeFactory.createEmployee("AJ", "Wiese");
        employeeRepository.create(employee);

        Employee existing = employeeRepository.read(employee.getEmployeeID());
        assertNotNull(existing);

        employeeRepository.delete(employee.getEmployeeID());
        Employee deleted = employeeRepository.read(employee.getEmployeeID());
        assertNull(deleted);
        System.out.println(deleted);
    }
}
