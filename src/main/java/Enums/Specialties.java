package Enums;

import java.util.Random;

public enum Specialties {
    Cardiology {
        final String id = "0";
        final String name ="Cardiology";
        public String getName() {
            return name;
        }
        public String getID (){
            return id;
        }} ,

    Neurospsychiatry {
        final String id = "1";
        final String name ="Neurospsychiatry";
        public String getName() {
            return name;
        }
        public String getID (){
            return id;
        }} ,

    MedicalSpecialty {
        final String id = "2";
        final String name ="Medical Specialty";
        public String getName() {
            return name;
        }
        public String getID (){
            return id;
        }} ,

    InternalMedicine {
        final String id = "3";
        final String name ="Internal Medicine";

        public String getName() {
            return name;
        }
        public String getID (){
            return id;
        }},
    ClinicalOncology{
        final String id = "4";
        final String name ="Clinical oncology";

        public String getName() {
            return name;
        }
        public String getID (){
            return id;
        }},
    Nutrition{
        final String id = "5";
        final String name ="Nutrition";

        public String getName() {
            return name;
        }
        public String getID (){
            return id;
        }},
    Physiotherapy {
        final String id = "6";
        final String name ="Physiotherapy";

        public String getName() {
            return name;
        }
        public String getID (){
            return id;
        }},
    Radiology {
        final String id = "7";
        final String name ="Radiology";

        public String getName() {return name;}
        public String getID (){
            return id;
        }},
    Dentistry{ final String id = "8";
        final String name ="Dentistry";

        public String getName() {return name;}
        public String getID (){
            return id;
        }
    }
    ;

    public abstract String getName ();
    public abstract String getID();

    // this method to get random specialties that implemented in the Enum
    public static Specialties getRandomSpecialty(){
        int length = Specialties.values().length;
        Random random = new Random();
        int randomIndex =random.ints(0,length).findFirst().getAsInt();
        return Specialties.values()[randomIndex];
    }

}
