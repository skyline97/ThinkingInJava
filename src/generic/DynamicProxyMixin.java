package generic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DynamicProxyMixin {
	public static void main(String[] args) {
	}
}

class MixinProxy implements InvocationHandler {
	
	private Map<String,Object> delegatesByMethod;
	
	public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
		delegatesByMethod = new HashMap<String, Object>();
		for(TwoTuple<Object,Class<?>> pair:pairs) {
			for(Method method:pair.second.getMethods()) {
				//delegatesByMethod.putIfAbsent(method.getName(), pair.first);
			}
		}
	}
	 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		Object delegate = delegatesByMethod.get(methodName);
		return method.invoke(delegate, args);
	}
	
	public static Object newInstance(TwoTuple<Object,Class<?>>... pairs) {
		Class<?>[] interfaces = new Class[pairs.length];
		for(int i=0;i<pairs.length;i++) {
			interfaces[i] = (Class<?>) pairs[i].second;
		}
		ClassLoader cl = pairs[0].first.getClass().getClassLoader();
		return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
	}
}

