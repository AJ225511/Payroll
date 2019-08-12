package wiese.aj.service.demographics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiese.aj.domain.demographics.Race;
import wiese.aj.factory.demographics.RaceFactory;
import wiese.aj.service.demographics.impl.RaceServiceImpl;

import static junit.framework.TestCase.*;

public class RaceServiceImplTest {


    private RaceServiceImpl raceService;

    @Before
    public void setUp() throws Exception {
        raceService = RaceServiceImpl.getService();
    }

    @Test
    public void getAll() {
        assertEquals(raceService.getAll(),raceService.getAll());
    }

    @Test
    public void create(){
    Race race = RaceFactory.createRace("HISPANIC");
    raceService.create(race);

    Assert.assertNotNull(raceService.getAll());
    System.out.println(race);

    }
    
    @Test
    public void read(){
        Race race = RaceFactory.createRace("HISPANIC");
        raceService.create(race);

        Race existing = raceService.read(race.getRaceID());
        assertNotNull(existing);
        System.out.println(existing);
    }
    
    @Test
    public void update(){
        Race race = RaceFactory.createRace("HISPANIC");
        raceService.create(race);

        Race race1 = RaceFactory.createRace("INDIAN");
        race1.setRaceID(race.getRaceID());
        raceService.update(race1);
        System.out.println("Original: \n"+race);
        System.out.println("Updated: \n"+race1);

        Race race2 = raceService.read(race1.getRaceID());
        assertEquals(race1, race2);
    }
    
    @Test
    public void delete(){
        Race race = RaceFactory.createRace("HISPANIC");
        raceService.create(race);

        Race existing = raceService.read(race.getRaceID());
        assertNotNull(existing);

        raceService.delete(race.getRaceID());
        Race deleted = raceService.read(race.getRaceID());
        assertNull(deleted);
        System.out.println(deleted);
    }
}

