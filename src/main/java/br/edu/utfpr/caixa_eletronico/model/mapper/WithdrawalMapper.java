package br.edu.utfpr.caixa_eletronico.model.mapper;

import br.edu.utfpr.caixa_eletronico.model.domain.Withdrawal;
import br.edu.utfpr.caixa_eletronico.model.dto.WithdrawalDTO;

public class WithdrawalMapper {

    public static Withdrawal toEntity(WithdrawalDTO dto) {
        Withdrawal entity = new Withdrawal(dto.getAccountNumber(), dto.getValue(), dto.getType());

        return entity;
    }

    public static WithdrawalDTO toDTO(Withdrawal entity) {
        WithdrawalDTO dto = new WithdrawalDTO(entity.getAccountNumber(), entity.getValue(), entity.getType());

        return dto;
    }
}

