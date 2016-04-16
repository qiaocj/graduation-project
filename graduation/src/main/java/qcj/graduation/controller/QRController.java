package qcj.graduation.controller;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qcj.graduation.service.QRservice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qiao on 2016/4/12.
 */
@Controller
@RequestMapping("/qr")
public class QRController {
    @Autowired
    private QRservice qRservice;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String,Object> createQR(@RequestBody Map<String, Object> map) throws IOException, WriterException {
        String code = map.get("code").toString();
        String path = qRservice.createQR(code);
        Map<String,Object> m = new HashMap<>();
        m.put("path",path);
        return m;
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void downloadQR(@RequestBody Map<String, Object> map,HttpServletResponse response) throws IOException, WriterException {
        String code = map.get("code").toString();
        qRservice.downloadQR(response,code);
    }
}
