package qcj.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcj.graduation.mapper.SignInMapper;
import qcj.graduation.model.SignIn;

import java.util.List;

/**
 * Created by Administrator on 2016/4/10.
 */
@Service
public class SignInService {

    @Autowired
    private SignInMapper signInMapper;

    public List<SignIn> getSignInList() {
        return signInMapper.getSignInList();
    }

    public Boolean isSuccess(Long code) {
        Boolean result = Boolean.FALSE;
        SignIn signIn = signInMapper.isSucess(code);
        if(signIn != null){
            result = Boolean.TRUE;
        }
        return result;
    }
}
