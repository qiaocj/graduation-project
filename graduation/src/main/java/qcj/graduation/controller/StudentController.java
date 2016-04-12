package qcj.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qcj.graduation.model.Student;
import qcj.graduation.service.StudentService;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getnotsignin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getNotSignInList() {
        return studentService.getNotSignInList();
    }
}
