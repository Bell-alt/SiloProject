package com.example.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.project.dto.SiloFile;

@Mapper
public interface Membermapper {
    
    @Select("select * from siloFile ")
    SiloFile fildbyId(long id);

}
