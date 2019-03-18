/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsstand.literature;

/**
 *
 * @author Ishmael
 */
public abstract class Literature {

    protected boolean valid = true;
    /**
     * The magazine title
     */
    private String title;

    /**
     * The publisher name
     */
    private String publisher;

    /**
     * type of category the magazine is about.
     */
    private String category;

    private int price;

    private int quantity;

    /**
     * Constructor for objects of class Magazine.
     *
     * @param publisher The publisher of the magazine
     * @param category The category of the magazine
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
     * Sets the value of this.title from parameter title. also check if the
     * value from parameter is valid
     *
     * @param title parameter contains an string with the title
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
     * Sets the value of this.publisher from parameter publisher. also check if
     * the value from parameter is valid
     *
     * @param publisher parameter contains an string with the publisher
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
     * Sets the value of this.category from parameter category. also check if
     * the value from parameter is valid
     *
     * @param category parameter contains an string with the category
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

    private void setPrice(int price) {
        if (price < 0) {
            valid = false;
        } else {
            this.price = price;
        }
    }

    private void setQuantity(int quantity) {
        if (quantity < 0) {
            valid = false;
        } else {
            this.quantity = quantity;
        }
    }

    public void increaseStock() {
        quantity++;
    }

    public void decreaseStock() {
        quantity--;
    }

    public void addOrRemoveStock(int amount) {
        this.quantity += amount;
    }

    /**
     * Returns the title of the magazine
     *
     * @return the magazine title name
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the magazine
     *
     * @return the magazine publisher
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Returns the category of the magazine
     *
     * @return the type of category the magazine is
     */
    public String getCategory() {
        return this.category;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean isLiteratureValid() {
        return valid;
    }
}
