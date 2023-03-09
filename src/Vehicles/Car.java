package Vehicles;

public class Car extends Vehicle
{

    private int doors;
    private float fuelConsumption;

    public Car (String brand, String model, int speed, int year, float fuelConsumption, int doors)
    {
        super(brand, model, speed, year);
        this.doors = doors;
        this.fuelConsumption = fuelConsumption;
    }

    public int getDoors ()
    {
        return doors;
    }

    public void setDoors (int doors)
    {
        this.doors = doors;
    }

    @Override
    public float getFuelConsumption ()
    {
        return this.fuelConsumption;
    }

    @Override
    public int maxSpeed ()
    {
        return this.getSpeed();
    }

    @Override
    public String toString()
    {
        String finalResult = "";
        finalResult += String.format("%s %s (%d)\n", this.getBrand(), this.getModel(), this.getYear());
        finalResult += String.format("Max speed: %d km/h\n", this.getSpeed());
        finalResult += String.format("Fuel consumption: %.2f l/100 km\n", this.getFuelConsumption());
        finalResult += String.format("Door count: %d", this.getDoors());

        return finalResult;
    }
}
