package com.javahabit.exception;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FxErrorHandler implements GraphQLErrorHandler {


    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> graphQLErrorList) {
        /*for(GraphQLError graphQLError: graphQLErrorList){
            graphQLError.getExtensions().remove("type");
            graphQLError.getExtensions().remove("classification");
        }*/
        return graphQLErrorList;
    }
}
