package qcj.graduation.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcj.graduation.mapper.StudentMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Hashtable;

/**
 * Created by Qiao on 2016/4/12.
 */
@Service
public class QRservice {

    @Autowired
    private StudentMapper studentMapper;

    public String createQR(String code) throws IOException, WriterException {

        Long classCode = studentMapper.getClassCode(Long.valueOf(code));

        int width = 400;
        int height = 400;
        String format = "jpg";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(code + "," + classCode, BarcodeFormat.QR_CODE, width, height, hints);
        File outputFile = new File("src/main/webapp/QRimage/" + code + ".jpg");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        String name = code + ".jpg";
        return name;
    }

    public void downloadQR(HttpServletResponse response, String code) throws IOException {
        InputStream inStream = new FileInputStream("src/main/webapp/QRimage/" + code + ".jpg");
        OutputStream output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + code + ".jpg");
        response.setContentType("image/jpg");
        byte[] b = new byte[100];
        int len;
        while ((len = inStream.read(b)) > 0) {
            output.write(b, 0, len);
        }
        inStream.close();
        output.close();
    }
}
