package com._520it.crm.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 2017/6/30.
 */
public class ExportExcelUtil {
    private ExportExcelUtil() {
    }

    /**
     *
     * @param clz 数据实体的class
     * @param resp 响应对象
     * @param datas 数据的集合
     * @param ExcelName excel的文件名字,不要写中文
     * @param title 表的第一行的大抬头
     */
    public static void ExportExcel(Class<?> clz, HttpServletResponse resp, List<?> datas,String ExcelName,String title) {
        ExportExcel exportExcel = new ExportExcel(title, clz).setDataList(datas);
        try {
            exportExcel.write(resp,ExcelName+".xls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
