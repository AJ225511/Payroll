package wiese.aj.repository.users;

import wiese.aj.domain.users.Employee;
import wiese.aj.domain.users.EmployeeGender;
import wiese.aj.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {
    Set<Employee> getAll();
}
