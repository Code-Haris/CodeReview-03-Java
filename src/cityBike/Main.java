package cityBike;

/**
 * This project would be more interesting with MySQL Databases
 * Maybe next time :D*/

import java.util.HashMap;
import java.util.Map;

public class Main {

    static HashMap<Integer, Bike> bikes = new HashMap<>();
    static HashMap<Integer, Station> stations = new HashMap<>();
    static HashMap<Integer, User> users = new HashMap<>();


    public static void main(String[] args) {

        Bike bike1 = new Bike("red", Bike.Status.CanBeRented);
        Bike bike2 = new Bike("blue", Bike.Status.CanBeRented);
        Bike bike3 = new Bike("white", Bike.Status.CanBeRented);
        Bike bike4 = new Bike("black", Bike.Status.CanBeRented);
        Bike bike5 = new Bike("purple", Bike.Status.CanBeRented);
        Bike bike6 = new Bike("green", Bike.Status.CanBeRented);
        Bike bike7 = new Bike("white", Bike.Status.CanBeRented);
        Bike bike8 = new Bike("rose", Bike.Status.InService);

        //create bikes Hashmap
        bikes.put(bike1.getBikeId(), bike1);
        bikes.put(bike2.getBikeId(), bike2);
        bikes.put(bike3.getBikeId(), bike3);
        bikes.put(bike4.getBikeId(), bike4);
        bikes.put(bike5.getBikeId(), bike5);
        bikes.put(bike6.getBikeId(), bike6);
        bikes.put(bike7.getBikeId(), bike7);
        bikes.put(bike8.getBikeId(), bike8);

        //creates Station
        Station station1 = new Station("Schwedenplatz");
        Station station2 = new Station("Karlsplatz");
        Station station3 = new Station("Stephansplatz");

        //creates HashMap for station

        stations.put(station1.getStationId(), station1);
        stations.put(station2.getStationId(), station2);
        stations.put(station3.getStationId(), station3);

        //adds bikes to station
        station1.addBike(1);
        station1.addBike(2);
        station1.addBike(3);
        station2.addBike(4);
        station2.addBike(5);
        station2.addBike(6);
        station2.addBike(7);

        //creates user
        User usr1 = new User("Otto", "Bismark");
        User usr2 = new User("Karin", "Bing");
        User usr3 = new User("Kurt", "Holz");

        //puts user in a HashMap
        users.put(usr1.getUserId(), usr1);
        users.put(usr2.getUserId(), usr2);
        users.put(usr3.getUserId(), usr3);


        usr1.rentABike(2);
        System.out.println("user: " + usr1.getCurrRentedBike());
        System.out.println("Station 1: "+ station1.getBikes().toString());
        station1.returnBike(2);

        usr1.rentABike(3);
        System.out.println("user: " + usr1.getCurrRentedBike());
        System.out.println("Station 1: " + station1.getBikes().toString());
        System.out.println(("Station 2: "+station2.getBikes().toString()));
        station1.returnBike(3);
        usr1.rentABike(5);
        station1.returnBike(5);
        System.out.println("user: " + usr1.getCurrRentedBike());
        System.out.println("Station 1: " + station1.getBikes().toString());
        System.out.println(("Station 2: "+station2.getBikes().toString()));
        usr2.rentABike(7);
        station1.returnBike(7);
        System.out.println("Station 1: " + station1.getBikes().toString());
        usr2.rentABike(6);
        station3.returnBike(6);
        System.out.println("Station 3: " + station3.getBikes().toString());


        usr1.allBikesRentedByUser();

    }

    public static void checkStation(Integer bikeId) {
        Station station = new Station();//create new station
        for (Map.Entry<Integer, Station> entry : stations.entrySet()) {//check station hashmap
            if (entry.getValue().getBikes().contains(bikeId)) { //if there is a value...
                station = entry.getValue();
                break;
            }
        }
        station.removeBike(bikeId);
    }

    public static void checkWhichUser(Integer bikeId){
        User usr = new User();
        for(Map.Entry<Integer, User> entry: users.entrySet()){
            if(entry.getValue().getCurrRentedBike() == bikeId){
                usr = entry.getValue();
                break;
            }
        }
        usr.removeBike(bikeId);
    }
}








