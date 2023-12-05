package com.example.doctorkom.Services.RepositoryHandler.Commander;

import org.springframework.stereotype.Component;

@Component
public class ExistenceChecker extends Command{
    
    

    //find if there is an entity with the given attribute
    @Override
    public String executecheck(String attribute, String type) {
        return switch (type) {
            case "email" -> accountRepository.findByEmail(attribute).isPresent() ? "email already exists" : "";
            case "username" -> accountRepository.findByUsername(attribute).isPresent() ? "username already exists" : "";
            case "id" -> accountRepository.findById(Integer.parseInt(attribute)).isPresent() ? "id already exits" : "";
            case "mobilePhone" -> systemUserRepository.findByMobilePhone(attribute).isPresent() ? "mobile phone already exists" : "";
            default -> null;
        };
    }
    //find if an acccount exits or not



}
