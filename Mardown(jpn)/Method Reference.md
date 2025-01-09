メソッドの参照には、4 つの主要なタイプがあります。

---

### **1. 静的メソッド参照 (Static Method Reference)**

**形式**
```java
クラス名::メソッド名
```

#### **例題**

1. **使用する関数型インターフェース**
   ```java
   @FunctionalInterface
   interface MathOperation {
       int operation(int a, int b);
   }
   ```

2. **静的メソッド定義**
   ```java
   public class Calculator {
       public static int add(int a, int b) {
           return a + b;
       }
   }
   ```

3. **メソッド参照使用**
   ```java
   public class Main {
       public static void main(String[] args) {
           MathOperation addition = Calculator::add; // 메서드 참조
           System.out.println(addition.operation(5, 3)); // 출력: 8
       }
   }
   ```

---

### **2. 特定オブジェクトのインスタンスメソッド参照 (Instance Method Reference of a Particular Object)**

**形式**
```java
オブジェクト参照::メソッド名
```

#### **例題**

1. **使用する関数型インターフェース**
   ```java
   @FunctionalInterface
   interface Printer {
       void print(String message);
   }
   ```

2. **インスタンスメソッド定義**
   ```java
   public class MessagePrinter {
       public void printMessage(String message) {
           System.out.println(message);
       }
   }
   ```

3. **メソッド参照使用**
   ```java
   public class Main {
       public static void main(String[] args) {
           MessagePrinter printer = new MessagePrinter();
           Printer printFunc = printer::printMessage; // 메서드 참조
           printFunc.print("Hello, Method Reference!"); // 출력: Hello, Method Reference！
       }
   }
   ```

---

### **3. 特定クラスのインスタンスメソッド参照 (Instance Method Reference of a Class)**

**形式**
```java
クラス名::メソッド名
```

#### **特徴**
- **最初のパラメータ**がメソッドを呼び出すオブジェクトになります。
- ストリームAPIとともによく使われます。

#### **例題**

1. **使用する関数型インターフェース**
   ```java
   @FunctionalInterface
   interface StringProcessor {
       String process(String str);
   }
   ```

2. **インスタンスメソッド定義**
   ```java
   public class StringUtils {
       public String toUpperCase(String str) {
           return str.toUpperCase();
       }
   }
   ```

3. **メソッド参照使用**
   ```java
   public class Main {
       public static void main(String[] args) {
           StringProcessor processor = String::toUpperCase; // 메서드 참조
           System.out.println(processor.process("hello")); // 출력: HELLO
       }
   }
   ```

---

### **4. 生成者参照(Constructor Reference)**

**形式**
```java
クラス名::new
```

#### **例題**

1. **使用する関数型インターフェース**
   ```java
   @FunctionalInterface
   interface ObjectFactory {
       MyClass create(String value);
   }
   ```

メソッドの参照には、4 つの主要なタイプがあります。

---

### **1. 静的メソッド参照 (Static Method Reference)**

**形式**
```java
クラス名::メソッド名
```

#### **例題**

1. **使用する関数型インターフェース**
   ```java
   @FunctionalInterface
   interface MathOperation {
       int operation(int a, int b);
   }
   ```

2. **静的メソッド定義**
   ```java
   public class Calculator {
       public static int add(int a, int b) {
           return a + b;
       }
   }
   ```

3.