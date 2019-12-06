package cityBike;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Rent {

    private Integer bikeId;
    private GregorianCalendar rentStart;
    private GregorianCalendar rentEnd;

    public Rent(Integer bikeId, GregorianCalendar rentStart){
        this.bikeId = bikeId;
        this.rentStart = rentStart;
    }

    public void setRentEnd(){
        this.rentEnd = (GregorianCalendar) Calendar.getInstance();
    }

    public Integer getBikeId(){
        return bikeId;
    }

    public GregorianCalendar getRentStart(){
        return rentStart;
    }

    public GregorianCalendar getRentEnd(){
        return rentEnd;
    }


}
