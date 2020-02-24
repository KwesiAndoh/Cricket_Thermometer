package org.amalitech.temperature;

import java.text.DecimalFormat;

import android.app.Activity;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText et_NoOfChirps;
	Button btn_calTemp;
	TextView tv_Result;
	DecimalFormat formatter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et_NoOfChirps = (EditText)findViewById(R.id.et_NoOfChirps);
		btn_calTemp =(Button)findViewById(R.id.btn_send);
		tv_Result=(TextView)findViewById(R.id.tv_temperature);
		
		tv_Result.setVisibility(View.GONE);
		
		formatter = new DecimalFormat("#0.00");
		
		btn_calTemp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (et_NoOfChirps.getText().toString().isEmpty()) {
					Toast.makeText(MainActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();;
				}
				int chirps = Integer.parseInt(et_NoOfChirps.getText().toString().trim());
				double temp = (chirps /3.0)+ 4;
				String result = "the temperature outside is " + formatter.format(temp) + " degrees outside";
				tv_Result.setText(result);
				
				tv_Result.setVisibility(View.VISIBLE);
			}
		});
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
}
