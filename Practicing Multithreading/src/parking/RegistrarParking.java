package parking;

public class RegistrarParking {

    private static int counter = 1;
    private final int parkingId;

    public RegistrarParking() {
        this.parkingId = counter++;
    }

    public int getParkingId() {
        return parkingId;
    }
}
