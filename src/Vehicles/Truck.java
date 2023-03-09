package Vehicles;

public class Truck extends Vehicle
{
    private int doors;
    private int capacity;
    private float fuelConsumption;

    public Truck (String brand, String model, int speed, int year, int doors, float fuelConsumption, int capacity)
    {
        super(brand, model, speed, year);
        this.doors = doors;
        this.capacity = capacity;
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

    public int getCapacity ()
    {
        return capacity;
    }

    public void setCapacity (int capacity)
    {
        this.capacity = capacity;
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
        finalResult += String.format("Door count: %d\n", this.getDoors());
        finalResult += String.format("Capacity: %d", this.getCapacity());

        return finalResult;
    }
}
