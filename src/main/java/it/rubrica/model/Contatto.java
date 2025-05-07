package it.rubrica.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contatti")
public class Contatto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,50}", message = "Caratteri Non Ammessi In Nome")
    private String nome;
    @Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,50}", message = "Caratteri Non Ammessi In Cognome")
    private String cognome;

    private String fotografia;

    @Pattern(regexp = "\\d{10}", message = "Caratteri Non Ammessi In Telefono")
    private String telefono;

    @Email(message = "Inserisci un indirizzo email valido")
    private String mail;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="indirizzo_id", referencedColumnName="id")
    @Valid
    private Indirizzo indirizzo;

}
