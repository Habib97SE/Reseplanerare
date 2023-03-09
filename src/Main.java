import Vehicles.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{


    static Scanner scanner = new Scanner(System.in);

    public static float calculateFuelNeeded (float distance, float fuelConsumption)
    {
        float distanceIn100Unit = distance / 100.0f;
        return distanceIn100Unit * fuelConsumption;
    }

    public static float calculateFuelPrice (float fuelPrice, float distance, float fuelConsumption)
    {

        return calculateFuelNeeded(distance, fuelConsumption) * fuelPrice;
    }

    public static void main (String[] args)
    {
        Car bmwCar = new Car("BMW", "M5", 220, 2022, 7.5f, 4);
        Truck scaniaTruck = new Truck("Scania", "R450", 90, 2015, 2, 35, 40);
        MotorCycle harleyDavidsonMotorCycle = new MotorCycle("Harley-Davidson", "Sporster", 200, 2019, 5, false);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(bmwCar);
        vehicles.add(scaniaTruck);
        vehicles.add(harleyDavidsonMotorCycle);

        float distanceInKilometers;
        float fuelPricePerLitre;

        // Ta in inputs från användare för att sen använda dem i beräkningarna.
        while (true) {
            try {
                System.out.print("Distance to travel: ");
                distanceInKilometers = scanner.nextFloat();

                System.out.print("Fuel price: ");
                fuelPricePerLitre = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again. " + e.getMessage());
                scanner.nextLine(); // consume invalid input
            }
        }

        // Variabler som sparar data om billigaste fordon för resan.
        String leastFuelConsumptionBrandModelName = "";
        float leastFuelConsumptionPrice = 0;


        System.out.println("================================");
        System.out.println("Distance to travel: " + distanceInKilometers + " km.");
        System.out.println("Fuel price: " + fuelPricePerLitre + " kr/l.");
        System.out.println();
        // Loopar genom alla elementer i ArrayList vehicles för att printa ut kort info samt beräkningarna.
        for (Vehicle vehicle : vehicles)
        {
            System.out.println(vehicle.toString());
            System.out.printf("Travel distance: %.2f km\n", distanceInKilometers);
            System.out.printf("Fuel needed: %.2f\n", calculateFuelNeeded(distanceInKilometers,
                    vehicle.getFuelConsumption()));

            float totalPrice = calculateFuelPrice(fuelPricePerLitre, distanceInKilometers,
                    vehicle.getFuelConsumption());
            System.out.printf("Price: %.2f kr\n", totalPrice);
            if (leastFuelConsumptionPrice == 0 || leastFuelConsumptionPrice > totalPrice)
            {
                leastFuelConsumptionPrice = totalPrice;
                leastFuelConsumptionBrandModelName = String.format("%s %s (%d)", vehicle.getBrand(),
                        vehicle.getModel(), vehicle.getYear());
            }
            System.out.println();
        }

        // Slut meddelande om vilket fordon som är snålast för körning.
        System.out.println(leastFuelConsumptionBrandModelName + " är billigast, den kostar bara " + leastFuelConsumptionPrice + " kr per sträcka.");


    }
}