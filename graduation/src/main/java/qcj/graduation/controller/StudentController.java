package qcj.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qcj.graduation.model.SignIn;
import qcj.graduation.model.Student;
import qcj.graduation.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/11.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String,Object> getSignInList() {
        Map<String,Object> result = new HashMap<>();
        result.put("data",studentService.getSignInList());
        return result;
    }

    @RequestMapping(value = "/isSuccess", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Boolean isSuccess(@RequestParam String code) {
        return studentService.isSuccess(Long.valueOf(code));
    }
    @RequestMapping(value = "/getnotsignin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String,Object> getNotSignInList() {
        Map<String,Object> result = new HashMap<>();
        result.put("data",studentService.getNotSignInList());
        return result;
    }
}
