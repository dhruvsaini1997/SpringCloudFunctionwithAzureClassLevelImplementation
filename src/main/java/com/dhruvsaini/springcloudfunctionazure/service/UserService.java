package com.dhruvsaini.springcloudfunctionazure.service;

import com.dhruvsaini.springcloudfunctionazure.model.ResponseValueObject;
import com.dhruvsaini.springcloudfunctionazure.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
private static List<User> users=new ArrayList<>();

@Autowired
    private RestTemplate restTemplate;

@PostConstruct
public  void init(){
User user=new User();
user.setName("Dhruv Saini");
user.setEmail("dhruvsaini1997@gmail.com");
users.add(user);
}

public ResponseValueObject save(User user){
users.add(user);
ResponseValueObject responseValueObject=new ResponseValueObject();
responseValueObject.setData(user);
responseValueObject.setMessage("Success");
responseValueObject.setStatus(true);
return  responseValueObject;
}

public ResponseValueObject update(User user){
    ResponseValueObject responseValueObject=new ResponseValueObject();
    if(user.getId()!=null){
        users.removeIf(it->it.getId()==user.getId());
        users.add(user);
        responseValueObject.setMessage("Record updated");
        responseValueObject.setData(user);
        responseValueObject.setStatus(true);
    }
else{
responseValueObject.setMessage("Record cannot be updated");
responseValueObject.setStatus(false);
    }
return responseValueObject;
}
public ResponseValueObject get(Integer id){
ResponseValueObject responseValueObject=new ResponseValueObject();
if(id!=null){
    User user=users.stream().filter(it->it.getId()==id).findFirst().get();
    responseValueObject.setData(user);
    responseValueObject.setMessage("Success");
    responseValueObject.setStatus(true);
}
else {
    responseValueObject.setMessage("User not found");
    responseValueObject.setStatus(false);
}
return responseValueObject;
}

public ResponseValueObject delete(Integer id){
    ResponseValueObject responseValueObject=new ResponseValueObject();
    if(id!=null){
        users.removeIf(it->it.getId()==id);
        responseValueObject.setMessage("Removed successfully");
        responseValueObject.setStatus(true);
    }else{
        responseValueObject.setStatus(false);
        responseValueObject.setMessage("Can't be removed");
    }
    return responseValueObject;
}

public ResponseValueObject getAll(){
    ResponseValueObject responseValueObject= new ResponseValueObject();
    responseValueObject.setData(users);
    responseValueObject.setStatus(true);
    return responseValueObject;
}


}
