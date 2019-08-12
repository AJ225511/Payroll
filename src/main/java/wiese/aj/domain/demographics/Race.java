package wiese.aj.domain.demographics;

public class Race {

    private String raceID;
    private String race;

    private Race(){

    }

    public Race(Builder builder){
        this.race = builder.race;
        this.raceID = builder.raceID;
    }

    public String getRace(){
        return race;
    }

    public String getRaceID(){
        return raceID;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setRaceID(String raceID) {
        this.raceID = raceID;
    }

    public static class Builder{
        private String raceID;
        private String race;

        public Builder raceID(String r){
            this.raceID = r;
            return this;
        }

        public Builder race(String race){
            this.race = race;
            return this;
        }

        public Race build(){
            return new Race(this);
        }
    }

    @Override
    public String toString(){
        return "Race{" +
                "raceID='" + raceID + '\'' +
                ", race='" + race + '\''+
                '}';
    }
}
