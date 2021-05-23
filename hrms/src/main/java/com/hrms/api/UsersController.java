package com.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.UserService;
import com.hrms.core.entities.concretes.User;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("getall")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user){
        return this.userService.add(user);
    }

}
