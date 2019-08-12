package wiese.aj.service.demographics;

import wiese.aj.domain.demographics.Race;
import wiese.aj.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String> {
    Set<Race> getAll();
}
