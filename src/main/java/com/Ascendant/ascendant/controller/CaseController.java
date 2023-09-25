package com.Ascendant.ascendant.controller;

import com.Ascendant.ascendant.entity.CaseEntity;
import com.Ascendant.ascendant.model.Case;
import com.Ascendant.ascendant.model.Client;
import com.Ascendant.ascendant.services.CaseServiceImpl;
import com.Ascendant.ascendant.services.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CaseController {
    private final CaseServiceImpl caseService;

    public CaseController(CaseServiceImpl caseService) {
        this.caseService = caseService;
    }

    @PostMapping("/case")
    public Case createCase(@RequestBody Case c) {
        return caseService.createCase(c);
    }

    @GetMapping("/case/{id}")
    public List<Case> getAllCases() {
        return caseService.getAllCases();
    }
    @GetMapping("/case")
    public Case getCaseById(@PathVariable long id) {
            return caseService.getCaseById(id);
    }

    @GetMapping("/case/getClient/{caseId}")
    public Client findClientByCaseId(@PathVariable Long caseId) {
        return caseService.findCaseByClientId(caseId);
    }

    @PutMapping("/case/{caseId}")
    public ResponseEntity<Case> updateCase(@PathVariable Long caseId, @RequestBody Case c) {
        c = caseService.updateCase(caseId, c);
        return ResponseEntity.ok(c);
    }

    @PutMapping("/case/endCase/{caseId}")
    public ResponseEntity<Case> endCase(@PathVariable Long caseId) {
        Case c = caseService.endCase(caseId);
        return ResponseEntity.ok(c);
    }
}
