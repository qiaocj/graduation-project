package qcj.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcj.graduation.mapper.SignInMapper;
import qcj.graduation.mapper.StudentMapper;
import qcj.graduation.model.Student;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SignInMapper signInMapper;

    public List<Student> getNotSignInList(){
        List<Long> classCode = signInMapper.getClassCode();
        String classCodes = String.valueOf(classCode);
        String studentCodes = String.valueOf(signInMapper.getStudentCodes());
        List<Student> notSignIn = studentMapper.getNotSignInList(classCodes,studentCodes);
        return notSignIn;
    }
}
