package utils;

import java.util.Random;

public class TestData
{
    public static Random random = new Random();

    public static String getRandomFirstName()
    {
        String[] names = {"John", "Amit", "Ravi", "Neha", "Priya"};
        return names[random.nextInt(names.length)];
    }

    public static String getRandomLastName()
    {
        String[] names = {"Sharma", "Patel", "Singh", "Kumar", "Das"};
        return names[random.nextInt(names.length)];
    }

    public static String getRandomYear()
    {
        int year = random.nextInt(121);
        return String.valueOf(year);
    }

    public static String getRandomMonth()
    {
        int month = random.nextInt(12); 
        return String.valueOf(month);
    }

    public static String getRandomAddress()
    {
        return "Street " + (100 + random.nextInt(900));
    }

    public static String getRandomPhone()
    {
        return "9" + (100000000 + random.nextInt(900000000));
    }
}