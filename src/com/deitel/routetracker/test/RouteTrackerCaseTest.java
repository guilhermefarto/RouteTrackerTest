package com.deitel.routetracker.test;

import android.test.ActivityInstrumentationTestCase2;
import com.deitel.routetracker.R;
import com.deitel.routetracker.RouteTracker;
import com.deitel.routetracker.test.util.TestLocationProvider;
import com.robotium.solo.Solo;

public class RouteTrackerCaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	private boolean actualTest = false;

	@SuppressWarnings("unchecked")
	public RouteTrackerCaseTest() {
		super(RouteTracker.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testApp() {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_map));

		solo.clickOnMenuItem(solo.getString(R.string.menuitem_satellite));

		actualTest = solo.searchToggleButton(solo.getString(R.string.button_start_tracking));

		assertEquals("Toggle Button not found", true, actualTest);

		solo.clickOnToggleButton(solo.getString(R.string.button_start_tracking));

		solo.sleep(1000);
		TestLocationProvider.sendLocation(solo, new double[] { -50.657203, -50.655003, -50.655164, -50.656130, -50.656183, -50.653426, -50.653319 }, new double[] { -23.186256, -23.186256, -23.184718, -23.184797, -23.183712, -23.183486, -23.184551 });

		solo.sleep(1000);

		solo.searchToggleButton(solo.getString(R.string.button_stop_tracking));

		assertEquals("Toggle Button not found", true, actualTest);

		solo.clickOnToggleButton(solo.getString(R.string.button_stop_tracking));

		actualTest = solo.waitForDialogToOpen(3000);

		assertEquals("Dialog not found", true, actualTest);

		actualTest = solo.waitForText(solo.getString(R.string.results));

		assertEquals("Dialog Text not found", true, actualTest);

		actualTest = solo.waitForText("Distance: 0.9KM 0.6MI");

		assertEquals("Dialog Text not found", true, actualTest);

		solo.clickOnButton(solo.getString(R.string.button_ok));

		solo.sleep(1000);
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
