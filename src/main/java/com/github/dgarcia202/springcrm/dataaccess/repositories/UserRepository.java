package com.github.dgarcia202.springcrm.dataaccess.repositories;

import com.github.dgarcia202.springcrm.dataaccess.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
