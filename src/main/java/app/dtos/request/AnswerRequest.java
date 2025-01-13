package app.dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class AnswerRequest {
    private String userName;
    private List<String> selectedOptions;
}
