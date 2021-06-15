package transport.model;

import transport.exception.InvalidDateException;
import transport.exception.InvalidNameTransportException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transport implements Serializable {
    private String idTransport;
    private String nameTransport;
    private String kindOfTransport;
    private String manufacturer;
    private String yearOfManufacture;
    private String where;
    private long price;
    private float height;
    private float weight;
    private String licensePlate;

    public Transport() {
    }

    public Transport(String idTransport) {
        this.idTransport = idTransport;
    }

    public Transport(String idTransport, String nameTransport, String kindOfTransport, String manufacturer,
                     String yearOfManufacture, String where,
                     long price, float height, float weight, String licensePlate)
            throws InvalidNameTransportException, InvalidDateException {
        this.idTransport = idTransport;
        setNameTransport(nameTransport);
        this.kindOfTransport = kindOfTransport;
        this.manufacturer = manufacturer;
        setYearOfManufacture(yearOfManufacture);
        this.where = where;
        this.price = price;
        this.height = height;
        this.weight = weight;
        this.licensePlate = licensePlate;
    }

    public String getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(String idTransport) {
        this.idTransport = idTransport;
    }

    public String getNameTransport() {
        return nameTransport;
    }

    public String getKindOfTransport() {
        return kindOfTransport;
    }

    public void setKindOfTransport(String kindOfTransport) {
        this.kindOfTransport = kindOfTransport;
    }


    public void setNameTransport(String nameTransport) throws InvalidNameTransportException {
        String regex = "^[a-zA-Z0-9\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameTransport);
        if (matcher.find()) {
            this.nameTransport = nameTransport;
        } else {
            this.nameTransport = null;
            var msg = "Name isn't Suitable";
            throw new InvalidNameTransportException(msg, nameTransport);
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) throws InvalidDateException {
        String regex = "^[0-9]{2}/[0-9]{2}/[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(yearOfManufacture);
        if (matcher.find()) {
            this.yearOfManufacture = yearOfManufacture;
        } else {
            this.yearOfManufacture = null;
            var msg = "occur Exception Date isn't Suitable";
            throw new InvalidDateException(msg, yearOfManufacture);
        }


    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "idTransport='" + idTransport + '\'' +
                ", nameTransport='" + nameTransport + '\'' +
                ", kindOfTransport='" + kindOfTransport + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", where='" + where + '\'' +
                ", price=" + price +
                ", height=" + height +
                ", weight=" + weight +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
