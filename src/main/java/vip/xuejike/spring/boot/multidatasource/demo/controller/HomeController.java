package vip.xuejike.spring.boot.multidatasource.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.xuejike.spring.boot.multidatasource.demo.db1.dao.UserDao;
import vip.xuejike.spring.boot.multidatasource.demo.db1.entity.User;
import vip.xuejike.spring.boot.multidatasource.demo.db2.dao.User2Dao;
import vip.xuejike.spring.boot.multidatasource.demo.db2.entity.UserD2;

@Controller
public class HomeController {

    @Autowired
    UserDao userDao;
    @Autowired
    User2Dao user2Dao;
    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        UserD2 userD2 = new UserD2();
        userD2.setName("|sss");
        user2Dao.save(userD2);
        return "";
    }

    @RequestMapping("/t1")
    @ResponseBody
    @Transactional
    public String t1(){
        User user = new User();
        user.setUsername("u1");
        userDao.save(user);
        return "t1";
    }
    @RequestMapping("/t2")
    @ResponseBody
    @Transactional(transactionManager = "twoTransactionManager")
    public String t2(){
        UserD2 user = new UserD2();
        user.setName("u1");
        user2Dao.save(user);
        return "t2";
    }
}
