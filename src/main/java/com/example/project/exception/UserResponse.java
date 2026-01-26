
package com.example.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private boolean success;
    private String message;
    private Object data;

    // 에러 응답을 위한 static 메서드
    public static UserResponse error(String message) {
        return new UserResponse(false, message, null);
    }

    // 데이터 포함 성공 응답을 위한 static 메서드
    public static UserResponse successData(String message, Object data) {
        return new UserResponse(true, message, data);
    }
    
    // 단순 메시지 성공 응답
    public static UserResponse successMessage(String message) {
        return new UserResponse(true, message, null);
    }
}