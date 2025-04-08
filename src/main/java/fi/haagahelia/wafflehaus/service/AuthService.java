package fi.haagahelia.wafflehaus.service;

import fi.haagahelia.wafflehaus.dto.AuthRequest;
import fi.haagahelia.wafflehaus.dto.AuthResponse;
import fi.haagahelia.wafflehaus.dto.RegisterRequest;
import fi.haagahelia.wafflehaus.model.Role;
import fi.haagahelia.wafflehaus.model.User;
import fi.haagahelia.wafflehaus.repository.UserRepository;
import fi.haagahelia.wafflehaus.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/* Registers new users
Hashes their passwords
- Saves user with default `CUSTOMER` role  
- Returns a JWT token + role + name | */

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // REGISTER
    public AuthResponse register(RegisterRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Hash password
        user.setRole(Role.CUSTOMER);

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, user.getRole(), user.getName());
    }
    // LOGIN
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        boolean isPasswordCorrect = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!isPasswordCorrect) {
            throw new RuntimeException("Invalid email or password");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, user.getRole(), user.getName());
    }
}
