package user.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user") // "/user" 도 가능
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@PostMapping(value="write") //value="/user/write"
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@PostMapping(value="checkId")
	@ResponseBody
	public String checkId(@RequestParam String id) {
		return userService.checkId(id);
	}
	
	@GetMapping(value="list")
	public String list() {
		return "/user/list";
	}
	
	@PostMapping(value="getUserList")
	@ResponseBody
	public List<UserDTO> getUserList() {
		return userService.getUserList();
	}
	
	@GetMapping(value="updateForm")
	public String updateForm() {
		return "/user/updateForm";
	}
	
	@PostMapping(value="getUser")
	@ResponseBody
	public UserDTO getUser(@RequestParam String id) {
		return userService.getUser(id);
	}
	
	@PostMapping(value="update")
	@ResponseBody
	public void update(@RequestParam Map<String, String> map) {
		userService.update(map);
	}
	
	@GetMapping(value="deleteForm")
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@PostMapping(value="delete")
	@ResponseBody
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
	
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "/user/uploadForm";
	}
	
	//name="img" 1개인 경우
	/*
	@PostMapping(value="upload")
	@ResponseBody
	public String upload(@RequestParam MultipartFile img, HttpSession session) {
			
		public String upload(@RequestParam MultipartFile img) {
		//가상폴더
		
		String filePath = "D:\\Spring\\workspace\\chapter06_SpringWebMaven\\WebContent\\storage";
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath, fileName); //파일생성
		
		//복사
		try {
			//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			img.transferTo(file);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//실제폴더
		String filePath = session.getServletContext().getRealPath("/storage");
		System.out.println("실제폴더 = " + filePath);
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath, fileName); //파일생성
		
		try {
			img.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//UserService -> UserDAO -> DB에는 이미지를 저장하는 것이 아니라 파일명만 저장
		
		return "<img src='../storage/"+ fileName + "' width='200' height='200'>";
	}
	*/
	
	//name="img" 2개 이상인 경우, 배열로 받아온다.
	/*
	@PostMapping(value="upload")
	@ResponseBody
	public void upload(@RequestParam MultipartFile[] img, HttpSession session) {
		//실제폴더
		String filePath = session.getServletContext().getRealPath("/storage");
		String fileName;
		File file;
		
		if(img[0] != null) {
			fileName = img[0].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img[0].transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(img[1] != null) {
			fileName = img[1].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img[1].transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	*/
	
	//파일을 여러개 선택
	@PostMapping(value="upload")
	@ResponseBody
	public void upload(@RequestParam("img[]") List<MultipartFile> list, HttpSession session) {
		//실제폴더
		String filePath = session.getServletContext().getRealPath("/storage");
		String fileName;
		File file;
		
		for(MultipartFile img : list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} //for
		
	}
}


