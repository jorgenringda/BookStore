package newsstand.literature;

/**
 * A super class of Literature
 *
 * @author Ishmael
 */
public abstract class Literature {

    /**
     * True or false if the parameters is valid or not.
     */
    protected boolean valid = true;
    /**
     * The Literature title
     */
    private String title;

    /**
     * The publisher name
     */
    private String publisher;

    /**
     * type of category the Literature is about.
     */
    private String category;

    /**
     * The price of the Literature
     */
    private int price;

    /**
     * The quantity of the Literature
     */
    private int quantity;

    /**
     * Constructor for objects of class Literature.
     *
     * @param title is the title of the Literature
     * @param publisher is the publisher of the Literature
     * @param category is the category of the Literature
     * @param price is the price of the Literature
     * @param quantity is the quantity of the Literature that is being added to
     * stock
     */
    public Literature(String title, String publisher,
            String category, int price, int quantity) {
        setTitle(title);
        setPublisher(publisher);
        setCategory(category);
        setPrice(price);
        setQuantity(quantity);
    }

    /**
     * Method that sets the title of a Literature from parameter title. Also
     * check if the value from parameter is valid.
     *
     * @param title parameter contains a string with the title
     */
    private void setTitle(String title) {
        if (title == null) {
            title = "";
        }
        title = title.trim();
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            valid = false;
        }
    }

    /**
     * Method that sets the publisher of a Literature from parameter publisher.
     * Also check if the value from parameter is valid.
     *
     * @param publisher parameter contains a string with the publisher
     */
    private void setPublisher(String publisher) {
        if (publisher == null) {
            publisher = "";
        }
        publisher = publisher.trim();
        if (!publisher.isEmpty()) {
            this.publisher = publisher;
        } else {
            valid = false;
        }
    }

    /**
     * Method that sets the category of a Literature from parameter category.
     * Also check if the value from parameter is valid.
     *
     * @param category parameter contains a String with the category
     */
    private void setCategory(String category) {
        if (category == null) {
            category = "";
        }
        category = category.trim();
        if (!category.isEmpty()) {
            this.category = category;
        } else {
            valid = false;
        }
    }

    /**
     * Method that sets the price of a Literature from parameter price. Also
     * check if the value from parameter is valid.
     *
     * @param price parameter contains an int with the price
     */
    private void setPrice(int price) {
        if (price < 0) {
            valid = false;
        } else {
            this.price = price;
        }
    }

    /**
     * Method that sets the quantity of a Literature from parameter quantity.
     * Also check if the value from parameter is valid.
     *
     * @param quantity parameter contains an int with the quantity
     */
    private void setQuantity(int quantity) {
        if (quantity < 0) {
            valid = false;
        } else {
            this.quantity = quantity;
        }
    }

    /**
     * Method that increase the quantity of a Literature by 1;
     */
    public void increaseStock() {
        quantity++;
    }

    /**
     * Method that decrease the quantity of a Literature by 1.
     */
    public void decreaseStock() {
        quantity--;
    }

    /**
     * Method that add given quantity to a Literature.
     *
     * @param quantity is the amount of a Literature we want to add
     */
    public void addOrRemoveStock(int quantity) {
        this.quantity += quantity;
    }

    /**
     * Method that return the title of given Literature.
     *
     * @return the title of a Literature.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Method that return the publisher of given Literature.
     *
     * @return the publisher of a Literature
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Method that return the category of given Literature.
     *
     * @return the type of category the Literature
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Method that return the price of given Literature.
     *
     * @return price of a Literature
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Method that return the quantity of given Literature.
     *
     * @return quantity of a Literature
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Method that return a Boolean true or false if the set parameters is valid
     *
     * @return a Boolean true or false if the parameters is valid or not
     */
    public boolean isLiteratureValid() {
        return valid;
    }
}
