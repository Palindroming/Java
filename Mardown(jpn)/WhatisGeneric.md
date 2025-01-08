
### **ジェネリクス(Generic)とは？**
ジェネリクス(Generic)は、**Javaのコード再利用性と型安全性(type-safety)を向上させる機能**です。  
**コンパイル時にデータ型を指定**することで、不正な型のデータが使用されることを防ぎます。

---

### **ジェネリクスの主な特徴**
1. **型安全性の提供**
   - コンパイル時に型を強制し、実行時エラーを減らします。
   - 不正なデータ型を使用しようとする試みはコンパイルエラーとして検出されます。

2. **コード再利用性の向上**
   - 複数の型に対して同じコードを書く必要がありません。
   - ジェネリクスを使用することで、さまざまな型を1つのコードで処理できます。

3. **キャストの排除**
   - データを使用する際に明示的な型変換(casting)をする必要がありません。

---

### **ジェネリクス使用例**

#### **ジェネリクスを使わないコード:**
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Raw型を使用
        list.add("Hello");
        list.add(123); // 異なる型を追加可能（非推奨）

        for (Object obj : list) {
            String str = (String) obj; // 明示的なキャストが必要
            System.out.println(str);
        }
    }
}
```

- このコードでは、`ArrayList`に文字列と整数を混在して追加するため、実行時に`ClassCastException`が発生する可能性があります。

---

#### **ジェネリクスを使用したコード:**
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); // ジェネリクスを使用
        list.add("Hello");
        // list.add(123); // コンパイルエラー発生（型不一致）

        for (String str : list) {
            System.out.println(str); // キャスト不要
        }
    }
}
```

- ジェネリクスを使用すると、`ArrayList<String>`は**文字列(String)**のみを追加できます。
- 型の不一致による実行時エラーが発生しません。

---

### **ジェネリクスクラス**

#### **ジェネリクスクラスの定義:**
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

#### **ジェネリクスクラスの使用:**
```java
public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem()); // 出力: Hello

        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
        System.out.println(intBox.getItem()); // 出力: 123
    }
}
```

- **`<T>`**: 型パラメータで、使用時に型を指定します。
- 同じクラス`Box`をさまざまな型(String, Integerなど)で利用できます。

---

### **ジェネリクスメソッド**

#### **ジェネリクスメソッドの定義:**
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

#### **ジェネリクスメソッドの使用:**
```java
public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"A", "B", "C"};
        Integer[] intArray = {1, 2, 3};

        GenericMethodExample.printArray(stringArray); // 出力: A B C
        GenericMethodExample.printArray(intArray);    // 出力: 1 2 3
    }
}
```

- **`<T>`**はメソッドレベルでのみ有効な型パラメータです。

---

### **ジェネリクスインターフェース**

#### **ジェネリクスインターフェースの定義:**
```java
public interface Pair<K, V> {
    K getKey();
    V getValue();
}
```

#### **ジェネリクスインターフェースの実装:**
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

#### **使用例:**
```java
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new KeyValue<>("Age", 30);
        System.out.println(pair.getKey() + ": " + pair.getValue()); // 出力: Age: 30
    }
}
```

---

### **ジェネリクスの制限 (Bounded Type Parameters)**

#### **親クラス/インターフェースで制限:**
```java
public class NumberBox<T extends Number> { // TはNumberまたはそのサブクラスである必要がある
    private T number;

    public void setNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }
}
```

#### **使用例:**
```java
NumberBox<Integer> intBox = new NumberBox<>();
intBox.setNumber(100);

NumberBox<Double> doubleBox = new NumberBox<>();
doubleBox.setNumber(3.14);

// NumberBox<String> stringBox = new NumberBox<>(); // コンパイルエラー (StringはNumberのサブクラスではない)
```

---

### **ワイルドカード (Wildcard)**

#### **`?` ワイルドカードの使用:**
- **`?`**: ジェネリクスタイプの不特定性を示します。

```java
public static void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

#### **ワイルドカードの制限:**
- **`? extends Type`**: `Type`およびそのサブタイプのみ許可。
- **`? super Type`**: `Type`およびそのスーパークラスのみ許可。

```java
public static void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num);
    }
}
```

---

### **ジェネリクスの利点**
1. **型安全性**: コンパイル時に型エラーを防止。
2. **キャストの排除**: 明示的な型変換が不要。
3. **コード再利用性**: 多様な型に対して同じコードを再利用可能。

ジェネリクスは、**安全で柔軟なコード**を作成するための強力なツールです。これにより、型関連のエラーを減らし、コードの可読性と保守性を向上させます。


