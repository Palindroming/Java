### **🔹 Why Does `UserRepository` Extend `JpaRepository` Instead of Implementing It?**
In Java, **interfaces extend interfaces**, while **classes implement interfaces**.

`JpaRepository` is an **interface**, and **you are extending it, not implementing it**.

📌 **Your Code:**
```java
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
```
✅ **This is correct** because `JpaRepository` is an interface, and `UserRepository` **inherits** its methods.

---

## **🔹 What Happens If You Use `implements` Instead?**
If you try:
```java
public interface UserRepository implements JpaRepository<User, Long> {
}
```
🚨 **Compiler Error:**
```
"Interface cannot implement another interface."
```
💡 **Why?**
- **Interfaces cannot implement other interfaces** because they do not contain method implementations.
- `implements` is used by **classes** to provide implementations for interface methods.

✅ Instead, you should **extend** `JpaRepository` since it's also an interface.

---

## **🔹 How Spring Boot Handles It Automatically**
Normally, when you extend `JpaRepository`, Spring Boot automatically creates the **implementation** for you at runtime.

```java
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
```
💡 **Spring Boot will generate an implementation of `UserRepository` behind the scenes.**
- You don't need to manually write an implementation.
- Just autowire and use it:
```java
@Autowired
private UserRepository userRepository;
```

---

## **🔹 When Do You Use `implements`?**
If you want to **manually implement** the repository, you need to **create a class**:

```java
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                            .setParameter("username", username)
                            .getSingleResult();
    }
}
```
❌ **This is unnecessary in most cases**, since Spring Boot already provides `JpaRepository`.

---

## **🚀 Summary**
| **Keyword**  | **Used With**  | **Explanation** |
|-------------|---------------|----------------|
| `extends`   | **Interface to Interface** | Inherits methods from another interface (e.g., `JpaRepository`). |
| `implements` | **Class to Interface** | Provides method implementations for an interface. |

✅ Use `extends` for `JpaRepository` in `UserRepository`.  
❌ **Don't** use `implements` because interfaces **cannot implement other interfaces**.

Now you understand why **`extends JpaRepository` is correct!** 🚀🔥