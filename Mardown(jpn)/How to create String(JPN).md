Javaでは、`String`オブジェクトを作成する方法には主に以下の2つがあります。

1. `String str = "Hello world";`
2. `String str = new String("Hello world");`

これらの違いについて説明します。

---

### **1. `String str = "Hello world";`**
- **動作方法:**
  - **文字列リテラル**を使用して文字列を作成します。
  - この文字列は**String Pool**（ヒープメモリ内の特別な領域）に格納されます。
  - 同じ値の文字列リテラルがすでにString Poolに存在する場合、その既存の参照を再利用します。
  - 新しいオブジェクトを作成する必要がないため、効率的です。

- **特徴:**
  - **メモリ効率が高い**：同じ文字列リテラルが複数回作成されることを防ぎます。
  - **パフォーマンスが良い**：既存のオブジェクトを再利用するため、無駄な処理を避けます。

- **例:**
  ```java
  String str1 = "Hello world";
  String str2 = "Hello world";
  System.out.println(str1 == str2); // true (同じ参照を持つ)
  ```

---

### **2. `String str = new String("Hello world");`**
- **動作方法:**
  - `new`キーワードを使用して、新しい`String`オブジェクトを明示的に作成します。
  - この場合、**String Poolを確認せず**に、ヒープメモリ内に**必ず新しいオブジェクト**を作成します。
  - 同じ文字列の値であっても、異なるオブジェクトとして扱われます。

- **特徴:**
  - **メモリ効率が低い**：不要なオブジェクトを作成します。
  - **特別な場合**を除いて使用されません。

- **例:**
  ```java
  String str1 = new String("Hello world");
  String str2 = new String("Hello world");
  System.out.println(str1 == str2); // false (異なるオブジェクトを指す)
  ```

---

### **まとめ**

| **属性**                   | `String str = "Hello world";`              | `String str = new String("Hello world");`  |
|---------------------------|-------------------------------------------|-------------------------------------------|
| **メモリの場所**            | String Pool                               | ヒープメモリ                                |
| **オブジェクトの生成方法**   | 既存のオブジェクトを再利用（重複なし）      | 必ず新しいオブジェクトを生成               |
| **メモリの使用効率**         | 効率的                                    | 非効率的                                   |
| **参照の比較 (`==`)**        | 同じリテラル値は同じ参照                  | 新しいオブジェクトは異なる参照             |
| **一般的な使用ケース**       | 推奨（よく使用される）                    | 特別な場合のみ使用                         |

---

### **注意点**
文字列を比較する際には、値を正確に比較するために**`==`ではなく`equals()`を使用**する必要があります。

```java
String str1 = "Hello world";
String str2 = new String("Hello world");
System.out.println(str1 == str2);          // false（参照が異なる）
System.out.println(str1.equals(str2));    // true（値が同じ）
```