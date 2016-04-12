package qcj.graduation.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import qcj.graduation.model.Student;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE class_code IN (#{classCodes}) AND code NOT IN (#{codes}) order by class_code")
    @Results(
            @Result(property = "classCode", column = "class_code")
    )
    List<Student> getNotSignInList(@Param("classCodes") String classCodes, @Param("codes") String codes);

    @Select("SELECT class_code from student where code = #{code}")
    Long getClassCode(Long code);

    @Select("SELECT * from student where code = #{code}")
    Student getStudentDetail(Long code);
}
