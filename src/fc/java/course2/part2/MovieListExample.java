package fc.java.course2.part2;

import fc.java.model2.MovieDTO;

import java.util.ArrayList;

public class MovieListExample {
    public static void main(String[] args) {

        ArrayList<MovieDTO> list = new ArrayList<MovieDTO>(); //MovieDTO[]
        list.add(new MovieDTO("괴물","봉준호","2006","kor"));
        list.add(new MovieDTO("기생충","봉준호","2019","kor"));
        list.add(new MovieDTO("완벽한 타인","이재규","2018","kor"));

        for (MovieDTO movieDTO : list) {
            System.out.println(movieDTO.toString());
        }

        System.out.println("|title|director|year|country|");
        System.out.println("|--|--|--|--|");
        for (MovieDTO movieDTO : list) {
            System.out.printf("|%-16s|%-8s|%-4s|%-6s|\n", movieDTO.getTitle(), movieDTO.getDirector(), movieDTO.getYear(), movieDTO.getCountry());
        }


        String searchTitle = "기생충";
        for(MovieDTO movieDTO : list){
            if(movieDTO.getTitle().toLowerCase().contains(searchTitle)){
                System.out.println(movieDTO.toString());
            }
        }
    }
}
