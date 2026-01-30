package com.example.project.mapper;

import java.lang.reflect.Member;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.project.dto.MemberDTO;
import com.example.project.dto.MemberJoinDTO;
import com.example.project.handler.MemberRoleTypeHandler;

@Mapper
public interface Membermapper {
    
    //@Select("select * from siloFile ")
    //SiloFileResponse fildbyId(long id);
    
    
    @Insert("insert into member(member_id, member_name, member_pass, role) values(#{member_id}, #{member_name}, #{member_pass}, #{role})")
    @Options(useGeneratedKeys = true, keyProperty = "member_idx")
    public void insertMember(MemberJoinDTO memberJoin);
    
    
    
	@Select("select member_idx, member_id, member_name, member_pass, role from member where member_id=#{member_id}")
	@Results({
		@Result(property="member_idx", column="member_idx"),
		@Result(property="member_id", column="member_id"),
		@Result(property="member_name", column="member_name"),
		@Result(property="member_pass", column="member_pass"),
		@Result(property="role", column="role", typeHandler=MemberRoleTypeHandler.class)
	})
    Optional<MemberDTO> getAllUsersDetail(@Param("member_id")String member_id);


    @Select("select meember_id, member_name, role from member")
    @Results({
		@Result(property="member_id", column="member_id"),
        @Result(property="member_name",column="member_name"),
		@Result(property="role", column="role",typeHandler=MemberRoleTypeHandler.class )
	})
	Optional<MemberDTO> findMemberbyId(@Param("member_id")String member_id);

}
