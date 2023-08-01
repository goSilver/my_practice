package org.example.a.creation.b.factory.method;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂的工厂
 * 因为工厂类只包含方法，不包含成员变量，完全可以复用，
 * 不需要每次都创建新的工厂类对象，所以，简单工厂模式的第二种实现思路更加合适。
 *
 * @author goku
 * @datetime 2023/8/1 11:40 PM
 */
public class RuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParserFactory> CACHED_FACTORIES = new HashMap<>();

    static {
        CACHED_FACTORIES.put("json", new JsonRuleConfigParserFactory());
        CACHED_FACTORIES.put("xml", new XmlRuleConfigParserFactory());
        CACHED_FACTORIES.put("yaml", new YamlRuleConfigParserFactory());
        CACHED_FACTORIES.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return CACHED_FACTORIES.get(type.toLowerCase());
    }
}