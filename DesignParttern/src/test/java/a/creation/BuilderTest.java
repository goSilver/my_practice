package a.creation;

import org.example.a.creation.c.builder.ResourcePoolConfig;
import org.junit.Test;

/**
 * @author goku
 * @datetime 2023/8/2 9:22 PM
 */
public class BuilderTest {

    @Test
    public void testBuilder() {
        // 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbconnectionpool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(12)
                .build();
    }
}
