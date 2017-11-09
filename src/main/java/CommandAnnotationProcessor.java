import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class CommandAnnotationProcessor implements BeanPostProcessor {

    private ConfigurableListableBeanFactory configurableListableBeanFactory;

    @Autowired
    public CommandAnnotationProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.configurableListableBeanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        this.scanDataAccessAnnotation(bean, beanName);
        return bean;
    }

    private void scanDataAccessAnnotation(Object bean, String beanName) {
        this.configureFieldInjection(bean);
    }

    private void configureFieldInjection(Object bean) {
        Class<?> managedBeanClass = bean.getClass();
        ReflectionUtils.FieldCallback fieldCallback = new ShellCommandNameCallback(configurableListableBeanFactory, bean);
        ReflectionUtils.doWithFields(managedBeanClass, fieldCallback);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
