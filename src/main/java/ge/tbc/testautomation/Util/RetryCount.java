package ge.tbc.testautomation.Util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RetryCount {
    int count() default 0;
}
