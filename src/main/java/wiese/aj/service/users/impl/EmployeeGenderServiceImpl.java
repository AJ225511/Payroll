package wiese.aj.service.users.impl;

import wiese.aj.domain.users.EmployeeGender;
import wiese.aj.repository.users.impl.EmployeeGenderRepositoryImpl;
import wiese.aj.service.users.EmployeeGenderService;

import java.util.Set;

public class EmployeeGenderServiceImpl implements EmployeeGenderService {
    private static EmployeeGenderServiceImpl service = null;
    private EmployeeGenderRepositoryImpl repository;

    public EmployeeGenderServiceImpl(){
        repository = EmployeeGenderRepositoryImpl.getRepository();
    }

    public static EmployeeGenderServiceImpl getService() {
        if (service == null) {
            return new EmployeeGenderServiceImpl();
        }
        return service;
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return repository.getAll();
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        return repository.create(employeeGender);
    }

    @Override
    public EmployeeGender read(String string) {
        return repository.read(string);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        return repository.update(employeeGender);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
