package wiese.aj.repository.demographics;

import wiese.aj.domain.demographics.Gender;
import wiese.aj.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {
    Set<Gender> getAll();
}
