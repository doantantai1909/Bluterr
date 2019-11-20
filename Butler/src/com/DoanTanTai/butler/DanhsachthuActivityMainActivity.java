package com.DoanTanTai.butler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.ChiTietKhoanChiEntity;
import model.ChiTietKhoanThuEntity;
import model.KhoanThuEntity;
import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DanhsachthuActivityMainActivity extends ActionBarActivity {
	 ListView dskt;
	TextView tientong;
	int tien = 0 ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.danhsachthu_activity_main);
	
		final myDB db = new myDB(getApplicationContext());
		tientong = (TextView)findViewById(R.id.tongtien);
		dskt = (ListView)findViewById(R.id.listVkt);
		List<ChiTietKhoanThuEntity> thuEntities = db.getAllChiTietKhoanThu();
		
		List<String> list = new ArrayList<String>();
		for (ChiTietKhoanThuEntity chiTietKhoanThuEntity: thuEntities){
			list.add(chiTietKhoanThuEntity.getTenkhoanthu() + " " + String.valueOf(chiTietKhoanThuEntity.getSotien() + " " + chiTietKhoanThuEntity.getNgaythu()));
			tien+= chiTietKhoanThuEntity.getSotien();
		}
          tientong.setText(String.valueOf(tien));
		  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
		   adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		   dskt.setAdapter(adapter);
		
	  		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.danhsachthu_activity_main, menu);
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
