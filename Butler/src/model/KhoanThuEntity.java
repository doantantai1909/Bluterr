package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.ParseException;

public class KhoanThuEntity {
	private int idthu;
	private String tenkhoanthu;
	private String ghighu;
	public int getIdthu() {
		return idthu;
	}
	public void setIdthu(int idthu) {
		this.idthu = idthu;
	}
	public String getTenkhoanthu() {
		return tenkhoanthu;
	}
	public void setTenkhoanthu(String tenkhoanthu) {
		this.tenkhoanthu = tenkhoanthu;
	}
	public String getGhighu() {
		return ghighu;
	}
	public void setGhighu(String ghighu) {
		this.ghighu = ghighu;
	}
	public KhoanThuEntity() {
		super();
	}
	public KhoanThuEntity(int idthu, String tenkhoanthu, String ghighu) {
		super();
		this.idthu = idthu;
		this.tenkhoanthu = tenkhoanthu;
		this.ghighu = ghighu;
	}
	@Override
	public String toString() {
		return "KhoanThuEntity [idthu=" + idthu + ", tenkhoanthu="
				+ tenkhoanthu + ", ghighu=" + ghighu + "]";
	}
	
	
	
	
	
	

}
