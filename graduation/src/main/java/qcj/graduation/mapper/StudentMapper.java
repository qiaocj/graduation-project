package qcj.graduation.mapper;

import org.apache.ibatis.annotations.*;
import qcj.graduation.model.Student;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
public interface StudentMapper {

    @SelectProvider(type = StudentMapperProvider.class, method = "getNotSignInList")
    @Results(
            @Result(property = "classCode", column = "class_code")
    )
    List<Student> getNotSignInList(@Param("classCodes") List<Long> classCodes, @Param("codes") List<Long> codes);

    @Select("SELECT class_code from student where code = #{code}")
    Long getClassCode(Long code);

    @Select("SELECT * from student where code = #{code}")
    @Results(
            @Result(property = "classCode", column = "class_code")
    )
    Student getStudentDetail(Long code);
}
