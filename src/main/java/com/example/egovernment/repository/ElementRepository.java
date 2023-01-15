package com.example.egovernment.repository;

import com.example.egovernment.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element, Integer> {
    Element findByCode(String code);
}
