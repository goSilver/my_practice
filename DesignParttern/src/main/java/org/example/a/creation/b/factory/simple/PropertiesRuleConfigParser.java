package org.example.a.creation.b.factory.simple;

/**
 * @author goku
 * @datetime 2023/8/1 11:06 PM
 */
public class PropertiesRuleConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig(configText);
    }
}
