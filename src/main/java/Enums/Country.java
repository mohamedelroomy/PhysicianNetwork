package Enums;

import java.util.Random;

public enum Country {
    Egypt{
        final String Code ="+20";
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
        public String getCode (){
            return Code;
        }
        public String generatePhoneNumber() {
            int number1 = (int)((Math.random() * 900000)+100000);
            int number2 = (int)((Math.random() * 900)+100);
            return number1 +String.valueOf(number2);
        }
    };
    public abstract String getCode();
    public abstract String generatePhoneNumber();
    public static Country getRandomCountry(){
        int length = Country.values().length;
        Random random = new Random();
        int randomIndex =random.ints(0,length).findFirst().getAsInt();
        return Country.values()[randomIndex];
    }
}
