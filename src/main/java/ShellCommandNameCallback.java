import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class ShellCommandNameCallback implements ReflectionUtils.FieldCallback {

    public ShellCommandNameCallback(ConfigurableListableBeanFactory configurableListableBeanFactory, Object bean) {

    }

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {

    }
}
