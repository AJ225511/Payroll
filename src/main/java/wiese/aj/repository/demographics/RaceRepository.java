package wiese.aj.repository.demographics;

import wiese.aj.domain.demographics.Race;
import wiese.aj.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {
    Set<Race> getAll();
}
