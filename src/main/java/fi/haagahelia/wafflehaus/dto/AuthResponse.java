package fi.haagahelia.wafflehaus.dto;

//represents response sent back to the clienet after successful authentication
//return after login
public class AuthResponse {
    private String token;
    private String role;
    private String username;

    public AuthResponse() {}

    public AuthResponse(String token, String role, String username) {
        this.token = token;
        this.role = role;
        this.username = username;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
