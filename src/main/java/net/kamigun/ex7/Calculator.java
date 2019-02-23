package net.kamigun.ex7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class Calculator {

    public static final String SUM_METHOD_NAME = "sum";

    private Optional engine = Optional.empty();
    private Method sumMethod;

    public Calculator(boolean hasMemory) {
        try {
            if (hasMemory) {
                sumMethod = EngineWithMemory.class.getMethod(SUM_METHOD_NAME, int.class, int.class);
                engine = Optional.of(new EngineWithMemory());
            } else {
                sumMethod = EngineWithoutMemory.class.getMethod(SUM_METHOD_NAME, int.class, int.class);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public int sum(int a, int b) throws InvocationTargetException, IllegalAccessException {
        int result;
        if (engine.isPresent()) {
            result = (int) sumMethod.invoke(engine.get(), a, b);
        } else {
            result = (int) sumMethod.invoke(null, a, b);
        }

        return result;
    }
}
