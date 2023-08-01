package a.creation;

import org.example.a.creation.a.singleton.*;
import org.junit.Test;

/**
 * 单例模式单元测试
 *
 * @author goku
 * @datetime 2023/8/1 10:16 PM
 */
public class SingletonTest {

    @Test
    public void testHungry() {
        Hungry hungry = Hungry.getInstance();
        System.out.println(hungry.getId());
        System.out.println(hungry.getId());
    }

    @Test
    public void testLazy() {
        Lazy lazy = Lazy.getInstance();
        System.out.println(lazy.getId());
        System.out.println(lazy.getId());
    }

    @Test
    public void testDoubleCheck() {
        DoubleCheck dc = DoubleCheck.getInstance();
        System.out.println(dc.getId());
        System.out.println(dc.getId());
    }

    @Test
    public void testStaticInnerClass() {
        StaticInnerClass sic = StaticInnerClass.getInstance();
        System.out.println(sic.getId());
        System.out.println(sic.getId());
    }

    @Test
    public void testEnumm() {
        Enumm enumm = Enumm.INSTANCE;
        System.out.println(enumm.getId());
        System.out.println(enumm.getId());
    }
}
