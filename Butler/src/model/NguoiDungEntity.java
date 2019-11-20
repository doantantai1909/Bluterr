package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.http.ParseException;

import android.R.string;

public class NguoiDungEntity {
private int id;
private String tendangnhap;
private String matkhau;
private String ngaysinh;
private String gioitinh;
private String hoten;
private String idgiadinh;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTendangnhap() {
	return tendangnhap;
}
public void setTendangnhap(String tendangnhap) {
	this.tendangnhap = tendangnhap;
}
public String getMatkhau() {
	return matkhau;
}
public void setMatkhau(String matkhau) {
	this.matkhau = matkhau;
}
public String getNgaysinh() {
	return ngaysinh;
}
public void setNgaysinh(String ngaysinh) {
	this.ngaysinh = ngaysinh;
}
public String getGioitinh() {
	return gioitinh;
}
public void setGioitinh(String gioitinh) {
	this.gioitinh = gioitinh;
}
public String getHoten() {
	return hoten;
}
public void setHoten(String hoten) {
	this.hoten = hoten;
}
public String getIdgiadinh() {
	return idgiadinh;
}
public void setIdgiadinh(String idgiadinh) {
	this.idgiadinh = idgiadinh;
}
public NguoiDungEntity() {
	super();
}
public NguoiDungEntity(int id, String tendangnhap, String matkhau,
		String ngaysinh, String gioitinh, String hoten, String idgiadinh) {
	super();
	this.id = id;
	this.tendangnhap = tendangnhap;
	this.matkhau = matkhau;
	this.ngaysinh = ngaysinh;
	this.gioitinh = gioitinh;
	this.hoten = hoten;
	this.idgiadinh = idgiadinh;
}
@Override
public String toString() {
	return "NguoiDungEntity [id=" + id + ", tendangnhap=" + tendangnhap
			+ ", matkhau=" + matkhau + ", ngaysinh=" + ngaysinh + ", gioitinh="
			+ gioitinh + ", hoten=" + hoten + ", idgiadinh=" + idgiadinh + "]";
}

	
	

}
