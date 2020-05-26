package com.dhruvsaini.springcloudfunctionazure.functions;

import com.dhruvsaini.springcloudfunctionazure.model.ResponseValueObject;
import com.dhruvsaini.springcloudfunctionazure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeleteUser implements Function<Integer, ResponseValueObject> {
    @Autowired
    UserService userService;

    @Override
    public ResponseValueObject apply(Integer id){
        return userService.delete(id);
    }
}
