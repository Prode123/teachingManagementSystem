package com.hafu.edu.teachingmanagementsystem.service.impl;

import com.hafu.edu.teachingmanagementsystem.Exception.BaseCodeInterface;
import com.hafu.edu.teachingmanagementsystem.Exception.ErrorCodeEnum;
import com.hafu.edu.teachingmanagementsystem.Exception.ServiceException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hafu.edu.teachingmanagementsystem.Exception.ex.getUserNullPointerException;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import com.hafu.edu.teachingmanagementsystem.dao.UserDao;
import com.hafu.edu.teachingmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-02-06 17:46:53
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long uid) {
        return this.userDao.queryById(uid);
    }

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long uid) {
        return this.userDao.deleteById(uid) > 0;
    }

    /**
     * 通过账号查询user对象
     * @param number 账号
     * @return user对象
     */
    @Override
    public User getUserByNumber(String number) {
        if (number == null) {
            throw new getUserNullPointerException("账号为空，请重新访问");
        }
        User user = userDao.queryByNumber(number);
        if (user == null) {
            throw new getUserNullPointerException("账号错误，请重新访问");
        }
        return user;
    }

    /**
     * @Description: 修改密码
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    @Override
    public R udpatePasswordByNumber(String oldPasswd, String number, String newPasswd) {

        User user = userDao.queryByNumber(number);

        if (user == null) {
            throw new ServiceException(ErrorCodeEnum.USER_ACCOUNT_NOT_FOUND);
        }

        // 数据库里面的老密码
        String userPasswd = user.getPasswd();

        // 用数据库里面的老密码和输入的老密码进行比对
        boolean matches = bCryptPasswordEncoder.matches(oldPasswd, userPasswd);

        if (matches) {
            // 给新的密码进行加密
            String encodePassword = bCryptPasswordEncoder.encode(newPasswd);

            // 将新的密码传入进去
            int flag = userDao.updatePwByNumber(number, encodePassword);

            return R.ok();
        } else {
            return R.exp(201, "原密码不正确，请重新输入");
        }
    }


    /**
     * @Description: 通过名字查询账号信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/11
     */
    @Override
    public R queryUserByUserName(String username) {

        ArrayList<User> userlist = userDao.queryByUserName(username);

        for (User user : userlist) {
            user.setPasswd(null);
        }

        if (userlist.size() == 0) {
            return R.exp(201, "用户不存在");
        }

        return R.ok().setData(userlist);
    }

    /**
     * 管理员查询多个用户
     * 2022/2/11
     * @author lt
     */
    @Override
    public R getAllUsers(int pageNum, int pageSize,User user){
        PageHelper.startPage(pageNum, pageSize);
//        判断为老师还是学生
//        roleid is 0  说明是学生
        System.out.println("roleid is "+user.getRoleId()+"教研室是"+user.getTeachingResearch());

        if (user.getRoleId()==null){
            ArrayList<User> users = userDao.selectAllTeacher(user);
            for (User user1 : users) {
                System.out.println(user1.getTeachingResearch());
            }
            System.out.println(users);
            PageInfo<User> page=new PageInfo<>(users);
            return R.ok().setData(page);
        }
        if (user.getRoleId().equals("0"))
        {
            List<User> users = userDao.selectAllStudent(user);
            PageInfo<User> page=new PageInfo<>(users);
            return R.ok().setData(page);
        }
        return R.exp(201,"请传正确的roleId");
    }
    /**
     * 管理员添加一个用户信息
     * 2022/2/13
     * @author lt
     */
    @Override
    public R addUser(User user) {
        user.setPasswd("123456");
        user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));

        user.setCreateTime(new Date());

        int i = userDao.insert(user);
        if (i > 0) {
            return R.ok().setData(user);
        }
        return R.fail();
    }

    /**
     * @Description: 管理员批量导入用户信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/13
     */
    @Override
    public R batchAddAllUser(List<User> userList) {
        String failMsg = null;
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUsername() == null){
                return R.exp(201,"批量导入失败，在第" + (i + 1) + "条导入失败，请查看该记录名字是否填写");
            }else if (user.getSex()  == null){
                return R.exp(201,"批量导入失败，在第" + (i + 1) + "条导入失败，请查看该记录性别是否填写");
            }else if (user.getNumber()  == null){
                return R.exp(201,"批量导入失败，在第" + (i + 1) + "条导入失败，请查看该记录学号是否填写");
            }else if (user.getRoleId()  == null){
                return R.exp(201,"批量导入失败，在第" + (i + 1) + "条导入失败，请查看该记录'教师/学生'是否填写");
            }else if (user.getFaculty() == null){
                return R.exp(201,"批量导入失败，在第" + (i + 1) + "条导入失败，请查看该记录'学院'是否填写");
            }
        }
        for (int i = 0; i < userList.size(); i++){
            User user = userList.get(i);
            try {
                 userDao.insert(user);
            }catch (DataAccessException e){
                System.out.println("第" + (i+1) +"条出现错误");
            }
        }

        return R.ok();
    }

    /**
     * @Description: 管理员修改用户信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/17
     */
    @Override
    public R updateUserByAdmin(User user) {
        // 如果密码不是空，则给密码进行加密处理，进行修改
        if (user.getPasswd() != null){
            String psw = bCryptPasswordEncoder.encode(user.getPasswd());
            user.setPasswd(psw);
        }
        int update = userDao.update(user);

        if (update == 0){
            return R.exp(201,"修改用户信息错误！！");
        }
        return R.ok();
    }


    /**
     * @Description: 根据用户名批量查询多个用户信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/17
     */
    @Override
    public R queryUserByUserNameList(List<String> usernameList) {
        ArrayList<User> users = new ArrayList<>();
        for (String username : usernameList) {
            ArrayList<User> userlist = userDao.queryByUserName(username);
            if (userlist.size() != 0) {
                for (User user : userlist) {
                    user.setPasswd(null);
                    System.out.println(user);

                    users.add(user);
                }
            }
        }
        return R.ok().setData(users);
    }
}
