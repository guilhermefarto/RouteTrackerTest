package com.deitel.routetracker.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import com.deitel.routetracker.R;
import com.deitel.routetracker.RouteTracker;
import com.deitel.routetracker.test.util.TestCaseUtil;
import com.deitel.routetracker.test.util.TestLocationProvider;
import com.robotium.solo.Solo;

public class RTM8CaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	@SuppressWarnings("unchecked")
	public RTM8CaseTest() {
		super(RouteTracker.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCesOne() throws Exception {
		String cesOne = "Display_map, Press_Menu, Display_menu, Press_Map, Display_map_image, Display_map, Initiate_tracking, Detect_initial_point, Move_map_to_actual_point, Display_coordinates, Update_coordinates_from_GPS, Stop_tracking, Display_distance_and_average_speed, Press_Back, Display_map, Press_Back";

		TestCaseUtil.executeTestCase(this, RTM8CaseTest.class, cesOne);
	}

	public void testCesTwo() throws Exception {
		String cesTwo = "Display_map, Move_map_touch, Display_map, Press_Menu, Display_menu, Back, Hide_menu, Display_map, Press_Menu, Display_menu, Press_Satellite, Display_satellite_image, Display_map, Initiate_tracking, Detect_initial_point, Move_map_to_actual_point, Display_coordinates, Update_coordinates_from_GPS, Display_satellite_image, Move_map_to_actual_place, Draw_line_between_previous_place_and_actual_place, Display_route_on_map, Move_map_touch, Display_route_on_map, Display_menu, Press_Back, Hide_menu, Display_route_on_map, Display_menu, Press_Satellite, Display_satellite_image, Display_route_on_map, Display_menu, Press_Map, Display_map_image, Display_route_on_map, Update_coordinates_from_GPS, Stop_tracking, Display_distance_and_average_speed, Press_Ok, Display_map, Initiate_tracking, Detect_initial_point, Move_map_to_actual_point, Display_coordinates, Update_coordinates_from_GPS, Display_satellite_image, Move_map_to_actual_place, Draw_point, Display_route_on_map, Press_Back";

		TestCaseUtil.executeTestCase(this, RTM8CaseTest.class, cesTwo);
	}

	public void Display_map() throws Exception {
	}

	public void Press_Menu() throws Exception {
		new Thread(new Runnable() {
			public void run() {
				getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
			}
		}).start();
	}

	public void Display_menu() throws Exception {
		boolean actualTest = solo.searchText(solo.getString(R.string.menuitem_map));

		if (!actualTest) {
			Press_Menu();
		}
	}

	public void Press_Map() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_map));
	}

	public void Display_map_image() throws Exception {
	}

	public void Initiate_tracking() throws Exception {
		boolean actualTest = solo.searchToggleButton(solo.getString(R.string.button_start_tracking));

		assertEquals("Toggle Button not found", true, actualTest);

		solo.clickOnToggleButton(solo.getString(R.string.button_start_tracking));
	}

	public void Detect_initial_point() throws Exception {
		TestLocationProvider.sendLocation(solo, new double[] { -50.657203 }, new double[] { -23.186256 });
	}

	public void Move_map_to_actual_point() throws Exception {
	}

	public void Display_coordinates() throws Exception {
	}

	public void Update_coordinates_from_GPS() throws Exception {
		TestLocationProvider.sendLocation(solo, new double[] { -50.655003, -50.655164, -50.656130, -50.656183, -50.653426, -50.653319 }, new double[] { -23.186256, -23.184718, -23.184797, -23.183712, -23.183486, -23.184551 });
	}

	public void Stop_tracking() throws Exception {
		boolean actualTest = solo.searchToggleButton(solo.getString(R.string.button_stop_tracking));

		assertEquals("Toggle Button not found", true, actualTest);

		solo.clickOnToggleButton(solo.getString(R.string.button_stop_tracking));

		actualTest = solo.waitForDialogToOpen(3000);
	}

	public void Display_distance_and_average_speed() throws Exception {
		boolean actualTest = solo.waitForDialogToOpen(3000);

		assertEquals("Dialog not found", true, actualTest);

		actualTest = solo.waitForText(solo.getString(R.string.results));

		assertEquals("Dialog Text not found", true, actualTest);

		actualTest = solo.waitForText("Distance: 0.9KM 0.6MI");

		if (!actualTest) {
			actualTest = solo.waitForText("Distance: 1.8KM 1.1MI");

			assertEquals("Dialog Text not found", true, actualTest);
		}
	}

	public void Press_Back() throws Exception {
		solo.goBack();
	}

	public void Move_map_touch() throws Exception {
	}

	public void Back() throws Exception {
	}

	public void Hide_menu() throws Exception {
	}

	public void Press_Satellite() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_satellite));
	}

	public void Display_satellite_image() throws Exception {
	}

	public void Move_map_to_actual_place() throws Exception {
	}

	public void Draw_line_between_previous_place_and_actual_place() throws Exception {
	}

	public void Display_route_on_map() throws Exception {
	}

	public void Press_Ok() throws Exception {
		solo.clickOnButton(solo.getString(R.string.button_ok));
	}

	public void Draw_point() throws Exception {
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
