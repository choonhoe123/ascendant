package com.Ascendant.ascendant.services;

import com.Ascendant.ascendant.entity.CaseEntity;
import com.Ascendant.ascendant.model.Case;
import com.Ascendant.ascendant.model.Client;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CaseService {
    Case createCase(@RequestBody Case c);
    Case getCaseById(@PathVariable Long caseId);
    List<Case> getAllCases();
    Case findByCaseId(@PathVariable Long caseId);
    Client findCaseByClientId(@PathVariable Long caseId);
    Case updateCase(@PathVariable Long caseId, @RequestBody Case c);
    Case endCase(@PathVariable Long caseId);
}

