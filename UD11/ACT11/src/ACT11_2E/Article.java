package ACT11_2E;

public class Article implements Comparable<Article> {
    private int productId;
    private String productName;
    private int productPrice;

    public Article(int productId, String productName, int productPrice) {
        setProductId(productId);
        setProductName(productName);
        setProductPrice(productPrice);
    }

    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " no pot ser null ni buit");
        }
    }

    private void validateNonNegative(int value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " no pot ser negatiu");
        }
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        validateNonNegative(productId, "productId");
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        validateString(productName, "productName");
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        validateNonNegative(productPrice, "productPrice");
        this.productPrice = productPrice;
    }

    @Override
    public int compareTo(Article o) {
        return this.productName.compareTo(o.productName); // Ordenar per Name
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.productId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        return this.productId == other.productId;
    }

    @Override
    public String toString() {
        return "Article{" + "productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + '}';
    }



}
