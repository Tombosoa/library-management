package Entity;

public abstract class CrupdateBook {
    private int id;
    private String bookName;
    private int pageNumbers;
    private String topic;
    private String releaseDate;

    public CrupdateBook(int id, String bookName, int pageNumbers, String topic, String releaseDate) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.topic = topic;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "CrupdateBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", pageNumbers=" + pageNumbers +
                ", topic='" + topic + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
