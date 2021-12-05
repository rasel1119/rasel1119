package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    //Print Month and Year
    public static String returnNextMonth() {
        //Create Data object
        Date dNow = new Date();

        // Create calendar object for GregorianCalender();
        Calendar calendar = new GregorianCalendar();

        //Set calendar date to current date
        calendar.setTime(dNow);

        // Create object of SimpleDateFormat
        // Defining Date format to - example: (Jan-2020)
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");

        // Incrementing the current month
        calendar.add(Calendar.MONTH, 1);

        //Generating the date based on the specified format
        String date = sdf.format(calendar.getTime());

        return date;
    }
}