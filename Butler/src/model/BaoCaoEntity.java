package model;


public class BaoCaoEntity {
	private int id;
	private int idgiadinh;
	private int thang;
	private int idthu;
	private int idchi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdgiadinh() {
		return idgiadinh;
	}
	public void setIdgiadinh(int idgiadinh) {
		this.idgiadinh = idgiadinh;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getIdthu() {
		return idthu;
	}
	public void setIdthu(int idthu) {
		this.idthu = idthu;
	}
	public int getIdchi() {
		return idchi;
	}
	public void setIdchi(int idchi) {
		this.idchi = idchi;
	}
	public BaoCaoEntity() {
		super();
	}
	public BaoCaoEntity(int id, int idgiadinh, int thang, int idthu, int idchi) {
		super();
		this.id = id;
		this.idgiadinh = idgiadinh;
		this.thang = thang;
		this.idthu = idthu;
		this.idchi = idchi;
	}
	@Override
	public String toString() {
		return "BaoCaoEntity [id=" + id + ", idgiadinh=" + idgiadinh
				+ ", thang=" + thang + ", idthu=" + idthu + ", idchi=" + idchi
				+ "]";
	}
	
	
	

}
