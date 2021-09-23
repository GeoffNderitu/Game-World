package com.project0.gameworld;


public class ProductDiscount {

    private String Title;
    private String Description;
    private String Price;
    private int ProductImage;

    public ProductDiscount() {
    }

    public ProductDiscount(String title, String description, String price, int productImage) {
        Title = title;
        Description = description;
        Price = price;
        ProductImage = productImage;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return Price;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }
}
