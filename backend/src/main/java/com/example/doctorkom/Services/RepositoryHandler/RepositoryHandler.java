package com.example.doctorkom.Services.RepositoryHandler;


import com.example.doctorkom.Services.RepositoryHandler.Commander.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryHandler {
    private final Adder adder;
    private final Finder finder;
    private final ExistenceChecker existenceChecker;
    private final Deleter deleter;


    @Autowired
    public RepositoryHandler(Adder adder, Finder finder, ExistenceChecker existenceChecker, Deleter deleter) {
        this.adder = adder;
        this.finder = finder;
        this.existenceChecker = existenceChecker;
        this.deleter = deleter;
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
            case "delete" -> {
                return deleter;
            }
            default -> {
                return null;
            }
        }
    }



}
