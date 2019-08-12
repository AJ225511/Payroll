package wiese.aj.service.demographics.impl;

import wiese.aj.domain.demographics.Gender;
import wiese.aj.repository.demographics.impl.GenderRepositoryImpl;
import wiese.aj.service.demographics.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {
    private static GenderServiceImpl service = null;
    private GenderRepositoryImpl repository;

    public GenderServiceImpl(){
        repository = GenderRepositoryImpl.getRepository();
    }

    public static GenderServiceImpl getService() {
        if (service == null) {
            return new GenderServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Gender> getAll() {
        return repository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return repository.create(gender);
    }

    @Override
    public Gender read(String string) {
        return repository.read(string);
    }

    @Override
    public Gender update(Gender gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
