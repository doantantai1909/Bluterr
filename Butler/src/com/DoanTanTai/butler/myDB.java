package com.DoanTanTai.butler;

import java.util.ArrayList;
import java.util.List;

import model.BaoCaoEntity;
import model.ChiTietKhoanChiEntity;
import model.ChiTietKhoanThuEntity;
import model.GiaDinhEntity;
import model.KhoanChiEntity;
import model.KhoanThuEntity;
import model.NguoiDungEntity;
import model.NguoiDungTamEntity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class myDB extends SQLiteOpenHelper {
	public myDB(Context context) {
		super(context, "DanhMucDB.db", null, 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	
	
	


	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL("create table NguoiDung(ID INTEGER PRIMARY KEY AUTOINCREMENT, TenDangNhap text, MatKhau text, NgaySinh date, GioiTinh text, HoTen text, idgiadinh text)");
		arg0.execSQL("create table GiaDinh(ID INTEGER PRIMARY KEY AUTOINCREMENT,idgiadinh text, GhiChu text)");
		arg0.execSQL("create table ChiTietKhoanThu(ID INTEGER PRIMARY KEY AUTOINCREMENT,IDNguoiThu interger,TenKhoanThu text, SoTien interger, IDThu interger, ngaythu text)");
		arg0.execSQL("CREATE TABLE BaoCao(ID INTEGER PRIMARY KEY AUTOINCREMENT,idgiadinh text, Thang interger, IDThu interger, IDChi interger)");
		arg0.execSQL("CREATE TABLE ChiTietKhoanChi(ID INTEGER PRIMARY KEY AUTOINCREMENT,TenKhoanChi text, SoTien interger, IDChi interger, IDNguoiChi interger, ngaychi text)");
		arg0.execSQL("CREATE TABLE KhoanThu(idthu INTEGER PRIMARY KEY AUTOINCREMENT,tenkhoanthu text, GhiChu text)");
		arg0.execSQL("CREATE TABLE KhoanChi(idchi INTEGER PRIMARY KEY AUTOINCREMENT, tenkhoanchi text, GhiChu text)");
		arg0.execSQL("CREATE TABLE NguoiDungTam(ID INTEGER PRIMARY KEY AUTOINCREMENT,TenDangNhap text)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL("DROP TABLE IF EXISTS NguoiDung");
		arg0.execSQL("DROP TABLE IF EXISTS GiaDinh");
		arg0.execSQL("DROP TABLE IF EXISTS ChiTietKhoanThu");
		arg0.execSQL("DROP TABLE IF EXISTS KhoanThu");
		arg0.execSQL("DROP TABLE IF EXISTS BaoCao");
		arg0.execSQL("DROP TABLE IF EXISTS KhoanChi");
		arg0.execSQL("DROP TABLE IF EXISTS ChiTietKhoanChi");
		onCreate(arg0);
	}

//	public String findid(int id) {
//		List<KhoanThuEntity> khoanThuEntities = new ArrayList<KhoanThuEntity>();
//		SQLiteDatabase db = getReadableDatabase();
//		Cursor cursor = db.rawQuery(
//				"SELECT  FROM NguoiDung, ChiTietKhoanChi, KhoanChi WHERE '"
//						+ id + "'", null);
//		return null;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Boolean findtendn(String tendn){
		List<NguoiDungEntity> nguoiDungEntities = new ArrayList<NguoiDungEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT ID, TenDangNhap, MatKhau, NgaySinh, GioiTinh, Hoten, IdGiaDinh FROM NguoiDung Where TenDangNhap ='"
						+ tendn + "'", null );
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			nguoiDungEntities.add(new NguoiDungEntity(cursor
					.getInt(0), cursor.getString(1), cursor.getString(2), cursor
					.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
			cursor.moveToNext();
		}
		cursor.close();
		if (nguoiDungEntities.size()>0){
			return true;
		}
		 return false;
	}

	
	public Boolean findmagd(String giadinhma){
		List<NguoiDungEntity> nguoiDungEntities = new ArrayList<NguoiDungEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT ID, TenDangNhap, MatKhau, NgaySinh, GioiTinh, Hoten, IdGiaDinh FROM NguoiDung Where IdGiaDinh ='"
						+ giadinhma + "'", null );
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			nguoiDungEntities.add(new NguoiDungEntity(cursor
					.getInt(0), cursor.getString(1), cursor.getString(2), cursor
					.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
			cursor.moveToNext();
		}
		cursor.close();
		if (nguoiDungEntities.size()>0){
			return true;
		}
		 return false;
	}
	
	
	
	
	
	
	public int tongTienThuGD(String magd) {

		List<ChiTietKhoanThuEntity> chiTietKhoanThuEntities = new ArrayList<ChiTietKhoanThuEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT NguoiDung.id, ChiTietKhoanThu.idnguoithu, ChiTietKhoanThu.tenkhoanthu, ChiTietKhoanThu.sotien, GiaDinh.idgiadinh, NguoiDung.idgiadinh FROM ChiTietKhoanThu,NguoiDung,GiaDinh WHERE GiaDinh.idgiadinh = NguoiDung.idgiadinh and NguoiDung.id = ChiTietKhoanThu.idnguoithu and NguoiDung.idgiadinh = '"
								+ magd + "'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			chiTietKhoanThuEntities.add(new ChiTietKhoanThuEntity(cursor
					.getInt(0), cursor.getInt(1), cursor.getString(2), cursor
					.getInt(3), cursor.getInt(4), cursor.getString(5)));
			cursor.moveToNext();
		}
		cursor.close();
		int thugd = 0;
		for (ChiTietKhoanThuEntity chiTietKhoanThuEntity : chiTietKhoanThuEntities) {
			thugd += chiTietKhoanThuEntity.getSotien();
		}

		return thugd;
	}

	public void insertNguoiDungTam(NguoiDungTamEntity dungTamEntity) {
	
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues insValues = new ContentValues();
		insValues.put("id", dungTamEntity.getId());
		insValues.put("TenDangNhap", dungTamEntity.getTendangnhap());	
		db.insert("NguoiDungtam", null, insValues);
		
		
	}
	


	public void deleteNguoiDungTam() {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE FROM NguoiDungTam ");
		db.execSQL("VACUUM");
	}

	public List<NguoiDungTamEntity> getAllNguoiDungTam() {
		List<NguoiDungTamEntity> nguoiDungTamEntities = new ArrayList<NguoiDungTamEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT id, tendangnhap FROM NguoiDungTam ORDER BY id desc",
				null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			nguoiDungTamEntities.add(new NguoiDungTamEntity(cursor.getInt(0),
					cursor.getString(1)));
			cursor.moveToNext();
		}
		cursor.close();
		return nguoiDungTamEntities;
	}

	public int getidNguoidung(String tennguoidung) {

		List<NguoiDungEntity> nguoiDungEntities = new ArrayList<NguoiDungEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, tendangnhap, matkhau, ngaysinh, gioitinh, hoten, idgiadinh FROM NguoiDung WHERE tendangnhap = '"
								+ tennguoidung + "'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			nguoiDungEntities.add(new NguoiDungEntity(cursor.getInt(0), cursor
					.getString(1), cursor.getString(2), cursor.getString(3),
					cursor.getString(4), cursor.getString(5), cursor
							.getString(6)));
			cursor.moveToNext();
		}
		cursor.close();

		return nguoiDungEntities.get(0).getId();
	}

	public String getTenKhoanChi(int id) {

		List<KhoanChiEntity> khoanChiEntities = new ArrayList<KhoanChiEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT idchi, tenkhoanchi, GhiChu FROM KhoanChi WHERE idchi = '"
						+ id + "'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			khoanChiEntities.add(new KhoanChiEntity(cursor.getInt(0), cursor
					.getString(1), cursor.getString(2)));
			cursor.moveToNext();
		}
		cursor.close();
		return khoanChiEntities.get(0).getTenkhoanchi();
	}

	
	
	public String getTenKhoanThu(int id) {

		List<KhoanThuEntity> khoanThuEntities = new ArrayList<KhoanThuEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT idthu, tenkhoanthu, GhiChu FROM KhoanThu WHERE idthu = '"
						+ id + "'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			khoanThuEntities.add(new KhoanThuEntity(cursor.getInt(0), cursor
					.getString(1), cursor.getString(2)));
			cursor.moveToNext();
		}
		cursor.close();
		return khoanThuEntities.get(0).getTenkhoanthu();
	}
	
	
	
	
	
	
	
	
	
	public void insertBaoCao(BaoCaoEntity baoCaoEntity) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues insValues = new ContentValues();
		insValues.put("idgiadinh", baoCaoEntity.getIdgiadinh());
		insValues.put("thang", baoCaoEntity.getThang());
		insValues.put("idthu", baoCaoEntity.getIdthu());
		insValues.put("idchi", baoCaoEntity.getIdchi());
		db.insert("BaoCao", null, insValues);
	}

	public void updateBaoCao(int id, int idgiadinh, int thang, int idthu,
			int idchi) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("idgiadinh", idgiadinh);
		contentValues.put("thang", thang);
		contentValues.put("idthu", idthu);
		contentValues.put("idchi", idchi);
		db.update("BaoCao", contentValues, "id=" + id, null);
	}

	public void deleteBaoCao(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE from BaoCao where id=" + id);
	}

	public void createdate() {
		insertBaoCao(new BaoCaoEntity(0, 123, 9, 1, 2));
		insertBaoCao(new BaoCaoEntity(0, 124, 7, 5, 9));
		insertBaoCao(new BaoCaoEntity(0, 125, 6, 11, 19));
		insertChiTietKhoanChi(new ChiTietKhoanChiEntity(0, "Tien dien",
				1000000, 2, 015, "14/5/2019"));
		insertChiTietKhoanChi(new ChiTietKhoanChiEntity(0, "Tien nuoc",
				5000000, 2, 016, "13/6/2019"));
		insertChiTietKhoanChi(new ChiTietKhoanChiEntity(0, "tien an", 3000000,
				3, 015, "12/10/2019"));
		insertChiTietKhoanChi(new ChiTietKhoanChiEntity(0, "Tien dam, tiec",
				2000000, 3, 015, " 15/9/2019 "));
		insertChiTietKhoanThu(new ChiTietKhoanThuEntity(0, 015, "tien luong",
				2000000, 3, "30/10/2019"));
		insertChiTietKhoanThu(new ChiTietKhoanThuEntity(0, 016,
				"tien cho thue nha", 2000000, 2, "29/9/2019"));
		insertGiaDinh(new GiaDinhEntity(0, "abc", "dcm m casi apps"));
		insertGiaDinh(new GiaDinhEntity(0, "zxc", "may coi chung t nha cai app"));
		insertNguoiDung(new NguoiDungEntity(0, "admin", "123456", "19/9/1998",
				"nam", "doan tan tai", "abc"));
		insertNguoiDung(new NguoiDungEntity(0, "admin3", "123456", "19/9/1998",
				"nu", "doan tan toan", "abc"));
		insertNguoiDung(new NguoiDungEntity(0, "admin2", "123456", "13/9/1998",
				"nu", "vo thi a", "zxc"));
		insertNguoiDung(new NguoiDungEntity(0, "admin4", "123456", "13/9/1998",
				"nam", "vo thi zec", "zxc"));
		insertKhoanChi(new KhoanChiEntity(0, "tien dien",
				"tien nay hao nhieu qua"));
		insertKhoanChi(new KhoanChiEntity(0, "tien an", "an qua nhieu"));
		insertKhoanThu(new KhoanThuEntity(0, "tien luong", "tien nay it qua"));
		insertKhoanThu(new KhoanThuEntity(0, "tien cho thue nha",
				"cu dong tien tro tre"));

	}

	public void deleteDatabase(Context mContext) {
		mContext.deleteDatabase("DanhMucDB.db");
	}

	public List<BaoCaoEntity> getAllBaoCao() {
		List<BaoCaoEntity> baoCaoEntities = new ArrayList<BaoCaoEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, idgiadinh, thang, idthu, idchi FROM BaoCao ORDER BY id desc",
						null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			baoCaoEntities.add(new BaoCaoEntity(cursor.getInt(0), cursor
					.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor
					.getInt(4)));
			cursor.moveToNext();
		}
		cursor.close();
		return baoCaoEntities;
	}

	public BaoCaoEntity getBaoCaoTungCai(int id) {

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT id,  idgiadinh, thang, idthu, idchi FROM BaoCao", null);
		cursor.moveToFirst();
		BaoCaoEntity baoCaoEntity = new BaoCaoEntity(cursor.getInt(0),
				cursor.getInt(1), cursor.getInt(2), cursor.getInt(3),
				cursor.getInt(4));

		cursor.close();
		return baoCaoEntity;
	}

	public void deleteBaoCaobyID(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE FROM BaoCao WHERE id=" + id);
	}

	public void insertChiTietKhoanThu(
			ChiTietKhoanThuEntity chiTietKhoanThuEntity) {
		SQLiteDatabase db = this.getReadableDatabase();
		ContentValues insValues = new ContentValues();
		insValues.put("tenkhoanthu", chiTietKhoanThuEntity.getTenkhoanthu());
		insValues.put("sotien", chiTietKhoanThuEntity.getSotien());
		insValues.put("idthu", chiTietKhoanThuEntity.getIdthu());
		insValues.put("idnguoithu", chiTietKhoanThuEntity.getIdnguoithu());
		insValues.put("ngaythu", chiTietKhoanThuEntity.getNgaythu());
		db.insert("ChiTietKhoanThu", null, insValues);

	}

	public void updateChiTietKhoanThu(int id, String tenkhoanthu, int sotien,
			int idthu, int idnguoithu, String ngaythu) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("tenkhoanchi", tenkhoanthu);
		contentValues.put("sotien", sotien);
		contentValues.put("idchi", idthu);
		contentValues.put("idnguoichi", idnguoithu);
		contentValues.put("ngaythu", ngaythu);
		db.update("ChiTietKhoanThu", contentValues, "id=" + id, null);
	}

	public void deleteChiTietKhoanThu(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE from ChiTietKhoanChi where id=" + id);
	}

	public List<ChiTietKhoanThuEntity> getAllChiTietKhoanThu() {
		List<ChiTietKhoanThuEntity> chiTietKhoanThuEntities = new ArrayList<ChiTietKhoanThuEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, idnguoithu, tenkhoanthu, sotien, idthu, ngaythu FROM ChiTietKhoanThu ORDER BY id desc",
						null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			chiTietKhoanThuEntities.add(new ChiTietKhoanThuEntity(cursor
					.getInt(0), cursor.getInt(1), cursor.getString(2), cursor
					.getInt(3), cursor.getInt(4), cursor.getString(5)));
			cursor.moveToNext();
		}
		cursor.close();
		return chiTietKhoanThuEntities;
	}

	public ChiTietKhoanThuEntity getChiTietKhoanThuTungCai(int id) {

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, tenkhoanthu, sotien, idthu, idnguoithu, ngaythu FROM ChiTietKhoanThu",
						null);
		cursor.moveToFirst();
		ChiTietKhoanThuEntity chiTietKhoanThuEntity = new ChiTietKhoanThuEntity(
				cursor.getInt(0), cursor.getInt(1), cursor.getString(2),
				cursor.getInt(3), cursor.getInt(4), cursor.getString(5));

		cursor.close();
		return chiTietKhoanThuEntity;
	}

	public void deleteChiTietKhoanThubyID(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE FROM ChiTietKhoanChi WHERE id=" + id);
	}

	public void insertChiTietKhoanChi(
			ChiTietKhoanChiEntity chiTietKhoanChiEntity) {
		SQLiteDatabase db = this.getReadableDatabase();
		ContentValues insValues = new ContentValues();
		insValues.put("tenkhoanchi", chiTietKhoanChiEntity.getTenkhoanchi());
		insValues.put("sotien", chiTietKhoanChiEntity.getSotien());
		insValues.put("idchi", chiTietKhoanChiEntity.getIdchi());
		insValues.put("idnguoichi", chiTietKhoanChiEntity.getIdnguoichi());
		insValues.put("ngaychi", chiTietKhoanChiEntity.getNgaychi());
		db.insert("ChiTietKhoanChi", null, insValues);
	}

	public void updateChiTietKhoanChi(int id, String tenkhoanchi, int sotien,
			int idchi, int idnguoichi, String ngaychi) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("tenkhoanchi", tenkhoanchi);
		contentValues.put("sotien", sotien);
		contentValues.put("idchi", idchi);
		contentValues.put("idnguoichi", idnguoichi);
		contentValues.put("ngaychi", ngaychi);
		db.update("ChiTietKhoanChi", contentValues, "id=" + id, null);
	}

	public void deleteChiTietKhoanChi(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE from ChiTietKhoanChi where id=" + id);
	}

	public List<ChiTietKhoanChiEntity> getAllChiTietKhoanChi() {
		List<ChiTietKhoanChiEntity> chiTietKhoanChiEntities = new ArrayList<ChiTietKhoanChiEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, tenkhoanchi, sotien, idchi, idnguoichi, ngaychi FROM ChiTietKhoanChi ORDER BY id desc",
						null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			chiTietKhoanChiEntities.add(new ChiTietKhoanChiEntity(cursor
					.getInt(0), cursor.getString(1), cursor.getInt(2), cursor
					.getInt(3), cursor.getInt(4), cursor.getString(5)));
			cursor.moveToNext();
		}
		cursor.close();
		return chiTietKhoanChiEntities;
	}

	public ChiTietKhoanChiEntity getChiTietKhoanChiTungCai(int id) {

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, tenkhoanchi, sotien, idchi, idnguoichi FROM ChiTietKhoanChiEntyty",
						null);
		cursor.moveToFirst();
		ChiTietKhoanChiEntity chiTietKhoanChiEntity = new ChiTietKhoanChiEntity(
				cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
				cursor.getInt(3), cursor.getInt(4), cursor.getString(5));

		cursor.close();
		return chiTietKhoanChiEntity;
	}

	public void deleteChiTietKhoanChibyID(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE FROM ChiTietKhoanChi WHERE id=" + id);
	}

	public void insertGiaDinh(GiaDinhEntity giaDinhEntity) {
		SQLiteDatabase db = this.getReadableDatabase();
		ContentValues insValues = new ContentValues();
		insValues.put("idgiadinh", giaDinhEntity.getIDGiaDinh());
		insValues.put("GhiChu", giaDinhEntity.getGhiChu());
		db.insert("GiaDinh", null, insValues);
	}

	public void updateGiaDinh(int id, String idgiadinh, String GhiChu) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("idgiadinh", idgiadinh);
		contentValues.put("GhiChu", GhiChu);
		db.update("GiaDinh", contentValues, "id=" + id, null);
	}

	public void deleteGiaDinh(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE from GiaDinh where id=" + id);
	}

	public List<GiaDinhEntity> getAllGiaDinh() {
		List<GiaDinhEntity> giaDinhEntities = new ArrayList<GiaDinhEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT id, idgiadinh, GhiChu FROM GiaDinh ORDER BY id desc",
				null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			giaDinhEntities.add(new GiaDinhEntity(cursor.getInt(0), cursor
					.getString(1), cursor.getString(2)));
			cursor.moveToNext();
		}
		cursor.close();
		return giaDinhEntities;
	}

	public GiaDinhEntity getGiaDinhTungCai(int id) {

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT id, idgiadinh, GhiChu FROM GiaDinh", null);
		cursor.moveToFirst();
		GiaDinhEntity giaDinhEntity = new GiaDinhEntity(cursor.getInt(0),
				cursor.getString(1), cursor.getString(2));

		cursor.close();
		return giaDinhEntity;
	}

	public void deleteGiaDinhbyID(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE FROM GiaDinh WHERE id=" + id);
	}

	public void insertKhoanChi(KhoanChiEntity khoanChiEntity) {
		SQLiteDatabase db = this.getReadableDatabase();
		ContentValues insValues = new ContentValues();
		insValues.put("tenkhoanchi", khoanChiEntity.getTenkhoanchi());
		insValues.put("ghichu", khoanChiEntity.getGhichu());
		db.insert("KhoanChi", null, insValues);
	}

	public void updateKhoanChi(int idchi, String tenkhoanchi, String ghichu) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("tenkhoanchi", tenkhoanchi);
		contentValues.put("ghichu", ghichu);
		db.update("KhoanChi", contentValues, "idchi=" + idchi, null);
	}

	public void deleteKhoanChi(int idchi) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE from GiaDinh where idchi=" + idchi);
	}

	public List<KhoanChiEntity> getAllKhoanChi() {
		List<KhoanChiEntity> khoanChiEntities = new ArrayList<KhoanChiEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT idchi, tenkhoanchi, ghichu FROM KhoanChi ORDER BY idchi desc",
						null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			khoanChiEntities.add(new KhoanChiEntity(cursor.getInt(0), cursor
					.getString(1), cursor.getString(2)));
			cursor.moveToNext();
		}
		cursor.close();
		return khoanChiEntities;
	}

	public KhoanChiEntity getKhoanChiTungCai(int id) {

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT idchi, tenkhoanchi, ghichu FROM KhoanChi", null);
		cursor.moveToFirst();
		KhoanChiEntity khoanChiEntity = new KhoanChiEntity(cursor.getInt(0),
				cursor.getString(1), cursor.getString(2));

		cursor.close();
		return khoanChiEntity;
	}

	public void deleteKhoanChibyID(int idchi) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE FROM KhoanChi WHERE idchi=" + idchi);
	}

	public void insertKhoanThu(KhoanThuEntity khoanThuEntity) {
		SQLiteDatabase db = this.getReadableDatabase();
		ContentValues insValues = new ContentValues();
		insValues.put("tenkhoanthu", khoanThuEntity.getTenkhoanthu());
		insValues.put("ghichu", khoanThuEntity.getGhighu());
		db.insert("KhoanThu", null, insValues);
	}

	public void updateKhoanThu(int idthu, String tenkhoanthu, String ghichu) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("tenkhoanthu", tenkhoanthu);
		contentValues.put("ghichu", ghichu);
		db.update("KhoanThu", contentValues, "idthu=" + idthu, null);
	}

	public void deleteKhoanThu(int idthu) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE from KhoanThu where idthu=" + idthu);
	}

	public List<KhoanThuEntity> getAllKhoanThu() {
		List<KhoanThuEntity> khoanThuEntities = new ArrayList<KhoanThuEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT idthu, tenkhoanthu, GhiChu FROM KhoanThu ORDER BY idthu desc",
						null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			khoanThuEntities.add(new KhoanThuEntity(cursor.getInt(0), cursor
					.getString(1), cursor.getString(2)));
			cursor.moveToNext();
		}
		cursor.close();
		return khoanThuEntities;
	}

	public KhoanThuEntity getKhoanThuTungCai(int idthu) {

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT idthu, tenkhoanthu, ghichu FROM KhoanThu", null);
		cursor.moveToFirst();
		KhoanThuEntity khoanThuEntity = new KhoanThuEntity(cursor.getInt(0),
				cursor.getString(1), cursor.getString(2));

		cursor.close();
		return khoanThuEntity;
	}

	public void deleteKhoanThubyID(int idthu) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE FROM KhoanThu WHERE idthu=" + idthu);
	}

	public void insertNguoiDung(NguoiDungEntity nguoiDungEntity) {
		SQLiteDatabase db = this.getReadableDatabase();
		ContentValues insValues = new ContentValues();
		insValues.put("tendangnhap", nguoiDungEntity.getTendangnhap());
		insValues.put("matkhau", nguoiDungEntity.getMatkhau());
		insValues.put("ngaysinh", nguoiDungEntity.getNgaysinh());
		insValues.put("gioitinh", nguoiDungEntity.getGioitinh());
		insValues.put("hoten", nguoiDungEntity.getHoten());
		insValues.put("idgiadinh", nguoiDungEntity.getIdgiadinh());
		db.insert("NguoiDung", null, insValues);
	}

	public void updateKhoanThu(int id, String tendangnhap, String matkhau,
			String ngaysinh, String gioitinh, String hoten, String idgiadinh) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("tendangnhap", tendangnhap);
		contentValues.put("matkhau", matkhau);
		contentValues.put("ngaysinh", ngaysinh);
		contentValues.put("gioitinh", gioitinh);
		contentValues.put("hoten", hoten);
		contentValues.put("idgiadinh", idgiadinh);
		db.update("NguoiDung", contentValues, "id=" + id, null);
	}

	public void deleteNguoiDung(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE from NguoiDung where id=" + id);
	}

	public List<NguoiDungEntity> getAllNguoiDung() {
		List<NguoiDungEntity> nguoiDungEntities = new ArrayList<NguoiDungEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, tendangnhap, matkhau, ngaysinh, gioitinh, hoten, idgiadinh FROM NguoiDung ORDER BY id desc",
						null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			nguoiDungEntities.add(new NguoiDungEntity(cursor.getInt(0), cursor
					.getString(1), cursor.getString(2), cursor.getString(3),
					cursor.getString(4), cursor.getString(5), cursor
							.getString(6)));
			cursor.moveToNext();
		}
		cursor.close();
		return nguoiDungEntities;
	}

	public Boolean ktDangNhap(String tendangnhap, String matkhau) {

		List<NguoiDungEntity> nguoiDungEntities = new ArrayList<NguoiDungEntity>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, tendangnhap, matkhau from NguoiDung where tendangnhap = ? and matkhau = ?",
						new String[] { tendangnhap, matkhau });
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			nguoiDungEntities
					.add(new NguoiDungEntity(cursor.getInt(0), cursor
							.getString(1), cursor.getString(2), null, null,
							null, null));
			cursor.moveToNext();
		}

		cursor.close();
		if (nguoiDungEntities.size() > 0) {
			
	
			
			
			
			return true;
		}
		return false;
	}

	public String hienTen(String tendangnhap){
		
		List<NguoiDungEntity> nguoiDungEntities1 = new ArrayList<NguoiDungEntity>();
		SQLiteDatabase db1 = this.getWritableDatabase();
		 db1 = getReadableDatabase();
		 Cursor cursor1 = db1
					.rawQuery(
							"SELECT id, tendangnhap, matkhau, ngaysinh, gioitinh, hoten, idgiadinh FROM NguoiDung where tendangnhap = '" + tendangnhap + "'",
							null);
			cursor1.moveToFirst();
			while (!cursor1.isAfterLast()) {
				nguoiDungEntities1.add(new NguoiDungEntity(cursor1.getInt(0), cursor1
						.getString(1), cursor1.getString(2), cursor1.getString(3),
						cursor1.getString(4), cursor1.getString(5), cursor1
								.getString(6)));
				cursor1.moveToNext();
			}
			cursor1.close();
			
			Log.d("test",String.valueOf(nguoiDungEntities1.size()));
	
		
			
		if (nguoiDungEntities1.size()>0)
		{
			return nguoiDungEntities1.get(0).getHoten();
		}
		return "abc";
	}
	
	
	
	
	
	
	
	
