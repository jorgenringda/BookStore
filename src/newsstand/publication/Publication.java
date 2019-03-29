package newsstand.publication;

/**
 * A super class of Publication
 *
 * @author Ishmael
 */
public abstract class Publication {

    /**
     * True or false if the parameters is valid or not.
     */
    protected boolean valid = true;
    /**
     * The Publication title
     */
    private String title;

    /**
     * The publisher name
     */
    private String publisher;

    /**
     * type of category the Publication is about.
     */
    private String category;

    /**
     * The price of the Publication
     */
    private int price;

    /**
     * The quantity of the Publication
     */
    private int quantity;

    /**
     * Constructor for objects of class Publication.
     *
     * @param title is the title of the Publication
     * @param publisher is the publisher of the Publication
     * @param category is the category of the Publication
     * @param price is the price of the Publication
     * @param quantity is the quantity of the Publication that is being added to
     * stock
     */
    public Publication(String title, String publisher,
            String category, int price, int quantity) {
        setTitle(title);
        setPublisher(publisher);
        setCategory(category);
        setPrice(price);
        setQuantity(quantity);
    }

    /**
     * Method that sets the title of a Publication from parameter title. Also
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
     * Method that sets the publisher of a Publication from parameter publisher.
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
     * Method that sets the category of a Publication from parameter category.
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
     * Method that sets the price of a Publication from parameter price. Also
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
     * Method that sets the quantity of a Publication from parameter quantity.
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
     * Method that increase the quantity of a Publication by 1;
     */
    public void increaseStock() {
        quantity++;
    }

    /**
     * Method that decrease the quantity of a Publication by 1.
     */
    public void decreaseStock() {
        quantity--;
    }

    /**
     * Method that add given quantity to a Publication.
     *
     * @param quantity is the amount of a Publication we want to add
     */
    public void addOrRemoveStock(int quantity) {
        this.quantity += quantity;
    }

    /**
     * Method that return the title of given Publication.
     *
     * @return the title of a Publication.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Method that return the publisher of given Publication.
     *
     * @return the publisher of a Publication
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Method that return the category of given Publication.
     *
     * @return the type of category the Publication
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Method that return the price of given Publication.
     *
     * @return price of a Publication
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Method that return the quantity of given Publication.
     *
     * @return quantity of a Publication
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Method that return a Boolean true or false if the set parameters is valid
     *
     * @return a Boolean true or false if the parameters is valid or not
     */
    public boolean isPublicationValid() {
        return valid;
    }
}
