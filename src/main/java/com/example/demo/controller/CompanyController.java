package com.example.demo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.bo.CompanyBO;
import com.example.demo.model.vo.CompanyVO;
import com.example.demo.service.CompanyService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

/**
 * @author Alan.Juan
 *
 */
@Api(tags = "Company")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CompanyController {
    
    private final CompanyService companyService;
    
    @PostMapping("/company")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OPERATER')")
    public void createCompany(
            @RequestBody CompanyBO companyBO
    ) {
        companyService.createCompany(companyBO);
    }
    
    @PatchMapping("/company/{companyId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public void modifyCompany(
            @PathVariable("companyId") Long companyId,
            @RequestBody CompanyBO companyBO
    ) {
        companyService.modifyCompany(companyId, companyBO);
    }
    
    @DeleteMapping("/company/{companyId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public void deleteCompany(
            @PathVariable("companyId") Long companyId
    ) {
        companyService.deleteCompany(companyId);
    }
    
    @GetMapping("/company/{companyId}")
    public CompanyVO viewCompany(
            @PathVariable("companyId") Long companyId
    ) {
        return companyService.viewCompany(companyId);
    }
    
    @GetMapping("/companys")
    public List<CompanyVO> viewCompanys() {
        return companyService.viewCompanys();
    }
}
