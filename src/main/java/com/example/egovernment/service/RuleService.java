package com.example.egovernment.service;

import com.example.egovernment.model.Element;
import com.example.egovernment.model.Rule;
import com.example.egovernment.model.UserView;
import com.example.egovernment.repository.ElementRepository;
import com.example.egovernment.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleService {
    private final RuleRepository ruleRepository;
    private final ElementRepository elementRepository;
    private final RuleExtractor ruleExtractor;

    public boolean findPath(UserView userView) {
        List<Rule> rules = ruleRepository.findAll();

        List<Element> facts = ruleExtractor.extractFacts(userView);

        Element goal = elementRepository.findByCode(userView.getQuestionCode());
        return new BCSolver().solve(rules, facts, goal);
    }

}
