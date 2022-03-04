package com.hafu.edu.teachingmanagementsystem.Utils;


import com.hafu.edu.teachingmanagementsystem.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author 程世玉
 * @create 2022/2/13 15:42
 * @PROJECT_NAME Teaching-Management-System
 * @Description 本类是为了批量导入用户信息，生成user对象的工具
 */
public class POIUserUtils {
    public static List<User> getUserList(MultipartFile excelFile) {
        String[][] str = new String[0][];
        try {
            str = POIUtils.readExcel(excelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //遍历list,查看数据
        /**
         * 拿到list集合和，list集合里面都是我们表格里面的数据，他是从第一行开始，从左到右依次存入其中
         * 我们可以按照行和列再将list结合给遍历出来，放到对象里面
         */
        Date date = new Date();
        ArrayList<User> users = new ArrayList<>();
        System.out.println("POIUtils.lastRowNum = "+POIUtils.lastRowNum);
        System.out.println("POIUtils.lastCellNum = " + POIUtils.lastCellNum);
        for (int i = 1; i < POIUtils.lastRowNum + 1; i++) {
            User user = new User();
            for (int j = 0; j < POIUtils.lastCellNum; j++) {
                if (str[i][j] != ""){
                    switch (j) {
                        case 0:
                            user.setUsername(str[i][j]);
                            continue;
                        case 1:
                            if (Objects.equals("教师",str[i][j])){
                                user.setRoleId("1");
                            }else if (Objects.equals("学生",str[i][j])){
                                user.setRoleId("0");
                            }
                            continue;
                        case 2:
                            user.setNumber(str[i][j]);
                            continue;
                        case 3:
                            user.setIdentityCard(str[i][j]);
                            user.setPasswd("$2a$10$Anox23g7A1ItvosdEGnL1u/KrZxptGoJN.cc/QWvbIyLbqb.mi.EW");
                            continue;
                        case 4:
                            user.setPhoneNumber(str[i][j]);
                            continue;
                        case 5:
                            user.setSex(Integer.valueOf(str[i][j]));
                            user.setStatus(1);
                            continue;
                        case 6:
                            user.setGrade(str[i][j]);
                            continue;
                        case 7:
                            user.setClazz(str[i][j]);
                            continue;
                        case 8:
                            user.setFaculty(str[i][j]);
                            continue;
                        case 9:
                            user.setMajor(str[i][j]);
                            continue;
                        case 10:
                            user.setTeachingResearch(str[i][j]);
                            user.setCreateTime(new Date());
                            continue;
                        default:
                            break;
                    }
                }
            }
            System.out.println(user);
            users.add(user);
        }

        return users;
    }
}
