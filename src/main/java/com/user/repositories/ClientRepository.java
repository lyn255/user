package com.user.repositories;

import com.user.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepository extends JpaRepository<Client, Integer> { //Client is the name of the model class and Integer is the primary key
}

