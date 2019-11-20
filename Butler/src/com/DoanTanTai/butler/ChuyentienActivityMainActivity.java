package com.DoanTanTai.butler;

import java.util.ArrayList;
import java.util.List;

import model.ChiTietKhoanThuEntity;
import model.KhoanThuEntity;
import model.NguoiDungEntity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ChuyentienActivityMainActivity extends ActionBarActivity {
	private Spinner chuyentien, khoanthu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chuyentien_activity_main);
		
		
		
		
		
		final myDB db = new myDB(getApplicationContext());
		chuyentien = (Spinner)findViewById(R.id.spinChuyenTien);
		khoanthu = (Spinner)findViewById(R.id.spinner1);
		List<NguoiDungEntity> list1 = db.getAllNguoiDung();
		List<String> list = new ArrayList<String>();
		for (NguoiDungEntity nguoiDungEntity : list1) {
			
			list.add(nguoiDungEntity.getHoten());
		}
	     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
	     adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	     chuyentien.setAdapter(adapter);
	     chuyentien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	 		@Override
	 		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
	 				long arg3) {
	 			// TODO Auto-generated method stub
	 			 Toast.makeText(ChuyentienActivityMainActivity.this, chuyentien.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
	 		}

	 		@Override
	 		public void onNothingSelected(AdapterView<?> arg0) {
	 			// TODO Auto-generated method stub
	 			
	 		}
	     	 
	     	 
	 	});
		
		

	 	List<KhoanThuEntity> list2 = db.getAllKhoanThu();
	 	List<String> list3 = new ArrayList<String>();
	 	for (KhoanThuEntity khoanThuEntity : list2) {
	 		list3.add(khoanThuEntity.getTenkhoanthu());
	 	}
	      ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list3);
	      adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	      khoanthu.setAdapter(adapter1);
	      khoanthu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	 		@Override
	 		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
	 				long arg3) {
	 			// TODO Auto-generated method stub
	 			 Toast.makeText(ChuyentienActivityMainActivity.this, khoanthu.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
	 		}
	 		@Override
	 		public void onNothingSelected(AdapterView<?> arg0) {
	 			// TODO Auto-generated method stub		
	 		} 	 
	 	});
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     Button btnChuyenTien =(Button)findViewById(R.id.btn1);
		TextView txtTien=(TextView)findViewById(R.id.textView4);
		
		btnChuyenTien.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				db.insertKhoanThu(new KhoanThuEntity(0, loaithuchi.getText().toString(), txtGhiChu.getText().toString()));	
//				Toast.makeText(DanhmucthuchiActivityMainActivity.this,"Đã thêm vào khoản thu thành công", Toast.LENGTH_LONG).show();
//				loaithuchi.setText("");
//				txtGhiChu.setText("");
				// db.insertChiTietKhoanThu(new ChiTietKhoanThuEntity(0, ))
				
			}
		});
		
		
		
		
		
		
	
		
		
		
	
		
		
		
		
		
		
		
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chuyentien_activity_main, menu);
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
