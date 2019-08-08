package homework2;

public class MemberFindDto {
	private String name;
	private int seq;
	private String email;
	private String code;
	private String sdate;
	private String edate;
	//생성자 만들기
	public MemberFindDto(String name ,int seq, String email, String code, String sdate, String edate) {
		this.name = name;
		this.seq = seq;
		this.email = email;
		this.code = code;
		this.sdate = sdate;
		this.edate = edate;
	}
	public MemberFindDto() {
		
	}
	public void print(MemberFindDto m) {
		System.out.println("객체 이름 :" +name);
		System.out.println("seq : " + m.getSeq());
		System.out.println("email : " + m.getEmail());
		System.out.println("code : " + m.getCode());
		System.out.println("sdate : " + m.getSdate());
		System.out.println("edate : " + m.getEdate());
		System.out.println();
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}
	
}
