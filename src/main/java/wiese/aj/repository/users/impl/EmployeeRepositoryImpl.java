package wiese.aj.repository.users.impl;

import wiese.aj.domain.users.Employee;
import wiese.aj.repository.users.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl(){
        this.employees = new HashSet<>();
    }

    public static EmployeeRepositoryImpl getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Employee> getAll(){
        return employees;
    }

    @Override
    public Employee create(Employee employee){
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee read(String id){
        return employees.stream().filter(employee -> employee.getEmployeeID() == id).findAny().orElse(null);
    }


    @Override
    public Employee update(Employee employee){
        Employee employee1 = read(employee.getEmployeeID());
        if(employees.contains(employee1)){
            employees.remove(employee1);
            employees.add(employee);
        }
        return employee1;
    }

    @Override
    public void delete (String id){
        Employee employee = read(id);
        employees.remove(employee);
    }
}
