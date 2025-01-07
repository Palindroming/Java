VO(Value Object)와 DTO(Data Transfer Object)는 둘 다 객체 지향 프로그래밍에서 데이터를 담는 데 사용되는 객체지만, 사용 목적과 특징에서 차이가 있습니다.

---

## **1. VO (Value Object)**
### **특징:**
- **값**을 표현하는 객체로, 주로 **불변(immutable)** 속성을 가집니다.
- 값 자체를 비교하여 동일성을 판단합니다. 즉, **값이 같으면 같은 객체**로 간주합니다.
- 생성 후 값이 바뀌지 않으며, 객체 자체는 재사용될 수 있습니다.
- 도메인 모델 설계에 사용됩니다.

### **주요 목적:**
- 특정 데이터의 속성을 그룹화하거나 **비즈니스 로직에서 의미 있는 값을 표현**합니다.
- 값을 변경할 수 없도록 하여 **데이터 무결성을 보장**합니다.

### **사용 예:**
- 금융 애플리케이션에서 **금액**, **날짜**, **주소**, **전화번호**와 같은 값 표현.
- 예를 들어, "주소"라는 값을 `Address` 객체로 그룹화하여 사용하는 경우.

### **예제:**
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

    // equals와 hashCode는 값을 기준으로 비교
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

## **2. DTO (Data Transfer Object)**
### **특징:**
- 데이터를 **계층 간(Controller → Service → DAO)** 전달하기 위해 사용되는 객체.
- **데이터 전송**만을 목적으로 하며, **비즈니스 로직을 포함하지 않음**.
- 주로 **읽기/쓰기 가능한 속성**(setter/getter)을 가지고 있습니다.
- 값의 동일성보다는 **객체의 동일성**(참조)이 중요합니다.
- 네트워크나 API 호출 시 데이터 전달용으로 사용됩니다.

### **주요 목적:**
- 데이터를 효율적으로 전달하기 위해 사용됩니다.
- 컨트롤러와 서비스, 또는 API 요청/응답 시 데이터 캡슐화.

### **사용 예:**
- REST API의 요청/응답 데이터, 데이터베이스 조회 결과 전달.

### **예제:**
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

## **주요 차이점**

| **구분**            | **VO (Value Object)**                                     | **DTO (Data Transfer Object)**                           |
|---------------------|----------------------------------------------------------|--------------------------------------------------------|
| **주요 목적**        | 값을 표현하고 데이터 무결성 보장                          | 계층 간 데이터 전송                                    |
| **값의 변경 여부**   | 불변 (Immutable)                                         | 가변 (Mutable)                                         |
| **동일성 판단 기준** | 값 자체를 기준으로 비교 (`equals`와 `hashCode` 재정의 필요) | 객체의 참조로 비교                                     |
| **사용 위치**        | 도메인 계층 (비즈니스 로직, 모델 설계)                     | 컨트롤러, 서비스, DAO 간 데이터 전달                   |
| **비즈니스 로직**    | 포함 가능                                                | 포함하지 않음                                           |
| **예제 용도**        | 주소, 날짜, 금액 등의 값 표현                             | API 요청/응답, 데이터베이스 조회 결과 전달              |

---

## **정리**
- **VO**는 도메인 계층에서 **값을 표현**하고 데이터의 무결성을 유지하는 데 사용됩니다.
- **DTO**는 계층 간 또는 네트워크 간 **데이터 전달**을 목적으로 사용됩니다.

### 기억할 점:
- **VO는 불변**적이고, **DTO는 가변**적이라는 것이 큰 차이입니다.
- VO는 값을 중심으로 설계되고, DTO는 데이터를 효율적으로 전달하기 위해 설계됩니다.