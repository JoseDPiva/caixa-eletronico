package br.edu.utfpr.caixa_eletronico.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
public class Account {
    @NonNull
    private String name;

    @NonNull
    private String cpf;

    @NonNull
    private String password;

    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;

    @NonNull
    private double balance;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Account(@NonNull String name, @NonNull String cpf, @NonNull String password, @NonNull int accountNumber, @NonNull double balance) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
