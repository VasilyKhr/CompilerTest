package pack;

public class HelloCompiler  {
    public static void main(String[] args)
    {
        System.out.println("************************");
        System.out.println("**** Hello Compiler ****");
        System.out.println("************************");
        StringBuilder source = new StringBuilder();
        String lineSep = System.lineSeparator();
        source
                .append("package pack;").append(lineSep)
                .append("public class Test implements RuleClassInterface {").append(lineSep)
                .append("@Override").append(lineSep)
                .append("public String sayHello(){").append(lineSep)
                .append("return \"Hello, Beuatiful world\";").append(lineSep)
                .append("}").append(lineSep)
                .append("}");
        System.out.println(source.toString());

        //FileObjectImpl classFile = new FileObjectImpl("", source.toString());

        CharSequenceCompiler compiler = new CharSequenceCompiler(ClassLoader.getSystemClassLoader(), null);

        try {
            Class<RuleClassInterface> resClass = compiler.compile("pack.Test", source, null, new Class<?>[]{ RuleClassInterface.class });
            System.out.println(resClass.newInstance().sayHello());
        } catch (CharSequenceCompilerException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        /*ClassLoaderImpl classLoader = new ClassLoaderImpl(ClassLoader.getSystemClassLoader());
        classLoader.add("pack.Test", classFile);
        try {
            Object clazz = classLoader.loadClass("pack.Test", true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        /*try {
            Class<?> newClass = classLoader.findClass("Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
