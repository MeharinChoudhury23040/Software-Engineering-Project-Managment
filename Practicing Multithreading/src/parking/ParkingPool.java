package parking;

import java.util.LinkedList;
import java.util.Queue;

public class ParkingPool {

    private final Queue<RegistrarParking> pool = new LinkedList<>();

    public synchronized void addParking(RegistrarParking parking) {
        pool.add(parking);
        System.out.println("Car arrived for parking. ID: " + parking.getParkingId());
        notify();
    }

    public synchronized RegistrarParking getParking() throws InterruptedException {
        while (pool.isEmpty()) {
            wait();
        }
        return pool.poll();
    }
}
