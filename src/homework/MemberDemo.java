package homework;

public class MemberDemo {
	public static void main(String[] args) {
		MemberDto dto = new MemberDto(1,"test","test");
		MemberDao dao = MemberDao.getInstance();
		
		dao.insert(dto);
	}
}
