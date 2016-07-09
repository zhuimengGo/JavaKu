package Action.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckLoginIterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String url="";
		if(null!=ServletActionContext.getRequest().getSession().getAttribute("UserId")){
			url=arg0.invoke();
			
		}else{
			System.out.println("...........2");
			url="login_failure";
		}
		
		return url;
	}

}
