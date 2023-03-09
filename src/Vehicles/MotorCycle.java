package Vehicles;

import java.util.Objects;

public class MotorCycle extends Vehicle
{
    private boolean windShield;
    private float fuelConsumption;

    public MotorCycle (String brand, String model, int speed, int year, float fuelConsumption, boolean windShield)
    {
        super(brand, model, speed, year);
        this.windShield = windShield;
        this.fuelConsumption= fuelConsumption;
    }

    public boolean hasWindShield ()
    {
        return windShield;
    }

    public void setWindShield (boolean windShield)
    {
        this.windShield = windShield;
    }

    @Override
    public float getFuelConsumption ()
    {
        return this.fuelConsumption;
    }

    @Override
    public int maxSpeed ()
    {
        return getSpeed();
    }


    @Override
    public String toString ()
    {
        String finalResult = "";
        finalResult += String.format("%s %s (%d)\n", this.getBrand(), this.getModel(), this.getYear());
        finalResult += String.format("Max speed: %d km/h\n", this.getSpeed());
        finalResult += String.format("Fuel consumption: %.2f l/100 km\n", this.getFuelConsumption());
        finalResult += String.format("Has windshield: %s", this.hasWindShield() ? "Yes" : "No");

        return finalResult;
    }
}
