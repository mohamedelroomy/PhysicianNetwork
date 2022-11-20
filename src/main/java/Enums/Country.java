package Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Country {
    Egypt{
        final String Code ="+20";
        final String Name = "Egypt";
        final List<City> cities = Arrays.asList(City.Alexandria,City.Cairo);

        public List<City> getCities() {
            return cities;
        }

        public String getName() {return Name;}
        public String getCode (){
            return Code;
        }
        public String generatePhoneNumber() {
            int number1 = (int)((Math.random() * 9000000)+1000000);
            int number2 = (int)((Math.random() * 900)+100);
            return number1 +String.valueOf(number2);
        }
    },
    SaudiArabia{
        final String Code ="+966";
        final String Name = "Saudi Arabia";
        final List<City> cities = new ArrayList<>();

        public List<City> getCities() {
            return cities;
        }

        public String getName() {return Name;}
        public String getCode (){
            return Code;
        }
        public String generatePhoneNumber() {
            int number1 = (int)((Math.random() * 900000)+100000);
            int number2 = (int)((Math.random() * 900)+100);
            return number1 +String.valueOf(number2);
        }
    };

    public abstract String getName();
    public abstract String getCode();
    public abstract List<City> getCities();
    public abstract String generatePhoneNumber();
    public static Country getRandomCountry(){
        int length = Country.values().length;
        Random random = new Random();
        int randomIndex =random.ints(0,length).findFirst().getAsInt();
        return Country.values()[randomIndex];
    }
}
