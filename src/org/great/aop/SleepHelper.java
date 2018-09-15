package org.great.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * ����һ��˯�ߵ�֪ͨ����ǿ�� ͬʱʵ��ǰ�� �ͺ���
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println(target + method.getName() + args  +returnValue );
		System.out.println("睡觉中。。。");
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println(method.getName() + args + target);
		System.out.println("睡觉前。。。");

	}

}