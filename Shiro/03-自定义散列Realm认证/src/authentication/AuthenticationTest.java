package authentication;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class AuthenticationTest {

	//测试模拟用户的登录和退出
	@Test
	public void testLoginAndLogout() {
		//创建工厂,通过ini文件读取配置
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-demo.ini");
		
		//创建SecurityManager
		SecurityManager securityManager = factory.getInstance();
		
		//将SecurityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		//构造一个假想subject模拟请求
		Subject subject = SecurityUtils.getSubject();
		
		//准备token并执行认证的提交
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "123");
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//检测认证是否通过
		boolean isAuthenticated = false;
		isAuthenticated = subject.isAuthenticated();
		System.out.println("是否认证通过？" + isAuthenticated);
		
		//模拟退出,之后再次检测
		subject.logout();
		isAuthenticated = subject.isAuthenticated();
		System.out.println("是否认证通过？" + isAuthenticated);
	}
	
	
	
	//测试自定义Realm
	@Test
	public void testCustomRealm() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("", "admin");
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean isAuthenticated = false;
		isAuthenticated = subject.isAuthenticated();
		System.out.println("是否认证通过？" + isAuthenticated);
	}
	
	
	
	//测试自定义Realm-使用散列
	@Test
	public void testCustomRealmMD5() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm-md5.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("", "admin");
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean isAuthenticated = false;
		isAuthenticated = subject.isAuthenticated();
		System.out.println("是否认证通过？" + isAuthenticated);
	}
	
}
