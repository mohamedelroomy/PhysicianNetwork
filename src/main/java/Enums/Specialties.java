package Enums;

import java.util.Random;

public enum Specialties {
    ClinicalHematology {
        final String id = "0";
        final String name ="Clinical Hematology";
        public String getName() {
            return name;
        }
        public String getID (){
            return id;
        }} ,

    GeneralCheckup {
        final String id = "1";
        final String name ="General Checkup";
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
        }};

    public abstract String getName ();
    public abstract String getID();

    // this method to get random specialties that implemented in the Enum
    public static Specialties getRandomSpecialty(){
        int length = Specialties.values().length;
        Random random = new Random();
        int randomIndex =random.ints(0,length).findFirst().getAsInt();
        return Specialties.values()[randomIndex];
    };

}
