package com.javahabit.domain.fx.bank;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BankAccount {
    UUID id;
    Client client;
    Currency currency;
}
