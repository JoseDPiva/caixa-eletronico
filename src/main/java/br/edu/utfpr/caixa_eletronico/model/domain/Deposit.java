package br.edu.utfpr.caixa_eletronico.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "deposits")
@Data
@NoArgsConstructor
public class Deposit {
    @NonNull
    private int accountNumber;

    @NonNull
    private double value;

    @NonNull
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Deposit(@NonNull int accountNumber, @NonNull double value, @NonNull String type) {
        this.accountNumber = accountNumber;
        this.value = value;
        this.type = type;
    }
}
