package wiese.aj.service.demographics.impl;

import wiese.aj.domain.demographics.Race;
import wiese.aj.repository.demographics.impl.RaceRepositoryImpl;
import wiese.aj.service.demographics.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService {

    private static RaceServiceImpl service = null;
    private RaceRepositoryImpl repository;

    public RaceServiceImpl(){
        repository = RaceRepositoryImpl.getRepository();
    }

    public static RaceServiceImpl getService() {
        if (service == null) {
            return new RaceServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Race> getAll() {
        return repository.getAll();
    }

    @Override
    public Race create(Race race) {
        return repository.create(race);
    }

    @Override
    public Race read(String string) {
        return repository.read(string);
    }

    @Override
    public Race update(Race race) {
        return repository.update(race);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
