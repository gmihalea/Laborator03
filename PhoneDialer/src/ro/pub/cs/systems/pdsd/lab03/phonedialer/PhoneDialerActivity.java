package ro.pub.cs.systems.pdsd.lab03.phonedialer;

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

	private final int[] buttons = {
			R.id.digit_0,
			R.id.digit_1,
			R.id.digit_2,
			R.id.digit_3,
			R.id.digit_4,
			R.id.digit_5,
			R.id.digit_6,
			R.id.digit_7,
			R.id.digit_8,
			R.id.digit_9,
			R.id.diez,
			R.id.star
	};
	
	private DigitButtonClickListener digitButtonClickListener = new DigitButtonClickListener();
	private CallButtonClickListener callButtonClickListener = new CallButtonClickListener();
	private HangUpButtonClickListener handUpButtonClickListener = new HangUpButtonClickListener();
	private BackspaceButtonClickListener backspaceButtonClickListener = new BackspaceButtonClickListener();
	
	
	private class HangUpButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			finish();
		}
	}
	
	private class CallButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			
			EditText phoneNumberEditText = (EditText)findViewById(R.id.edit_text_phone_number);
			String phoneNumber = phoneNumberEditText.getText().toString();
			
			Intent intent = new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:" + phoneNumber));
			startActivity(intent);
		}
	}
	
	private class BackspaceButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			
			EditText phoneNumberEditText = (EditText)findViewById(R.id.edit_text_phone_number);
			String phoneNumber = phoneNumberEditText.getText().toString();
	
			if(phoneNumber.length() > 0){
				phoneNumberEditText.setText(phoneNumber.substring(0, phoneNumber.length() - 1));
			}
		}
	}
	
	private class DigitButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			
			EditText phoneNumberEditText = (EditText)findViewById(R.id.edit_text_phone_number);
			String phoneNumber = phoneNumberEditText.getText().toString();
			
			StringBuilder sb = new StringBuilder(phoneNumber);
			sb.append(((Button)v).getText().toString());
			
			phoneNumberEditText.setText(sb.toString());
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		
		for(int i = 0; i < this.buttons.length; ++i){
			Button button = (Button)findViewById(this.buttons[i]);
			button.setOnClickListener(digitButtonClickListener);
		}
		
		ImageButton callButton = (ImageButton)findViewById(R.id.call);
		callButton.setOnClickListener(callButtonClickListener);
		
		ImageButton backspaceButton = (ImageButton)findViewById(R.id.backspace);
		backspaceButton.setOnClickListener(backspaceButtonClickListener);
		
		ImageButton hangupButton = (ImageButton)findViewById(R.id.hangup);
		hangupButton.setOnClickListener(handUpButtonClickListener);
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
