package br.edu.utfpr.caixa_eletronico.model.dto;

import lombok.*;

@Data
public class DepositDTO {
    @NonNull
    private int accountNumber;

    @NonNull
    private double value;

    @NonNull
    private String type;
}
