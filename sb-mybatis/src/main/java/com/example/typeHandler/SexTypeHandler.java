package com.example.typeHandler;

import com.example.entity.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    /**
     * 设置非空性别参数
     * @param preparedStatement
     * @param i
     * @param sexEnum
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getId());
    }

    /**
     * 通过列名，获取性别
     * @param resultSet
     * @param col
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String col) throws SQLException {
        int sex = resultSet.getInt(col);
        if (sex != 1 && sex != 2 ) {
            return null;
        }
        return SexEnum.getSeEnumById(sex);
    }

    /**
     * 通过下标读取性别
     * @param resultSet
     * @param idx
     *
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int idx) throws SQLException {
        int sex = resultSet.getInt(idx);
        if (sex != 1 && sex != 2 ) {
            return null;
        }
        return SexEnum.getSeEnumById(sex);
    }

    /**
     * 通过存储过程读取性别
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        if (sex != 1 && sex != 2 ) {
            return null;
        }
        return SexEnum.getSeEnumById(sex);
    }
}
