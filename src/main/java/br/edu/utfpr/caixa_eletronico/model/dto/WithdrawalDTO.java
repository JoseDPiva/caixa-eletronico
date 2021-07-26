package br.edu.utfpr.caixa_eletronico.model.dto;

import lombok.*;

@Data
public class WithdrawalDTO {
    @NonNull
    private int accountNumber;

    @NonNull
    private double value;

    @NonNull
    private String type;
}
