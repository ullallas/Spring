package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {
	@Setter
	private UserDTO userDTO;
	@Setter
	private UserDAO userDAO;
	
//	public void setUserDTO(UserDTO userDTO) {
//		this.userDTO = userDTO;
//	}
	

	@Override
	public void execute() {
		//데이터
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB
		userDAO.write(userDTO);
		
		System.out.println();
		System.out.println("데이터를 저장하였습니다.");

	}

}
