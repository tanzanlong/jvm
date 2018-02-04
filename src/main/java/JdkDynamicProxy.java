import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy implements InvocationHandler{
	
	private Object target;
	
	
	public JdkDynamicProxy(Object target) {
		this.target=target;
	}
	
	public <T>T getProxy(){
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		before();
	Object result=method.invoke(target, args);
		after();
		return result;
	}
	
	private void before() {
		System.out.println("..before...");
	}
	
	private void after() {
		System.out.println("..after...");
	}

}
