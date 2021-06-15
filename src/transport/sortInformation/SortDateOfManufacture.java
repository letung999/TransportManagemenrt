package transport.sortInformation;

import transport.model.Transport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SortDateOfManufacture {
    public void SortByDate(ArrayList<Transport> transports) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < transports.size(); ++i) {
            for (int j = transports.size() - 1; j > i; j--) {
                Transport bj = transports.get(j);
                Transport bbj = transports.get(j - 1);
                try {
                    Date time1 = simpleDateFormat.parse(bj.getYearOfManufacture());
                    Date time2 = simpleDateFormat.parse(bbj.getYearOfManufacture());
                    long resTime1 = time1.getTime();
                    long resTime2 = time2.getTime();
                    if (resTime1 < resTime2) {
                        transports.set(j - 1, bj);
                        transports.set(j, bbj);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
