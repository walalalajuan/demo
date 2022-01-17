package com.example.demo.bussiness;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.demo.model.bo.ClientBO;
import com.example.demo.service.ClientService;
import com.example.demo.service.CompanyService;

import lombok.RequiredArgsConstructor;

/**
 * @author Alan.Juan
 *
 */

@Service
@RequiredArgsConstructor
public class ClientBusiness {
    
    private final CompanyService companyService;
    private final ClientService clientService;
    
    public void createClient(Long companyId, List<ClientBO> clientBOs) {
        if (Objects.isNull(companyService.viewCompany(companyId))) {
            //throw CustomException, example: Not Found
            return;
        }
        clientService.createClient(companyId, clientBOs);
    }
}
