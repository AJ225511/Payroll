package wiese.aj.repository.users.impl;

import wiese.aj.domain.users.EmployeeGender;
import wiese.aj.repository.users.EmployeeGenderRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImpl implements EmployeeGenderRepository {
    private static EmployeeGenderRepositoryImpl repository = null;
    private Set<EmployeeGender> employeeEmployeeGenders;

    private EmployeeGenderRepositoryImpl(){
        this.employeeEmployeeGenders = new HashSet<>();
    }

    public static EmployeeGenderRepositoryImpl getRepository(){
        if(repository == null) repository = new EmployeeGenderRepositoryImpl();
        return repository;
    }

    @Override
    public Set<EmployeeGender> getAll(){
        return employeeEmployeeGenders;
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeEmployeeGender){
        this.employeeEmployeeGenders.add(employeeEmployeeGender);
        return employeeEmployeeGender;
    }

    @Override
    public EmployeeGender read(String id){
        return employeeEmployeeGenders.stream().filter(employeeEmployeeGender -> employeeEmployeeGender.getEmpNum() == id).findAny().orElse(null);
    }


    @Override
    public EmployeeGender update(EmployeeGender employeeEmployeeGender){
        EmployeeGender employeeEmployeeGender1 = read(employeeEmployeeGender.getEmpNum());
        if(employeeEmployeeGenders.contains(employeeEmployeeGender1)){
            employeeEmployeeGenders.remove(employeeEmployeeGender1);
            employeeEmployeeGenders.add(employeeEmployeeGender);
        }
        return employeeEmployeeGender1;
    }

    @Override
    public void delete (String id){
        EmployeeGender employeeEmployeeGender = read(id);
        employeeEmployeeGenders.remove(employeeEmployeeGender);
    }
}

