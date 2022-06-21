package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional
public class UserDAOMyBatis implements UserDAO {
	@Setter
	private SqlSession sqlSession = null;

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	} //write()

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	} //getUserList()

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	} //getUser()

	@Override
	public void update(Map<String, String> map) {
		sqlSession.update("userSQL.update", map);
	} //update()

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	} //delete()
}
