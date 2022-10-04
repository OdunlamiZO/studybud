package odunlamizo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import odunlamizo.model.Entity;

public abstract class Repository<T extends Entity, Id> {

    public abstract T save(T entity);

    public abstract T find(Id id);

    protected Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/studybud", "studybud", "pAsSwOrD");
    }
    
}