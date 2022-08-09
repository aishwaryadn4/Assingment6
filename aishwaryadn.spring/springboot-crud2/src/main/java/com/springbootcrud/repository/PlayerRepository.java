package com.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootcrud.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player ,Long> {

}
