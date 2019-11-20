package com.DoanTanTai.butler;

import model.KhoanChiEntity;
import model.KhoanThuEntity;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DanhmucthuchiActivityMainActivity extends ActionBarActivity {

	EditText loaithuchi, ghichu;
	Button khoanthu, khoanchi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.danhmucthuchi_activity_main);
		
		 loaithuchi = (EditText)findViewById(R.id.editText1);
		 ghichu = (EditText)findViewById(R.id.editText2);
		 khoanthu = (Button)findViewById(R.id.btn1);
		 khoanchi = (Button)findViewById(R.id.button2);
		final  myDB db = new myDB(this.getApplicationContext());
		
		khoanthu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				db.insertKhoanThu(new KhoanThuEntity(0, loaithuchi.getText().toString(), ghichu.getText().toString()));	
				Toast.makeText(DanhmucthuchiActivityMainActivity.this,"Đã thêm vào khoản thu thành công", Toast.LENGTH_LONG).show();
				loaithuchi.setText("");
				ghichu.setText("");
			}
		});
		
		khoanchi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db.insertKhoanChi(new KhoanChiEntity(0, loaithuchi.getText().toString(), ghichu.getText().toString()));
				Toast.makeText(DanhmucthuchiActivityMainActivity.this,"Đã thêm vào khoản chi tiêu", Toast.LENGTH_LONG).show();
				loaithuchi.setText("");
				ghichu.setText("");
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.danhmucthuchi_activity_main, menu);
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
