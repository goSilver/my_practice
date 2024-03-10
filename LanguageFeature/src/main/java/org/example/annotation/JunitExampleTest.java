package org.example.annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 一个模块的封装大多数人都是通过继承和组合等模式来实现的，但是如果结合注解将可以极大程度提高实现的优雅度（降低耦合度）。
 * 而Junit3 到Junit4的演化就是最好的一个例子。
 *
 * @author chensh
 * @datetime 2024/3/10 5:23 PM
 */
public class JunitExampleTest {
    private HelloWorld hw;

    @Before
    public void setUp() {
        System.out.println("setUp()");
        hw = new HelloWorld();
    }

    @Test(expected=NumberFormatException.class)
    // 1.测试没有返回值,有别于junit3的使用，更加方便
    public void testHello() {
        hw.sayHello();
    }

    @Test
    public void testWorld() {
        hw.sayWorld();
    }

    @Test
    // 2.测试有返回值的方法
    // 返回字符串
    public void testSay() {
        assertEquals("测试失败", hw.say(), "hello world!");
    }

    @Test
    // 返回对象
    public void testObj() {
        assertNull("测试对象不为空", null);
        assertNotNull("测试对象为空", new String());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown()");
        hw = null;
    }

}

class HelloWorld {

    public void sayHello(){
        System.out.println("hello....");
        throw new NumberFormatException();
    }

    public void sayWorld(){
        System.out.println("world....");
    }

    public String say(){
        return "hello world!";
    }

}
