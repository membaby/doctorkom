package com.example.doctorkom.Services.RepositoryHandler;


import com.example.doctorkom.Services.RepositoryHandler.Commander.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryHandler {
    private final Adder adder;
    private final Finder finder;
    private final ExistenceChecker existenceChecker;


    @Autowired
    public RepositoryHandler(Adder adder, Finder finder, ExistenceChecker existenceChecker) {
        this.adder = adder;
        this.finder = finder;
        this.existenceChecker = existenceChecker;
    }
    //add account to database
    public Command GetCommmand(String command){
        switch (command) {
            case "add" -> {
                return adder;
            }
            case "find" -> {
                return finder;
            }
            case "check" -> {
                return existenceChecker;
            }
            default -> {
                return null;
            }
        }
    }



}
