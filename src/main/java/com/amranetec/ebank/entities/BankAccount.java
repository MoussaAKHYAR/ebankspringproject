package com.amranetec.ebank.entities;

import com.amranetec.ebank.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    //avoir l'enum en format string
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    //par default on a FetchType.LAZY qui veut dire : mode paresseux il ne charge que les informations sur la table indiquée sans charger en memoire les données de l'autre table
    //FetchType.EAGER : affiche les données de la table ainsi que celles de la table dont elle est liée
    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperations;
}
