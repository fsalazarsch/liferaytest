package taxes;

public class Type {

	String nametype;
	String nameproduct;
	
	Type(){
		}
	
	Type(String nameproduct, String nametype){
		this.nametype = nametype;
		this.nameproduct = nameproduct;
	}
	
	public String getNametype() {
		return nametype;
	}
	public void setNametype(String nametype) {
		this.nametype = nametype;
	}
	public String getNameproduct() {
		return nameproduct;
	}
	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}
	
}
