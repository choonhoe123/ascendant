package com.Ascendant.ascendant.services;

import com.Ascendant.ascendant.entity.CaseEntity;
import com.Ascendant.ascendant.entity.ClientEntity;
import com.Ascendant.ascendant.model.Case;
import com.Ascendant.ascendant.model.Client;
import com.Ascendant.ascendant.model.StatusEnum;
import com.Ascendant.ascendant.repository.CaseRepository;
import com.Ascendant.ascendant.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class CaseServiceImpl implements CaseService{
    private ClientRepository clientRepository;
    private CaseRepository caseRepository;

    public CaseServiceImpl(ClientRepository clientRepository, CaseRepository caseRepository) {
        this.clientRepository = clientRepository;
        this.caseRepository = caseRepository;
    }


    @Override
    public Case createCase(Case c) {
        if (c.getTitle() == null || c.getMsg() == null || c.getClient() == null) {
            throw new IllegalArgumentException("Title, msg, and client are required fields.");
        }
        c.setStatusEnum(StatusEnum.IN_PROGRESS);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date startDate = new Date();
        c.setCreateDate(startDate);
        CaseEntity caseEntity = new CaseEntity();
        BeanUtils.copyProperties(c, caseEntity);
        caseRepository.save(caseEntity);
        return c;
    }

    @Override
    public Case getCaseById(Long id) {
        Optional<CaseEntity> op = caseRepository.findById(id);
        if (op.isEmpty()) {
            return null;
        } else {
            Case c = new Case();
            CaseEntity curr = op.get();
            BeanUtils.copyProperties(curr, c);
            return c;
        }
    }
    @Override
    public List<Case> getAllCases() {
        List<Case> caseList = new ArrayList<>();
        List<CaseEntity> caseEntityList = caseRepository.findAll();
        for(CaseEntity u : caseEntityList){
            Case c = new Case();
            BeanUtils.copyProperties(u, c);
            caseList.add(c);
        }
        return caseList;
    }

    @Override
    public Case findByCaseId(Long caseId) {
        Case c = new Case();
        CaseEntity caseEntity = caseRepository.getReferenceById(caseId);
        BeanUtils.copyProperties(caseEntity, c);
        return c;
    }

    @Override
    public Client findCaseByClientId(Long caseId) {
        CaseEntity caseEntity = caseRepository.getReferenceById(caseId);
        ClientEntity c = caseEntity.getClient();
        Client client = new Client();
        BeanUtils.copyProperties(c, client);
        return client;
    }

    @Override
    public Case updateCase(Long caseId, Case c) {
        CaseEntity updatedCase = caseRepository.getReferenceById(caseId);
        updatedCase.setClient(c.getClient());
        updatedCase.setMsg(c.getMsg());
        updatedCase.setTitle(c.getTitle());
        updatedCase.setCreateDate(c.getCreateDate());
        updatedCase.setStatusEnum(c.getStatusEnum());
        caseRepository.save(updatedCase);
        return c;
    }

    @Override
    public Case endCase(Long caseId) {
        CaseEntity updatedCase = caseRepository.getReferenceById(caseId);
        updatedCase.setClient(updatedCase.getClient());
        updatedCase.setMsg(updatedCase.getMsg());
        updatedCase.setTitle(updatedCase.getTitle());
        updatedCase.setCreateDate(updatedCase.getCreateDate());
        updatedCase.setStatusEnum(StatusEnum.COMPLETED);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date endDate = new Date();
        updatedCase.setEndDate(endDate);
        caseRepository.save(updatedCase);
        Case output = new Case();
        BeanUtils.copyProperties(updatedCase, output);
        return output;
    }

    @Override
    public List<Case> getAllOutstandingCases() {
        List<CaseEntity> casesEntity = caseRepository.findAll();
        List<Case> cases = new ArrayList<>();
        for (CaseEntity c : casesEntity) {
            if (c.getStatusEnum() == StatusEnum.IN_PROGRESS) {
                Case casee = new Case();
                BeanUtils.copyProperties(c, casee);
                cases.add(casee);
            }
        }
        return cases;
    }

    @Override
    public List<Case> getAllCompletedCases() {
        List<CaseEntity> casesEntity = caseRepository.findAll();
        List<Case> cases = new ArrayList<>();
        for (CaseEntity c : casesEntity) {
            if (c.getStatusEnum() == StatusEnum.COMPLETED) {
                Case casee = new Case();
                BeanUtils.copyProperties(c, casee);
                cases.add(casee);
            }
        }
        return cases;
    }
}
