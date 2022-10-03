package Enums;

import Utilities.FakeData;

import java.util.Random;

public enum Gender {
    male{
        final FakeData FakeMale = new FakeData();
        final String FirstName = FakeMale.getMaleFirstName();
        final String LastName = FakeMale.getMaleLastName();

        public String getFirstName() {
            return FirstName;
        }

        public String getLastName() {
            return LastName;
        }
    },
    female{
        final FakeData FakeFemale = new FakeData();
        final String FirstName = FakeFemale.getFemaleFirstName();
        final String LastName = FakeFemale.getFemaleLastName();

        public String getFirstName() {
            return FirstName;
        }

        public String getLastName() {
            return LastName;
        }
    };

    public abstract String getFirstName();
    public abstract String getLastName();
    public static Gender getRandomGender(){
        int length = Gender.values().length;
        Random random = new Random();
        int randomIndex =random.ints(0,length).findFirst().getAsInt();
        return Gender.values()[randomIndex];
    }
};



