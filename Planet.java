/*
 * Class for planets in Astroknot project
 *
 * Adam Browning
 * 11/12/2019
 */
 
import java.text.DecimalFormat;
import java.math.BigInteger;
public class Planet
{
    private String name;
    private double diameter;
    private double gravity;
    private BigInteger mass;
   
    public Planet (String name, double diameter, String mass, double gravity)
    {
        this.name = name;
        this.diameter = diameter;
        this.mass = new BigInteger(mass);
        this.gravity = gravity;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getGravity()
    {
        return gravity;
    }
    
    public String toString()
    {
        DecimalFormat format = new DecimalFormat("0.###E0");
        return "Planet - " + name + " | Diameter - " + diameter + " miles | Mass - " + format.format(mass) + " kg | Gravity - " + gravity + " m/s^2";
    }

}
