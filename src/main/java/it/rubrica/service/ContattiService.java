package it.rubrica.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.rubrica.model.Contatto;

public interface ContattiService {

    List<Contatto> elencoContatti();
    Contatto contattoById(Integer id);
    void salvaContatto(Contatto contatto, MultipartFile fotografia);
    void eliminaContatto(Integer id);
}
