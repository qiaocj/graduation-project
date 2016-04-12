package qcj.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qcj.graduation.model.SignIn;
import qcj.graduation.model.Student;
import qcj.graduation.service.StudentService;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/11.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getSignInList() {
        return studentService.getSignInList();
    }

    @RequestMapping(value = "/isSuccess", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean isSuccess(@RequestBody Map<String,Object> map) {
        Long code = Long.valueOf(map.get("code").toString());
        return studentService.isSuccess(code);
    }
    @RequestMapping(value = "/getnotsignin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getNotSignInList() {
        return studentService.getNotSignInList();
    }
}
