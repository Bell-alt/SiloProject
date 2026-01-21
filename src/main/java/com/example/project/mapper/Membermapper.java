package com.example.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.project.dto.MemberJoinDTO;
import com.example.project.dto.SiloFileResponse;

@Mapper
public interface Membermapper {
    
    @Select("select * from siloFile ")
    SiloFileResponse fildbyId(long id);
    
    
    @Insert("insert into member(member_id. member_name, member_pass,role) values(#{member_id}, #{member_name}, #{member_pass}, #{role})")
    @Options(useGeneratedKeys = true, keyProperty = "member_idx")
    void insertMember(MemberJoinDTO memberJoin);


}
