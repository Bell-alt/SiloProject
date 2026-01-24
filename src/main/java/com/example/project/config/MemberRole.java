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

    public String getMemberRole(){
        return "ROLE_"+this.name();
    }
    
    public int getLevel(){
        return level;
    }
    
    public static MemberRole fromString(String rolename){
        if(rolename == null){
            return GUEST;
        }
        try {
            return MemberRole.valueOf(rolename.toUpperCase());
        } catch (IllegalArgumentException e) {
             e.getMessage();
             return GUEST;
        }
    }


    public boolean isAdmin(){
       return this == ADMIN;
    }

    public boolean isAuthority(){
        return this == AUTHORITY;
    }


    public boolean hashigherLevelThan(MemberRole otherRole){
        return this.ordinal() >= otherRole.ordinal();

     }
    
    
    }