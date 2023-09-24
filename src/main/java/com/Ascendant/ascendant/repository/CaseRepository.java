package com.Ascendant.ascendant.repository;

import com.Ascendant.ascendant.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<ClientEntity, Long> {
}
