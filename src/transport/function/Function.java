package transport.function;

import transport.model.Transport;

import java.util.ArrayList;

public interface Function {
    /**
     * create a object transport after add in list and write to file
     * @param transports
     * @param fileName
     */
    void writeTransportInFile(ArrayList<Transport> transports, String fileName);

    /**
     *read information recorded file and output file is list
     * @param fileName
     * @return
     */
    ArrayList<Transport> readInformationInFile(String fileName);

    /**
     *
     * @param transports
     * @param IDTransport
     * @return
     */

    ArrayList<Transport> searchByTransportByKindOfTransport(ArrayList<Transport> transports, String IDTransport);

    /**
     *
     * @param transports
     * @param idTransport
     * @return
     */

    ArrayList<Transport> deleteATransportById(ArrayList<Transport> transports, String idTransport);

    /**
     *
     * @param transports
     * @param ID
     * @param newPrice
     * @return
     */

    ArrayList<Transport> updatePriceTransportById(ArrayList<Transport> transports, String ID, long newPrice);

    /**
     *
     * @param transports
     * @param idTransport
     * @return
     */

    boolean checkExitsIdTransport(ArrayList<Transport> transports, String idTransport);

    /**
     *
     * @param transports
     */

    void showInfo(ArrayList<Transport> transports);

    /**
     *
     * @param transports
     * @return
     */

    ArrayList<String> getID(ArrayList<Transport> transports);

    /**
     *
     * @return
     */

    ArrayList<Transport> getCurrentTransport(ArrayList<Transport> transports);


}
