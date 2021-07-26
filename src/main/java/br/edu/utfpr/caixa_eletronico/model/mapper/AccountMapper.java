package br.edu.utfpr.caixa_eletronico.model.mapper;

import br.edu.utfpr.caixa_eletronico.model.domain.Account;
import br.edu.utfpr.caixa_eletronico.model.dto.AccountDTO;

public class AccountMapper {

    public static Account toEntity(AccountDTO dto) {
        Account entity = new Account(dto.getName(), dto.getCpf(), dto.getPassword(), dto.getAccountNumber(), dto.getBalance());

        return entity;
    }

    public static AccountDTO toDTO(Account entity) {
        AccountDTO dto = new AccountDTO(entity.getName(), entity.getCpf(), entity.getPassword(), entity.getAccountNumber(), entity.getBalance());

        return dto;
    }
}
