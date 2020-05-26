package com.dhruvsaini.springcloudfunctionazure.functions;

import com.dhruvsaini.springcloudfunctionazure.model.ResponseValueObject;
import com.dhruvsaini.springcloudfunctionazure.model.User;
import com.dhruvsaini.springcloudfunctionazure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UpdateUser implements Function<User, ResponseValueObject> {
    @Autowired
    UserService userService;

    @Override
    public ResponseValueObject apply(User user){
        return userService.update(user);
    }
}
