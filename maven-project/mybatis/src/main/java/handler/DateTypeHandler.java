package handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {


    @Override
    //java自定义类  到数据库 需要的类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        Long time = date.getTime();
        preparedStatement.setLong(i,time);
    }

    @Override
    //  数据库的类型  转到  java自定义类
    //String 为表中的字段名称 resultSet为查询结果集
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Date date = new Date(resultSet.getLong(s));
        return date;
    }

    @Override
    //  数据库的类型  转到  java自定义类
    //i为表中的字段位置 resultSet为查询结果集
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Date date = new Date(resultSet.getLong(i));
        return date;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Date date = new Date(callableStatement.getLong(i));
        return date;
    }
}
