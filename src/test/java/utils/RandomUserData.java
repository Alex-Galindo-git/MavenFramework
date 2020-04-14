package utils;


import org.apache.commons.lang3.RandomStringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RandomUserData {


    public static String createRandomName() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        System.out.println(generatedString);
        return generatedString;
    }

    public static String createRandomNumber() {
        String generatedStrings = RandomStringUtils.randomNumeric(10);
        System.out.println(generatedStrings);
        return generatedStrings;
    }

    public static String createRandomccvNumber() {
        String generatedStrings = RandomStringUtils.randomNumeric(3);
        System.out.println(generatedStrings);
        return generatedStrings;
    }

    public static String createRandomAlphnumeric() {
        String generatedStrings = RandomStringUtils.randomAlphanumeric(10);
        System.out.println(generatedStrings);
        return generatedStrings;
    }

    public static String generate_InBetweenRandomDate(String Format, String startDate, String endDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(Format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter.parse(startDate));
        Long value1 = cal.getTimeInMillis();

        cal.setTime(formatter.parse(endDate));
        Long value2 = cal.getTimeInMillis();

        long value3 = (long) (value1 + Math.random() * (value2 - value1));
        cal.setTimeInMillis(value3);
        formatter.format(cal.getTime());

//        System.out.println(generate_InBetweenRandomDate("yyyy-MM-dd", "01-Jan-1980", "01-Dec-1990"));
        return generate_InBetweenRandomDate(Format, startDate, endDate);

    }
}