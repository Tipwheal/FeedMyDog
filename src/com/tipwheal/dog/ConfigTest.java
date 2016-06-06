package com.tipwheal.dog;

import java.lang.reflect.Method;

/**
 * of no use now.
 * 
 * @author Administrator
 *
 */
public class ConfigTest {
	// public static void main(String[] args) {
	// try {
	// Runtime.getRuntime().exec("new ConfigTest().show()");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	public void show() {
		System.out.println("right");
	}

	public static void main(String[] args) throws Exception {
		Dog dog = new Dog();
		Method m = new Action().getClass().getDeclaredMethod("show", Dog.class);
		m.invoke(new Action(), new Object[] { dog });
		// String methodName = "show";
		// String params = "value";
		// ConfigTest obj = new ConfigTest();
		// Class classType = obj.getClass();
		// Method method = classType.getDeclaredMethod(methodName, new Class[]
		// {});
		// method.invoke(obj, new Object[] {});
	}
}
