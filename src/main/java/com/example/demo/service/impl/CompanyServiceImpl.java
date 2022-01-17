package com.example.demo.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.bo.CompanyBO;
import com.example.demo.model.vo.CompanyVO;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.entity.Company;
import com.example.demo.security.Utils;
import com.example.demo.service.CompanyService;

import lombok.RequiredArgsConstructor;

/**
 * @author Alan.Juan
 *
 */

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public void createCompany(CompanyBO companyBO) {
        Company company = Company.builder()
                .name(companyBO.getName())
                .address(companyBO.getAddress())
                .created_by(Utils.getCurrentUserName())
                .created_at(ZonedDateTime.now())
                .build();
        companyRepository.save(company);
    }

    @Override
    public void modifyCompany(Long companyId, CompanyBO companyBO) {
        if (companyRepository.existsById(companyId)) {
            Company company = Company.builder()
                    .id(companyId)
                    .name(companyBO.getName())
                    .address(companyBO.getAddress())
                    .updated_by(Utils.getCurrentUserName())
                    .updated_at(ZonedDateTime.now())
                    .build();
            companyRepository.saveAndFlush(company);
        } else {
            // do something
        }
    }

    @Override
    public void deleteCompany(Long companyId) {
        if (companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
        } else {
            //do something
        }
    }

    @Override
    public List<CompanyVO> viewCompanys() {
        return companyRepository.findAll().stream()
                .map(CompanyVO::toCompanyVO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyVO viewCompany(Long companyId) {
        return CompanyVO.toCompanyVO(companyRepository.findById(companyId).orElse(null));
    }

}
