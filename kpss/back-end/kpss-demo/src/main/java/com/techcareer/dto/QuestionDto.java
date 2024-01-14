package com.techcareer.dto;

import lombok.Data;

@Data
public class QuestionDto {
    private long id;
    private String description;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String answer;
}
