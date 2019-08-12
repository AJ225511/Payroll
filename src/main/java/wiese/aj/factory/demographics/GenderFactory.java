package wiese.aj.factory.demographics;

import wiese.aj.domain.demographics.Gender;
import wiese.aj.util.Misc;

public class GenderFactory {
    public static Gender createGender(String gender){
        return new Gender.Builder()
                .genderID(Misc.generateId())
                .genderType(gender)
                .build();
    }
}
