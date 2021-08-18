public class CreateUserResponsePojo {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private UserDataPojo data[];
    private SupportDataPojo support;

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public UserDataPojo[] getData() {
        return data;
    }

    public SupportDataPojo getSupports() {
        return support;
    }
}
