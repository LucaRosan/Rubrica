package it.rubrica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "indirizzo")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,50}", message = "Caratteri Non Ammessi In Via")
    private String via;
    @Pattern(regexp = "\\d{1,5}", message = "Caratteri Non Ammessi In Civico (massimo 5 cifre)")
    private String civico;
    @Pattern(regexp = "\\d{5}", message = "Caratteri Non Ammessi In Cap (deve contenere 5 cifre)")
    private String cap;
    @Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,50}", message = "Caratteri Non Ammessi In Comune")
    private String comune;
    @Pattern(regexp = "[a-zA-Z]{2}", message = "Caratteri Non Ammessi In Provincia")
    private String provincia;

}