public String hienMaGD(String tendangnhap){
		
		List<NguoiDungEntity> nguoiDungEntities1 = new ArrayList<NguoiDungEntity>();
		SQLiteDatabase db1 = this.getWritableDatabase();
		 db1 = getReadableDatabase();
		 Cursor cursor1 = db1
					.rawQuery(
							"SELECT id, tendangnhap, matkhau, ngaysinh, gioitinh, hoten, idgiadinh FROM NguoiDung where tendangnhap = '" + tendangnhap + "'",
							null);
			cursor1.moveToFirst();
			while (!cursor1.isAfterLast()) {
				nguoiDungEntities1.add(new NguoiDungEntity(cursor1.getInt(0), cursor1
						.getString(1), cursor1.getString(2), cursor1.getString(3),
						cursor1.getString(4), cursor1.getString(5), cursor1
								.getString(6)));
				cursor1.moveToNext();
			}
			cursor1.close();
			
		
	
		
			
		if (nguoiDungEntities1.size()>0)
		{
			return nguoiDungEntities1.get(0).getIdgiadinh();
		}
		return "abc";
	}
	
	
	
	
	
	
	
	
	
	
	
	public NguoiDungEntity getNguoiDungTungCai(int id) {

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db
				.rawQuery(
						"SELECT id, tendangnhap, matkhau, ngaysinh, gioitinh, hoten, idgiadinh FROM NguoiDung",
						null);
		cursor.moveToFirst();
		NguoiDungEntity nguoiDungEntity = new NguoiDungEntity(cursor.getInt(0),
				cursor.getString(1), cursor.getString(2), cursor.getString(3),
				cursor.getString(4), cursor.getString(5), cursor.getString(6));

		cursor.close();
		return nguoiDungEntity;
	}

	public void deleteNguoiDungbyID(int id) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("DELETE FROM NguoiDung WHERE id=" + id);
	}

}
