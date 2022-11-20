package Enums;

public enum Area {
    Roshdy{
        final String Name ="Roshdy";
        public String getName() {return Name;}
    },
    Smouha{
        final String Name ="Smouha";
        public String getName() {return Name;}
    },
    Sporting{
        final String Name ="Sporting";
        public String getName() {return Name;}
    };
    public abstract String getName();
}
