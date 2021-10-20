package com.example.chart.services;

import com.example.chart.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    private User user;
    public List<User> getAll()
    {
        String url = "http://localhost:8090/user";
        ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
        User[] users = response.getBody();
        return Arrays.asList(users);
    }

    public void addUser(User user) {
        String url = "http://localhost:8090/user";
        restTemplate.postForObject(url, user, User.class);
    }
    public void  setLoginUser(String name){
        for (int i = 0; i<this.getAll().size();i++){
            if (name.equals(this.getAll().get(i).getUsername())){
                user = this.getAll().get(i);
            }
        }
    }
    public User getUser(){
        return user;
    }
}
