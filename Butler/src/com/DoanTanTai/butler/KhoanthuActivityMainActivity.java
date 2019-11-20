package com.DoanTanTai.butler;

import java.util.ArrayList;
import java.util.List;

import model.BaoCaoEntity;
import model.ChiTietKhoanChiEntity;
import model.ChiTietKhoanThuEntity;
import model.KhoanThuEntity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class KhoanthuActivityMainActivity extends ActionBarActivity {

	private Spinner khoanthu;
	Button themthu;
	EditText tienkt, datethu;
	 int MaLoaiTin=1;
	String tenten;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.khoanthu_activity_main);
		tienkt = (EditText)findViewById(R.id.editsotienkt);
		datethu= (EditText)findViewById(R.id.editdatekt);
		final myDB db = new myDB(getApplicationContext());
		
		
		
		
	khoanthu = (Spinner)findViewById(R.id.spinnerkt);
	List<KhoanThuEntity> list1 = db.getAllKhoanThu();
	List<String> list = new ArrayList<String>();
	for (KhoanThuEntity khoanThuEntity : list1) {
		list.add(khoanThuEntity.getTenkhoanthu());
	}
     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
     adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
     khoanthu.setAdapter(adapter);
     khoanthu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			MaLoaiTin=arg2+1;
			tenten = db.getTenKhoanThu(arg2+1);
			 Toast.makeText(KhoanthuActivityMainActivity.this, khoanthu.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
    	 
    	 
	});
	
     
     
     
     
     
     themthu= (Button)findViewById(R.id.btnkhoanthu);
		themthu.setOnClickListener(new View.OnClickListener() {	
			 @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int sotienkt = Integer.parseInt(tienkt.getText().toString());
				String ngaykt = datethu.getText().toString();
				int idnguoithu;
				idnguoithu = db.getidNguoidung(db.getAllNguoiDungTam().get(0).getTendangnhap());
				
				 db.insertChiTietKhoanThu(new ChiTietKhoanThuEntity(0, sotienkt, tenten, MaLoaiTin, idnguoithu, ngaykt));
					Toast.makeText(KhoanthuActivityMainActivity.this,"Thêm Khoản Thu Thành Công", Toast.LENGTH_LONG).show();
			}
		});
     
     
     
     
     
     
     
     
     
     
     
     
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.khoanthu_activity_main, menu);
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
