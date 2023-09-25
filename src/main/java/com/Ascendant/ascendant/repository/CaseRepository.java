package com.Ascendant.ascendant.repository;

import com.Ascendant.ascendant.entity.CaseEntity;
import com.Ascendant.ascendant.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaseRepository extends JpaRepository<CaseEntity, Long> {

    List<CaseEntity> findByCaseId(@Param("caseId") long caseId);
}
