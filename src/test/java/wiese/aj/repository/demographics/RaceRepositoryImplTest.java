package wiese.aj.repository.demographics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiese.aj.domain.demographics.Race;
import wiese.aj.factory.demographics.RaceFactory;
import wiese.aj.repository.demographics.impl.RaceRepositoryImpl;

import static junit.framework.TestCase.*;

public class RaceRepositoryImplTest {

    private RaceRepositoryImpl raceRepository;

    @Before
    public void setUp() throws Exception {
        raceRepository = RaceRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
        assertEquals(raceRepository.getAll(),raceRepository.getAll());
    }

    @Test
    public void create(){
        Race race = RaceFactory.createRace("HISPANIC");
        raceRepository.create(race);

        Assert.assertNotNull(raceRepository.getAll());
        System.out.println(race);

    }

    @Test
    public void read(){
        Race race = RaceFactory.createRace("HISPANIC");
        raceRepository.create(race);

        Race existing = raceRepository.read(race.getRaceID());
        assertNotNull(existing);
        System.out.println(existing);
    }

    @Test
    public void update(){
        Race race = RaceFactory.createRace("HISPANIC");
        raceRepository.create(race);

        Race race1 = RaceFactory.createRace("INDIAN");
        race1.setRaceID(race.getRaceID());
        raceRepository.update(race1);
        System.out.println("Original: \n"+race);
        System.out.println("Updated: \n"+race1);

        Race race2 = raceRepository.read(race1.getRaceID());
        assertEquals(race1, race2);
    }

    @Test
    public void delete(){
        Race race = RaceFactory.createRace("HISPANIC");
        raceRepository.create(race);

        Race existing = raceRepository.read(race.getRaceID());
        assertNotNull(existing);

        raceRepository.delete(race.getRaceID());
        Race deleted = raceRepository.read(race.getRaceID());
        assertNull(deleted);
        System.out.println(deleted);
    }
}
