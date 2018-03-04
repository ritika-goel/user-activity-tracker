package com.tracker.activity.constants;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class ConstantsTest {

	@Test
	public void testPrivateConstructor() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<Constants> c = Constants.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(c.getModifiers()));
		c.setAccessible(true);
		c.newInstance();
	}
}
