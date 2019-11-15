
/*
 * Client for Astroknot project
 *
 * Adam Browning
 * 11/12/2019
 */

import java.text.DecimalFormat;
import java.math.BigInteger;
import java.util.Scanner;
public class Nasa
{
    public static void main ()
    {     
        Planet[] planets = new Planet[10];

        planets[0] = new Planet("X", 0, "0", 0);
        planets[1] = new Planet("Mercury", 3031.9, "328500000000000000000000", 3.7);
        planets[2] = new Planet("Earth", 7917.5, "5972000000000000000000000", 9.8);
        planets[3] = new Planet("Jupiter", 86881, "1898000000000000000000000000", 24.79);
        planets[4] = new Planet("Mars", 4212.3, "639000000000000000000000", 3.711);
        planets[5] = new Planet("Saturn", 72367, "568300000000000000000000000", 10.44);
        planets[6] = new Planet("Neptune", 30599, "102400000000000000000000000", 11.15);
        planets[7] = new Planet("Uranus", 31518, "86810000000000000000000000", 8.87);
        planets[8] = new Planet("Venus", 7520.8, "4867000000000000000000000", 8.87);
        planets[9] = new Planet("Pluto", 1476.8, "13090000000000000000000", 0.62);

        Scanner Input = new Scanner (System.in);
        DecimalFormat format1 = new DecimalFormat("0.00");
        int counter = 0;
        double weight = 0;
        double fitnessLevel = 0;
        int planetIndex = 0;
        
        int typeSpeed = 15;
        
        String response = "";

        String message = "Enter '1' to remove dialogue. Enter any other key to continue. ";
        Type(message, typeSpeed);
        String skip = Input.nextLine();

        System.out.print("\f");

        if (!skip.equalsIgnoreCase("1"))
        {

            message = "Hello! I am your Ship-based Artificial Intelligence Lattice, or S.A.I.L.";
            Type(message, typeSpeed);
            waitTime();

            message = "\nYou just woke up and are currently on an unknown planet. ";
            Type(message, typeSpeed);
            waitTime();

            message = "\nI never got your name before you blacked out. ";
            Type(message, typeSpeed);
            waitTime2();
        }

        message = "What is your name? ";
        Type(message, typeSpeed);

        String name = Input.nextLine();

        String newName = name.substring(0, 1).toUpperCase() + name.substring(1);

        if (!skip.equalsIgnoreCase("1"))
        {
            message = newName + " it is then. ";
            Type(message, typeSpeed);
            waitTime();

            System.out.print("\n");
        }

        counter = 0;

        while (counter == 0)
        {
            message = "What is your weight? ";
            Type(message, typeSpeed);

            weight = Input.nextDouble();
            if (weight < 50)
            {
                message = "I know your weight is at least 50 lbs!\n";
                Type(message, typeSpeed);
            } else if (weight > 250)
            {
                message = "I know your weight is not greater then 250 lbs!\n";
                Type(message, typeSpeed);
            } else
            {
                counter++;
            }
        }

        if (!skip.equalsIgnoreCase("1"))
        {

            message = "So, you are " + weight + " lbs then.\n";
            Type(message, typeSpeed);
            waitTime();
        }

        counter = 0;

        while (counter == 0)
        {
            message = "What is your fitness level from on a scale of 0 - 100? ";
            Type(message, typeSpeed);

            fitnessLevel = Input.nextDouble();
            if (fitnessLevel < 0)
            {
                message = "You must choose and number from 0 - 100!\n";
                Type(message, typeSpeed);
            } else if (fitnessLevel > 100)
            {
                message = "You must choose and number from 0 - 100!\n";
                Type(message, typeSpeed);
            } else
            {
                counter++;
            }
        }

        if (!skip.equalsIgnoreCase("1"))
        {
            message = "Unfortunately, you should not leave this space ship due to the unknown climate of this planet.";
            Type(message, typeSpeed);
            waitTime();

            message = "\nLet's travel to another planet.\n";
            Type(message, typeSpeed);
            waitTime();

        }

        message = "\nPlanets:\n";
        Type(message, typeSpeed);

        for (int i = 1; i <= planets.length-1; i++)
        {
            message = i + ") " + planets[i].getName() + "\n";
            Type(message, typeSpeed);
        }
        counter = 0;

        while (counter == 0)
        {
            message = "\nEnter the number of the planet you want to travel to: ";
            Type(message, typeSpeed);

            planetIndex = Input.nextInt();

            if (planetIndex < 1 || planetIndex > 9)
            {
                message = "\nThat is not an option. ";
                Type(message, typeSpeed);
            } else
            {
                counter++;
            }
        }

        Planet currentPlanet = planets[planetIndex];

        Astroknot Astro = new Astroknot(newName, weight, fitnessLevel, currentPlanet);

        traveling();

        message = "You have arrived at " + planets[planetIndex].getName() + "\n";
        Type(message, typeSpeed);        

        waitTime();

        Input.nextLine();
        
        System.out.println(Astro);

        while (true)
        {           
            actions();

            System.out.print("\nInput letter of what you want to do: ");

            response = Input.nextLine();

            if (response.equalsIgnoreCase("a"))
            {
                System.out.print("\f");
                System.out.println("You jumped a height of " + format1.format(Astro.jump()) + " meters.");
                if (Astro.jump() < 0.15)
                {
                    System.out.println("Your fitness level is so low or your weight is so high causing you to barely jump at all!");
                }
                
                System.out.println(Astro);

            } else if (response.equalsIgnoreCase("b"))
            {                
                String food = "";
                int randomFoodNumber = ((int)(Math.random() * 6) + 1);
                if (randomFoodNumber >= 1 && randomFoodNumber < 2)
                {
                    food = "deluxe pancakes";
                } else if (randomFoodNumber >= 2 && randomFoodNumber < 3)
                {
                    food = "a strawberry shortcake";
                } else if (randomFoodNumber >= 3 && randomFoodNumber < 4)
                {
                    food = "a thanksgiving dinner";
                } else if (randomFoodNumber >= 4 && randomFoodNumber < 5)
                {
                    food = "some brownies";
                } else if (randomFoodNumber >= 5 && randomFoodNumber < 6)
                {
                    food = "some chocolate budding";
                } else if (randomFoodNumber >= 6)
                {
                    food = "some beef jerky";
                }
                System.out.print("\f");
                if (Astro.getWeight() == 250 && Astro.getFitnessLevel() == 0)
                {
                    System.out.println("You ate " + food + ".\nYour fitness level is already at its minimum and your weight is already at its maximum.");
                } else if (Astro.getWeight() == 250)
                {
                    System.out.println("You ate " + food + ".\nYour fitness level has decreased.");
                } else if (Astro.getFitnessLevel() == 0)
                {
                    System.out.println("You ate " + food + ".\nYour weight has increased.");
                } else
                {
                    System.out.println("You ate " + food + ".\nYour fitness level has decreased and your weight has increased.");
                }
                Astro.eat();
                System.out.println(Astro);
            } else if (response.equalsIgnoreCase("c"))
            {
                System.out.print("\f");
                if (Astro.getFitnessLevel() < 100)
                {
                    System.out.println("You slept for " + (((int)(Math.random() * 3) + 1) + 5) + " hours and " + ((int)(Math.random() * 59) + 1) + " minutes.\nYour fitness level has increased");
                } else
                {
                    System.out.println("You slept for " + (((int)(Math.random() * 3) + 1) + 5) + " hours and " + ((int)(Math.random() * 59) + 1) + " minutes.\nYour fitness level is already at its maximum.");
                }
                Astro.rest();
                System.out.println(Astro);
            } else if (response.equalsIgnoreCase("d"))
            {
                System.out.print("\f"); 
                if (Astro.getWeight() == 50 && Astro.getFitnessLevel() == 100)
                {
                    System.out.println("You exercised for 1 hour and " + ((int)(Math.random() * 59) + 1) + " minutes.\nYour fitness level is already at its maximum and you weight is already at its minimum.");
                } else if (Astro.getWeight() == 50)
                {
                    System.out.println("You exercised for 1 hour and " + ((int)(Math.random() * 59) + 1) + " minutes.\nYour fitness level has increased.");
                } else if (Astro.getFitnessLevel() == 100)
                {
                    System.out.println("You exercised for 1 hour and " + ((int)(Math.random() * 59) + 1) + " minutes.\nYour weight has decreased.");
                } else
                {
                    System.out.println("You exercised for 1 hour and " + ((int)(Math.random() * 59) + 1) + " minutes.\nYour fitness level has increased and your weight has decreased.");
                }
                Astro.exercise();
                System.out.println(Astro);
            } else if (response.equalsIgnoreCase("e"))
            {
                System.out.print("\f");
                message = "Planets:\n";
                Type(message, 15);

                for (int i = 1; i <= planets.length-1; i++)
                {
                    message = i + ") " + planets[i].getName() + "\n";
                    Type(message, 25);
                }
                counter = 0;

                while (counter == 0)
                {
                    message = "\nEnter the number of the planet you want to travel to: ";
                    Type(message, 25);

                    planetIndex = Input.nextInt();

                    if (planetIndex < 1 || planetIndex > 9)
                    {
                        message = "\nThat is not an option. ";
                        Type(message, 25);
                    } else
                    {
                        counter++;
                    }
                }

                currentPlanet = planets[planetIndex];

                Astro.setCurrentPlanet(currentPlanet);

                traveling();

                message = "You have arrived at " + planets[planetIndex].getName() + "\n";
                Type(message, 25);
                
                waitTime();
                
                System.out.println(Astro);

                Input.nextLine();

            } else if (response.equalsIgnoreCase("f"))
            {
                System.out.print("\f");
                System.out.println("Planets Infomation: ");

                for (int i = 1; i <= planets.length-1; i++)
                {
                    if (currentPlanet == planets[i])
                    {
                        System.out.print("Current - ");
                    } else
                    {
                        System.out.print("          ");
                    }
                    System.out.print(planets[i] + "\n");
                }

            } else if (response.equalsIgnoreCase("g"))
            {
                System.out.print("\f");
                message = "Goodbye!";
                Type(message, 25); 
                break;
            } else
            {
                System.out.print("\f");
                System.out.println("Input a valid action.");
                System.out.println(Astro);
            }
        }
    }

