/*
 * This project is to demonstrate the HAS-A and IS-A relationships.
 * Design an Astroknot class with several instance variables including name, weight, fitnessLevel and currentPlanet.
 * The Astroknot will also have several actions it can perform.
 * At the minimum he/she should be able to jump, eat, rest and exercise. 
 * Note that the fitnessLevel will increase along with a decrease in weight when he/she exercises. 
 * Rest could also have an influence on the fitness level. 
 * Similarly when the astroknot Jumps it’s weight , currentPlanet and fitnessLevel will affect the height of 
 * the jump. For example Dr. Grateful on the moon will be able to jump much higher 
 * than Mr. Mela on Earth even though they have similar fitnessLevels;) 
 * (I know the moon is not a planet!!) Next you will need to create a class called Planet 
 * that creates planet objects that have name, diameter, mass and gravity. Remember 
 * all of the variables will need to be private so that they may not be changed.
 * 
 * Finally make a client to demonstrate the different aspects of the Astroknot. 
 * Send the astroknot to different planets, make them exercise, sleep and jump. Have fun with it!!!
 *
 * Adam Browning
 * 11/12/2019
 */
//

import java.text.DecimalFormat;
import java.lang.Math; 
public class Astroknot
{
    private String name;
    private double weight;
    private double fitnessLevel;            // 0 - 100
    private Planet currentPlanet;
    private double height;

    public Astroknot(String name, double weight, double fitnessLevel, Planet currentPlanet)
    {
        this.name = name;
        this.weight = weight;
        this.fitnessLevel = fitnessLevel;
        this.currentPlanet = currentPlanet;
    }

    public double jump()
    {
        if (fitnessLevel + 0.25 < 100)
        {
            fitnessLevel += 0.25;
        } else
        {
            fitnessLevel = 100;
        }

        double height;
        double time = -1.5/-currentPlanet.getGravity();
        if (weight >= 150)
        {
            height = (150/weight)*(fitnessLevel/40)*(1.5*time + (1/2) * -currentPlanet.getGravity()*Math.pow(time, 2));
        } else
        {
            height = (fitnessLevel/40)*(1.5*time + (1/2) * -currentPlanet.getGravity()*Math.pow(time, 2));
        }
        
        // Thanks Kevin for this equation     

        DecimalFormat format1 = new DecimalFormat("0.00");

        return height;
    }

    public void eat()
    {                     
        if (weight <= 250 - 5)
        {
            weight += 5;   
        } else
        {
            weight = 250;
        }
        if (fitnessLevel -5 >= 0 && fitnessLevel - 5 <= 100)
        {
            fitnessLevel -= 5;
        } else
        {
            fitnessLevel = 0;
        }     
    }

    public void rest()
    {
        if (fitnessLevel + 5 >= 0 && fitnessLevel + 5 <= 100)
        {
            fitnessLevel += 5;
        } else
        {
            fitnessLevel = 100;
        }
    }

    public void exercise()
    {
        if (weight >= 50 + 3)
        {
            weight -= 3;
        } else
        {
            weight = 50;
        }
        if (fitnessLevel + 5 >= 0 && fitnessLevel + 5 <= 100)
        {
            fitnessLevel += 5;
        } else
        {
            fitnessLevel = 100;
        }

    }

    public void setCurrentPlanet (Planet currentPlanet)
    {
        this.currentPlanet = currentPlanet;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getFitnessLevel()
    {
        return fitnessLevel;
    }

    public int random()
    {
        return (int)(Math.random() * 5) + 1;      
    }

    public String toString()
    {
        return "\n-----" + name + "'s " + "Information-----\nWeight - " + weight + " lbs\nFitness Level - " + fitnessLevel + "/100.0\nCurrent Planet - " + currentPlanet.getName();
    }     
}
