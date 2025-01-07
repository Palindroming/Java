
# 자바 컬렉션 프레임워크란?

- 자바 컬렉션 프레임워크(Collection Framework)API는 자바에서 제공하는 데이터 구조인 컬렉션을 표현하는 인터페이스와 클래스의 모음
  - wrapper class
  - 숫자와 문자열의 상호 변환
  - collection framework api란
  - 순서가 있고 중복 가능한 List API
  - 순서가 없고 중복 불가능한 Set API
  - Key-Value로 관리하는 Map API

## Wrapper class란?
- 기본 데이터 타입(primitive data type)을 객체로 다룰 수 있도록 만들어진 클래스
- wrapper 클래스를 사용하면 자동으로 박싱(boxing)과 언박싱(unboxing)이 이루어 진다

|기본 데이터 타입| wrapper 클래스 |
|-|-------------|
| byte| Byte|
|short| Short|
|int | Integer|
|long| Long|


|작업|설명|
|-|----|
|boxing|기본 데이터 타입을 해당하는 wrapper 클래스 객체로 변환|
|예시|int i = 10</br>Integer intObj = integer.valueOf(i);|
|unboxing| wrapper 클래스 객체를 해당하는 기본 데이터 타입으로 변환|
|예시| Integer intObj = new Integer(10);</br> int i = intObj.intValue();|


| 작업            | 설명                                                     |
|---------------|--------------------------------------------------------|
| Auto- boxing  | 기본 데이터 타입을 해당하는 wrapper 클래스 객체로 자동 변환                  |
| 예시            | int i = 10</br>Integer intObj = i;                     |
| Auto-unboxing | wrapper 클래스 객체를 해당하는 기본 데이터 타입으로 자동 변환                 |
| 예시            | Integer intObj = new Integer(10);</br> int i = intObj; |


## 숫자와 문자열의 변환
- 숫자형 문자열을 정수로 변환
``` java
String str = "123"
int num = Integer.parseInt(str);
```

- 정수를 문자열로 변환
```java
int num = 123;
String str1 = String.valueOf(num);
String str2 = ""+num;
System.out.println(str2); //123
```

## Collection FrameWork API란?

자바 컬렉션 프레임워크(Collection Framework) API는
- 자바에서 제공하는 데이터 구조인 컬렉션을 표현하는 인터페이스와 클래스의 모음입니다.
- 이 API를 사용하면 개발자가 데이터를 저장하고 관리하는 다양한 방법을 제공합니다.

| 인터페이스/클래스 | 설명                                           | 분류  |
|-------------------|----------------------------------------------|-------|
| **List**          | 순서가 있는 객체의 모음을 다루는 인터페이스      | List  |
| ArrayList         | List 인터페이스를 구현하는 클래스               | List  |
| LinkedList        | List 인터페이스를 구현하는 클래스               | List  |
| **Set**           | 중복된 원소가 없는 객체의 모음을 다루는 인터페이스 | Set   |
| HashSet           | Set 인터페이스를 구현하는 클래스                | Set   |
| TreeSet           | SortedSet 인터페이스를 구현하는 클래스          | Set   |
| **Map**           | 키-값 쌍의 객체를 다루는 인터페이스             | Map   |
| HashMap           | Map 인터페이스를 구현하는 클래스                | Map   |
| TreeMap           | SortedMap 인터페이스를 구현하는 클래스          | Map   |






