package app.dtos.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String userName;
    private int currentLevel;
}
