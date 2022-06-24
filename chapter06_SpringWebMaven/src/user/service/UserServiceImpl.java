package user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO = null;

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
	}

	@Override
	public String checkId(String id) {
		UserDTO userDTO = userDAO.checkId(id);
		
		if(userDTO == null)
			return "non_exist"; //사용 가능
		else
			return "exist"; //사용 불가능
	}

	@Override
	public List<UserDTO> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public UserDTO getUser(String id) {
		return userDAO.getUser(id);
	}
	
	@Override
	public void update(Map<String, String> map) {
		userDAO.update(map);
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
		
	}

}
