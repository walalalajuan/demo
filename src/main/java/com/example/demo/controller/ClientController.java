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

import com.example.demo.bussiness.ClientBusiness;
import com.example.demo.model.bo.ClientBO;
import com.example.demo.model.vo.ClientVO;
import com.example.demo.service.ClientService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

/**
 * @author Alan.Juan
 *
 */
@Api(tags = "Client")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientBusiness clientBusiness;
    private final ClientService clientService;

    @PostMapping("/client/{companyId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OPERATER')")
    public void createClient(
            @PathVariable("companyId") Long companyId,
            @RequestBody List<ClientBO> clientBOs
    ) {
        clientBusiness.createClient(companyId, clientBOs);
    }
    
    @PatchMapping("/client/{clientId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public void modifyClient(
            @PathVariable("clientId") Long clientId,
            @RequestBody ClientBO clientBO
    ) {
        clientService.modifyClient(clientId, clientBO);
    }
    
    @DeleteMapping("/client/{clientId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public void deleteClient(
            @PathVariable("clientId") Long clientId
    ) {
        clientService.deleteClient(clientId);
    }
    
    @GetMapping("/client/{clientId}")
    public ClientVO viewClient(
            @PathVariable("clientId") Long clientId
    ) {
        return clientService.viewClient(clientId);
    }
    
    @GetMapping("/clients")
    public List<ClientVO> viewClients() {
        return clientService.viewClients();
    }
}
