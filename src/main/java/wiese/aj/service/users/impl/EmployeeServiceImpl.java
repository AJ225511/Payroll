package wiese.aj.service.users.impl;

import wiese.aj.domain.users.Employee;
import wiese.aj.repository.users.impl.EmployeeRepositoryImpl;
import wiese.aj.service.users.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeServiceImpl service = null;
    private EmployeeRepositoryImpl repository;

    public EmployeeServiceImpl(){
        repository = EmployeeRepositoryImpl.getRepository();
    }

    public static EmployeeServiceImpl getService() {
        if (service == null) {
            return new EmployeeServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public Employee create(Employee employee) {
        return repository.create(employee);
    }

    @Override
    public Employee read(String string) {
        return repository.read(string);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
