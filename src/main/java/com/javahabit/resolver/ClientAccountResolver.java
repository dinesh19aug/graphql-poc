package com.javahabit.resolver;

import com.javahabit.domain.fx.bank.BankAccount;
import com.javahabit.domain.fx.bank.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
/**
 * NOTE :
 * 1. We are not using GraphQlQueryResolver but GraphQLResolver
 * 2. We are marking that GraphQLResolver<BankAccount> and NOT GraphQLResolver<Client>
 *     because Client is pulled when bankAccount is resolved.
 */

public class ClientAccountResolver implements GraphQLResolver<BankAccount> {

    //Assume that this is another call to either a DB, rest or another GraphQl server
    //NOTE : the method name must match the Ql schema file
    /*public Client client(BankAccount bankAccount) {
        log.info("Client Resolver is called ...");
        Client client = Client.builder().first_name("Dinesh").last_name("Arora").build();
        return client;
    }*/

    public DataFetcherResult<Client> client(BankAccount bankAccount) {
        log.info("Client Resolver is called ...");
        return DataFetcherResult.<Client>newResult().data(
                Client.builder()
                        .first_name("Dinesh")
                        .last_name("Arora")

                        .build())
                .error(new GenericGraphQLError("Could not fetch client's middle name"))
                .build();

    }
}
