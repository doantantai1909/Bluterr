package com.DoanTanTai.butler;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import model.ChiTietKhoanChiEntity;
import model.KhoanThuEntity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class DanhsachchiActivityMainActivity extends ActionBarActivity {
	ListView lv;
	TextView tientong;
	int tien = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.danhsachchi_activity_main);
		final myDB db = new myDB(this.getApplicationContext());

		lv = (ListView) findViewById(R.id.listVkc);
        tientong = (TextView)findViewById(R.id.tongtien1);
		List<ChiTietKhoanChiEntity> chiEntities = db.getAllChiTietKhoanChi();

		List<String> list = new ArrayList<String>();
		for (ChiTietKhoanChiEntity chiTietKhoanChiEntity : chiEntities) {
			list.add(chiTietKhoanChiEntity.getTenkhoanchi()
					+ " "
					+ String.valueOf(chiTietKhoanChiEntity.getSotien() + " "
							+ chiTietKhoanChiEntity.getNgaychi()));
			tien+= chiTietKhoanChiEntity.getSotien();
		}
          tientong.setText(String.valueOf(tien));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, list);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		lv.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.danhsachchi_activity_main, menu);
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
