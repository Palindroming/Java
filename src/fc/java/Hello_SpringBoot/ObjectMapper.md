오브젝트 매퍼(Object Mapper)에 대해 설명하자면, 주로 **Java** 또는 **Spring Framework**에서 사용하는 **객체 변환 도구**입니다. 특히 JSON 데이터와 Java 객체 간의 변환을 편리하게 처리하는 역할을 합니다. 대표적인 구현체로는 **Jackson ObjectMapper**가 있습니다.

### **ObjectMapper란?**
ObjectMapper는 데이터 포맷(예: JSON, XML)을 Java 객체로 변환하거나, 반대로 Java 객체를 특정 포맷의 데이터로 직렬화/역직렬화하는 도구입니다.

#### 주요 기능:
1. **Java 객체를 JSON으로 변환 (Serialization)**  
   Java 객체 → JSON 문자열
2. **JSON을 Java 객체로 변환 (Deserialization)**  
   JSON 문자열 → Java 객체
3. **데이터 타입 간 변환**  
   예: `List<Map<String, Object>>` → `User[]`

---

### **ObjectMapper가 메서드에 적용되는 이유**

ObjectMapper는 **"어떤 데이터의 구조를 객체로 변환하는 역할"**을 하기 때문에, 객체나 변수 자체가 아니라, **"메서드의 입출력 과정"**에서 주로 사용됩니다.

1. **데이터 변환은 동작(로직)의 일부**  
   ObjectMapper는 데이터를 다룰 때, JSON이나 XML 같은 외부 데이터를 Java 객체로 변환하거나, 반대로 객체를 JSON으로 변환해야 할 때 사용됩니다. 이는 주로 데이터를 처리하거나 응답을 생성하는 메서드의 일부 작업으로 포함됩니다.

2. **객체나 변수가 아닌 데이터를 처리해야 하기 때문**  
   ObjectMapper의 주요 책임은 특정 데이터를 변환하는 것이므로, 변환 과정은 메서드 레벨에서 실행됩니다.

#### 예시: 메서드에서의 활용
```java
public User parseUser(String jsonString) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonString, User.class); // JSON → User 객체
}

public String convertToJson(User user) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(user); // User 객체 → JSON 문자열
}
```
---

### **ObjectMapper가 사용되는 곳**
ObjectMapper는 다음과 같은 상황에서 자주 사용됩니다:

#### 1. **REST API 통신**
- 클라이언트가 서버로 데이터를 보낼 때, 객체를 JSON으로 변환해 요청을 보냄
- 서버에서 클라이언트의 JSON 데이터를 Java 객체로 변환해 로직 처리

```java
@RestController
public class UserController {
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody String userJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class); // JSON → User 객체
        // 로직 처리 후 응답
        return ResponseEntity.ok("User created: " + user.getName());
    }
}
```

#### 2. **파일 데이터 읽기/쓰기**
- JSON 파일을 읽어서 객체로 변환하거나, 객체를 JSON 형식으로 파일에 저장

```java
ObjectMapper objectMapper = new ObjectMapper();
User user = new User("Alice", 30);
objectMapper.writeValue(new File("user.json"), user); // 객체 → JSON 파일 저장

User readUser = objectMapper.readValue(new File("user.json"), User.class); // 파일 → 객체
```

#### 3. **외부 API 통합**
- 외부 API에서 전달받은 JSON 데이터를 객체로 변환하거나, 요청 데이터를 JSON 형식으로 변환

#### 4. **테스트 데이터 생성**
- 테스트를 위해 객체를 JSON 문자열로 직렬화하거나, JSON을 객체로 변환해 빠르게 데이터 준비

---

### **ObjectMapper의 장점**
1. **사용이 간단**: 직렬화/역직렬화 메서드 (`writeValueAsString`, `readValue`)를 호출하기만 하면 간단히 변환 가능.
2. **다양한 포맷 지원**: JSON뿐만 아니라 YAML, XML 등 다양한 데이터 포맷을 지원.
3. **유연한 커스터마이징**: 어노테이션(`@JsonProperty`, `@JsonIgnore`, 등)으로 변환 규칙을 쉽게 설정 가능.
4. **대규모 시스템 통합에 적합**: REST API 기반 시스템에서 객체-JSON 변환을 빠르고 안정적으로 처리.

---

### **결론**
ObjectMapper는 JSON과 객체 간의 변환을 쉽게 처리하기 위해 설계된 도구로, 데이터를 다루는 메서드에서 주로 활용됩니다. REST API 통신, 파일 입출력, 외부 API 통합 등 객체와 데이터 포맷 간의 변환이 필요한 다양한 상황에서 필수적으로 사용됩니다.


---
