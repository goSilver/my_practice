package org.example.a.creation.b.factory.simple;

/**
 * @author goku
 * @datetime 2023/8/1 11:01 PM
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new Exception("Rule config file format is not supported: " + ruleConfigFilePath);
        }

        String configText = "配置文本" + ruleConfigFileExtension;
        //从ruleConfigFilePath文件中读取配置文本到configText中
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}