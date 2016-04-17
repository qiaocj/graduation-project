package qcj.graduation.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/17.
 */
public class StudentMapperProvider {

    public String getNotSignInList(Map map) {
        List<Long> classCodes = (List<Long>) map.get("classCodes");
        List<Long> codes = (List<Long>) map.get("codes");
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM student WHERE class_code IN (");
        for (Long classCode : classCodes) {
            sb.append(classCode + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(") AND code NOT IN (");
        for (Long code : codes) {
            sb.append(code + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(") order by class_code");
        return sb.toString();
    }
}
