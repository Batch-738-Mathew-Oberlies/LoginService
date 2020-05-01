package com.revature.rideshare.services;

import com.revature.rideshare.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service", url = "http://user-service:8080")
public interface UserService {
    @GetMapping(value = "/")
    List<User> getUserByUsername(@RequestParam(name = "username") String username);
}
