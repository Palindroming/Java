The `@Order` annotation in Spring Framework is used to **specify the execution order of components**, particularly in scenarios where the order matters, such as filters, aspects, or when multiple beans of the same type exist.

---

### **Function of `@Order`**
- It **sets the priority** of a component when Spring processes or executes multiple beans of the same type.
- The annotation is typically applied to classes or methods, and it takes an integer value to define the order.

---

### **How It Works**
1. **Lowest Value = Highest Priority**
    - The lower the value of `@Order`, the higher the priority. For example:
        - `@Order(0)` has the **highest priority**.
        - `@Order(1)` has a lower priority than `@Order(0)`.

2. **Default Order**
    - If `@Order` is not specified, the default behavior depends on the specific use case:
        - For filters or aspects: If no `@Order` is defined, the order is **undefined** and may vary.

---

### **Common Use Cases**

#### 1. **With Filters**
In a Spring application, filters process HTTP requests and responses. The `@Order` annotation is used to define the order of execution for multiple filters.

```java
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1) // This filter will execute first
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("First filter executed");
        chain.doFilter(request, response);
    }
}

@Component
@Order(2) // This filter will execute second
public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Second filter executed");
        chain.doFilter(request, response);
    }
}
```

In this example:
- The `FirstFilter` runs before the `SecondFilter` because `@Order(1)` is a lower value than `@Order(2)`.

---

#### 2. **With Aspects**
In Spring AOP (Aspect-Oriented Programming), `@Order` determines the order of execution for multiple aspects.

```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // Executes first
public class LoggingAspect {
    @Before("execution(* com.example.demo.service.*.*(..))")
    public void logBefore() {
        System.out.println("Logging aspect executed");
    }
}

@Aspect
@Component
@Order(2) // Executes second
public class SecurityAspect {
    @Before("execution(* com.example.demo.service.*.*(..))")
    public void checkSecurity() {
        System.out.println("Security aspect executed");
    }
}
```

When a method in `com.example.demo.service` is invoked:
1. The `LoggingAspect` executes first because it has `@Order(1)`.
2. The `SecurityAspect` executes second because it has `@Order(2)`.

---

#### 3. **With Bean Initialization**
When multiple beans of the same type are defined, `@Order` can be used to prioritize their execution during initialization.

```java
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FirstBean {
    public FirstBean() {
        System.out.println("FirstBean initialized");
    }
}

@Component
@Order(2)
public class SecondBean {
    public SecondBean() {
        System.out.println("SecondBean initialized");
    }
}
```

Output during application startup:
```
FirstBean initialized
SecondBean initialized
```

---

### **Where `@Order` Can Be Used**
- **Filters:** Define the order of execution for filters.
- **Aspects:** Control the execution order of aspects in AOP.
- **Beans:** Specify the initialization order of beans when multiple beans of the same type exist.
- **Event Listeners:** Prioritize event listeners when multiple listeners listen for the same event.

---

### **Key Notes**
1. **Value Range:**
    - `@Order` takes an integer value.
    - Negative values (e.g., `@Order(-1)`) can be used for higher priority than `@Order(0)`.

2. **Default Behavior:**
    - Without `@Order`, the order of execution may be **undefined** and could vary depending on the context.

3. **Integration with Other Annotations:**
    - `@Order` works alongside annotations like `@Component`, `@Aspect`, `@Bean`, and `@Filter`.

---

### **Summary**
The `@Order` annotation in Spring is a powerful tool to control the order of execution for components like filters, aspects, beans, and event listeners. By assigning a priority value, it ensures that components execute in a predictable sequence, improving the clarity and control of the application's behavior.