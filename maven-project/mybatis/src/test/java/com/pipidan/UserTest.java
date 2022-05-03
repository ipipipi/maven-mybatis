package com.pipidan;


import com.pipidan.dao.UserMapper;
import com.pipidan.test.GenerateLog;
import com.pipidan.test.UserMybatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class UserTest {


    @Test

    public void userTset() {

        UserMybatis user = new UserMybatis();
        user.setUserId(4);
        String birthday = "1999-02-25";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(sdf.parse(birthday));
        } catch(ParseException e) {
            GenerateLog.myLog.debug(e.getMessage());
        }

        List<Integer> userIds = new ArrayList<Integer>();
        userIds.add(4);
        SqlSession sqlSession = null;

        try {
            //获得核心配置文件
            InputStream resources = Resources.getResourceAsStream("sqlMapConfiguration.xml");
            //获得会话工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resources);
            //获得会话对象
            sqlSession = sqlSessionFactory.openSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserMybatis> userMybatisList = userMapper.findUserAndOrder();

            //mybatis默认事务不提交，所以要手动提交，否则不进行增删改操作；只有查操作不受影响

            GenerateLog.myLog.info(userMybatisList.toString());
            /*userMapper.updateUserBirthday(user);
            sqlSession.commit();*/




        }catch (Exception e) {
            GenerateLog.myLog.debug(e.getMessage());
        }finally {
            if(sqlSession!=null) {
                sqlSession.close();
            }

        }

    }
}
