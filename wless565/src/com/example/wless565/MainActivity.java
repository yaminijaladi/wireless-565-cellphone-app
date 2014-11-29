package com.example.wless565;

//GET LOCATION
import com.google.android.gms.common.*;
import com.google.android.gms.location.*;
import android.location.Location;
import android.widget.Toast;
//END GET LOCATION

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//GET LOCATION
public class MainActivity extends Activity implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
//END GET LOCATION
	
	//GET LOCATION
	protected static final int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
	protected LocationClient loClient;
    Location currentLocation;
	//END GET LOCATION
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //create a new class that executes a post request
        PostStuff p = new PostStuff();
        p.execute(null,null,null);
        
        //GET LOCATION
        loClient = new LocationClient(this,this,this);
        //END GET LOCATION
        
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //GET LOCATION
    // see https://developer.android.com/training/location/retrieve-current.html
    // for further information
    @Override
    protected void onStart() {
    	super.onStart();
    	loClient.connect();
    }
    @Override
    protected void onStop() {
    	loClient.disconnect();
    	super.onStop();
    }
    
	@Override
	public void onConnected(Bundle arg0) {
		Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
		currentLocation = loClient.getLastLocation();
	}
	@Override
	public void onDisconnected() {
		Toast.makeText(this, "Disconnected. Please re-connect.",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		Toast.makeText(this, "Connection Failed", Toast.LENGTH_SHORT).show();
		
	}
	//END GET LOCATION
}