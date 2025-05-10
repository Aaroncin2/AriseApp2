package pe.edu.upc.ariseapp.dtos;

public class HU54DTO {
    private String TypeDonation;
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTypeDonation() {
        return TypeDonation;
    }

    public void setTypeDonation(String typeDonation) {
        TypeDonation = typeDonation;
    }
}
