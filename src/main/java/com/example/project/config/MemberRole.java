package com.example.project.config;

import org.checkerframework.checker.units.qual.s;

public enum MemberRole {
   
    ADMIN(3),
    AUTHORITY(2),    
    USER(1),
    GUEST(0);

    private final int level;

    MemberRole(int level){
        this.level = level;

    }
    
    private int getLevel(){
        return level;
    }


}
