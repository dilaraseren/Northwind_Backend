package io.kodlama.Northwind.core.dataAccess;

import io.kodlama.Northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);

}
