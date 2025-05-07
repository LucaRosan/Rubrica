package it.rubrica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rubrica.model.Contatto;
import it.rubrica.repository.ContattiRepository;

@Service
public class ContattiServiceImpl implements ContattiService{


    @Autowired
    private ContattiRepository contattiRepository;


    @Override
    public List<Contatto> elencoContatti() {
        return (List<Contatto>) contattiRepository.findAll();
    }


    @Override
    public Contatto contattoById(Integer id) {
        return contattiRepository.findById(id).get();
    }


    @Override
    public void salvaContatto(Contatto contatto) {
        contattiRepository.save(contatto);
    }


    @Override
    public void eliminaContatto(Integer id) {
        contattiRepository.deleteById(id);
    }

}
