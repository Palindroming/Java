package GetAddress;

import java.io.*;


public class GetMain {


    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("주소를 입력하세요.: ");
            String address = br.readLine();

            double[] coordinates = KakaoAPI.getAddressCoordinate(address);

            if(coordinates != null){
                System.out.println("주소: "+ address);
                System.out.println("위도: "+ coordinates[0]);
                System.out.println("경도: "+ coordinates[1]);




            }else {
                System.out.println("주소를 찾을 수 없습니다. ");
            }

        } catch (IOException e ){
            e.printStackTrace();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
