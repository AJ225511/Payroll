package wiese.aj.repository.demographics.impl;

import wiese.aj.domain.demographics.Gender;
import wiese.aj.repository.demographics.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {
    private static GenderRepositoryImpl repository = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl(){
        this.genders = new HashSet<>();
    }

    public static GenderRepositoryImpl getRepository(){
        if(repository == null) repository = new GenderRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Gender> getAll(){
        return genders;
    }

    @Override
    public Gender create(Gender gender){
        this.genders.add(gender);
        return gender;
    }

    @Override
    public Gender read(String id){
        return genders.stream().filter(gender -> gender.getGenderID() == id).findAny().orElse(null);
    }


    @Override
    public Gender update(Gender gender){
        Gender gender1 = read(gender.getGenderID());
        if(genders.contains(gender1)){
            genders.remove(gender1);
            genders.add(gender);
        }
        return gender1;
    }

    @Override
    public void delete (String id){
        Gender gender = read(id);
        genders.remove(gender);
    }
}
