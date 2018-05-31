package com.github.dgarcia202.springcrm.dataaccess.repositories;

import com.github.dgarcia202.springcrm.dataaccess.entities.Authority;
import com.github.dgarcia202.springcrm.dataaccess.entities.AuthorityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityKey> {
    List<Authority> findByusername(String username);
}
