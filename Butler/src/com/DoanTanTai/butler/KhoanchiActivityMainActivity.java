package com.DoanTanTai.butler;

import java.util.ArrayList;
import java.util.List;

import model.ChiTietKhoanChiEntity;
import model.KhoanChiEntity;
import model.KhoanThuEntity;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class KhoanchiActivityMainActivity extends ActionBarActivity {

	private Spinner khoanchi;
	Button themchi;
	EditText tienkc, datechi;
	 int MaLoaiTin=1;
	String tenten;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.khoanchi_activity_main);
		tienkc = (EditText)findViewById(R.id.editsotienkc);
		datechi = (EditText)findViewById(R.id.editdatekc);
		
		final myDB db = new myDB(getApplicationContext());
		khoanchi = (Spinner)findViewById(R.id.spinnerkc);
		
		
		List<KhoanChiEntity> list1 = db.getAllKhoanChi();
		

		List<String> list = new ArrayList<String>();
		for (KhoanChiEntity khoanChiEntity : list1) {
			list.add(khoanChiEntity.getTenkhoanchi());
		}
		 
	     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
	     adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	     khoanchi.setAdapter(adapter);
	     khoanchi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				MaLoaiTin=arg2+1;
				tenten = db.getTenKhoanChi(arg2+1);
				 //Toast.makeText(KhoanchiActivityMainActivity.this, khoanchi.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	    	 
	    	 
		});
		
		themchi= (Button)findViewById(R.id.btnkhoanchi);
		themchi.setOnClickListener(new View.OnClickListener() {	
			 @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int sotienkc = Integer.parseInt(tienkc.getText().toString());
				String ngaykc = datechi.getText().toString();
				int idnguoichi;
				idnguoichi = db.getidNguoidung(db.getAllNguoiDungTam().get(0).getTendangnhap());
				
				 db.insertChiTietKhoanChi(new ChiTietKhoanChiEntity(0, tenten, sotienkc, MaLoaiTin, idnguoichi, ngaykc));
					Toast.makeText(KhoanchiActivityMainActivity.this,"Thêm Khoản Chi Thành Công", Toast.LENGTH_LONG).show();
			}
		});
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.khoanchi_activity_main, menu);
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
