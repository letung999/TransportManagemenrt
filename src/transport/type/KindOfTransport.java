package transport.type;

public enum KindOfTransport {
    CAR("CÁC LOẠI XE Ô TÔ"),
    TRUCT("CÁC LOẠI XE TẢI"),
    VESSELS("CÁC LOẠI TÀU THYỀN"),
    PLANES("CÁC LOẠI MÁY BAY"),
    TRAM("CÁC LOẠI XE ĐIỆN");

    private String value;

    KindOfTransport(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
