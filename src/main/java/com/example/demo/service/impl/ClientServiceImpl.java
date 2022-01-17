package com.example.demo.service.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.bo.ClientBO;
import com.example.demo.model.vo.ClientVO;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.entity.Client;
import com.example.demo.security.Utils;
import com.example.demo.service.ClientService;

import lombok.RequiredArgsConstructor;

/**
 * @author Alan.Juan
 *
 */

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository clientRepository;
    
    @Override
    public void createClient(Long companyId, List<ClientBO> clientBOs) {
        List<Client> clients = clientBOs.stream().map(
                clientBO -> Client.builder()
                    .company_id(companyId)
                    .name(clientBO.getName())
                    .email(clientBO.getEmail())
                    .phone(clientBO.getPhone())
                    .created_by(Utils.getCurrentUserName())
                    .created_at(ZonedDateTime.now())
                    .build())
                .collect(Collectors.toList());
        clientRepository.saveAll(clients);
    }

    @Override
    public void modifyClient(Long clientId, ClientBO clientBO) {
        if (clientRepository.existsById(clientId)) {
            Client client = Client.builder()
                    .id(clientId)
                    .name(clientBO.getName())
                    .email(clientBO.getEmail())
                    .phone(clientBO.getPhone())
                    .updated_by(Utils.getCurrentUserName())
                    .updated_at(ZonedDateTime.now())
                    .build();
            clientRepository.saveAndFlush(client);
        } else {
            //do something
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
        } else {
            //do something
        }
    }

    @Override
    public List<ClientVO> viewClients() {
        return clientRepository.findAll().stream()
                .map(ClientVO::toClientVO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientVO viewClient(Long clientId) {
        return ClientVO.toClientVO(clientRepository.findById(clientId).orElse(null));
    }

}
