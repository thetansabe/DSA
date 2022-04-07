public class Rating {
    private Customer customer;
    private Product product;
    private int stars;

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Rating(){
        this.customer = null;
        this.product = null;
        this.stars = 0;
    }

    public Rating(Customer cus, Product pro, int weight){
        this.customer = cus;
        this.product = pro;
        this.stars = weight;
    }
}
