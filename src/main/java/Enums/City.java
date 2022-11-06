package Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum City {
    Alexandria{
        final String Name ="Alexandria";
        final List<Area> areas = Arrays.asList(Area.values());
        public String getName() {return Name;}


        public List<Area> getAreas() {
            return areas;
        }
    },
    Cairo{
        final String Name ="Cairo";
        final List<Area> areas = new ArrayList<>();
        public String getName() {return Name;}
        public List<Area> getAreas() {
            return areas;
        }
    };
    public abstract String getName();
    public abstract List<Area> getAreas();
}
