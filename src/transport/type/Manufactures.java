package transport.type;

public class Manufactures {
    public String getManufactures(int option){
        String manufacturer = null;
        switch (option){
            case 1:{
                manufacturer = Manufacturer.FOR.toString();
                break;
            }
            case 2:{
                manufacturer = Manufacturer.TOYOTA.toString();
                break;
            }
            case 3:{
                manufacturer = Manufacturer.MARTIN.toString();
                break;
            }
            case 4:{
                manufacturer = Manufacturer.MERCEDES.toString();
                break;
            }
            case 5:{
                manufacturer = Manufacturer.MITSUBISHI.toString();
                break;
            }
            case 6:{
                manufacturer = Manufacturer.HYUNDAI.toString();
                break;
            }
            case 7:{
                manufacturer = Manufacturer.NISSAN.toString();
                break;
            }
            case 8:{
                manufacturer = Manufacturer.KIA.toString();
                break;
            }
        }
        return manufacturer;
    }
}
