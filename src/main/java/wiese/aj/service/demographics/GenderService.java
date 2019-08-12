package wiese.aj.service.demographics;

import wiese.aj.domain.demographics.Gender;
import wiese.aj.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, String> {
    Set<Gender> getAll();
}
