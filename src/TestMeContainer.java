import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by user-2 on 31/8/16.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestMeContainer {
    TestMe [] value();
}
