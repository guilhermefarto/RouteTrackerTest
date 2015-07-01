package com.deitel.routetracker.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import com.deitel.routetracker.R;
import com.deitel.routetracker.RouteTracker;
import com.deitel.routetracker.test.util.TestCaseUtil;
import com.deitel.routetracker.test.util.TestLocationProvider;
import com.robotium.solo.Solo;

public class RTM6CaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	@SuppressWarnings("unchecked")
	public RTM6CaseTest() {
		super(RouteTracker.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCesOne() throws Exception {
		// String cesOne =
		// "Open_application, Display_Tracking_Screen, Press_Menu, Press_Back, Display_Tracking_Screen, Press_Menu, Display_Options, Select_SATELLITE, Display_Satellite, Display_Tracking_Screen, Press_Start_Tracking, Connect_GPS, Display_Error_Message, Display_Tracking_Screen, Press_Menu, Display_Options, Select_MAP, Display_maps, Display_Tracking_Screen, Press_Start_Tracking, Connect_GPS, Listen_to_GPS, Coordinate_updated, Read_Capture_informations, Draw_Line, Update_Screen_Map, Listen_to_GPS, Press_Stop_Tracking, Shutdown_GPS, Display_Tracking_Screen, Press_Back, Close_application";
		String cesOne = "Open_application, Display_Tracking_Screen, Press_Menu, Press_Back, Display_Tracking_Screen, Press_Menu, Display_Options, Select_SATELLITE, Display_Satellite, Display_Tracking_Screen, Press_Start_Tracking, Connect_GPS, Display_Error_Message, Display_Tracking_Screen, Press_Menu, Display_Options, Select_MAP, Display_maps, Display_Tracking_Screen, Connect_GPS, Listen_to_GPS, Coordinate_updated, Read_Capture_informations, Draw_Line, Update_Screen_Map, Listen_to_GPS, Press_Stop_Tracking, Shutdown_GPS, Display_Tracking_Screen, Press_Back, Close_application";

		TestCaseUtil.executeTestCase(this, RTM6CaseTest.class, cesOne);
	}

	public void Open_application() throws Exception {
	}

	public void Display_Tracking_Screen() throws Exception {
	}

	public void Press_Menu() throws Exception {
		new Thread(new Runnable() {
			public void run() {
				getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
			}
		}).start();
	}

	public void Press_Back() throws Exception {
		solo.goBack();
	}

	public void Display_Options() throws Exception {
	}

	public void Select_SATELLITE() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_satellite));
	}

	public void Display_Satellite() throws Exception {
	}

	public void Press_Start_Tracking() throws Exception {
		boolean actualTest = solo.searchToggleButton(solo.getString(R.string.button_start_tracking));

		assertEquals("Toggle Button not found", true, actualTest);

		solo.clickOnToggleButton(solo.getString(R.string.button_start_tracking));
	}

	public void Connect_GPS() throws Exception {
	}

	public void Display_Error_Message() throws Exception {
	}

	public void Select_MAP() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_map));
	}

	public void Display_maps() throws Exception {
	}

	public void Listen_to_GPS() throws Exception {
	}

	public void Coordinate_updated() throws Exception {
		TestLocationProvider.sendLocation(solo, new double[] { -50.657203, -50.655003, -50.655164, -50.656130, -50.656183, -50.653426, -50.653319 }, new double[] { -23.186256, -23.186256, -23.184718, -23.184797, -23.183712, -23.183486, -23.184551 });
	}

	public void Read_Capture_informations() throws Exception {
	}

	public void Draw_Line() throws Exception {
	}

	public void Update_Screen_Map() throws Exception {
	}

	public void Press_Stop_Tracking() throws Exception {
		boolean actualTest = solo.searchToggleButton(solo.getString(R.string.button_stop_tracking));

		assertEquals("Toggle Button not found", true, actualTest);

		solo.clickOnToggleButton(solo.getString(R.string.button_stop_tracking));

		actualTest = solo.waitForDialogToOpen(3000);

		assertEquals("Dialog not found", true, actualTest);

		actualTest = solo.waitForText(solo.getString(R.string.results));

		assertEquals("Dialog Text not found", true, actualTest);

		actualTest = solo.waitForText("Distance: 0.9KM 0.6MI");

		assertEquals("Dialog Text not found", true, actualTest);

		solo.clickOnButton(solo.getString(R.string.button_ok));
	}

	public void Shutdown_GPS() throws Exception {
	}

	public void Close_application() throws Exception {
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
