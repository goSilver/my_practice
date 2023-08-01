package org.example.a.creation.b.factory.simple;

/**
 * @author goku
 * @datetime 2023/8/1 11:05 PM
 */
public class JsonRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig(configText);
    }
}
