package com.hafu.edu.teachingmanagementsystem.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程世玉
 * @create 2022/2/7 15:08
 * @PROJECT_NAME Teaching-Management-System
 * @Description 本类作用，对字符串按照指定的方式进行分割
 */
public class splitUtils {
    public static List<String> splitString(String str, String separator){
        String[] split = str.split(separator);

        ArrayList<String> strings = new ArrayList<>();

        for (String s : split) {
            strings.add(s);
        }

        return strings;
    }
}
