Java에서 `String` 객체를 생성하는 두 가지 방식, `String str = "Hello world";`와 `String str = new String("Hello world");`의 차이점은 주로 **메모리 관리**와 **성능** 측면에서 나타납니다.

---

### 1. **String str = "Hello world";**
- **동작 방식:**
    - 문자열 리터럴 방식으로 생성됩니다.
    - 문자열이 **String Pool**(힙 메모리의 특별한 영역)에 저장됩니다.
    - 동일한 값의 문자열 리터럴이 이미 String Pool에 존재하면, 해당 참조를 재사용합니다.
    - 따라서, **중복된 문자열 객체가 생성되지 않습니다.**

- **특징:**
    - 메모리 효율적.
    - 성능이 더 좋음 (기존 객체를 재사용하므로).

- **예제:**
  ```java
  String str1 = "Hello world";
  String str2 = "Hello world";
  System.out.println(str1 == str2); // true (참조가 동일함)
  ```

---

### 2. **String str = new String("Hello world");**
- **동작 방식:**
    - `new` 키워드를 사용해 명시적으로 새로운 `String` 객체를 힙 메모리에 생성합니다.
    - **String Pool을 확인하지 않고, 무조건 새로운 객체를 생성합니다.**
    - 이로 인해 동일한 값이라도 중복된 객체가 존재할 수 있습니다.

- **특징:**
    - 메모리 비효율적 (불필요한 객체 생성).
    - 일반적으로 사용하지 않는 방식 (특수한 경우 제외).

- **예제:**
  ```java
  String str1 = new String("Hello world");
  String str2 = new String("Hello world");
  System.out.println(str1 == str2); // false (참조가 다름)
  ```

---

### **정리**
| 속성                            | `String str = "Hello world";`              | `String str = new String("Hello world");`  |
|---------------------------------|-------------------------------------------|-------------------------------------------|
| **메모리 위치**                 | String Pool                               | 힙 메모리                                 |
| **객체 생성 방식**              | 기존 객체를 재사용 (중복 방지)             | 항상 새로운 객체 생성                     |
| **메모리 사용**                 | 효율적                                    | 비효율적                                  |
| **참조 비교 (`==`)**            | 동일한 리터럴 값은 같은 참조를 가짐       | 새로운 객체는 참조가 다름                 |
| **일반적인 사용 사례**           | 추천 (자주 사용됨)                        | 특별한 경우에만 사용                      |

### **주의 사항**
- 문자열을 비교할 때는 **`==` 대신 `equals()`를 사용**해야 정확한 값 비교가 가능합니다.
  ```java
  String str1 = "Hello world";
  String str2 = new String("Hello world");
  System.out.println(str1 == str2);          // false
  System.out.println(str1.equals(str2));    // true
  ```