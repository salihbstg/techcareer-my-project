package com.techcareer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="mathematics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mathematics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="description")
    private String description;
    @Column(name="question")
    private String question;
    @Column(name="option1")
    private String option1;
    @Column(name="option2")
    private String option2;
    @Column(name="option3")
    private String option3;
    @Column(name="option4")
    private String option4;
    @Column(name="option5")
    private String option5;
    @Column(name="answer")
    private String answer;
}
