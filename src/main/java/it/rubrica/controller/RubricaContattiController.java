package it.rubrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.rubrica.model.Contatto;
import it.rubrica.service.ContattiService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class RubricaContattiController {

    @Autowired
    private ContattiService contattiService;

    @GetMapping
    public String renderPagina(Model model) {

        model.addAttribute("contatti", contattiService.elencoContatti());
        model.addAttribute("contatto", new Contatto());
        return "rubricacontatti";
    }

    @GetMapping("/dettaglio")
    public String dettaglioContatto(Model model, @RequestParam(required = false) Integer id) {
        model.addAttribute("contatto", contattiService.contattoById(id));
        return "dettagli";
    }

    @GetMapping("/elimina")
    public String eliminaContatto(@RequestParam Integer id) {
        contattiService.eliminaContatto(id);
        return "redirect:/";
    }

    @PostMapping
    public String salvaContatto(@Valid @ModelAttribute Contatto contatto, BindingResult result,
            @RequestParam(required = false, name = "fileFotografia") MultipartFile fotografia,
            Model model) {
                
        if (result.hasErrors()) {
            model.addAttribute("contatti", contattiService.elencoContatti());
            return "rubricacontatti";
        }

        contattiService.salvaContatto(contatto, fotografia);
        return "redirect:/";
    }


    @GetMapping("/modifica")
    public String modificaContatto(@RequestParam Integer id, Model model){

        Contatto contatto = contattiService.contattoById(id);
        
        model.addAttribute("contatto", contatto);
        model.addAttribute("contatti", contattiService.elencoContatti());
        return "rubricacontatti";

    }


}
