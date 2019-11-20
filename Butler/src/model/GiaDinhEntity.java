package model;

public class GiaDinhEntity {
private int id;
 private String IDGiaDinh;
 private String GhiChu;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getIDGiaDinh() {
	return IDGiaDinh;
}
public void setIDGiaDinh(String iDGiaDinh) {
	IDGiaDinh = iDGiaDinh;
}
public String getGhiChu() {
	return GhiChu;
}
public void setGhiChu(String ghiChu) {
	GhiChu = ghiChu;
}
public GiaDinhEntity() {
	super();
}
public GiaDinhEntity(int id, String iDGiaDinh, String ghiChu) {
	super();
	this.id = id;
	IDGiaDinh = iDGiaDinh;
	GhiChu = ghiChu;
}
@Override
public String toString() {
	return "GiaDinhEntity [id=" + id + ", IDGiaDinh=" + IDGiaDinh + ", GhiChu="
			+ GhiChu + "]";
}

 

 


}

