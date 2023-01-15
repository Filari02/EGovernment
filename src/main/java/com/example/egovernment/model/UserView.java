package com.example.egovernment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserView {
    private int birthYear;
    private boolean convicted;
    private boolean parentLithuanian;
    private int yearsLivedInLithuania;
    private boolean requestedNationality;
    private boolean passedLanguageExam;
    private String questionCode;


}
