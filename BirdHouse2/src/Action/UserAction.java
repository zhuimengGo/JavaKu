package Action;


import java.io.IOException;

import java.io.PrintWriter;
import org.apache.struts2.ServletActionContext;
import pojo.Users;
import util.send;
import Service.IUsersService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private IUsersService userService;
	private String name;
	private String password;
	private String veryCode;
	private Users user;
	private String sendphonenumber;
	public String login(){
		ServletActionContext.getRequest().getSession().removeAttribute("UserId");
		ServletActionContext.getRequest().getSession().removeAttribute("listShow");
		Users u=null;	
		u=userService.findByName(name);
		if(u.getId()==null){
			this.addFieldError("erroruserid","没有找到此账户,您可以选择注册它!");
			return "login_failure";
		}else {
			int logincount=u.getLogincount();
			String code=ServletActionContext.getRequest().getSession().getAttribute("numrand").toString();
			if(!veryCode.equals(code)){
				this.addFieldError("errorpassword", "验证码错误!");
				return "login_failure";
			}
			if(u.getState()==0){
				this.addFieldError("sdloginerror", "您的账号已被锁定禁止登陆,请联系客服!");
				return "login_failure";
			}
			if(password.equals(u.getPassword())) {
				ServletActionContext.getRequest().getSession().setAttribute("UserId",u.getId());
				if (u.getIsadmin()==null) {
					return "yonghu";
				}
				return "guanli";
			}else {
				if(logincount==0){
					this.addFieldError("sdloginerror", "您的账号已被锁定禁止登陆,请联系客服!");
					return "login_failure";
				}
				if(logincount<=5){
					int nlogincount=logincount-1;
					u.setLogincount(nlogincount);
					userService.saveorupdate(u);
					this.addFieldError("sdloginerror", "密码错误,剩余"+u.getLogincount()+"次将会被锁定");
					return "login_failure";
				}
				if (logincount==0) {
					this.addFieldError("sdloginerror", "连续输错5次密码,该账户已经被锁定请联系客服");
					return "login_failure";
				}
				return "login_failure";
				}
			}}
	public String logout(){
		ServletActionContext.getRequest().getSession().removeAttribute("UserId");
		return "SUCCESS";
	}
	public String regs(){
		userService.saveorupdate(user);
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		return "SUCCESS";
	}
	public String yanz() throws Exception{
		send s=new send();
		int num=s.send(sendphonenumber);
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print(num);
		return null;
	}
	public void yanzname() throws Exception{
		Users u=userService.findByName(name);
		PrintWriter out=ServletActionContext.getResponse().getWriter();
		if(u.getName()==null){
			out.print(1);
		}else{
			out.print(0);
		}
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "SUCCESS";
	}
	public IUsersService getUserService() {
		return userService;
	}
	public void setUserService(IUsersService userService) {
		this.userService = userService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVeryCode() {
		return veryCode;
	}
	public void setVeryCode(String veryCode) {
		this.veryCode = veryCode;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getSendphonenumber() {
		return sendphonenumber;
	}
	public void setSendphonenumber(String sendphonenumber) {
		this.sendphonenumber = sendphonenumber;
	}
	
}
