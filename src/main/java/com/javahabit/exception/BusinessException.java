package com.javahabit.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import graphql.language.SourceLocation;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



@Getter
public class BusinessException extends  RuntimeException implements GraphQLError, GraphQLErrorHandler {
    private String error_code;
    private String error_description;

    public BusinessException(String error_code, String error_description){
        super(error_description);
        this.error_code = error_code;
        this.error_description = error_description;
        //this.getLocations().clear();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public List<Object> getPath() {
        return null;
    }

    @Override
    public Map<String, Object> toSpecification() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> customAttributes = new LinkedHashMap<>();

        customAttributes.put("error_code", getError_code());
        customAttributes.put("error_description", this.getError_description());
        customAttributes.put("api_spec_uri", "https://developer.wellsfargo.com");

        return customAttributes;
    }

    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        return false;
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> graphQLErrorList) {
        for(GraphQLError graphQLError: graphQLErrorList){
            graphQLError.getExtensions().remove("type");
            graphQLError.getExtensions().remove("classification");
        }
        return graphQLErrorList;
    }
}
