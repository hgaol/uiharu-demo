package com.github.hgaol.demo.aop;

import com.github.hgaol.uiharu.annotation.Aspect;
import com.github.hgaol.uiharu.annotation.Controller;
import com.github.hgaol.uiharu.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * @author: gaohan
 * @date: 2018-08-24 16:47
 **/
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        System.out.println("---- before ----");
        System.out.println(String.format("class: %s", cls.getName()));
        System.out.println(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) {
        System.out.println(String.format("time: %dms", System.currentTimeMillis() - begin));
        System.out.println("----------- end -----------");
    }

}
