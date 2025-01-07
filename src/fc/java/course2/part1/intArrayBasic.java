package fc.java.course2.part1;

public class intArrayBasic {

    public static void main(String[] args) { //배열 생성 동작 : 고정길이(단점) -> 가변길이?
        int[] arr = new int[5]; //저장동작
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        for(int i= 0 ; i<arr.length; i++){ // 길이를 구하는 동작
            int data  = arr[i];
            System.out.println(arr[i]+ "\n"); //데이터를 얻는 동작
        }

        for(int data: arr){ //향상된 for문
            System.out.println(data);
        }
    }
}

/* 이 동작들을 메서드로 구현하여 API로 만들면 어떨까? */

