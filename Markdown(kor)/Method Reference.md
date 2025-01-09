
메서드 참조에는 4가지 주요 유형이 있습니다.

---

### **1. 정적 메서드 참조 (Static Method Reference)**

**형식**
```java
클래스이름::메서드이름
```

#### **예제**

1. **사용할 함수형 인터페이스**
   ```java
   @FunctionalInterface
   interface MathOperation {
       int operation(int a, int b);
   }
   ```

2. **정적 메서드 정의**
   ```java
   public class Calculator {
       public static int add(int a, int b) {
           return a + b;
       }
   }
   ```

3. **메서드 참조 사용**
   ```java
   public class Main {
       public static void main(String[] args) {
           MathOperation addition = Calculator::add; // 메서드 참조
           System.out.println(addition.operation(5, 3)); // 출력: 8
       }
   }
   ```

---

### **2. 특정 객체의 인스턴스 메서드 참조 (Instance Method Reference of a Particular Object)**

**형식**
```java
객체참조::메서드이름
```

#### **예제**

1. **사용할 함수형 인터페이스**
   ```java
   @FunctionalInterface
   interface Printer {
       void print(String message);
   }
   ```

2. **인스턴스 메서드 정의**
   ```java
   public class MessagePrinter {
       public void printMessage(String message) {
           System.out.println(message);
       }
   }
   ```

3. **메서드 참조 사용**
   ```java
   public class Main {
       public static void main(String[] args) {
           MessagePrinter printer = new MessagePrinter();
           Printer printFunc = printer::printMessage; // 메서드 참조
           printFunc.print("Hello, Method Reference!"); // 출력: Hello, Method Reference!
       }
   }
   ```

---

### **3. 특정 클래스의 인스턴스 메서드 참조 (Instance Method Reference of a Class)**

**형식**
```java
클래스이름::메서드이름
```

#### **특징**
- **첫 번째 매개변수**가 메서드를 호출하는 객체가 됩니다.
- 스트림 API와 함께 자주 사용됩니다.

#### **예제**

1. **사용할 함수형 인터페이스**
   ```java
   @FunctionalInterface
   interface StringProcessor {
       String process(String str);
   }
   ```

2. **인스턴스 메서드 정의**
   ```java
   public class StringUtils {
       public String toUpperCase(String str) {
           return str.toUpperCase();
       }
   }
   ```

3. **메서드 참조 사용**
   ```java
   public class Main {
       public static void main(String[] args) {
           StringProcessor processor = String::toUpperCase; // 메서드 참조
           System.out.println(processor.process("hello")); // 출력: HELLO
       }
   }
   ```

---

### **4. 생성자 참조 (Constructor Reference)**

**형식**
```java
클래스이름::new
```

#### **예제**

1. **사용할 함수형 인터페이스**
   ```java
   @FunctionalInterface
   interface ObjectFactory {
       MyClass create(String value);
   }
   ```

2. **클래스 정의**
   ```java
   public class MyClass {
       private String value;

       public MyClass(String value) {
           this.value = value;
       }

       @Override
       public String toString() {
           return "MyClass{" +
                   "value='" + value + '\'' +
                   '}';
       }
   }
   ```

3. **생성자 참조 사용**
   ```java
   public class Main {
       public static void main(String[] args) {
           ObjectFactory factory = MyClass::new; // 생성자 참조
           MyClass myObject = factory.create("Hello, Constructor!");
           System.out.println(myObject); // 출력: MyClass{value='Hello, Constructor!'}
       }
   }
   ```

---

### **요약**

| 유형                                  | 형식                           | 설명                                                              |
|---------------------------------------|--------------------------------|-------------------------------------------------------------------|
| **정적 메서드 참조**                 | `클래스이름::메서드이름`       | 정적 메서드를 참조합니다.                                          |
| **특정 객체의 인스턴스 메서드 참조** | `객체참조::메서드이름`         | 특정 객체의 인스턴스 메서드를 참조합니다.                          |
| **특정 클래스의 인스턴스 메서드 참조**| `클래스이름::메서드이름`       | 첫 번째 매개변수로 객체를 받아 해당 객체의 메서드를 호출합니다.      |
| **생성자 참조**                      | `클래스이름::new`              | 생성자를 참조하여 객체를 생성합니다.                               |

---

### **장점**
- 코드가 더 간결하고 읽기 쉬움.
- 재사용 가능한 기존 메서드를 직접 참조하여 명시적 구현 필요 없음.
- 람다 표현식보다 간결하고 중복 코드 제거에 유리.

---

이 4가지 방법은 자바의 함수형 프로그래밍 스타일을 더욱 직관적으로 사용할 수 있게 도와줍니다.