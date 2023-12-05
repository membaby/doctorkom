package com.example.doctorkom.Services.RepositoryHandler;


import com.example.doctorkom.Services.RepositoryHandler.Commander.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryHandler {
    @Autowired
    private Adder adder;
    @Autowired
    private Finder finder;
    @Autowired
    private ExistenceChecker existenceChecker;
    @Autowired
    private Deleter deleter;


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
