/**
 * AuthController handles user authentication endpoints.
 * 
 * Base path: /api/auth
 * 
 * This REST controller exposes the following routes:
 * - POST /register : Register a new user and return JWT
 * - POST /login    : Authenticate user credentials and return JWT
 * 
 * The controller allows cross-origin requests to support frontend apps
 * (e.g. React or mobile clients) interacting with this API.
 */
package fi.haagahelia.wafflehaus.controller;
import fi.haagahelia.wafflehaus.dto.AuthRequest;
import fi.haagahelia.wafflehaus.dto.AuthResponse;
import fi.haagahelia.wafflehaus.dto.RegisterRequest;
import fi.haagahelia.wafflehaus.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request){
        return authService.login(request);
    }
}
