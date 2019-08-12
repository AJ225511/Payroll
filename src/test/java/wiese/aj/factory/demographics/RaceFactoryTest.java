package wiese.aj.factory.demographics;

import org.junit.Test;
import wiese.aj.domain.demographics.Race;

import static junit.framework.TestCase.assertNotNull;

public class RaceFactoryTest {

    @Test
    public void getRace(){
        Race r = RaceFactory.createRace("Hispanic");
        assertNotNull(r);
    }
}