    private static void traveling()
    {
        System.out.println("\f");
        for (int i = 0; i < 10; i++)
        {  
            if (i == 0 || i == 1)
            {
                System.out.print("    Traveling");
            }
            if (i == 2 || i == 3)
            {
                System.out.print("    Traveling.");
            }           
            if (i == 4 || i == 5)
            {
                System.out.print("    Traveling..");
            }            
            if (i == 6 || i == 7)
            {
                System.out.print("    Traveling...");
            }            
            if (i == 8 || i == 9)
            {
                System.out.print("    Traveling....");
            }

            System.out.print("\n\n");
            System.out.println("                                                   ,:");
            System.out.println("                                                 ,' |");
            System.out.println("                                                /   :");
            System.out.println("                                             --'   /");
            System.out.println("                                             \\/ />/");
            System.out.println("                                             / <//_\\");
            System.out.println("                                          __/   /");
            System.out.println("                                          )'-. /");
            System.out.println("                                          ./  :\\");
            System.out.println("                                           /.' '");
            System.out.println("                                         '/'");
            System.out.println("                                         +");
            System.out.println("                                        '");
            System.out.println("                                      `.");
            System.out.println("                                  .-'- ");
            System.out.println("                                 (    |");
            System.out.println("                              . .-'  '.");
            System.out.println("                             ( (.   )8:");
            System.out.println("                         .'    / (_  )");
            System.out.println("                          _. :(.   )8P  `");
            System.out.println("                      .  (  `-' (  `.   .");
            System.out.println("                       .  :  (   .a8a)");
            System.out.println("                      /_`( 'a `a. )''");
            System.out.println("                  (  (/  .  ' )=='");
            System.out.println("                 (   (    )  .8'   +");
            System.out.println("                   (`'8a.( _(   (");
            System.out.println("                ..-. `8P    ) `  )  +");
            System.out.println("              -'   (      -ab:  )");
            System.out.println("            '    _  `    (8P'Ya");
            System.out.println("          _(    (    )b  -`.  ) +");
            System.out.println("         ( 8)  ( _.aP' _a   \\( \\   *");
            System.out.println("       +  )/    (8P   (88    )  )");
            System.out.println("          (a:f   '     `'       `");

            try {
                Thread.sleep(150);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            System.out.println("\f");

            if (i == 0 || i == 1)
            {
                System.out.print("    Traveling");
            }
            if (i == 2 || i == 3)
            {
                System.out.print("    Traveling.");
            }           
            if (i == 4 || i == 5)
            {
                System.out.print("    Traveling..");
            }            
            if (i == 6 || i == 7)
            {
                System.out.print("    Traveling...");
            }            
            if (i == 8 || i == 9)
            {
                System.out.print("    Traveling....");
            }

            System.out.print("\n\n");
            System.out.println("                                                   ,:");
            System.out.println("                                                 ,' |");
            System.out.println("                                                /   :");
            System.out.println("                                             --'   /");
            System.out.println("                                             \\/ />/");
            System.out.println("                                             / <//_\\");
            System.out.println("                                          __/   /");
            System.out.println("                                          )'-. /");
            System.out.println("                                          ./  :\\");
            System.out.println("                                           /.' '");
            System.out.println("                                         '/'");
            System.out.println("                                         +");
            System.out.println("                                        '");
            System.out.println("                                      `.");
            System.out.println("                                  .--'- ");
            System.out.println("                                 (    |");
            System.out.println("                               . .-''.");
            System.out.println("                             ( a8((.   )8:");
            System.out.println("                           .'   (8 -/_  )");
            System.out.println("                          _. :(.+   )8P  `");
            System.out.println("                      .  (  `-') (  `.   .");
            System.out.println("                       .  :  (   .a8a)");
            System.out.println("                     /_`(( 'aa `a. )''");
            System.out.println("                   (  (/  ).  '=='");
            System.out.println("                 (   (-    )  .8'   +");
            System.out.println("                   (`'8a.( _(   (");
            System.out.println("                ..--. `8zP    ) `  )  +");
            System.out.println("              -'8   (      -a-b:  )");
            System.out.println("             '    _  `    P'Ya");
            System.out.println("          _(    (    )b  -`.  ) +");
            System.out.println("          ( 8)   _.P' _a   \\( \\");
            System.out.println("         /    (8P   (88    )  ");
            System.out.println("            ( '     `'     ");

            try {
                Thread.sleep(150);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            System.out.println("\f");
        }
        System.out.print("\f");
    }

    private static void actions()
    {
        System.out.println("\n");
        System.out.println("              ____,.--------------.,___             ___,.---------------.,____               ");
        System.out.println("      ____----'                        `'- .   . -'`                          '----____      ");
        System.out.println("     |                                      \\ /                                        |     ");
        System.out.println("    ||                                       |                                         ||    ");
        System.out.println("    ||                                       |                                         ||    ");    
        System.out.println("    ||                                       |                                         ||    ");
        System.out.println("    ||           ----Actions----             |                                         ||    ");
        System.out.println("    ||                                       |                                         ||    ");
        System.out.println("    ||           a) Jump                     |                                         ||    ");
        System.out.println("    ||           b) Eat                      |                                         ||    ");
        System.out.println("    ||           c) Rest                     |                                         ||    ");
        System.out.println("    ||           d) Exercise                 |                                         ||    ");
        System.out.println("    ||           e) Travel                   |                                         ||    ");
        System.out.println("    ||           f) Show Planet Info         |                                         ||    ");
        System.out.println("    ||           g) Exit                     |                                         ||    ");
        System.out.println("    ||                                       |                                         ||    ");
        System.out.println("    ||                                       |                                         ||    ");
        System.out.println("    ||                                       |                                         ||    ");
        System.out.println("    ||                                       |                                         ||    ");
        System.out.println("    ||                 ____________          |           ____________                  ||    ");
        System.out.println("    ||        ______''  ________    '---,    |     ,---'    ________  ''______         ||    ");
        System.out.println("    ||_______'___,-----'        ' --- ,  '--.|.--'   , --- '        '-----,___' _______||    ");
        System.out.println("    |___________________________________.         ._____________________________________|    ");
        System.out.println("                                         '-------'                                           ");      
    }

    private static void Type(String message, long speed)            // decrease speed to increase overall speed (sleeping for less time)
    {
        for (int i = 0; i < message.length(); i++)
        {
            System.out.print(message.charAt(i));

            try
            {
                Thread.sleep(speed);
            }
            catch (InterruptedException a)
            {
                a.printStackTrace();
            }
        }
    }

    private static void waitTime()
    {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }   
    }

    private static void waitTime2()
    {
        try {
            Thread.sleep(750);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }   
    }

    private static void Earth()
    {
        //System
    }
}

