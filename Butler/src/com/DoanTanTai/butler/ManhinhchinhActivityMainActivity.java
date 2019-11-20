package com.DoanTanTai.butler;

import model.BaoCaoEntity;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManhinhchinhActivityMainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manhinhchinh_activity_main);
		TextView txtHienTen=(TextView)findViewById(R.id.textView3);
		TextView txtMaGD=(TextView)findViewById(R.id.textView4);
		Button btnKhoanThu=(Button)findViewById(R.id.btn1);
		Button btnKhoanChi=(Button)findViewById(R.id.btn2);
		Button btnChuyenTien=(Button)findViewById(R.id.btn3);
		Button btnBaoCao=(Button)findViewById(R.id.btn4);
		Button btnDanhMuc=(Button)findViewById(R.id.btn5);
		
	myDB db1 = new myDB(getApplicationContext());
		//txtHienTen.setText(db1.hienTen());

	Bundle bundle = getIntent().getExtras();
	txtHienTen.setText( db1.hienTen(bundle.getString("tdn")));
	txtMaGD.setText(db1.hienMaGD(bundle.getString("tdn")));
		btnKhoanThu.setOnClickListener(new View.OnClickListener() {
			
			
			
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent intent=new Intent(ManhinhchinhActivityMainActivity.this,KhoanthuActivityMainActivity.class);
				startActivity(intent);
				
			}
		});
		
		btnKhoanChi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(ManhinhchinhActivityMainActivity.this,KhoanchiActivityMainActivity.class);
				startActivity(intent);
				
			}
		});
		
		btnChuyenTien.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(ManhinhchinhActivityMainActivity.this,ChuyentienActivityMainActivity.class);
				startActivity(intent);
				
			}
		});
		btnBaoCao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(ManhinhchinhActivityMainActivity.this,BaoCaoMainActivity.class);
				startActivity(intent);
				
			}
		});
		btnDanhMuc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(ManhinhchinhActivityMainActivity.this,DanhmucthuchiActivityMainActivity.class);
				startActivity(intent);
				
			}
		});
		
		
		
	}
	
	public void displayMessage(){
		AlertDialog.Builder builder= new AlertDialog.Builder(ManhinhchinhActivityMainActivity.this);
		builder.setTitle("Chú Ý");
		builder.setMessage("Bạn có muốn thoát khỏi ứng dụng");
		builder.setCancelable(false);
		builder.setPositiveButton("Quay lại", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
		});
		builder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		AlertDialog alertDialog=builder.create();
		alertDialog.show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode==KeyEvent.KEYCODE_BACK || keyCode==KeyEvent.KEYCODE_ESCAPE)
			displayMessage();
		return super.onKeyDown(keyCode, event);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manhinhchinh_activity_main, menu);
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
