import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class MainRunner {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java MainRunner <package name> <class name> <class arg1> <class arg2> ...");
            return;
        }

        String packageName = args[0];
        String className = args[1];
        String[] classArgs = Arrays.copyOfRange(args, 2, args.length);

        String classFilePath = packageName.replace(".", File.separator) + File.separator + className + ".java";
        File classFile = new File(classFilePath);

        // Compile the class
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, classFile.getAbsolutePath());
        if (compilationResult != 0) {
            System.out.println("Compilation failed.");
            return;
        }

        // Load and execute the class
        try {
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{classFile.getParentFile().toURI().toURL()});
            Class<?> loadedClass = Class.forName(packageName + "." + className, true, classLoader);
            Method method = findMethod(loadedClass, className);
            if (method != null) {
                System.out.println("Found method: " + method.getName() + ", Parameter types: " + Arrays.toString(method.getParameterTypes()));
                Object[] parsedArgs = parseArgs(classArgs, method.getParameterTypes());
                if (parsedArgs != null) {
                    printInputDetails(packageName, className, method, parsedArgs);
                    Object result = method.invoke(null, parsedArgs);
                    printOutputDetails(method, result);
                } else {
                    System.out.println("Argument mismatch.");
                }
            } else {
                System.out.println("Method not found.");
            }
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | java.net.MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static Method findMethod(Class<?> loadedClass, String methodName) {
        methodName = methodName.substring(0, 1).toLowerCase() + methodName.substring(1); // Convert class name to method name (camel case)
        Method[] methods = loadedClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }

    private static void printInputDetails(String packageName, String className, Method method, Object[] args) {
        System.out.print("Topic: " + packageName);
        System.out.print("\nQuestion: " + className);
        System.out.print("\nInputs: ");
        for (int i = 0; i < args.length; i++) {
            System.out.print("[" + method.getParameterTypes()[i].getSimpleName() + "] ");
            printArg(args[i]);
            if (i < args.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }

    private static void printOutputDetails(Method method, Object result) {
        System.out.print("Output: ");
        System.out.println("[" + method.getReturnType().getSimpleName() + "] " + result);
    }

    private static void printArg(Object arg) {
        if (arg.getClass().isArray()) {
            System.out.print(arrayToString(arg));
        } else {
            System.out.print(arg);
        }
    }

    private static String arrayToString(Object array) {
        StringBuilder sb = new StringBuilder("[");
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object element = Array.get(array, i);
            if (element.getClass().isArray()) {
                sb.append(arrayToString(element));
            } else {
                sb.append(element);
            }
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static Object[] parseArgs(String[] args, Class<?>[] paramTypes) {
        if (args.length != paramTypes.length) {
            return null; // Argument count mismatch
        }

        Object[] parsedArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            Object parsedArg = parseArg(args[i], paramTypes[i]);
            if (parsedArg == null) {
                return null; // Argument type mismatch
            }
            parsedArgs[i] = parsedArg;
        }
        return parsedArgs;
    }

    private static Object parseArg(String arg, Class<?> paramType) {
        if (paramType.isArray()) {
            // Handling multi-dimensional arrays
            String[] elements = arg.split(",");
            return parseArgArray(elements, paramType.getComponentType());
        } else {
            // Handling one-dimensional arrays and other types
            if (arg.isEmpty()) {
                throw new IllegalArgumentException("Empty argument provided.");
            }
            if (paramType.equals(int.class) || paramType.equals(Integer.class)) {
                return Integer.parseInt(arg);
            } else if (paramType.equals(long.class) || paramType.equals(Long.class)) {
                return Long.parseLong(arg);
            } else if (paramType.equals(float.class) || paramType.equals(Float.class)) {
                return Float.parseFloat(arg);
            } else if (paramType.equals(double.class) || paramType.equals(Double.class)) {
                return Double.parseDouble(arg);
            } else if (paramType.equals(boolean.class) || paramType.equals(Boolean.class)) {
                return Boolean.parseBoolean(arg);
            } else if (paramType.equals(char.class) || paramType.equals(Character.class)) {
                if (arg.length() != 1) {
                    throw new IllegalArgumentException("Character value must have length 1.");
                }
                return arg.charAt(0);
            } else {
                return arg; // For non-primitive types, assume the argument is a String
            }
        }
    }

    private static Object parseArgArray(String[] elements, Class<?> componentType) {
        if (componentType.isArray()) {
            // Multi-dimensional array
            int[] dimensions = new int[getArrayDimensions(componentType)];
            dimensions[0] = elements.length;
            Object array = Array.newInstance(componentType.getComponentType(), dimensions);
            for (int i = 0; i < elements.length; i++) {
                String[] subElements = elements[i].substring(1, elements[i].length() - 1).split(",");
                Array.set(array, i, parseArgArray(subElements, componentType.getComponentType()));
            }
            return array;
        } else {
            // One-dimensional array
            Object array = Array.newInstance(componentType, elements.length);
            for (int i = 0; i < elements.length; i++) {
                String element = elements[i].trim();
                if (element.startsWith("[") && element.endsWith("]")) {
                    element = element.substring(1, element.length() - 1);
                }
                Array.set(array, i, parseArg(element, componentType));
            }
            return array;
        }
    }

    private static int getArrayDimensions(Class<?> arrayType) {
        int dimensions = 0;
        while (arrayType.isArray()) {
            dimensions++;
            arrayType = arrayType.getComponentType();
        }
        return dimensions;
    }
}
