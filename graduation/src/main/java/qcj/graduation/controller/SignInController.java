package qcj.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qcj.graduation.model.SignIn;
import qcj.graduation.service.SignInService;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/10.
 */
@RestController
@RequestMapping("/signin")
public class SignInController {
    @Autowired
    private SignInService signInService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<SignIn> getSignInList() {
        return signInService.getSignInList();
    }

    @RequestMapping(value = "/isSuccess", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean isSuccess(@RequestBody Map<String,Object> map) {
        Long code = Long.valueOf(map.get("code").toString());
        return signInService.isSuccess(code);
    }


}
