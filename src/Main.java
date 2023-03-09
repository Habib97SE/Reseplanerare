import Vehicles.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{



    static Scanner scanner = new Scanner(System.in);

    public static float calculateFuelNeeded(float distance, float fuelConsumption)
    {
        float distanceIn100Unit = distance / 100.0f;
        return  distanceIn100Unit * fuelConsumption;
    }
    public static float calculateFuelPrice(float fuelPrice, float distance, float fuelConsumption)
    {

        return calculateFuelNeeded(distance, fuelConsumption) * fuelPrice;
    }

    public static void main (String[] args)
    {
        Car car = new Car("BMW", "M5", 220, 2022, 7.5f, 4);
        Truck truck = new Truck("Scania", "R450", 90, 2015, 2, 35, 40);
        MotorCycle motorCycle = new MotorCycle("Harley-Davidson", "Sporster", 200, 2019, 5, false);

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(car);
        vehicles.add(truck);
        vehicles.add(motorCycle);

        System.out.print("Distance to travel: ");
        float distanceInKilometers = scanner.nextFloat();

        System.out.print("Fuel price: ");
        float fuelPricePerLitre = scanner.nextFloat();

        String leastFuelConsumptionBrandModelName = "";
        float leastFuelConsumptionPrice = 0;

        System.out.println();
        for (Vehicle vehicle : vehicles)
        {
            System.out.println(vehicle.toString());
            System.out.printf("Travel distance: %.2f km\n", distanceInKilometers);
            System.out.printf("Fuel needed: %.2f\n", calculateFuelNeeded(distanceInKilometers,
                    vehicle.getFuelConsumption()));

            float totalPrice = calculateFuelPrice(fuelPricePerLitre, distanceInKilometers,
                    vehicle.getFuelConsumption());
            System.out.printf("Price: %.2f kr", totalPrice);
            if (leastFuelConsumptionPrice == 0 || leastFuelConsumptionPrice > totalPrice)
            {
                leastFuelConsumptionPrice = totalPrice;
                leastFuelConsumptionBrandModelName = String.format("%s %s (%d)", vehicle.getBrand(),
                        vehicle.getModel(), vehicle.getYear());
            }
            System.out.println("\n");
        }
        System.out.println();
        System.out.println(leastFuelConsumptionBrandModelName + " är billigast, den kostar bara " + leastFuelConsumptionPrice + " per sträcka." );



    }
}