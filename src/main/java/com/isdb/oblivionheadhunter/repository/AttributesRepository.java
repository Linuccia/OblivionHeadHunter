package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {

    Optional<Attributes> findById(Long id);

}
