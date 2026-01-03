package parking;

public class ParkingAgent extends Thread {

    private final ParkingPool parkingPool;
    private final String agentName;

    public ParkingAgent(String name, ParkingPool pool) {
        this.agentName = name;
        this.parkingPool = pool;
    }

    @Override
    public void run() {
        while (true) {
            try {
                RegistrarParking parking = parkingPool.getParking();
                System.out.println(agentName + " is parking car ID: " + parking.getParkingId());
                Thread.sleep(1000);
                System.out.println(agentName + " finished parking car ID: " + parking.getParkingId());
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
