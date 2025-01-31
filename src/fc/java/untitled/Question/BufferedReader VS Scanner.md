**`BufferedReader`와 `Scanner`**는 둘 다 **Java에서 입력을 읽는 데 사용**되는 클래스이지만, **목적**, **성능**, **사용 편의성**에서 차이가 있습니다. 각각의 특징과 사용 사례를 살펴보겠습니다.

---

### **1. BufferedReader**
#### **특징**
- **클래스 위치:** `java.io.BufferedReader`
- **목적:**
    - 주로 **문자 단위 입력**을 처리하기 위해 사용됩니다.
    - **대량의 데이터**를 효율적으로 읽기 위해 버퍼를 사용합니다.
- **주요 메서드:**
    - `readLine()`: 한 줄씩 데이터를 읽어옵니다.
    - `read()`: 문자 하나를 읽어옵니다.
- **필요한 입력 스트림:**
    - `BufferedReader`는 `InputStreamReader`나 다른 `Reader`와 함께 사용됩니다.
      ```java
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      ```

#### **장점**
1. **빠른 속도:**
    - 버퍼링을 사용하여 데이터를 처리하므로, 속도가 상대적으로 빠릅니다.
    - 특히, 대량의 데이터 입력에 적합합니다.
2. **단순성:**
    - 한 번에 **한 줄**씩 읽어오기 때문에 문자열 입력 처리에 적합합니다.

#### **단점**
1. **데이터 파싱 어려움:**
    - 기본적으로 문자열만 읽어오기 때문에, 숫자나 기타 데이터 타입으로 변환하려면 추가 작업이 필요합니다.
      ```java
      int number = Integer.parseInt(br.readLine());
      ```

#### **사용 예시**
```java
import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        String name = br.readLine(); // 한 줄 입력받기
        System.out.println("Hello, " + name + "!");
    }
}
```

---

### **2. Scanner**
#### **특징**
- **클래스 위치:** `java.util.Scanner`
- **목적:**
    - 데이터를 **파싱**하는 데 적합하며, 숫자, 문자열, 특정 패턴 등 다양한 형식의 입력을 쉽게 처리할 수 있습니다.
- **주요 메서드:**
    - `next()`: 공백을 기준으로 하나의 토큰을 읽어옵니다.
    - `nextLine()`: 한 줄의 입력을 읽어옵니다.
    - `nextInt()`, `nextDouble()`: 정수 또는 실수 데이터를 읽어옵니다.
- **필요한 입력 스트림:**
    - `Scanner`는 `System.in`과 바로 연결해서 사용할 수 있습니다.
      ```java
      Scanner scanner = new Scanner(System.in);
      ```

#### **장점**
1. **다양한 데이터 처리:**
    - 정수, 실수, 문자열 등 다양한 데이터 타입을 읽어올 수 있습니다.
    - 파싱 작업이 내장되어 있어 추가 변환 코드가 필요 없습니다.
2. **간편한 사용:**
    - 특정 데이터 타입이나 패턴을 쉽게 처리할 수 있습니다.
    - 예: 공백을 기준으로 단어를 읽어오거나, 숫자를 바로 읽어올 수 있음.

#### **단점**
1. **속도:**
    - `BufferedReader`보다 상대적으로 느립니다.
    - 대량의 데이터 입력 처리에는 적합하지 않습니다.
2. **버그 발생 가능성:**
    - `nextInt()`와 `nextLine()`을 함께 사용할 경우 입력 버퍼 문제가 발생할 수 있습니다.
        - 해결: `nextLine()`을 호출하여 남아 있는 버퍼를 비우는 작업이 필요합니다.

#### **사용 예시**
```java
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // 정수 입력받기
        scanner.nextLine(); // 버퍼 비우기
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // 문자열 입력받기
        System.out.println("Hello, " + name + ". You are " + age + " years old.");
    }
}
```

---

### **BufferedReader와 Scanner의 차이점**

| **특징**               | **BufferedReader**                         | **Scanner**                                  |
|------------------------|--------------------------------------------|---------------------------------------------|
| **속도**              | 더 빠름 (버퍼 사용)                         | 느림 (데이터 파싱에 시간이 소요됨)            |
| **입력 처리 단위**      | **문자열 단위** (라인 또는 문자)              | **토큰 단위** (숫자, 문자열 등 자동 파싱 가능) |
| **데이터 타입 지원**     | 문자열 입력만 지원, 추가 변환 필요             | 다양한 데이터 타입(숫자, 실수, 문자열 등) 바로 지원 |
| **복잡한 파싱**         | 추가 작업 필요                              | 내장 파싱 기능으로 간단히 처리 가능             |
| **사용 편의성**         | 상대적으로 복잡 (추가 스트림 필요)             | 간단 (바로 사용 가능)                         |
| **대량 데이터 처리**     | 적합                                      | 부적합                                       |
| **주요 사용 사례**       | 파일 읽기, 대량 입력 처리                     | 사용자 입력 파싱 및 간단한 입력 작업             |

---

### **결론: 언제 어떤 것을 사용할까?**

1. **`BufferedReader`를 사용할 때:**
    - 대량의 데이터를 효율적으로 읽어야 할 때.
    - 파일 입력이나 네트워크 입력과 같이 라인 단위로 데이터를 처리해야 할 때.
    - 입력 데이터를 문자열로 읽어온 뒤, 별도로 가공하거나 파싱할 필요가 있을 때.

2. **`Scanner`를 사용할 때:**
    - 사용자 입력을 처리하거나, 다양한 데이터 타입(숫자, 문자열 등)을 바로 사용해야 할 때.
    - 간단한 입력과 데이터 파싱 작업을 빠르게 구현하고 싶을 때.

---

### **실제로 두 가지를 혼합해서 사용할 수 있을까?**
- 가능하지만 권장되지 않습니다. 두 클래스는 서로 다른 입력 처리 방식을 가지므로 혼합 사용 시 데이터 처리 순서에 따라 예상치 못한 동작이 발생할 수 있습니다.
- 프로젝트에서 한 가지 방식을 일관되게 사용하는 것이 좋습니다.