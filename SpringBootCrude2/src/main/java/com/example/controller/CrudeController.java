package com.example.controller;

import java.util.List;
//import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.CrudeServiceImpl;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.websocket.server.PathParam;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CrudeController {
	
	/*@RequestMapping("/")
	public String Login() {
		
		return "la_login";
	}*/
	private final String key = "Bar12345Bar12345";
	@Autowired
	private CrudeServiceImpl crudeService;
	
	@RequestMapping(value="/empShow",method = RequestMethod.GET,produces="application/json")
	public String home(Model model) {
		System.out.println("starting page load :::: ");
		return "emp";
	}
	
	@RequestMapping(value="/authentication",method = RequestMethod.POST,produces="application/json")
	public String authentication(//@RequestParam("userName")String userName,//@ResponseBody
			//@RequestParam("password")String password,
			@RequestBody User user,
			Model model) {
		System.out.println("userName ::::::: "+user.getUserName());
		User emp =crudeService.findUserByUname(user.getUserName());
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String response="";
		
		if(emp != null) {
			response="";
			System.out.println("emp fname :::::::::::"+emp.getFirstName());
			System.out.println("emp id :::::::::::"+emp.getId());
			System.out.println("( !emp.equals(null) ) :::::::::: "+( !emp.equals(null) ));
			
			try 
	        {
	            //String text = "Hello World";
	             // 128 bit key
	            // Create key and cipher
				String key = "Bar12345Bar12345";
	            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
	            Cipher cipher = Cipher.getInstance("AES");
	            // encrypt the text
	            //cipher.init(Cipher.ENCRYPT_MODE, aesKey);
	            
	            // decrypt the text
	            cipher.init(Cipher.DECRYPT_MODE, aesKey);
	            //string.getBytes(Charset.forName("UTF-8"));
	            
	            String decrypted = new String(cipher.doFinal(Base64.decodeBase64(emp.getPassword())));//StandardCharsets.UTF_8
	            System.err.println("decrypted ::::::::::::::::::: "+decrypted);
	            System.out.println("user.getPassword() :::::::::::::"+user.getPassword());
	            System.out.println("user.getPassword().equals(decrypted) :::::::::::::"+user.getPassword().equals(decrypted));
	            if(user.getPassword().equals(decrypted) == true) {//emp.getPassword().equals(password)
					System.out.println("(emp.getPassword().equals(password)) :::::::::: "+(emp.getPassword().equals(user.getPassword())));
					response="Success";
				}else {
					System.out.println("(emp.getPassword().equals(password)) else:::::::::: "+(emp.getPassword().equals(user.getPassword())));
					response="Password Is not Match";
				}
	        }
	        catch(Exception e) 
	        {
	            e.printStackTrace();
	        }
			
			//boolean isPasswordMatch = passwordEncoder.matches(password, emp.getPassword());
			
		}else {
			System.out.println("else :::::::::: ");
			response="User Name is not match Please sign in otherwise contact admin";
		}
		System.out.println("starting authentication load :::: ");
		return response;
	}
	
	@RequestMapping(value="/showAllUser",method = RequestMethod.GET,produces="application/json")
	public  List<User> updateEmp(Model model){//@ResponseBody
		List<User> emplist =crudeService.findAll();
		
		//System.out.println("emp.getId() ::: "+emp.getId());
		System.out.println("showAll ::: ");
		return emplist;
	}
	
	@RequestMapping(value = "/saveUser",method = RequestMethod.POST,produces="application/json")
	public  Integer saveUser(//@RequestParam("fname")String firstname,//@ResponseBody
			@RequestBody User user
			//@RequestParam("lname")String lastname,
			//@RequestParam("address")String address,
			//@RequestParam("userName")String userName,
			//@RequestParam("password")String password,
			//@RequestParam("gen") String gen, Model model
			) {
		System.out.println(" save ::: ");
		System.out.println("firstname ::: "+user.getFirstName());
		System.out.println("lastname ::: "+user.getLastName());
		System.out.println("address ::: "+user.getAddress());
		System.out.println("gen ::: "+user.getGender());
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User emp = new User();
		emp.setFirstName(user.getFirstName());
		emp.setLastName(user.getLastName());
		emp.setUserName(user.getUserName());
		try 
        {
			String key = "Bar12345Bar12345";
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        // encrypt the text
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(user.getPassword().getBytes());
        System.err.println(new String(encrypted));
		//String encodedPassword = passwordEncoder.encode(password);
		emp.setPassword(new String(Base64.encodeBase64(encrypted)));
        }catch (Exception e) {
        	  e.printStackTrace();
		}
		emp.setAddress(user.getAddress());
		emp.setGender(user.getGender());
		emp.setDflag(1);
		String message ="";
		int i =0;
		emp=crudeService.save(emp);
		System.out.println("emp.getId() ::: "+emp.getId());
		if(emp.getId() >0) {
			message="success";
			i=1;
		}else {
			message="fail";
			i=2;
		}
		System.out.println("message ::: "+message);
		System.out.println("message ::: "+i);
		return i;
	}
	
	@RequestMapping(value ="editUserData/{id}",method = RequestMethod.GET, produces="application/json")
	public  User editUserData(@PathVariable("id") int id) {//@ResponseBody
		System.out.println("id ::::::::::::::: "+id);
		User emp =crudeService.findById(id);
		return emp;
	}
	
	@RequestMapping(value="/updateUser",method = RequestMethod.PUT,produces="application/json")//@ResponseBody
	public  Integer updateUser(@RequestBody User user //@RequestParam("id")int id,@RequestParam("fname")String firstname,@RequestParam("lname")String lastname,
			//@RequestParam("address")String address,@RequestParam("gen")String gen
			,Model model){
		User emp =crudeService.findById(user.getId());
		emp.setFirstName(user.getFirstName());
		emp.setLastName(user.getLastName());
		emp.setUserName(emp.getUserName());
		emp.setPassword(emp.getPassword());
		emp.setAddress(user.getAddress());
		emp.setDflag(emp.getDflag());
		emp.setGender(user.getGender());
		emp=crudeService.save(emp);
		System.out.println("emp.getId() ::: "+emp.getId());
		String message ="";
		int i =0;
		if(emp.getId() >0) {
			message="success";
			i=1;
		}else {
			message="fail";
			i=2;
		}
		System.out.println("message ::: "+message);
		System.out.println("message ::: "+i);
		return i;
	}
	@RequestMapping(value="/deleteUser/{id}",method = RequestMethod.DELETE, produces="application/json")
	public  Integer deleteUser(@PathVariable("id")Integer id) {//@ResponseBody
		System.out.println("id  :::::::::::::::: "+id);
		User emp = crudeService.findById(id);
		emp.setFirstName(emp.getFirstName());
		emp.setLastName(emp.getLastName());
		emp.setUserName(emp.getUserName());
		emp.setPassword(emp.getPassword());
		emp.setAddress(emp.getAddress());
		emp.setDflag(0);
		emp.setGender(emp.getGender());
		emp=crudeService.save(emp);
		String message ="";
		int i =0;
		if(emp == null) {
			message="success";
			i=1;
		}else {
			message="fail";
			i=2;
		}
		System.out.println("message ::: "+message);
		System.out.println("message ::: "+i);
		return i;
		
	}
}