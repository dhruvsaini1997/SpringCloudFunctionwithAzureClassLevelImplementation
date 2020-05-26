package com.dhruvsaini.springcloudfunctionazure.requestHandler;

import com.dhruvsaini.springcloudfunctionazure.model.ResponseValueObject;
import com.dhruvsaini.springcloudfunctionazure.model.User;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;

public class AzureHandler extends  AzureSpringBootRequestHandler<Object, ResponseValueObject>  {

    @FunctionName("saveUsers")
    public ResponseValueObject save(
            @HttpTrigger(name="saveUserRequest",methods = {HttpMethod.POST},authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<User>> request, ExecutionContext context){
        return handleRequest(request.getBody().get(),context);

    }
    @FunctionName("getUser")
    public ResponseValueObject get(
            @HttpTrigger(name="getUserRequest",methods = {HttpMethod.GET},authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage request,
            @BindingName("id") Integer id,
            ExecutionContext context){
        return handleRequest(id,context);

    }

    @FunctionName("deleteUser")
    public ResponseValueObject delete(
            @HttpTrigger(name="deleteUserRequest",methods = {HttpMethod.DELETE},authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage request,
            @BindingName("id") Integer id,ExecutionContext context){
        return handleRequest(id,context);

    }

    @FunctionName("updateUser")
    public ResponseValueObject update(
            @HttpTrigger(name="updateUserRequest",methods = {HttpMethod.PUT},authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage<Optional<User>> request,
           ExecutionContext context){
        return handleRequest(request.getBody().get(),context);

    }
@FunctionName("getAll")
    public ResponseValueObject getAll(
            @HttpTrigger(name="getAllUserRequest",methods = {HttpMethod.GET},authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage request,
            ExecutionContext context){
    return handleRequest(null,context);

}}
