package api.v1.metrics.repository;

import api.v1.metrics.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
}
