package com.example.locationapp;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	LocationListener loc ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		
			loc = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				String newLocation= "Altitude " +location.getAltitude() +"Latitude "+location.getLatitude()+
						"Longitude "+location.getLongitude();
				Toast.makeText(getApplicationContext(), newLocation, 1).show();
			}
		};
		LocationManager m =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
	    Criteria cri=new Criteria();
		cri.setAccuracy(Criteria.ACCURACY_FINE);
		cri.setPowerRequirement(Criteria.POWER_LOW);
		String provider=m.getBestProvider(cri, true);
		m.requestLocationUpdates(provider, 20000, 2, loc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
