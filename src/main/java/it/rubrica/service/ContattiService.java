package it.rubrica.service;

import java.util.List;

import it.rubrica.model.Contatto;

public interface ContattiService {

    List<Contatto> elencoContatti();
    Contatto contattoById(Integer id);
    void salvaContatto(Contatto contatto);
    void eliminaContatto(Integer id);
}
