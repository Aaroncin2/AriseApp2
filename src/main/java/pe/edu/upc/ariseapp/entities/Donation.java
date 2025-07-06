package pe.edu.upc.ariseapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDonation;

    @Column(name="nameDonation", nullable = false, length = 30)
    private String nameDonation;

    @Column(name = "donation" , nullable = false, length = 30)
    private String donation;

    public Donation() {
    }

    public Donation(int idDonation, String nameDonation, String donation) {
        this.idDonation = idDonation;
        this.nameDonation = nameDonation;
        this.donation = donation;
    }

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
