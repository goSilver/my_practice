package org.example.a.creation.b.factory.method;

import org.example.a.creation.b.factory.simple.IRuleConfigParser;
import org.example.a.creation.b.factory.simple.JsonRuleConfigParser;

/**
 * @author goku
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
