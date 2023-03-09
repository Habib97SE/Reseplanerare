package Vehicles;

public abstract class Vehicle
{
    private String brand;

    private String model;
    private int speed;
    private int year;


    public Vehicle (String brand, String model, int speed, int year )
    {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
        this.year = year;
    }

    public String getBrand ()
    {
        return brand;
    }

    public void setBrand (String brand)
    {
        this.brand = brand;
    }


    public String getModel ()
    {
        return model;
    }

    public void setModel (String model)
    {
        this.model = model;
    }

    public int getSpeed ()
    {
        return speed;
    }

    public void setSpeed (int speed)
    {
        this.speed = speed;
    }

    public int getYear ()
    {
        return year;
    }

    public void setYear (int year)
    {
        this.year = year;
    }

    public abstract float getFuelConsumption ();

    public abstract int maxSpeed ();


}
