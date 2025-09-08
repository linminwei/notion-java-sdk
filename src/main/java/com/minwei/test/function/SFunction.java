package com.minwei.test.function;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @author lmw
 */
@FunctionalInterface
public interface SFunction<T, R> extends Function<T, R>, Serializable {
}
