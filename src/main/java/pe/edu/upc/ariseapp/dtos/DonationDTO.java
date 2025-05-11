package pe.edu.upc.ariseapp.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DonationDTO {
    private int idDonation;
    @NotBlank(message = "El nombre de la donacion no puede estar vacío")
    @Size(max = 30, message = "El nombre de la donacion no puede tener más de 30 caracteres")
    private String nameDonation;
    @NotBlank(message = "La donacion no puede estar vacío")
    @Size(max = 30, message = "La donacion no puede tener más de 30 caracteres")
    private String donation;

    public int getIdDonation() {
        return idDonation;
    }

    public void setIdDonation(int idDonation) {
        this.idDonation = idDonation;
    }

    public String getNameDonation() {
        return nameDonation;
    }

    public void setNameDonation(String nameDonation) {
        this.nameDonation = nameDonation;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }
}
