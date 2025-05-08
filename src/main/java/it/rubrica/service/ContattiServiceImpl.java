package it.rubrica.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.rubrica.model.Contatto;
import it.rubrica.repository.ContattiRepository;

@Service
public class ContattiServiceImpl implements ContattiService {

    @Autowired
    private ContattiRepository contattiRepository;

    @Override
    public List<Contatto> elencoContatti() {
        return contattiRepository.findAllByOrderByCognomeAsc();
    }

    @Override
    public Contatto contattoById(Integer id) {
        return contattiRepository.findById(id).get();
    }

    @Override
    public void salvaContatto(Contatto contatto, MultipartFile fotografia) {

        if (fotografia != null && !fotografia.isEmpty()) {
            try {
                String formato = fotografia.getContentType();
                String copertinaCodificata = "data:" + formato + ";base64,"
                        + Base64.getEncoder().encodeToString(fotografia.getBytes());
                contatto.setFotografia(copertinaCodificata);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        contattiRepository.save(contatto);
    }

    @Override
    public void eliminaContatto(Integer id) {
        contattiRepository.deleteById(id);
    }

}
