package transport.view;


import transport.connectdataBase.DeleteATransportInDataBase;
import transport.connectdataBase.InsertIntoInDataBase;
import transport.connectdataBase.LoadDataFromDataBase;
import transport.controller.Controller;
import transport.exception.InvalidDateException;
import transport.exception.InvalidNameTransportException;
import transport.model.Transport;
import transport.randomElement.IDTransport;
import transport.randomElement.LicensePlate;
import transport.sortInformation.SortByHeight;
import transport.sortInformation.SortByPrice;
import transport.sortInformation.SortByWeight;
import transport.sortInformation.SortDateOfManufacture;
import transport.type.KindOfTransports;
import transport.type.Manufactures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var id = new IDTransport();
        var load = new LoadDataFromDataBase();
        var insert = new InsertIntoInDataBase();
        var delete = new DeleteATransportInDataBase();
        var sortByDateOfManufacture = new SortDateOfManufacture();
        var kindOfTransports = new KindOfTransports();
        var manufacturers = new Manufactures();
        var licensePlates = new LicensePlate();
        var transport = new Transport();
        var controller = new Controller();
        ArrayList<Transport> transports = new ArrayList<Transport>();
        var fileName = "TRANSPORT.DAT";
        int option, chooseKindOfTransport, chooseManufacturer;
        do {
            System.out.println("*************************Menu*********************");
            System.out.println("1.Add A Transport In File");
            System.out.println("2.Show Information In File ");
            System.out.println("3.Search A Transport By ID");
            System.out.println("4.Delete A Transport By ID");
            System.out.println("5.Sort Date of Manufacture");
            System.out.println("6.Sort by Price");
            System.out.println("7.Sort by Height");
            System.out.println("8.Sort By Weight");
            System.out.println("9.Update Price For A Transport");
            System.out.println("10.Write Information in Database");
            System.out.println("11.Load Data Information in Database");
            System.out.println("12.Delete A Transport in DataBase");
            System.out.println("0.exits");
            System.out.println("you choose");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0: {
                    System.out.println("exits");
                    break;
                }
                case 1: {
                    if (transports.size() > 0) {
                        transports = controller.readInformationInFile(fileName);
                    } else {
                        //do nothing
                    }
                    String idTransport, nameTransport, kindOfTransport, manufacturer, yearOfManufacture, where;
                    long price;
                    float height;
                    float weight;
                    String licensePlate;
                    idTransport = id.getIdTransport();
                    transport.setIdTransport(idTransport);
                    System.out.println("Enter Name Transport");
                    nameTransport = scanner.nextLine();
                    try {
                        transport.setNameTransport(nameTransport);
                    } catch (InvalidNameTransportException e) {
                        System.out.println("Occur InvalidNameTransportException");
                        System.out.println(e.getMessage());
                    }
                    do {
                        System.out.println("Enter Kind Of Transport");
                        System.out.println("1.CAR\n2.TRUCK\n3.VESSELS\n4PLANES\n5.TRAM");
                        chooseKindOfTransport = scanner.nextInt();
                        if (chooseKindOfTransport >= 1 && chooseKindOfTransport <= 5) {
                            kindOfTransport = kindOfTransports.getKindOfTransport(chooseKindOfTransport);
                            transport.setKindOfTransport(kindOfTransport);
                            break;
                        } else {
                            System.out.println("choose option in List");
                        }
                    } while (true);
                    do {
                        System.out.println("Enter Kind Of manufacturer");
                        System.out.println("1.FOR\n2.TOYOTA\n3.MARTIN\n4.MERCEDES5" +
                                "\n5.MITSUBISHI\n6.HYUNDAI\n7.NISSAN\n8.KIA");
                        chooseManufacturer = scanner.nextInt();
                        if (chooseManufacturer >= 1 && chooseManufacturer <= 8) {
                            manufacturer = manufacturers.getManufactures(chooseManufacturer);
                            transport.setManufacturer(manufacturer);
                            break;
                        } else {
                            System.out.println("choose option in List");
                        }
                    } while (true);
                    System.out.println("Enter Year of manufacture( format:dd/mm/yyyy)");
                    scanner.nextLine();
                    yearOfManufacture = scanner.nextLine();
                    try {
                        transport.setYearOfManufacture(yearOfManufacture);
                    } catch (InvalidDateException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter Where manufactures");
                    where = scanner.nextLine();
                    transport.setWhere(where);
                    System.out.println("Enter Price($)");
                    price = scanner.nextLong();
                    transport.setPrice(price);
                    System.out.println("Enter Height(cm)");
                    height = scanner.nextInt();
                    transport.setHeight(height);
                    System.out.println("Enter Weight(kg)");
                    weight = scanner.nextFloat();
                    transport.setWeight(weight);
                    licensePlate = licensePlates.getLicensePlate();
                    transport.setLicensePlate(licensePlate);
                    transports.add(transport);
                    controller.writeTransportInFile(transports, fileName);
                    break;
                }
                case 2: {
                    transports = controller.readInformationInFile(fileName);
                    System.out.println("*********************SHOW INFORMATION A TRANSPORT*******************\n");
                    controller.showInfo(transports);
                    break;
                }
                case 3: {
                    String ID;
                    transports = controller.readInformationInFile(fileName);
                    System.out.println("*********************SHOW INFORMATION A TRANSPORT*******************\n");
                    controller.showInfo(transports);
                    System.out.println("Enter ID Transport to Search");
                    ID = scanner.nextLine();
                    var results = new ArrayList<Transport>();
                    results = controller.searchByTransportByKindOfTransport(transports, ID);
                    if (results.size() == 0) {
                        System.out.println("No information to search");
                    } else {
                        System.out.println("*************************RESULTS***************************\n");
                        controller.showInfo(results);
                    }
                    break;
                }
                case 4: {
                    String ID;
                    transports = controller.readInformationInFile(fileName);
                    System.out.println("*********************SHOW INFORMATION A TRANSPORT*******************\n");
                    controller.showInfo(transports);
                    System.out.println("Enter ID Transport to Delete");
                    ID = scanner.nextLine();
                    if (controller.checkExitsIdTransport(transports, ID) == false) {
                        System.out.println("ID NOT EXIT IN SYSTEM");
                    }
                    transports = controller.deleteATransportById(transports, ID);
                    System.out.println("*************************RESULTS***************************\n");
                    controller.showInfo(transports);
                    controller.writeTransportInFile(transports, fileName);
                    break;
                }
                case 5: {
                    transports = controller.readInformationInFile(fileName);
                    sortByDateOfManufacture.SortByDate(transports);
                    System.out.println("*************************RESULTS***************************\n");
                    controller.showInfo(transports);
                    break;

                }
                case 6: {
                    transports = controller.readInformationInFile(fileName);
                    Collections.sort(transports, new SortByPrice());
                    System.out.println("*************************RESULTS***************************\n");
                    controller.showInfo(transports);
                    break;
                }
                case 7: {
                    transports = controller.readInformationInFile(fileName);
                    Collections.sort(transports, new SortByHeight());
                    System.out.println("*************************RESULTS***************************\n");
                    controller.showInfo(transports);
                    break;
                }
                case 8: {
                    transports = controller.readInformationInFile(fileName);
                    Collections.sort(transports, new SortByWeight());
                    System.out.println("*************************RESULTS***************************\n");
                    controller.showInfo(transports);
                    break;
                }
                case 9: {
                    String ID;
                    long newPrice;
                    transports = controller.readInformationInFile(fileName);
                    System.out.println("*********************SHOW INFORMATION A TRANSPORT*******************\n");
                    controller.showInfo(transports);
                    System.out.println("Enter ID Transport to Update");
                    ID = scanner.nextLine();
                    if (controller.checkExitsIdTransport(transports, ID) == false) {
                        System.out.println("ID NOT EXIT IN SYSTEM");
                        break;
                    }
                    System.out.println("Enter New price Transport to Update");
                    newPrice = scanner.nextLong();
                    transports = controller.updatePriceTransportById(transports, ID, newPrice);
                    System.out.println("*************************RESULTS***************************\n");
                    controller.showInfo(transports);
                    controller.writeTransportInFile(transports, fileName);
                    break;
                }
                case 10: {
                    ArrayList<Transport> resultDifferent = new ArrayList<Transport>();
                    var listTransport = load.load();
                    int results = -1;
                    transports = controller.readInformationInFile(fileName);
                    for (int i = 0; i < transports.size(); ++i) {
                        if (controller.checkExitsIdTransport(listTransport, transports.get(i).getIdTransport()) == false) {
                            resultDifferent.clear();
                            resultDifferent.add(transports.get(i));
                            insert.Insert(resultDifferent);
                        }
                    }
                }
                case 11: {
                    transports = load.load();
                    if (transports.size() == 0) {
                        System.out.println("List Is Null");
                    }
                    System.out.println("*************************RESULTS***************************\n");
                    controller.showInfo(transports);
                    break;
                }
                case 12: {
                    transports = load.load();
                    if (transports.size() == 0) {
                        System.out.println("List Is Null");
                        break;
                    }
                    System.out.println("*************************RESULTS***************************\n");
                    controller.showInfo(transports);
                    System.out.println("Enter ID ATransport to Delete");
                    String ID;
                    ID = scanner.nextLine();
                    if (controller.checkExitsIdTransport(transports, ID) == false) {
                        System.out.println("ID isn't Exit In DataBase");
                        break;
                    }
                    int result = delete.delete(ID);
                    if (result != -1) {
                        System.out.println("DELETE SUCCESS");
                    } else {
                        System.out.println("FAIL");
                    }
                    break;
                }
            }
        } while (option != 0);
    }

    public static boolean checkExitsIdTransport(ArrayList<String> transports, String idTransport) {
        for (int i = 0; i < transports.size(); ++i) {
            if (transports.get(i).equals(idTransport) == true) {
                return true;
            }
        }
        return false;
    }

}
