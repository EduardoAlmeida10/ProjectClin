package com.projectclin.demo.repositories;

import com.projectclin.demo.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //By: João Gabriel
    boolean existsByConfirmationToken(String token);

    @Query(value = "SELECT * FROM TB_USER WHERE confirmation_token = :confirmationToken", nativeQuery = true)
    User getUserByConfirmationToken(@Param("confirmationToken") String confirmationToken);

}
