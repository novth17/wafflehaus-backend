package fi.haagahelia.wafflehaus.dto;
import fi.haagahelia.wafflehaus.model.Role;

//represents response sent back to the clienet after successful authentication
//return after login
public class AuthResponse {
    private String token;
    private Role role;
    private String username;

    public AuthResponse() {}

    public AuthResponse(String token, Role role, String username) {
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
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
