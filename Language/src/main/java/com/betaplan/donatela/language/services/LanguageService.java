package com.betaplan.donatela.language.services;

import com.betaplan.donatela.language.models.Language;
import com.betaplan.donatela.language.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository lRepo;

    //Get every single language from database
    public List<Language> getAllLanguages(){
        return this.lRepo.findAll();
    }

    //Get one language
    public Language getOneLanguage(Long id){
        return this.lRepo.findById(id).orElse(null);
    }

    //Create a language
    public Language createLanguage(Language language){
        return this.lRepo.save(language);
    }

    //Update language
    public Language editLanguage(Language language){
        return this.lRepo.save(language);
    }

    //Delete when it has a button
   /* public String deleteLanguage(Long id){
        this.lRepo.deleteById(id);
        return "Language has been deleted";
    }*/

    //View Information, also used for the delete link in the controller class
    public Language getById(Long id ){
        return this.lRepo.findById(id).orElse(null);
    }

    //Delete when it is with a link tag
    public void deleteLanguage(Language language) {
        lRepo.delete(language);
    }
}
