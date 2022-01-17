package com.example.demo.service;

import java.util.List;

import com.example.demo.model.bo.CompanyBO;
import com.example.demo.model.vo.CompanyVO;

/**
 * @author Alan.Juan
 *
 */

public interface CompanyService {
    
    void createCompany(CompanyBO companyBO);
    
    void modifyCompany(Long companyId, CompanyBO companyBO);
    
    void deleteCompany(Long companyId);
    
    List<CompanyVO> viewCompanys();
    
    CompanyVO viewCompany(Long companyId);
}
