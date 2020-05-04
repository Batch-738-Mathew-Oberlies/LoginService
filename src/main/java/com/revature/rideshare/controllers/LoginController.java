package com.revature.rideshare.controllers;

import com.revature.rideshare.models.User;
import com.revature.rideshare.services.DistanceService;
import com.revature.rideshare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * LoginController takes userName and Password.
 *
 * @author Bertrick Lappa
 */

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    DistanceService distanceService;

    @GetMapping
    public Map<String, Set<String>> login(
            @RequestParam(name = "userName") String userName,
            @RequestParam(name = "passWord") String passWord
    ) {
        // TODO: Log this instead of System.out
        System.out.println(userName);
        Map<String, Set<String>> errors = new HashMap<>();
        if (userName.length() == 0) {
            errors.computeIfAbsent("userName", key -> new HashSet<>()).add("userName required!");
        }
        if (errors.isEmpty()) {
            Map<String, Set<String>> info = new HashMap<>();
            //call login service here
            List<User> u = userService.getUserByUsername(userName);
            System.out.println(u.toString());
            if (!u.isEmpty()) {
                info.computeIfAbsent("name", key -> new HashSet<>()).add(u.get(0).getFirstName() + " " + u.get(0).getLastName());
                info.computeIfAbsent("userid", key -> new HashSet<>()).add(u.get(0).getUserId() + "");
            } else {
                info.computeIfAbsent("userNotFound", key -> new HashSet<>()).add("User not found!");
            }
            return info;
        } else {
            return errors;
        }
    }

    @GetMapping("/getGoogleApi")
    public Map<String, Set<String>> getGoogleApi() {
        Map<String, Set<String>> info = new HashMap<>();
        // getting API key
        String newkey = distanceService.getGoogleMAPKey();
        info.computeIfAbsent("googleMapAPIKey", key -> new HashSet<>()).add(newkey);
        return info;
    }
}
