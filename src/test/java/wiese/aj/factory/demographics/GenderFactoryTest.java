package wiese.aj.factory.demographics;

import org.junit.Test;
import wiese.aj.domain.demographics.Gender;

import static junit.framework.TestCase.assertNotNull;

public class GenderFactoryTest {

    @Test
    public void getGender(){
        Gender g = GenderFactory.createGender("Male");
        assertNotNull(g);
    }
}
