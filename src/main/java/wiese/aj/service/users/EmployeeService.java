package wiese.aj.service.users;

import wiese.aj.domain.users.Employee;
import wiese.aj.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee> getAll();
}
