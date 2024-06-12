package EX_RECUPERACIO_13Z;

import java.io.Serializable;

public class ProductInformation implements Serializable {
    private int productId;
    private String productName;
    private String productDescription;
    private int categoryId;
    private String productStatus;

    public ProductInformation(int productId, String productName, String productDescription, int categoryId, String productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.categoryId = categoryId;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    @Override
    public String toString() {
        return "ProductInformation{" + "productId=" + productId + ", productName=" + productName + ", productDescription=" + productDescription + ", categoryId=" + categoryId + ", productStatus=" + productStatus + '}';
    }
    
}
