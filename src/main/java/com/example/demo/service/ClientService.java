package com.example.demo.service;

import java.util.List;

import com.example.demo.model.bo.ClientBO;
import com.example.demo.model.vo.ClientVO;

/**
 * @author Alan.Juan
 *
 */

public interface ClientService {
    
    void createClient(Long companyId, List<ClientBO> clientBOs);
    
    void modifyClient(Long clientId, ClientBO clientBO);
    
    void deleteClient(Long clientId);
    
    List<ClientVO> viewClients();
    
    ClientVO viewClient(Long clientId);
}
