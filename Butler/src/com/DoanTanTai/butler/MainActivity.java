package com.DoanTanTai.butler;

import model.NguoiDungEntity;
import model.NguoiDungTamEntity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap_activity_main);
        
        
        Button btn1 = (Button)findViewById(R.id.btn1);
        final myDB db = new myDB(this.getApplicationContext());
		db.deleteNguoiDungTam();
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText txtDangNhap = (EditText)findViewById(R.id.editText1);
				EditText txtMatKhau = (EditText)findViewById(R.id.editText2);
			
				String tendn=txtDangNhap.getText().toString();
				//Toast.makeText(DangnhapActivityMainActivity.this,tendn, Toast.LENGTH_LONG).show();
				String MKdn=txtMatKhau.getText().toString();
				
				
						
				if (db.ktDangNhap(txtDangNhap.getText().toString(), txtMatKhau.getText().toString())){
					db.insertNguoiDungTam(new NguoiDungTamEntity(0,tendn));
					Toast.makeText(MainActivity.this,"Đăng Nhập Thành Công", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(MainActivity.this,ManhinhchinhActivityMainActivity.class);
					
					Bundle bundle = new Bundle();
					// đóng gói kiểu dữ liệu String, Boolean
					bundle.putString("tdn", tendn);

					// đóng gói bundle vào intent
					intent.putExtras(bundle);
					
					
					startActivity(intent);
					
					 
				
				}
				else{
					Toast.makeText(MainActivity.this,"Tên Đăng Nhập hoặc Mật Khẩu không chính xác", Toast.LENGTH_LONG).show();
					txtDangNhap.setText("");
					txtMatKhau.setText("");
				}
				
			}
		});
        
        
        Button taoao=(Button)findViewById(R.id.taoao);
        Button taoao2=(Button)findViewById(R.id.taoao2);
        taoao.setVisibility(View.GONE);
        taoao2.setVisibility(View.GONE);
        taoao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myDB db= new myDB(MainActivity.this.getApplicationContext());
				db.createdate();
				Toast.makeText(getApplicationContext(), "da tao du lieu thanh cong", Toast.LENGTH_LONG).show();
			}
		});
  
        taoao2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myDB db = new myDB(MainActivity.this.getApplicationContext());
				db.deleteDatabase(getApplicationContext());
				Toast.makeText(getApplicationContext(), "Da xoa du lieu", Toast.LENGTH_LONG).show();
			}
		});
        
  
    	TextView txtDangKy = (TextView)findViewById(R.id.textView4);
    	txtDangKy.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,DangkyActivityMainActivity.class);
	              startActivity(intent);
			}
		});
        
    
    }
        
        

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
