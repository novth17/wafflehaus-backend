package fi.haagahelia.wafflehaus.repository;

import fi.haagahelia.wafflehaus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
