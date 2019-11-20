package com.DoanTanTai.butler;

import java.util.ArrayList;
import java.util.List;

import model.ChiTietKhoanChiEntity;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class BaoCaoMainActivity extends ActionBarActivity {

	Button chicanhan, chigiadinh, thucanhan, thugiadinh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bao_cao_main);
		final myDB db = new myDB(this.getApplicationContext());
		chicanhan = (Button) findViewById(R.id.btn2);
		thucanhan = (Button) findViewById(R.id.btn4);
		chigiadinh = (Button) findViewById(R.id.btn1);
		thugiadinh = (Button) findViewById(R.id.btn3);

		chicanhan.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(BaoCaoMainActivity.this,
						DanhsachchiActivityMainActivity.class);
				startActivity(intent);
			}
		});

		thucanhan.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(BaoCaoMainActivity.this,
						DanhsachthuActivityMainActivity.class);
				startActivity(intent);
			}
		});

		chigiadinh.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BaoCaoMainActivity.this,
						DanhsachthuActivityMainActivity.class);
				startActivity(intent);
			}
		});
		thugiadinh.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BaoCaoMainActivity.this,
						DanhsachthuActivityMainActivity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bao_cao_main, menu);
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
