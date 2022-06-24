package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserService {

	public void write(UserDTO userDTO);

	public String checkId(String id);

	public List<UserDTO> getUserList();

	public UserDTO getUser(String id);

	public void update(Map<String, String> map);

	public void delete(String id);



	




	
}
