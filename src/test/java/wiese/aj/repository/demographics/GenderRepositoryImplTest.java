package wiese.aj.repository.demographics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiese.aj.domain.demographics.Gender;
import wiese.aj.factory.demographics.GenderFactory;
import wiese.aj.repository.demographics.impl.GenderRepositoryImpl;

import static junit.framework.TestCase.*;

public class GenderRepositoryImplTest {
    private GenderRepositoryImpl genderRepository;

    @Before
    public void setUp() throws Exception {
        genderRepository = GenderRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
        assertEquals(genderRepository.getAll(),genderRepository.getAll());
    }

    @Test
    public void create(){
        Gender gender = GenderFactory.createGender("MALE");
        genderRepository.create(gender);

        Assert.assertNotNull(genderRepository.getAll());
        System.out.println(gender);

    }

    @Test
    public void read(){
        Gender gender = GenderFactory.createGender("MALE");
        genderRepository.create(gender);

        Gender existing = genderRepository.read(gender.getGenderID());
        assertNotNull(existing);
        System.out.println(existing);
    }

    @Test
    public void update(){
        Gender gender = GenderFactory.createGender("MALE");
        genderRepository.create(gender);

        Gender gender1 = GenderFactory.createGender("FEMALE");
        gender1.setGenderID(gender.getGenderID());
        genderRepository.update(gender1);
        System.out.println("Original: \n"+gender);
        System.out.println("Updated: \n"+gender1);

        Gender gender2 = genderRepository.read(gender1.getGenderID());
        assertEquals(gender1, gender2);
    }

    @Test
    public void delete(){
        Gender gender = GenderFactory.createGender("MALE");
        genderRepository.create(gender);

        Gender existing = genderRepository.read(gender.getGenderID());
        assertNotNull(existing);

        genderRepository.delete(gender.getGenderID());
        Gender deleted = genderRepository.read(gender.getGenderID());
        assertNull(deleted);
        System.out.println(deleted);
    }
}
