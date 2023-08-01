package org.example.a.creation.b.factory.method;

import org.example.a.creation.b.factory.simple.IRuleConfigParser;
import org.example.a.creation.b.factory.simple.YamlRuleConfigParser;

/**
 * @author goku
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
