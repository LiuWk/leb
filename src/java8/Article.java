package java8;

public class Article {
    private String title;
    private String author;
    private ArticleType type;
    private Integer likes;

    public Article(String title, String author, ArticleType type, Integer likes) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.likes = likes;
    }

    public Article() {
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

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}

enum ArticleType {
    /**
     * 文章类型
     */
    NEWS,
    REVIEW,
    GUIDE
}