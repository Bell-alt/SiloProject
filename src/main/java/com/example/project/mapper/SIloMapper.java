package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.project.dto.SiloFileResponse;

@Mapper
public interface SIloMapper {


    @Select("select * from siloFile")
    List<SiloFileResponse> findAllSilos();
    
    @Select("""
             select * ,
             case when #{userLevel} >= required_level then 1 else 0 end as hasAccess
             from siloFiles where cetegory = #{category}            
            """)
    List<SiloFileResponse> findByLevelandCategory(@Param("userLevel")int userLevel, @Param("category")String category);

}
