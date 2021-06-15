package transport.sortInformation;

import transport.model.Transport;

import java.util.Comparator;

public class SortByHeight implements Comparator<Transport> {
    @Override
    public int compare(Transport t1, Transport t2) {
        float results = t1.getHeight() - t2.getHeight();
        if (results > 0) {
            return 1;
        }
        if (results < 0) {
            return -1;
        }
        return 0;

    }
}
