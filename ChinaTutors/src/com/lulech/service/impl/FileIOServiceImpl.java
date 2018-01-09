package com.lulech.service.impl;

import com.lulech.dao.impl.FileIODaoImpl;
import com.lulech.entity.ClassScore;
import com.lulech.entity.ExamFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FileIOServiceImpl implements Serializable {

    @Autowired
    private FileIODaoImpl dao;
    public static String FILEDIR = "D:/files/";
    public ExamFile readxFile(String path) {
        return dao.readxFile(path);
    }

    public void download(ClassScore cs, ServletOutputStream outputStream) {
        File file = null;
        try {
            file = dao.writeScore(cs);
            FileInputStream in = new FileInputStream(file);
            write(in, outputStream);
        } catch (IOException ex) {
            Logger.getLogger(FileIOServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(FileIOServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void write(InputStream in, OutputStream out) throws IOException {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
            }
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
    }
}
