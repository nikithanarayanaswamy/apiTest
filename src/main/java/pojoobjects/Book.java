package pojoobjects;

public class Book {

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public int[] getVersions() {
        return versions;
    }

    public void setVersions(int[] versions) {
        this.versions = versions;
    }

    private String releaseDate;
    private Boolean aBoolean ;
    private int[] versions;

}
