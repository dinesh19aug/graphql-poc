package com.javahabit.exception;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;


//NOTE: This requires turning on graphl. servlet.exception-handlers-enabled: true
@Component
public class FxExceptionHandler  {

    @ExceptionHandler
    public ThrowableGraphQLError handleException(GraphQLException ex){
        return new ThrowableGraphQLError(ex);
    }

    @ExceptionHandler
    public  ThrowableGraphQLError handleException(BusinessException ex){
        return new ThrowableGraphQLError(ex);
    }

    @ExceptionHandler
    public  ThrowableGraphQLError handleException(RuntimeException ex){
        return new ThrowableGraphQLError(ex);
    }


}
