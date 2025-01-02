package app.repositories;

import app.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    Users findByUserName(String userName);

    boolean existsByEmail(String email);
}
