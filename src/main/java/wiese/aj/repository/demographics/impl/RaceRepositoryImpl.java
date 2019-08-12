package wiese.aj.repository.demographics.impl;

import wiese.aj.domain.demographics.Race;
import wiese.aj.repository.demographics.RaceRepository;

import java.util.*;

public class RaceRepositoryImpl implements RaceRepository {
    private static RaceRepositoryImpl repository = null;
    private Set<Race> races;

    private RaceRepositoryImpl(){
        this.races = new HashSet<>();
    }

    public static RaceRepositoryImpl getRepository(){
        if(repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Race> getAll(){
        return races;
    }

    @Override
    public Race create(Race race){
        this.races.add(race);
        return race;
    }

    @Override
    public Race read(String id){
        return races.stream().filter(race -> race.getRaceID() == id).findAny().orElse(null);
    }


    @Override
    public Race update(Race race){
        Race race1 = read(race.getRaceID());
        if(races.contains(race1)){
            races.remove(race1);
            races.add(race);
        }
        return race1;
    }

    @Override
    public void delete (String id){
        Race race = read(id);
        races.remove(race);
    }
}
