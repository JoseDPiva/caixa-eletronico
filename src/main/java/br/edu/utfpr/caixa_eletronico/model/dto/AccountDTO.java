package br.edu.utfpr.caixa_eletronico.model.dto;

import lombok.*;

@Data
public class AccountDTO {
    @NonNull
    private String name;

    @NonNull
    private String cpf;

    @NonNull
    private String password;

    @NonNull
    private int accountNumber;

    @NonNull
    private double balance;
}
