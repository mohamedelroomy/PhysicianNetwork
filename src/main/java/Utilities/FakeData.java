package Utilities;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.PersonProperties;

public class FakeData {
    private final Fairy fairy;

    public FakeData() {
        fairy = Fairy.create();
    }
    public String getMaleFirstName(){
        return fairy.person(PersonProperties.male()).firstName();
    }
    public String getMaleLastName(){
        return fairy.person(PersonProperties.male()).lastName();
    }

    public String getFemaleFirstName(){
        return fairy.person(PersonProperties.female()).firstName();
    }
    public String getFemaleLastName(){
        return fairy.person(PersonProperties.female()).lastName();
    }

}
