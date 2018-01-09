package com.lulech.dao.impl;

import com.lulech.entity.ClassScore;
import com.lulech.entity.ExamFile;
import com.lulech.entity.OneScore;
import com.lulech.entity.OneTest;
import java.io.Serializable;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@Repository
public class FileIODaoImpl implements Serializable {

    public ExamFile readxFile(String path) {
        ExamFile examsf = new ExamFile();
        List<OneTest> otlist = new ArrayList<>();
        File xlsfile = new File(path);
        try {
            Workbook workbook = Workbook.getWorkbook(xlsfile);
            Sheet[] sheets = workbook.getSheets();
            Sheet st = sheets[0];
            int rows = st.getRows();
            int cols = st.getColumns();
            for (int i = 0; i < rows;) {
                OneTest ot = new OneTest();
                ot.setId(String.valueOf(i));
                ot.setTitle(st.getCell(0, i++).getContents());
                ot.setOptionA(st.getCell(1, i++).getContents());
                ot.setOptionB(st.getCell(1, i++).getContents());
                ot.setOptionC(st.getCell(1, i++).getContents());
                ot.setOptionD(st.getCell(1, i++).getContents());
                ot.setKeyanswer(st.getCell(1, i++).getContents());
                otlist.add(ot);
            }
            workbook.close();
            examsf.setTestslist(otlist);
        } catch (IOException | BiffException ex) {
            Logger.getLogger(FileIODaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return examsf;
    }

    public File writeScore(ClassScore cs) throws IOException, WriteException {
        File file = new File("D:/files/classscore.xls");
        if (!file.exists()) {
            file.createNewFile();
        }
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        sheet.addCell(new Label(0, 0, "班级编号"));
        sheet.addCell(new Label(1, 0, cs.getClasses().getClassId()));
        sheet.addCell(new Label(0, 1, "班级名称"));
        sheet.addCell(new Label(1, 1, cs.getClasses().getClassName()));
        sheet.addCell(new Label(0, 2, "课程名称"));
        sheet.addCell(new Label(1, 2, cs.getClasses().getCourses().getTitle()));
        sheet.addCell(new Label(0, 3, "学号"));
        sheet.addCell(new Label(1, 3, "中文姓名"));
        sheet.addCell(new Label(2, 3, "英文姓名"));
        sheet.addCell(new Label(3, 3, "章节"));
        sheet.addCell(new Label(4, 3, "成绩"));
        List<OneScore> olist = cs.getClassscores();
        for (int i = 0; i < olist.size(); i++) {
            OneScore os = olist.get(i);
            sheet.addCell(new Label(0, 4+i, os.getStuId()));
            sheet.addCell(new Label(1, 4+i, os.getCnName()));
            sheet.addCell(new Label(2, 4+i, os.getEnName()));
            sheet.addCell(new Label(3, 4+i, os.getChapter()));
            sheet.addCell(new Label(4, 4+i, os.getScore().toString()));
        }
        workbook.write();
        workbook.close();
        return file;
    }
}
