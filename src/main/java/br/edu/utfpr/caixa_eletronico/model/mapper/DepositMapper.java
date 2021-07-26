package br.edu.utfpr.caixa_eletronico.model.mapper;

import br.edu.utfpr.caixa_eletronico.model.domain.Deposit;
import br.edu.utfpr.caixa_eletronico.model.dto.DepositDTO;

public class DepositMapper {

    public static Deposit toEntity(DepositDTO dto) {
        Deposit entity = new Deposit(dto.getAccountNumber(), dto.getValue(), dto.getType());

        return entity;
    }

    public static DepositDTO toDTO(Deposit entity) {
        DepositDTO dto = new DepositDTO(entity.getAccountNumber(), entity.getValue(), entity.getType());

        return dto;
    }
}
