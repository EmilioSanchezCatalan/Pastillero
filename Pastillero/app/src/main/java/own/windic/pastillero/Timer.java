package own.windic.pastillero;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by windic on 27/01/2017.
 */

public class Timer {
    public static String now(){
        return new SimpleDateFormat("dd/M/yyyy").format(new Date());
    }
}
