package weather.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CurrentDate {

    protected Date date;

    public CurrentDate(Date timestamp) {
        this.date = date;
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, MMM dd", new Locale("en", "EN"));
        return simpleDateFormat.format(date);
    }
}
