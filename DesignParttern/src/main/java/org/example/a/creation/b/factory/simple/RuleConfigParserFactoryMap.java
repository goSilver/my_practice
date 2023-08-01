package org.example.a.creation.b.factory.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂的第二种实现方式，通过一个map将对象都提前创建并缓存起来
 *
 * @author goku
 * @datetime 2023/8/1 11:14 PM
 */
public class RuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParser> CACHED_PARSERS = new HashMap<>();

    static {
        CACHED_PARSERS.put("json", new JsonRuleConfigParser());
        CACHED_PARSERS.put("xml", new XmlRuleConfigParser());
        CACHED_PARSERS.put("yaml", new YamlRuleConfigParser());
        CACHED_PARSERS.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        return CACHED_PARSERS.get(configFormat.toLowerCase());
    }
}
