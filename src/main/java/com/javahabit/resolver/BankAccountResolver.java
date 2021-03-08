package com.javahabit.resolver;


import com.javahabit.domain.fx.bank.BankAccount;
import com.javahabit.domain.fx.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class BankAccountResolver implements GraphQLQueryResolver{

    public BankAccount bankaccount(UUID id){

        log.info("Retrieveing bank id {}: ", id);

        return BankAccount.builder().id(id)
                .currency(Currency.CAD)
                .build();
    }



}
