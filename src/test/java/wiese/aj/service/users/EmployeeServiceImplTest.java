package wiese.aj.service.users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiese.aj.domain.users.Employee;
import wiese.aj.factory.users.EmployeeFactory;
import wiese.aj.service.users.impl.EmployeeServiceImpl;

import static junit.framework.TestCase.*;

public class EmployeeServiceImplTest {
    private EmployeeServiceImpl employeeService;

    @Before
    public void setUp() throws Exception {
        employeeService = EmployeeServiceImpl.getService();
    }

    @Test
    public void getAll() {
        assertEquals(employeeService.getAll(),employeeService.getAll());
    }

    @Test
    public void create(){
        Employee employee = EmployeeFactory.createEmployee("AJ", "Wiese");
        employeeService.create(employee);

        Assert.assertNotNull(employeeService.getAll());
        System.out.println(employee);

    }

    @Test
    public void read(){
        Employee employee = EmployeeFactory.createEmployee("AJ", "Wiese");
        employeeService.create(employee);

        Employee existing = employeeService.read(employee.getEmployeeID());
        assertNotNull(existing);
        System.out.println(existing);
    }

    @Test
    public void update(){
        Employee employee = EmployeeFactory.createEmployee("AJ", "Wiese");
        employeeService.create(employee);

        Employee employee1 = EmployeeFactory.createEmployee("JJ", "Lasta");
        employee1.setEmployeeID(employee.getEmployeeID());
        employeeService.update(employee1);
        System.out.println("Original: \n"+employee);
        System.out.println("Updated: \n"+employee1);

        Employee employee2 = employeeService.read(employee1.getEmployeeID());
        assertEquals(employee1, employee2);
    }

    @Test
    public void delete(){
        Employee employee = EmployeeFactory.createEmployee("AJ", "Wiese");
        employeeService.create(employee);

        Employee existing = employeeService.read(employee.getEmployeeID());
        assertNotNull(existing);

        employeeService.delete(employee.getEmployeeID());
        Employee deleted = employeeService.read(employee.getEmployeeID());
        assertNull(deleted);
        System.out.println(deleted);
    }
}
