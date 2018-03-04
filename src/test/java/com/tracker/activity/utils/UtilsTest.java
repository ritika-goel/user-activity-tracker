package com.tracker.activity.utils;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class UtilsTest {
	@Test
	public void testPrivateConstructor() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<Utils> c = Utils.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(c.getModifiers()));
		c.setAccessible(true);
		c.newInstance();
	}

}
