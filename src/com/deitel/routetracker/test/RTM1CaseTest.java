package com.deitel.routetracker.test;

import android.test.ActivityInstrumentationTestCase2;
import com.deitel.routetracker.R;
import com.deitel.routetracker.RouteTracker;
import com.deitel.routetracker.test.util.TestCaseUtil;
import com.deitel.routetracker.test.util.TestLocationProvider;
import com.robotium.solo.Solo;

public class RTM1CaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	@SuppressWarnings("unchecked")
	public RTM1CaseTest() {
		super(RouteTracker.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCesOne() throws Exception {
		String cesOne = "Initialize_Application, Load_Map, Press_Menu, Satellite, Load_Map, Trace_route, Load_Map, SensorSimulator, Console, Click_on_Connect, Add_Latitude_and_Longitude, Send_GPS, Load_Map, Press_Menu, Map, Load_Map, Press_Back_Exit";

		TestCaseUtil.executeTestCase(this, RTM1CaseTest.class, cesOne);
	}

	public void Initialize_Application() throws Exception {
	}

	public void Load_Map() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_map));
	}

	public void Press_Menu() throws Exception {
	}

	public void Satellite() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_satellite));
	}

	public void Trace_route() throws Exception {
	}

	public void SensorSimulator() throws Exception {
	}

	public void Console() throws Exception {
	}

	public void Click_on_Connect() throws Exception {
	}

	public void Add_Latitude_and_Longitude() throws Exception {
		TestLocationProvider.sendLocation(solo, new double[] { -50.657203, -50.655003, -50.655164, -50.656130, -50.656183, -50.653426, -50.653319 }, new double[] { -23.186256, -23.186256, -23.184718, -23.184797, -23.183712, -23.183486, -23.184551 });
	}

	public void Send_GPS() throws Exception {
	}

	public void Map() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_map));
	}

	public void Press_Back_Exit() throws Exception {
		solo.goBack();
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
