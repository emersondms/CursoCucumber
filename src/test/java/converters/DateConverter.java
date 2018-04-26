package converters;

import cucumber.api.Transformer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter extends Transformer<Date> {

    @Override
    public Date transform(String s) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
