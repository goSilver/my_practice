package org.example.a.creation.b.factory.method;

import org.example.a.creation.b.factory.simple.IRuleConfigParser;
import org.example.a.creation.b.factory.simple.PropertiesRuleConfigParser;

/**
 * @author goku
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
