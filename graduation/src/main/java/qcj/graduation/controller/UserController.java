package qcj.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import qcj.graduation.mapper.SignInMapper;
import qcj.graduation.mapper.UserMapper;
import qcj.graduation.model.SignIn;
import qcj.graduation.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/9.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean login(@RequestBody Map<String, Object> map) {
        Long userName = Long.valueOf(map.get("userName").toString());
        String password = map.get("password").toString();
        return userService.login(userName,password);
    }
}
