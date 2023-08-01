package a.creation;

import org.example.a.creation.b.factory.simple.IRuleConfigParser;
import org.example.a.creation.b.factory.simple.RuleConfig;
import org.example.a.creation.b.factory.simple.RuleConfigParserFactory;
import org.junit.Test;

/**
 * @author goku
 * @datetime 2023/8/1 11:09 PM
 */
public class SimpleFactoryTest {

    @Test
    public void testSimpleFactory() {
        IRuleConfigParser parser = RuleConfigParserFactory.createParser("json");
        RuleConfig config = parser.parse("config");
        System.out.println(config.getConfig());
    }

}
