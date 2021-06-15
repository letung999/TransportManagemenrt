package transport.type;


public class KindOfTransports {
    public String getKindOfTransport(int option) {
        String kinds = null;
        switch (option) {
            case 1: {
                kinds = KindOfTransport.CAR.getValue();
                break;
            }
            case 2: {
                kinds = KindOfTransport.TRUCT.getValue();
                break;
            }
            case 3: {
                kinds = KindOfTransport.PLANES.getValue();
                break;

            }
            case 4: {
                kinds = KindOfTransport.VESSELS.getValue();
                break;
            }
            case 5: {
                kinds = KindOfTransport.TRAM.getValue();
                break;
            }
        }
        return kinds;
    }
}
