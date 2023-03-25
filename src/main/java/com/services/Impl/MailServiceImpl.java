package com.services.Impl;

import com.Dao.UserDao;
import com.POJO.User;
import com.services.MailService;
import com.services.UserService;
import com.utils.JMailUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MailServiceImpl implements MailService {
    @Override
    public void sendMail(User user) {
        // 生成激活码和激活link
        String activationCode = UUID.randomUUID().toString();
        String activationLink = "<a>http://localhost:8080/JWeb04/mail/activate?code=" + activationCode+"</a>";

        // 更新用户信息activateCode
        HashMap<String, String> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("activateCode", activationCode);
        UserService userService=new UserServiceImpl();
        userService.updateUser(params);

        // 发送邮件
        JMailUtils.send(activationLink);
    }
}
