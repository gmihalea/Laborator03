package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends Activity {

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	private class ButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			
			EditText phoneNumberEditText = (EditText)findViewById(R.id.edit_text_phone_number);
			String phoneNumber = phoneNumberEditText.getText().toString();
			
			if(v instanceof Button){
				phoneNumberEditText.setText(phoneNumber + ((Button)v).getText().toString());
			}
			
			if(v instanceof ImageButton){
				switch (((ImageButton)v).getId()){
					case R.id.backspace:
						if(phoneNumber.length() > 0){
							phoneNumberEditText.setText(phoneNumber.substring(0, phoneNumber.length() - 1));
						}
						break;
					case R.id.call:
						Intent intent = new Intent(Intent.ACTION_CALL);
						intent.setData(Uri.parse("tel:" + phoneNumber));
						startActivity(intent);
						break;
					case R.id.hangup:
						finish();
						break;
				}
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		ArrayList<? super View> phoneButtons = new ArrayList<View>();
		
		Button textButton = (Button)findViewById(R.id.digit_0);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_1);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_2);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_3);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_4);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_5);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_6);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_7);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_8);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.digit_9);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.star);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		textButton = (Button)findViewById(R.id.diez);
		textButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(textButton);
		
		ImageButton imageButton = (ImageButton)findViewById(R.id.backspace);
		imageButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(imageButton);
		
		imageButton = (ImageButton)findViewById(R.id.call);
		imageButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(imageButton);
		
		imageButton = (ImageButton)findViewById(R.id.hangup);
		imageButton.setOnClickListener(buttonClickListener);
		phoneButtons.add(imageButton);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.digit_1) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
