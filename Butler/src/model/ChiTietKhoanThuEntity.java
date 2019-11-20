package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.ParseException;

public class ChiTietKhoanThuEntity {

	
	private int id;
	private int idnguoithu;
	private String tenkhoanthu;
	private int sotien;
	private int idthu;
	private String ngaythu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdnguoithu() {
		return idnguoithu;
	}
	public void setIdnguoithu(int idnguoithu) {
		this.idnguoithu = idnguoithu;
	}
	public String getTenkhoanthu() {
		return tenkhoanthu;
	}
	public void setTenkhoanthu(String tenkhoanthu) {
		this.tenkhoanthu = tenkhoanthu;
	}
	public int getSotien() {
		return sotien;
	}
	public void setSotien(int sotien) {
		this.sotien = sotien;
	}
	public int getIdthu() {
		return idthu;
	}
	public void setIdthu(int idthu) {
		this.idthu = idthu;
	}
	public String getNgaythu() {
		return ngaythu;
	}
	public void setNgaythu(String ngaythu) {
		this.ngaythu = ngaythu;
	}
	public ChiTietKhoanThuEntity() {
		super();
	}
	public ChiTietKhoanThuEntity(int id, int idnguoithu, String tenkhoanthu,
			int sotien, int idthu, String ngaythu) {
		super();
		this.id = id;
		this.idnguoithu = idnguoithu;
		this.tenkhoanthu = tenkhoanthu;
		this.sotien = sotien;
		this.idthu = idthu;
		this.ngaythu = ngaythu;
	}
	@Override
	public String toString() {
		return "ChiTietKhoanThuEntity [id=" + id + ", idnguoithu=" + idnguoithu
				+ ", tenkhoanthu=" + tenkhoanthu + ", sotien=" + sotien
				+ ", idthu=" + idthu + ", ngaythu=" + ngaythu + "]";
	}
	
	
	
	

	
}
