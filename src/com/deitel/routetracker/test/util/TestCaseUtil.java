package com.deitel.routetracker.test.util;

import java.lang.reflect.Method;
import android.util.Log;

public class TestCaseUtil {

	public static void executeTestCase(Object klassObject, Class<?> klass, String cesOne) throws Exception {
		String[] events = cesOne.split(",");

		for (int index = 1; index < events.length - 1; index++) {
			String event = events[index].trim();

			Log.i("Tracing", event);

			Method method = klass.getDeclaredMethod(event);

			if (method != null) {
				method.invoke(klassObject);
			}
		}
	}

}
