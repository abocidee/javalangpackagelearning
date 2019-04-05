package langpackagelearning;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import entity.EnemyShipFactory;
import entity.UFOEnemyShip;

public class test {
	
 public static void main(String[] args) {
	 Class reflectClass = UFOEnemyShip.class;
		String className =reflectClass.getName();
		System.out.println(className);
		
		int classModifer =reflectClass.getModifiers();
		System.out.println(Modifier.isPublic(classModifer));
		//isAbstract ,isFinal,isInterface,isPrivate,isProtected
		//isStatic isStrict,isSynchronized isVolatile
		
		Class[] interfaces = reflectClass.getInterfaces();
		Class classSuper =reflectClass.getSuperclass();
		
		System.out.println(classSuper.getName());
		
		Method[] classMethods =reflectClass.getDeclaredMethods();
	    for(Method m:classMethods) {
	    	System.out.println("method name :" +m.getName());
	    	if(m.getName().startsWith("get")) {
	    		System.out.println("get method"+m.getName());
	    	}else if(m.getName().startsWith("set")) {
	    		System.out.println("set method "+ m.getName());
	    	}
	    	
	    	System.out.println("return type" +m.getReturnType());
	    	
	    	Class[] ParameterTypes =m.getParameterTypes();
	    	System.out.println("Parameters");
	    	for(Class parameter:ParameterTypes) {
	    		System.out.println(parameter.getName());
	    	}
	    	System.out.println();
	    	Constructor constructor =null;
	    	Object constructor2 =null;
	    	try {
				constructor=reflectClass.getConstructor(new Class[] {
						EnemyShipFactory.class
				});
				
				try {
					constructor2=reflectClass.getConstructor(int.class,String.class).newInstance(12,"woca");
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	Class[]constructParameters =constructor.getParameterTypes();
	    	for(Class parameter:constructParameters) {
	    		System.out.println(parameter.getName());
	    	}
	    	
	    	UFOEnemyShip newEnemyShip =null;
	    	EnemyShipFactory shipFactory =null;
	    	
	    	try {
				newEnemyShip =(UFOEnemyShip) constructor.newInstance(shipFactory);
				
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	newEnemyShip.setShipFactory(new EnemyShipFactory("float"));
	    	
	    	Field privateStringname=null;
	    	UFOEnemyShip enemyshipPrivate = new UFOEnemyShip(shipFactory);
	    	try {
	    		String idcodeString ="idcode";
				privateStringname =UFOEnemyShip.class.getDeclaredField(idcodeString);
				privateStringname.setAccessible(true);
				System.out.println(privateStringname.getName());
				
				String valueOfName;
				try {
					valueOfName = (String) privateStringname.getName();
					System.out.println("private filed name" +valueOfName);
					
					String methodName ="getPrivate";
					Method  privateMethod =UFOEnemyShip.class.getDeclaredMethod(methodName, null);
					privateMethod.setAccessible(true);
					//String privateReturnVal =(String) privateMethod.invoke(null, null);
					//System.out.println(privateReturnVal);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	
}
}
