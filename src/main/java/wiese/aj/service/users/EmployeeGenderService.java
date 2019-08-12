package wiese.aj.service.users;

import wiese.aj.domain.users.EmployeeGender;
import wiese.aj.service.IService;

import java.util.Set;

public interface EmployeeGenderService extends IService<EmployeeGender, String> {
    Set<EmployeeGender> getAll();
}
