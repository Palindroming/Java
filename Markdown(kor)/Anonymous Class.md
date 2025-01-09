
### **익명 클래스(Anonymous Class)란?**

익명 클래스는 이름이 없는 클래스입니다. 일반적으로 인터페이스나 추상 클래스를 구현해야 할 때, 단 한 번만 사용되는 클래스의 인스턴스를 생성하는 데 사용됩니다.

- 익명 클래스는 **`new` 키워드 뒤에 작성된 인터페이스나 클래스를 기반으로 새로운 클래스를 즉석에서 정의하고 인스턴스를 생성**합니다.
- 인터페이스를 구현하거나 추상 클래스를 확장할 수 있지만, 클래스 자체의 이름이 없으므로 다른 곳에서 재사용할 수 없습니다.

---

### **코드 분석**

```java
MathOperation mo = new MathOperation() {
    @Override
    public int operation(int x, int y) {
        return x * y;
    }
};
```

#### 1. **익명 클래스 정의**
- `new MathOperation()` 부분에서 익명 클래스가 생성됩니다.
- 이 익명 클래스는 `MathOperation` 인터페이스를 구현합니다.
- `@Override` 키워드로 `MathOperation`의 추상 메서드 `operation(int x, int y)`를 구현합니다.

#### 2. **즉석에서 객체 생성**
- 익명 클래스는 생성과 동시에 객체가 만들어집니다.
- 객체는 `mo`라는 변수에 할당됩니다.

#### 3. **`implements` 선언이 필요 없는 이유**
- `implements`는 **클래스가 인터페이스를 구현하는 경우 클래스 수준에서 선언**해야 합니다.
- 하지만 익명 클래스는 **객체 생성 시에 인터페이스를 직접 구현**하기 때문에 클래스 선언부에 `implements`가 필요하지 않습니다.

---

### **익명 클래스 vs. `implements`**

#### **일반적인 `implements` 방식**
```java
public class FunctionalInterfaceTest implements MathOperation {
    @Override
    public int operation(int x, int y) {
        return x * y;
    }

    public static void main(String[] args) {
        MathOperation mo = new FunctionalInterfaceTest();
        System.out.println(mo.operation(2, 5)); // 10
    }
}
```

- `FunctionalInterfaceTest`는 명시적으로 `MathOperation` 인터페이스를 구현.
- 클래스 전체에서 이 구현을 재사용 가능.

#### **익명 클래스 방식**
```java
public class FunctionalInterfaceTest2 {
    public static void main(String[] args) {
        MathOperation mo = new MathOperation() {
            @Override
            public int operation(int x, int y) {
                return x * y;
            }
        };
        System.out.println(mo.operation(2, 5)); // 10
    }
}
```

- 익명 클래스는 코드 작성 시점에 즉석에서 생성됨.
- 재사용 불가능(한 번만 사용될 구현체에 적합).

---

### **익명 클래스 사용의 장단점**

#### **장점**
1. **간결함**: 한 번만 사용할 클래스의 구현체를 별도로 작성하지 않아도 됨.
2. **즉시 정의와 사용**: 구현체를 선언과 동시에 사용할 수 있어 코드가 더 직관적.

#### **단점**
1. **재사용 불가**: 익명 클래스는 한 번만 사용할 수 있으므로, 동일한 구현이 필요하면 새로 정의해야 함.
2. **복잡성 증가**: 코드가 길어지면 가독성이 떨어질 수 있음.

---

### **어떤 상황에서 사용하는가?**

- **익명 클래스**는 인터페이스를 구현하거나 추상 클래스를 확장해야 하지만, 한 번만 사용하는 경우 적합합니다.
- 예:
    - 이벤트 처리 (`ActionListener`)
    - 콜백 메서드 구현
    - 간단한 데이터 변환 로직

---

### **정리**

이 코드에서 `implements`가 필요하지 않은 이유는, **익명 클래스**를 사용하여 인터페이스를 즉석에서 구현했기 때문입니다. 클래스 선언부에 `implements`를 붙이는 방식은 특정 클래스에서 해당 인터페이스를 지속적으로 구현할 때 사용됩니다. 반면, 익명 클래스는 한 번만 사용될 구현체를 정의할 때 간단히 사용할 수 있습니다.