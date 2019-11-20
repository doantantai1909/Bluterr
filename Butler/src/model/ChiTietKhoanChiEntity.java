package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.ParseException;

public class ChiTietKhoanChiEntity {
	private int id;
	private String tenkhoanchi;
	private int sotien;
	private int idchi;
	private int idnguoichi;
	private String ngaychi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenkhoanchi() {
		return tenkhoanchi;
	}
	public void setTenkhoanchi(String tenkhoanchi) {
		this.tenkhoanchi = tenkhoanchi;
	}
	public int getSotien() {
		return sotien;
	}
	public void setSotien(int sotien) {
		this.sotien = sotien;
	}
	public int getIdchi() {
		return idchi;
	}
	public void setIdchi(int idchi) {
		this.idchi = idchi;
	}
	public int getIdnguoichi() {
		return idnguoichi;
	}
	public void setIdnguoichi(int idnguoichi) {
		this.idnguoichi = idnguoichi;
	}
	public String getNgaychi() {
		return ngaychi;
	}
	public void setNgaychi(String ngaychi) {
		this.ngaychi = ngaychi;
	}
	public ChiTietKhoanChiEntity() {
		super();
	}
	public ChiTietKhoanChiEntity(int id, String tenkhoanchi, int sotien,
			int idchi, int idnguoichi, String ngaychi) {
		super();
		this.id = id;
		this.tenkhoanchi = tenkhoanchi;
		this.sotien = sotien;
		this.idchi = idchi;
		this.idnguoichi = idnguoichi;
		this.ngaychi = ngaychi;
	}
	@Override
	public String toString() {
		return "ChiTietKhoanChiEntity [id=" + id + ", tenkhoanchi="
				+ tenkhoanchi + ", sotien=" + sotien + ", idchi=" + idchi
				+ ", idnguoichi=" + idnguoichi + ", ngaychi=" + ngaychi + "]";
	}
	
	

}
