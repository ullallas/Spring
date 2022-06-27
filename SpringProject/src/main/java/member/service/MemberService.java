package member.service;

import java.util.Map;

import member.bean.MemberDTO;

public interface MemberService {

	public String login(Map<String, String> map);

	public void logout();

	public String checkId(String id);

	public void write(MemberDTO memberDTO);

	public MemberDTO getMember(String id);

	public void update(MemberDTO memberDTO);

}
