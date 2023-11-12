package com.example.doctorkom.Configs;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;

public class NamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier(capitalizeFirstLetter(name.getText()), name.isQuoted());
    }

    private String capitalizeFirstLetter(String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1).toLowerCase();
    }
}
