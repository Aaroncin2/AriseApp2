package pe.edu.upc.ariseapp.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pe.edu.upc.ariseapp.entities.Donation;

public class TypeDonationDTO {
    private int idTypeDonation;
    @NotBlank(message = "El nombre de la donacion no puede estar vacío")
    @Size(max = 30, message = "El nombre de la donacion no puede tener más de 30 caracteres")
    private String typeDonation;
    private Donation donation;

    public int getIdTypeDonation() {
        return idTypeDonation;
    }

    public void setIdTypeDonation(int idTypeDonation) {
        this.idTypeDonation = idTypeDonation;
    }

    public String getTypeDonation() {
        return typeDonation;
    }

    public void setTypeDonation(String typeDonation) {
        this.typeDonation = typeDonation;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

}
