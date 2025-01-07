package fc.java.model2;
//잘 설계된 VO,DTO
public class BookDTO {

    private String title;
    private String company;
    private String author;
    private int price;
    //멤버변수, 상태정보, 속성(property)

    public BookDTO() { //default constructor

    }
    //생성자 메서드의 중복정의(Overloading)
    public BookDTO(String title, String company, String author, int price) {
        this.title = title;
        this.company = company;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //Object -> toString() 재정의
    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
