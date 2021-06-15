package transport.controller;

import transport.function.Function;
import transport.model.Transport;
import transport.model.Transport;

import java.io.*;
import java.util.ArrayList;

public class Controller implements Function {
    @Override
    public void writeTransportInFile(ArrayList<Transport> transports, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(transports);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Transport> readInformationInFile(String fileName) {
        ArrayList<Transport> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Transport>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Transport> searchByTransportByKindOfTransport(ArrayList<Transport> transports, String IdTransport) {
        ArrayList<Transport> results = new ArrayList<>();
        for (int i = 0; i < transports.size(); ++i) {
            if (transports.get(i).getIdTransport().equals(IdTransport) == true) {
                results.add(transports.get(i));
            }
        }
        return results;
    }

    @Override
    public ArrayList<Transport> deleteATransportById(ArrayList<Transport> transports, String idTransport) {
        for (int i = 0; i < transports.size(); ++i) {
            if (transports.get(i).getIdTransport().equals(idTransport) == true) {
                transports.remove(transports.get(i));
            }
        }
        return transports;
    }

    @Override
    public ArrayList<Transport> updatePriceTransportById(ArrayList<Transport> transports, String ID, long newPrice) {
        for (int i = 0; i < transports.size(); ++i) {
            if (transports.get(i).getIdTransport().equals(ID) == true) {
                transports.get(i).setPrice(newPrice);
            }
        }
        return transports;
    }

    @Override
    public boolean checkExitsIdTransport(ArrayList<Transport> transports, String idTransport) {
        for (var transport : transports) {
            if (transport.getIdTransport().equals(idTransport) == true) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showInfo(ArrayList<Transport> transports) {
        System.out.printf("%-20s%-35s%-20s%-15s%-20s%-10s%-10s%-10s%-10s%-10s\n",
                "idTransport", "nameTransport", "getKindOfTransport", "manufacturer", "yearOfManufacture",
                "where", "price", "height", "weight", "licensePlate");
        for (var transport : transports) {
            System.out.printf("%-20s%-35s%-20s%-15s%-20s%-10s%-10s%-10s%-10s%-10s\n",
                    transport.getIdTransport(), transport.getNameTransport(), transport.getKindOfTransport(),
                    transport.getManufacturer(), transport.getYearOfManufacture(), transport.getWhere(),
                    transport.getPrice(), transport.getHeight(), transport.getWeight(), transport.getLicensePlate());
        }

    }

    @Override
    public ArrayList<String> getID(ArrayList<Transport> transports) {
        ArrayList<String> results = new ArrayList<>();
        for(int i = 0; i < transports.size(); ++i){
            results.add(transports.get(i).getIdTransport());
        }
        return results;
    }

    @Override
    public ArrayList<Transport> getCurrentTransport(ArrayList<Transport> transports) {
        var results = new ArrayList<>();
//        for (int i = 0; i < )
        return null;
    }

}
