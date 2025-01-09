### **匿名クラス(Anonymous Class)とは？**

匿名クラスは名前のないクラスです。 通常、インターフェイスや抽象クラスを実装する必要がある場合、1 回だけ使用されるクラスのインスタンスを作成するために使用されます。

- 匿名クラスは、**`new`キーワードの後に作成されたインターフェースやクラスに基づいて新しいクラスをその場で定義し、インスタンスを作成**します。
- インターフェイスを実装したり、抽象クラスを拡張したりできますが、クラス自体に名前がないため、他の場所で再利用することはできません。

---

### **コード分析**

```java
MathOperation mo = new MathOperation() {
@Override
public int operation(int x, int y) {
return x * y;
}
};
```

#### 1. **匿名クラス定義**
- 「new MathOperation()」部分で匿名クラスが作成されます。
- この匿名クラスは、「MathOperation」インターフェイスを実装します。
- 「@Override」キーワードで「MathOperation」の抽象メソッド「operation(intx、inty)」を実装します。

#### 2. **即席でオブジェクト生成**
- 匿名クラスは、生成と同時にオブジェクトが作成されます。
- オブジェクトは 'mo' という変数に割り当てられます。

#### 3.**`implements`宣言が要らない理由**
- 「implements」は、**クラスがインターフェースを実装する場合、クラスレベルで宣言**しなければなりません。
- しかし、匿名クラスは**オブジェクト生成時にインターフェースを直接具現**するため、クラス宣言部に'implements'が必要ありません。

---

### **匿名クラス vs。 `implements`**

#### **一般的な 'implements' 方式**
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

- 「FunctionalInterfaceTest」は明示的に「MathOperation」インターフェースを実装。
- クラス全体でこの実装を再利用可能。

#### **匿名クラス方式**
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

- 匿名クラスは、コード作成時点で即座に生成される。
- 再使用不可能（一度だけ使用される実装体に適合）。

---

### **匿名クラス使用の長所と短所**

#### **長所**
1. **簡潔**:一度だけ使用するクラスの実装体を別途作成しなくてもいい。
2. **即時定義と使用**:実装体を宣言と同時に使用できるため、コードがより直観的。

#### **短所**
1. **再使用不可**:匿名クラスは一度だけ使用できるため、同じ実装が必要な場合は、新たに定義する必要があります。
2. **複雑性増加**: コードが長くなると可読性が落ちる可能性がある。

---

### どんな状況で使うのか？**

- **匿名クラス**はインターフェースを実装するか抽象クラスを拡張する必要がありますが、一度だけ使用する場合に適しています。
- 例:
- イベント処理 ('Action Listener')
- コールバックメソッド実装
- 簡単なデータ変換ロジック

---

### **まとめ**

このコードで「implements」が必要でない理由は、**匿名クラス**を使用してインターフェースをその場で具現したからです。 クラス宣言部に「implements」を付ける方式は、特定のクラスで当該インタフェースを継続的に実装するときに使用されます。 一方、匿名クラスは、一度だけ使用される実装体を定義するときに簡単に使用できます。