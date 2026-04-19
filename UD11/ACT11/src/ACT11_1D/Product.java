package ACT11_1D;

public class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private int numWarehouses;

    public Product(int productId, String productName, int numWarehouses) {
        setProductId(productId);
        setProductName(productName);
        setNumWarehouses(numWarehouses);
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
        validateNonNegative(productId, "producteId");
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.trim().isEmpty())
            throw new IllegalArgumentException("productName no pot ser null ni buit");
        else
            this.productName = productName;
    }

    public int getNumWarehouses() {
        return numWarehouses;
    }

    public void setNumWarehouses(int numWarehouses) {
        validateNonNegative(numWarehouses, "numWarehouses");
        this.numWarehouses = numWarehouses;
    }

    @Override
    public int compareTo(Product o) {
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
        final Product other = (Product) obj;
        return this.productId == other.productId;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", numWarehouses=" + numWarehouses + '}';
    }

}
