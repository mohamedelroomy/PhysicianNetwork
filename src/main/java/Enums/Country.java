package Enums;

public enum Country {
    Egypt{
        final String Code ="+20";
        public String getCode (){
            return Code;
        }
        public String generatePhoneNumber() {
            int number1 = (int)((Math.random() * 9000000)+1000000);
            int number2 = (int)((Math.random() * 900)+100);
            String number = String.valueOf(number1)+String.valueOf(number2);
            return number;
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
            String number = String.valueOf(number1)+String.valueOf(number2);
            return number;
        }
    };
    public abstract String getCode();
    public abstract String generatePhoneNumber();
}
