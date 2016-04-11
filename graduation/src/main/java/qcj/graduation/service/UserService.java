package qcj.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcj.graduation.mapper.UserMapper;
import qcj.graduation.model.User;

/**
 * Created by Administrator on 2016/4/10.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Boolean login(Long userName,String password){
        Boolean result = Boolean.FALSE;
        User user = userMapper.getUserDetail(userName,password);
        if(user != null){
            result = Boolean.TRUE;
        }
        return result;
    }
}
