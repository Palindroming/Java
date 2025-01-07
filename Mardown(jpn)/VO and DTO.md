### **VO（Value Object）とDTO（Data Transfer Object）の違い**

VOとDTOはどちらもオブジェクト指向プログラミングでデータを扱うために使用されますが、その**目的**や**特徴**には明確な違いがあります。

---

## **1. VO（Value Object）**
### **特徴:**
- **値そのものを表現するオブジェクト**。
- 基本的に**不変（Immutable）**で、生成後は値を変更できません。
- 同一性（等価性）は**オブジェクト自体ではなく値**で判断します。つまり、値が同じであれば同じオブジェクトとみなされます。
- 主に**ドメインモデル**（ビジネスロジックの一部）で使用されます。

### **主な目的:**
- 特定のデータや値のグループ化。
- 値を変更できないようにすることで、**データの整合性を保証**します。

### **使用例:**
- **住所**、**金額**、**日付**などの特定の値を表すとき。
- 例えば、「住所」を一つのオブジェクトとしてまとめたい場合。

### **例:**
```java
public class Address {
    private final String street;
    private final String city;
    private final String zipCode;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    // equals と hashCode を値に基づいて定義
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
               city.equals(address.city) &&
               zipCode.equals(address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, zipCode);
    }
}
```

---

## **2. DTO（Data Transfer Object）**
### **特徴:**
- **データを階層間で受け渡すためのオブジェクト**。
- **データの転送**が目的であり、ビジネスロジックは含まれません。
- 通常、**読み取り・書き込み可能**（setter/getter付き）。
- 値そのものではなく、**オブジェクトの参照**が重要。
- ネットワーク通信やAPIリクエスト・レスポンスでよく使用されます。

### **主な目的:**
- データを効率的に転送する。
- コントローラーとサービス、またはAPI間のデータカプセル化。

### **使用例:**
- REST APIリクエスト/レスポンスデータ。
- データベースのクエリ結果をサービスやコントローラーに渡すとき。

### **例:**
```java
public class UserDTO {
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

---

## **主要な違い**

| **項目**              | **VO（Value Object）**                             | **DTO（Data Transfer Object）**                  |
|-----------------------|--------------------------------------------------|-------------------------------------------------|
| **目的**              | 値そのものを表現する                              | 階層間のデータ転送                              |
| **値の変更可能性**     | 不変（Immutable）                                 | 可変（Mutable）                                 |
| **同一性の判断基準**   | 値に基づいて比較（`equals`や`hashCode`を再定義）  | オブジェクトの参照                              |
| **使用場所**          | ドメイン層（ビジネスロジック、モデル設計）          | コントローラー、サービス、DAO                   |
| **ビジネスロジック**   | 含めることができる                                | 含めない                                        |
| **使用例**            | 住所、金額、日付などの値を表現                    | APIリクエスト、データベースクエリ結果の転送     |

---

## **まとめ**
- **VO**は特定の値を表現し、データの整合性を維持するために使用されます。
- **DTO**は階層間で効率的にデータを転送するためのオブジェクトです。

### 覚えるべきポイント:
1. **VOは不変**で、値が等しい場合に等価とみなされます。
2. **DTOは可変**で、データの転送が目的です。