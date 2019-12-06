package cityBike;


import static org.junit.jupiter.api.Assertions.*;

class StationTest {
    //declares what variables will be used:
    Station station4;
    User usr4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //set up for Test  - same as in user Test:
        station4 = new Station ("Schönbrunn");
        usr4 = new User("Mickey", "Mouse");
        Main.users.put(4,usr4);
        usr4.setCurrRentedBike(9);
    }

    @org.junit.jupiter.api.Test
    void returnBike() {
        assertEquals(0,station4.getBikes().size());
        assertEquals(9,usr4.getCurrRentedBike());
        station4.returnBike(9);
        assertEquals(9,station4.getBikes().get(0));
        assertNull(usr4.getCurrRentedBike());

        //check station 4 if the are any bikes - should be currently 0 since usr4 rented it in the userTest
        //check if usr4 has the bike with bikeId 9
        //bike number 9 has been returned
        //check if station4 has the bike with the number 9
        //check if usr4 does not have the bike anymore

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getStationId() {
    }

    @org.junit.jupiter.api.Test
    void setStationId() {
    }

    @org.junit.jupiter.api.Test
    void getLocation() {
    }

    @org.junit.jupiter.api.Test
    void setLocation() {
    }

    @org.junit.jupiter.api.Test
    void getBikes() {
    }

    @org.junit.jupiter.api.Test
    void addBike() {
    }

    @org.junit.jupiter.api.Test
    void removeBike() {
    }


}