package edu.hznu.cliven.basicboot.controller;


import com.alibaba.fastjson.JSONObject;
import edu.hznu.cliven.basicboot.entity.User;
import edu.hznu.cliven.basicboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public JSONObject login(User user) {
        JSONObject resultEntity = new JSONObject();
        try {
            String username = user.getUsername();
            String password = user.getPassword();
            Assert.hasLength(username, "username 为空");
            Assert.hasLength(password, "password 为空");
            User targetUser = userService.findByUsername(username);
            Assert.notNull(targetUser, "username 或 password错误");
            if (!targetUser.getPassword().equals(password))
                throw new IllegalArgumentException("username 或 password错误");

            resultEntity.put("msg", UUID.randomUUID());
            resultEntity.put("success", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.put("msg", e.getMessage());
            resultEntity.put("success", 0);
        }
        return resultEntity;
    }


    @PostMapping("/register")
    public JSONObject register(User user) {
        JSONObject resultEntity = new JSONObject();
        try {
            String username = user.getUsername();
            String password = user.getPassword();
            String passwordRep = user.getPasswordRep();

            Assert.hasLength(username, "username 为空");
            Assert.hasLength(password, "password 为空");
            Assert.hasLength(passwordRep, "passwordRep 为空");

            User targetUser = userService.findByUsername(username);
            Assert.isNull(targetUser, "username 已经存在");

            if (!password.equals(passwordRep)) throw new IllegalArgumentException("两次密码不一致");
            userService.create(user);
            resultEntity.put("msg", "创建成功");
            resultEntity.put("success", 1);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.put("msg", e.getMessage());
            resultEntity.put("success", 0);
        }
        return resultEntity;
    }
}
