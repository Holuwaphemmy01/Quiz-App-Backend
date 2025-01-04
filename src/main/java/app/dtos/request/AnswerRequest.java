package app.dtos.request;

import lombok.Data;

@Data
public class AnswerRequest {
    private String userName;
    private int currentLevel;
    private String selectedOptions;
}
