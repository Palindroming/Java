
## Validation을 쓰는 이유

- 유효성 검증하는 코드의 길이가 너무 길다
- service logic에 대해서 방해가 된다
- 흩어져있는 경우 어디서 검증되었는지 찾기 힘들다
- 검증 로직이 변경되는 경우 테스트 코드 등 전체 로직이 흔들릴수 있다.


| name      | function       |
|-----------|----------------|
| @Size     | 문자 길이 측정       |
| @NotNull  | Null 불가        |
| @NotEmpty | null, ""불가     |
| @NotBlank | null, ""," "불가 |
| @Pattern  | 정규식 적용         |
| @Max      | 최대값            |
| @Min      | 최소값            |  
| @AssertTrue/False|별도 로직 적용|
|@Valid|해당 object validation 실행|


