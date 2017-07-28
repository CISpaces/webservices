/**
 * This class is responsible for formatting Date objects which will be inserted into the database.
 *
 * @author Yordanka Ivanova
 * @since July 2017
 */

package utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {

    /**
     * @param dateString the date string extracted from the JSON
     * @return a timestamp object which can be put into the database
     */
    public Timestamp formatDateCIS(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Timestamp(date.getTime());
    }
}
