package com.pipidan.test;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.random;

public class GenerateLog {
    public static Logger myLog = LoggerFactory.getLogger(GenerateLog.class);
    public static void main(String[] args) {

        UserMybatis user = new UserMybatis();

        user.setUserId(3);
        user.setUserName("lucky");
        user.setPassword("yoyo");
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Long time = date.getTime();
        System.out.println(time);
        System.out.println(sdf.format(date));*/
        Double d = random()*1000000;
        System.out.println(d);
        Double re = new BigDecimal(d).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(re);

       /* SqlSession sqlSession = null;
        try {
            //获得核心配置文件
            InputStream resources = Resources.getResourceAsStream("sqlMapConfiguration.xml");
            //获得会话工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resources);
            //获得会话对象
            sqlSession = sqlSessionFactory.openSession();
            //执行操作 参数：namespace.id
            //List<UserMybatis> userMybatisList = sqlSession.selectList("UserMapper.findAll");


            //mybatis默认事务不提交，所以要手动提交，否则不进行增删改操作；只有查操作不受影响
            sqlSession.commit();
            //myLog.info(userMybatisList.toString());
        }catch (IOException e) {
            myLog.debug(e.getMessage());
        }finally {
            //释放资源
            if(sqlSession!=null) {
                sqlSession.close();
            }
        }*/
    }

}
