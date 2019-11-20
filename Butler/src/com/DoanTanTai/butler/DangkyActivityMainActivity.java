package com.DoanTanTai.butler;

import java.util.UUID;

import model.NguoiDungEntity;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts.Intents.Insert;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DangkyActivityMainActivity extends ActionBarActivity {

	String gt;
	String DangNhap;
	String MatKhau;
	String TenHo;
	String Ngay;
	CheckBox nam, nu;
	Button dangky, nhanma;
	EditText tendn, mk, hoten, ngaysinh, magd;
	TextView delete;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dangky_activity_main);
		dangky = (Button) findViewById(R.id.btn1);
		tendn = (EditText) findViewById(R.id.editText1);
		mk = (EditText) findViewById(R.id.editText2);
		hoten = (EditText) findViewById(R.id.editText3);
		ngaysinh = (EditText) findViewById(R.id.editText5);
		nam = (CheckBox) findViewById(R.id.checkBox1);
		nu = (CheckBox) findViewById(R.id.checkBox2);
		magd = (EditText) findViewById(R.id.editText4);
		nhanma = (Button) findViewById(R.id.button2);
		delete = (TextView)findViewById(R.id.textView3);
		final myDB db = new myDB(this.getApplicationContext());

		nam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if (nam.isChecked()) {
					nu.setChecked(false);
					gt = "Nam";
				} else {
					nu.setChecked(true);
					gt = "Nu";
				}
			}
		});

		nu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if (nu.isChecked()) {
					nam.setChecked(false);
					gt = "Nu";
				} else {
					nam.setChecked(true);
					gt = "Nam";
				}
			}
		});

		nhanma.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				magd.setText(getRandomString(3, 3));
				if (db.findmagd(magd.getText().toString()) == true) {
					magd.setText(getRandomString(3, 3));
				}

			}
		});

		dangky.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DangNhap = tendn.getText().toString();
				if (db.findtendn(DangNhap) == true) {
					Toast.makeText(DangkyActivityMainActivity.this,
							"Tên đăng nhập đã tồn tại", Toast.LENGTH_LONG)
							.show();
					tendn.setText("");
				} else {
					MatKhau = mk.getText().toString();
					TenHo = hoten.getText().toString();
					Ngay = ngaysinh.getText().toString();
					if (DangNhap.trim().length() != 0
							&& MatKhau.trim().length() != 0
							&& TenHo.trim().length() != 0
							&& Ngay.trim().length() != 0
							&& gt.trim().length() != 0) {
						db.insertNguoiDung(new NguoiDungEntity(0, DangNhap,
								MatKhau, Ngay, gt, TenHo, magd.getText()
										.toString()));
						Toast.makeText(DangkyActivityMainActivity.this,
								"Đăng Ký Thành Công", Toast.LENGTH_LONG).show();
						Intent intent = new Intent(
								DangkyActivityMainActivity.this,
								MainActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(DangkyActivityMainActivity.this,
								"Bạn Nhập Thiếu Thông Tin. Mời Bạn Nhập Lại",
								Toast.LENGTH_LONG).show();
					}
				}

			}
		});

		
		delete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tendn.setText("");
				mk.setText("");
				hoten.setText("");
				ngaysinh.setText("");
				nam.setText("");
				nu.setText("");
				magd.setText("");
				nhanma.setText("");
			}
		});
		
		
		
	}

	
	
	
	
	public String getRandomString(int loai, int dodai) {
		// Loai : kieu ran dom
		// 0 : ngau nhien chi cac chu cai thuong
		// 1 : ngau nhien chi cac chu cai hoa
		// 2 : ngau nhien ca chu hoa va thuong
		// 3 : ngau nhien chu va so
		String ketqua = "";
		String hoa = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String thuong = hoa.toLowerCase();
		String so = "1234567890";
		String randomchuoi = "";
		if (loai > 3 || loai < 0) {
			ketqua = "Loai khong hop le, cho phep tu 0 - 3";
		} else if (loai == 0) {
			randomchuoi = thuong;
		} else if (loai == 1) {
			randomchuoi = hoa;
		} else if (loai == 2) {
			randomchuoi = hoa + thuong;
		} else if (loai == 3) {
			randomchuoi = hoa + thuong + so;
		}
		for (int i = 0; i < dodai; i++) {
			int temp = (int) Math.round(Math.random() * randomchuoi.length());
			ketqua += randomchuoi.charAt(temp);
		}
		return ketqua;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dangky_activity_main, menu);
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
