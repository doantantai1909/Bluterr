package model;

public class NguoiDungTamEntity {

	private int id;
	private String tendangnhap;
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
	public NguoiDungTamEntity() {
		super();
	}
	public NguoiDungTamEntity(int id, String tendangnhap) {
		super();
		this.id = id;
		this.tendangnhap = tendangnhap;
	}
	@Override
	public String toString() {
		return "NguoiDungTamEntity [id=" + id + ", tendangnhap=" + tendangnhap
				+ "]";
	}
	
	
	
	
	
	

}
