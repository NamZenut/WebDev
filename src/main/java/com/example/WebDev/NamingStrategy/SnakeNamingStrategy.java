package com.example.WebDev.NamingStrategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class SnakeNamingStrategy implements PhysicalNamingStrategy {
    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    private Identifier convertToSnakeCase(Identifier identifier) {
        if (identifier == null) {
            return null;
        }
        return Identifier.toIdentifier(identifier.getText().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase());
    }
}