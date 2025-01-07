### **제네릭(Generic)이란?**
제네릭(Generic)은 **자바의 코드 재사용성과 타입 안전성(type-safety)을 향상시키기 위한 기능**입니다. **컴파일 시점에 데이터 타입을 지정**함으로써, 잘못된 타입의 데이터가 사용되는 것을 방지합니다.

---

### **제네릭의 주요 특징**
1. **타입 안전성 제공**
    - 컴파일 시점에 타입을 강제하여 런타임 에러를 줄입니다.
    - 잘못된 데이터 타입을 사용하려는 시도는 컴파일 오류로 감지됩니다.

2. **코드 재사용성 향상**
    - 여러 타입에 대해 동일한 코드를 작성하지 않아도 됩니다.
    - 제네릭을 사용하면 다양한 타입을 하나의 코드로 처리할 수 있습니다.

3. **캐스팅 제거**
    - 데이터를 사용할 때 명시적으로 형 변환(casting)을 할 필요가 없습니다.

---

### **제네릭 사용 예제**

#### **제네릭 없는 코드:**
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Raw 타입 사용
        list.add("Hello");
        list.add(123); // 다른 타입 추가 가능 (비추천)

        for (Object obj : list) {
            String str = (String) obj; // 명시적 캐스팅 필요
            System.out.println(str);
        }
    }
}
```

- 위 코드에서는 `ArrayList`에 문자열과 정수를 혼합하여 추가했기 때문에, 런타임에서 `ClassCastException`이 발생할 수 있습니다.

---

#### **제네릭을 사용한 코드:**
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); // 제네릭 사용
        list.add("Hello");
        // list.add(123); // 컴파일 에러 발생 (타입 불일치)

        for (String str : list) {
            System.out.println(str); // 캐스팅 불필요
        }
    }
}
```

- 제네릭을 사용하면 `ArrayList<String>`은 **문자열(String)**만 추가할 수 있습니다.
- 타입 불일치로 인한 런타임 에러가 발생하지 않습니다.

---

### **제네릭 클래스**

#### **제네릭 클래스 정의:**
```java
public class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
```

#### **제네릭 클래스 사용:**
```java
public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem()); // 출력: Hello

        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
        System.out.println(intBox.getItem()); // 출력: 123
    }
}
```

- **`<T>`**: 타입 매개변수로, 사용할 때 타입을 지정합니다.
- 동일한 클래스 `Box`를 다양한 타입(String, Integer 등)으로 사용할 수 있습니다.

---

### **제네릭 메서드**

#### **제네릭 메서드 정의:**
```java
public class GenericMethodExample {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
```

#### **제네릭 메서드 사용:**
```java
public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"A", "B", "C"};
        Integer[] intArray = {1, 2, 3};

        GenericMethodExample.printArray(stringArray); // 출력: A B C
        GenericMethodExample.printArray(intArray);    // 출력: 1 2 3
    }
}
```

- **`<T>`**는 메서드 레벨에서만 유효한 타입 매개변수입니다.

---

### **제네릭 인터페이스**

#### **제네릭 인터페이스 정의:**
```java
public interface Pair<K, V> {
    K getKey();
    V getValue();
}
```

#### **제네릭 인터페이스 구현:**
```java
public class KeyValue<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
```

#### **사용 예:**
```java
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new KeyValue<>("Age", 30);
        System.out.println(pair.getKey() + ": " + pair.getValue()); // 출력: Age: 30
    }
}
```

---

### **제네릭의 제한 (Bounded Type Parameters)**

#### **상위 클래스/인터페이스로 제한:**
```java
public class NumberBox<T extends Number> { // T는 Number 또는 하위 클래스여야 함
    private T number;

    public void setNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }
}
```

#### **사용 예:**
```java
NumberBox<Integer> intBox = new NumberBox<>();
intBox.setNumber(100);

NumberBox<Double> doubleBox = new NumberBox<>();
doubleBox.setNumber(3.14);

// NumberBox<String> stringBox = new NumberBox<>(); // 컴파일 에러 (String은 Number의 하위 클래스가 아님)
```

---

### **와일드카드 (Wildcard)**

#### **`?` 와일드카드 사용:**
- **`?`**: 제네릭 타입의 불특정성을 나타냅니다.

```java
public static void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

#### **와일드카드 제한:**
- **`? extends Type`**: `Type` 및 그 하위 타입만 허용.
- **`? super Type`**: `Type` 및 그 상위 타입만 허용.

```java
public static void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num);
    }
}
```

---

### **제네릭의 장점**
1. **타입 안정성**: 컴파일 시점에 타입 오류를 방지.
2. **캐스팅 제거**: 명시적 형 변환이 불필요.
3. **코드 재사용성**: 다양한 타입에 대해 동일한 코드를 재사용 가능.

용 가능한 코드**를 작성하기 위한 강력한 도구입니다. 이를 통해 타입 관련 오류를 줄이고, 코드 가독성과 유지보수성을 높일 수 있습니다.