package com.hafu.edu.teachingmanagementsystem;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.dao.PermissionDao;
import com.hafu.edu.teachingmanagementsystem.dao.PrizeDao;
import com.hafu.edu.teachingmanagementsystem.entity.*;
import com.hafu.edu.teachingmanagementsystem.service.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@SpringBootTest
@MapperScan("com.hafu.edu.teachingmanagementsystem.dao")

class TeachingManagementSystemApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PrizeService prizeService;

    @Autowired
    private DocumentService documentService;

    @Resource
    private PrizeDao prizeDao;

    // 测试数据库连接
    @Test
    void test01() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*测试通过number查询user对象方法*/
    @Test
    void test02() {
        User user =
                userService.getUserByNumber("20192502010304");
        System.out.println(user);
    }

    /*测试通过roleid查询权限*/
    @Test
    void test03() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("0");
        roles.add("1");
        Set<Permission> permissions =
                permissionService.getPermissionsByRoleId(roles);

        for (Permission permission : permissions) {
            System.out.println(permission);
        }
    }

    /**
     * 测试随机数
     */
    @Test
    void test04() {
//        int radom = (int)(Math.random()*10000);
//        System.out.println(radom);
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        System.out.println(sb);
    }







    /*测试查询所有的组织信息*/
//    @Test
//    void test06() {
//        ArrayList<Organization> list = organizationService.queryAllCollege();
//        for (Organization organization : list) {
//            System.out.println(organization);
//        }
//    }


    /*测试删除奖项信息*/
    @Test
    void test07() {
        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        R r = prizeService.deleteByListId(integers);
        System.out.println(r);
    }


    /*测试删除奖项信息*/
    @Test
    void test08() {

        Document document = new Document();
        document.setUid(1);
        document.setFaculty("计算机与信息技术学院");
        document.setGrade("2018");
        document.setMajor("计算机科学与技术学院");
        document.setLevel(1);
        document.setFileType(30);

        R r = documentService.queryStudentTrainResouce(document);

        System.out.println(r);
    }


    /*测试通过用户名字查询用户信息*/
    @Test
    void test09() {
        R r = userService.queryUserByUserName("程世玉");

        System.out.println(r);
    }
    @Test
    void ts(){
        long a=100;
        String[] s={"10","55","100"};
        for (int i = 0; i < s.length; i++) {
            long l = Long.parseLong(s[i]);
            System.out.println(l);
        }
    }
    @Test
    void s(){
        String s="asdf/ssdf.pdf";
        System.out.println(s.indexOf("/"));
        System.out.println(s.substring(4));
    }

    @Test
    void abc(){
        Prize prize=new Prize();
        prize.setGrade("18");
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        prize.setSta(integers);
        List<Prize> prizes = prizeDao.testStatus(prize);
        for (Prize prize1 : prizes) {
            System.out.println(prize1);
        }
    }

    @Test
    void abcd() {
        int[] a = {1,5,6,8,9};
        for (int i = 0; i <a.length; i++) {
            for (int j = 1; j <a.length-1; j++) {
                if (a[i]+a[j]==14)
                    System.out.println("下标为"+i+"和"+j);
            }
        }

    }
    @Test
    void excep(){
        int[] array={0,1,2};
        try {
            System.out.println(array[5]);
        }
        catch (IndexOutOfBoundsException e){
        }
        finally {

        }
        System.out.println(array[0]);

    }

    @Test
     public void HelloWorld() {


    }




}
