package com.example.project.handler;

import java.lang.reflect.Member;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.checkerframework.checker.units.qual.s;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import com.example.project.config.MemberRole;

@Configuration
@MappedTypes(MemberRole.class)
@MapperScan(basePackages = "com.example.project.mapper")
public class MemberRoleTypeHandler extends BaseTypeHandler<MemberRole>{


    public MemberRoleTypeHandler roleTypeHandler(){
        return new MemberRoleTypeHandler();
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, MemberRole parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public MemberRole getNullableResult(ResultSet rs, String columnName) throws SQLException {
           String rolename = rs.getString(columnName);
           return MemberRole.fromString(rolename);
    }

    @Override
    public MemberRole getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
         String rolename = rs.getString(columnIndex);
         return MemberRole.fromString(rolename);
    }

    @Override
    public MemberRole getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
       
        String rolename = cs.getString(columnIndex);
        return MemberRole.fromString(rolename);
    }
}
