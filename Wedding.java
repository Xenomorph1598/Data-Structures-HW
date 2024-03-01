import java.time.LocalDate;

public class Wedding {
    private Couple toBeMarried; //Who's getting married
    private LocalDate weddingDay; //What day is the wedding
    private String location; //Where's it at

    //Constructor for a wedding object
    public Wedding(Couple marrying, LocalDate marriedOn, String at){
        toBeMarried = new Couple(marrying.getPersonOne(), marrying.getPersonTwo());
        weddingDay = marriedOn;
        location = at;
    }

    public Couple getToBeMarried() { //toBeMarried getter
        return toBeMarried;
    }

    public LocalDate getWeddingDay() { //weddingDay getter
        return weddingDay;
    }

    public String getLocation() { //location getter
        return location;
    }
}
