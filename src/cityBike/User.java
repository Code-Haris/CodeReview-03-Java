package cityBike;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class User {


    private static Integer counter =1;
    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private Integer currRentedBike;
    private Rent rent;
    private ArrayList<Rent>rents = new ArrayList<>();


    public User (String userFirstName, String userLastName ){

        this.userId = counter++;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;

    }

    public User(){} //to be able to see which User has the bike



    public void rentABike( Integer bikeId) {
        if (Main.bikes.get(bikeId).getaStatus() == Bike.Status.CanBeRented) {
            Main.checkStation(bikeId);
            this.currRentedBike = bikeId;
            GregorianCalendar today = (GregorianCalendar) Calendar.getInstance();
            this.rent = new Rent(bikeId, today);
            this.rents.add(this.rent);
        } else {
            System.out.println("This bike can't be rented, sorry!");
        }
    }

    public Integer getCurrRentedBike(){
        return this.currRentedBike;
    }

    public void setCurrRentedBike(Integer bikeId){ //to be able to see which user has which bike - pass bikeId
        this.currRentedBike = bikeId;
    }

    public int getUserId(){
        return this.userId;
    }

    //when user returns bike set currently rented bike to 0
    //added for  when User returns bike
    public void removeBike(Integer bikeId){
        this.rent.setRentEnd();
        this.currRentedBike = null;
    }

    public void allBikesRentedByUser(){

        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm dd.MM.yyyy");
        String printName = this.userFirstName +" "+ this.userLastName;
        System.out.printf("%S" + "%17s" + "%28s%n", printName, "Start", "End");
        System.out.println("----------------------------------------------------------");
        for (Rent rent :rents){
            System.out.printf("Bike" + "%2S" + "%34S" + "%30S%n", rent.getBikeId(), sdf.format(rent.getRentStart().getTime()), sdf.format(rent.getRentEnd().getTime()));

        }
    }

}








