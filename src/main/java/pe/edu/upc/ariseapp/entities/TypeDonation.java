package pe.edu.upc.ariseapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Typedonation")
public class TypeDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDonation;

    @Column(name = "typeDonation" , nullable = false,length = 30)
    private String typeDonation;

    @ManyToOne
    @JoinColumn(name="idDonation", nullable=false)
    private Donation donation;

    public TypeDonation() {
    }

    public TypeDonation(int idTypeDonation, String typeDonation, Donation donation) {
        this.idTypeDonation = idTypeDonation;
        this.typeDonation = typeDonation;
        this.donation = donation;
    }

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
