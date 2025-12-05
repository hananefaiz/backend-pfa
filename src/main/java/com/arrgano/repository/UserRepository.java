package com.arrgano.repository;



import com.arrgano.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByRole(String role);
    List<User> findByDepartment(String department);
    List<User> findByActiveTrue();
}
