package com.pipidan;

import com.pipidan.dao.OrderMapper;
import com.pipidan.test.GenerateLog;
import com.pipidan.test.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Math.random;

public class OrderTest {
    public List<Order> createOrderList() {
        List<Order> orderList = new ArrayList<Order>();

        for(int i=1; i<3; i++) {
            for(int j=0; j<2; j++) {
                Order order = new Order();
                order.setOrderId(i);
                order.setOrderTime(new Date(System.currentTimeMillis()));
                Double total = new BigDecimal(random()*1000).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                order.setTotal(total);
                orderList.add(order);
            }

        }
        return orderList;
    }
    @Test
    public void orderTset() {
        SqlSession sqlSession = null;
        try {
            InputStream resources = Resources.getResourceAsStream("sqlMapConfiguration.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(resources).openSession();
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
           /* List<Order> orderList = createOrderList();
            oderMapper.addOrders(orderList);
            sqlSession.commit();*/
            List<Order> orders = orderMapper.findAll();
            GenerateLog.myLog.info(orders.toString());

        } catch(IOException e) {
            GenerateLog.myLog.error(e.getMessage());
        } finally {
            if (sqlSession!=null) {
                sqlSession.close();
            }
        }

    }
}
