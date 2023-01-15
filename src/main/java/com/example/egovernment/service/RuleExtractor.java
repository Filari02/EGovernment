package com.example.egovernment.service;

import com.example.egovernment.model.Element;
import com.example.egovernment.model.UserView;
import com.example.egovernment.repository.ElementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RuleExtractor {
    private final ElementRepository elementRepository;

    private static final String CONVICTED_CODE = "C";
    private static final String PARENT_LITHUANIAN_CODE = "TLR";
    private static final String LANGUAGE_EXAM_CODE = "LT";
    private static final String REQUESTED_NATIONALITY_CODE = "R";
    private static final String SEIMAS_ENTRY_AGE_CODE = "AE";
    private static final String LIVED_IN_LITHUANIA_OVER_10_YEARS = "TYL";

    public List<Element> extractFacts(UserView userView) {
        List<Element> facts = new ArrayList<>();
        if (!userView.isConvicted()) {
            facts.add(elementRepository.findByCode(CONVICTED_CODE));
        }
        if (userView.isParentLithuanian()) {
            facts.add(elementRepository.findByCode(PARENT_LITHUANIAN_CODE));
        }
        if (userView.isPassedLanguageExam()) {
            facts.add(elementRepository.findByCode(LANGUAGE_EXAM_CODE));
        }
        if (userView.isRequestedNationality()) {
            facts.add(elementRepository.findByCode(REQUESTED_NATIONALITY_CODE));
        }
        if (Year.now().getValue() - userView.getBirthYear() >= 25) {
            facts.add(elementRepository.findByCode(SEIMAS_ENTRY_AGE_CODE));
        }
        if (userView.getYearsLivedInLithuania() >= 10) {
            facts.add(elementRepository.findByCode(LIVED_IN_LITHUANIA_OVER_10_YEARS));
        }
        return facts;
    }
}
