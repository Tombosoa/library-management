package Annotation;

import java.lang.reflect.Method;

public class test {
    public static String getMFAV(Class<?> clazz, String methodName){
        try{
            Method method = clazz.getMethod(methodName);
            MyFirstAnnotation annotation = method.getAnnotation(MyFirstAnnotation.class);
            if(annotation != null){
                return annotation.value();
            }
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        return null;
    }
    @MyFirstAnnotation("this is my annotation")
    public static void DoTest(){
        String value = getMFAV(test.class, "DoTest");
        System.out.println(value);
    }
    public static void main(String[] args) {
        DoTest();
    }
}
