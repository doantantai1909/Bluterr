package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.ParseException;

public class KhoanChiEntity {
	private int idchi;
	private String tenkhoanchi;
	private String ghichu;
	public int getIdchi() {
		return idchi;
	}
	public void setIdchi(int idchi) {
		this.idchi = idchi;
	}
	public String getTenkhoanchi() {
		return tenkhoanchi;
	}
	public void setTenkhoanchi(String tenkhoanchi) {
		this.tenkhoanchi = tenkhoanchi;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public KhoanChiEntity() {
		super();
	}
	public KhoanChiEntity(int idchi, String tenkhoanchi, String ghichu) {
		super();
		this.idchi = idchi;
		this.tenkhoanchi = tenkhoanchi;
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		return "KhoanChiEntity [idchi=" + idchi + ", tenkhoanchi="
				+ tenkhoanchi + ", ghichu=" + ghichu + "]";
	}
	
	
	
	
}