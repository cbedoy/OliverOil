package iambedoy.oliveoil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;

/**
 * OliveOil
 * <p>
 * Created by bedoy on 10/25/17.
 */

public class OilInjector
{
    private static HashMap<Class, Object> instances;

    static {
        instances = new HashMap<>();
    }

    public static void inject(Class... classes){
        createInstances(classes);

        linkInstances(classes);
    }

    public static Object getInstanceFromClass(Class __clazz){
        return instances.get(__clazz);
    }

    public static void clear(){
        instances.clear();
    }

    private static void createInstances(Class... classes){
        for (Class __clazz : classes){
            if (!instances.containsKey(__clazz)){
                try {
                    instances.put(__clazz, __clazz.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void linkInstances(Class... classes){
        for (Class __clazz : classes) {
            Method[] declaredMethods = __clazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (Modifier.isPublic(method.getModifiers())) {
                    String methodName = method.getName();
                    if (methodName.contains("set"))
                    {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1)
                        {
                            Class<?> parameterType = parameterTypes[0];
                            injectField(parameterType, __clazz, methodName);
                        }
                    }
                }
            }
        }
    }

    private static Object findInterfaceOf(Class<?> __clazz){
        for (Class instance : instances.keySet()){
            if (__clazz.isAssignableFrom(instance))
                return instances.get(instance);
        }
        return null;
    }

    private static void injectField(Class<?> parameterType, Class __clazz, String methodName){
        Object instance = findInterfaceOf(parameterType);
        if (instance != null)
        {
            try
            {
                String propertyName = methodName;
                if (propertyName.contains("set")){
                    propertyName = propertyName.replace("set", "");
                    propertyName = propertyName.toLowerCase();
                }
                Field declaredField = __clazz.getDeclaredField(propertyName);
                declaredField.set(instance, methodName);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
