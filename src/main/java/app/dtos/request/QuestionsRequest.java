package app.dtos.request;

import lombok.Data;

@Data
public class QuestionsRequest {
    private String userName;
    private int currentLevel;
}
