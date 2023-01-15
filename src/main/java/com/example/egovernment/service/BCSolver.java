package com.example.egovernment.service;

import com.example.egovernment.model.Element;
import com.example.egovernment.model.Rule;
import java.util.ArrayList;
import java.util.List;

public class BCSolver {

    public boolean solve(List<Rule> rulesList, List<Element> facts, Element goal) {
        List<Element> currentGaols = new ArrayList<>();
        List<Element> path = new ArrayList<>();
        return  solve(rulesList, facts, goal, currentGaols, path);
    }

    public boolean solve (List<Rule> ruleList, List<Element> facts, Element goal, List<Element> currentGoals, List<Element> path) {
        if (facts.contains(goal)) {
            return true;
        }
        if (currentGoals.contains(goal)) {
            //cycle
            return false;
        }
        for (Rule rule: ruleList) {
            if (rule.getConsequent().equals(goal)) {
                boolean allTrue = true;
                List<Element> tempGoals = new ArrayList<>(rule.getAntecedent());

                List<Element> newCurrentGaols = new ArrayList<>(currentGoals);
                newCurrentGaols.add(goal);
                for (Element subGoal: tempGoals) {
                    if (!solve(ruleList, facts, subGoal, newCurrentGaols, path)) {
                        allTrue = false;
                    }
                }
                if (allTrue) {
                    rule.getAntecedent().stream().map(path::add);
                    facts.add(goal);
                    return true;
                } else {
                    path.clear();
                }
            }
        }
        return false;
    }
}
