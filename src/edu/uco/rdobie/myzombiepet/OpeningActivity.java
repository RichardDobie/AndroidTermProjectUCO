package edu.uco.rdobie.myzombiepet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class OpeningActivity extends Activity {
	private EditText zombieName;
	private Button startButton;
	private String zName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opening);
		zombieName = (EditText)findViewById(R.id.zombie_name);
		
		startButton = (Button)findViewById(R.id.start_button);
		startButton.setOnClickListener( new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(OpeningActivity.this, MyZombieActivity.class);
				i.putExtra("name", zombieName.getText().toString());
				startActivity(i);
				
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.opening, menu);
		return true;
	}

}
