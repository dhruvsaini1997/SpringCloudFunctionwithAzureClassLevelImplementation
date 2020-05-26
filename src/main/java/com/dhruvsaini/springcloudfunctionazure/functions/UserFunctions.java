package com.dhruvsaini.springcloudfunctionazure.functions;

import com.dhruvsaini.springcloudfunctionazure.model.ResponseValueObject;
import com.dhruvsaini.springcloudfunctionazure.model.User;
import com.dhruvsaini.springcloudfunctionazure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class UserFunctions {

    @Autowired
    UserService userService;

//    @Bean("saveUsers")
//    public Function<User, ResponseValueObject> save(){return user -> userService.save(user);}

//    @Bean("deleteUser")
//    public Function<Integer,ResponseValueObject> delete(){return id ->  userService.delete(id);}
//
//    @Bean("getUser")
//    public Function<Integer,ResponseValueObject> get(){return id -> userService.get(id);}

    @Bean("getAll")
    public Supplier<ResponseValueObject> getAll(){return () -> userService.getAll();}

//    @Bean("updateUser")
//    public Function<User,ResponseValueObject> update(){return user -> userService.update(user);}
}
