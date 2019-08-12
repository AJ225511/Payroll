package wiese.aj.service.demographics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiese.aj.domain.demographics.Gender;
import wiese.aj.factory.demographics.GenderFactory;
import wiese.aj.service.demographics.impl.GenderServiceImpl;

import static junit.framework.TestCase.*;

public class GenderServiceImplTest {

    private GenderServiceImpl genderService;

    @Before
    public void setUp() throws Exception {
        genderService = GenderServiceImpl.getService();
    }

    @Test
    public void getAll() {
        assertEquals(genderService.getAll(),genderService.getAll());
    }

    @Test
    public void create(){
        Gender gender = GenderFactory.createGender("MALE");
        genderService.create(gender);

        Assert.assertNotNull(genderService.getAll());
        System.out.println(gender);

    }

    @Test
    public void read(){
        Gender gender = GenderFactory.createGender("MALE");
        genderService.create(gender);

        Gender existing = genderService.read(gender.getGenderID());
        assertNotNull(existing);
        System.out.println(existing);
    }

    @Test
    public void update(){
        Gender gender = GenderFactory.createGender("MALE");
        genderService.create(gender);

        Gender gender1 = GenderFactory.createGender("FEMALE");
        gender1.setGenderID(gender.getGenderID());
        genderService.update(gender1);
        System.out.println("Original: \n"+gender);
        System.out.println("Updated: \n"+gender1);

        Gender gender2 = genderService.read(gender1.getGenderID());
        assertEquals(gender1, gender2);
    }

    @Test
    public void delete(){
        Gender gender = GenderFactory.createGender("MALE");
        genderService.create(gender);

        Gender existing = genderService.read(gender.getGenderID());
        assertNotNull(existing);

        genderService.delete(gender.getGenderID());
        Gender deleted = genderService.read(gender.getGenderID());
        assertNull(deleted);
        System.out.println(deleted);
    }
}
