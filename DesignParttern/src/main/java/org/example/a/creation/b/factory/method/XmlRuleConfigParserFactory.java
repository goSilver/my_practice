package org.example.a.creation.b.factory.method;

import org.example.a.creation.b.factory.simple.IRuleConfigParser;
import org.example.a.creation.b.factory.simple.XmlRuleConfigParser;

/**
 * @author goku
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
