package fi.haagahelia.wafflehaus.dto;

//represent data required to create a new user account
//JSON frontend send to backend
public class RegisterRequest {
    private String name;
    private String email;
    private String password;

    //Fields that match the expected input when registering
    public RegisterRequest() {}

    //constructor - deserialize the JSON into this object
    public RegisterRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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
}
