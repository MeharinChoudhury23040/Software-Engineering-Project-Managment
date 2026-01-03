package parking;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        ParkingPool pool = new ParkingPool();

        new ParkingAgent("Agent-1", pool).start();
        new ParkingAgent("Agent-2", pool).start();
        new ParkingAgent("Agent-3", pool).start();

        Scanner scanner = new Scanner(System.in);
        int carCount = 0;

        while (carCount < 10) {
            System.out.println("Press Enter to add a car (-1 to exit)");
            String input = scanner.nextLine();

            if (input.equals("-1")) {
                break;
            }

            RegistrarParking parking = new RegistrarParking();
            pool.addParking(parking);
            carCount++;
        }

        scanner.close();
        System.out.println("System closed");
    }
}
