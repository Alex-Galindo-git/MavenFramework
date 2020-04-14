package utils;


import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Random;

public class CalendarDate  {
    @Test
//    public static void main(){
    public static String getRandomBirthDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1970, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(1997, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate  randomBirthDate = LocalDate.ofEpochDay(randomDay);

        return randomBirthDate.toString();
    }

    @Test
//    public static void main(){
    public static String getExpirationDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2020, 06, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2025, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomExpDate = LocalDate.ofEpochDay(randomDay);

        return randomExpDate.toString();
    }


}

