package wiese.aj.factory.demographics;

import wiese.aj.domain.demographics.Race;
import wiese.aj.util.Misc;

public class RaceFactory {
    public static Race createRace(String race){
        return new Race.Builder()
                .raceID(Misc.generateId())
                .race(race)
                .build();
    }
}
