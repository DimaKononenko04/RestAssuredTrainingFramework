package csv_operations.read_csv_into_pojo_jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class OnlineCourse {
    private static OnlineCourse onlineCourse;

    public static OnlineCourse getOnlineCourse(){
        if(onlineCourse == null){
            onlineCourse = new OnlineCourse();
        }
        return onlineCourse;
    }

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Author")
    private String author;
    @JsonProperty("Price")
    private int price;

    private OnlineCourse(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
