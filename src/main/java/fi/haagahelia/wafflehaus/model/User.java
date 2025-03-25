package fi.haagahelia.wafflehaus.model;

import jakarta.persistence.*;

@Entity //“This class is a database table.”
@Table(name = "users")
public class User {
    @Id //mark as PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;

    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role = "CUSTOMER";

    public User() {} // create a blank User object when loading from the database

    //constructor
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}