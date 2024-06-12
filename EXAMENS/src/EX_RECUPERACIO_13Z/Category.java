package EX_RECUPERACIO_13Z;

public class Category {
    private int categoryId;
    private String categoryNameString;
    private String categoryDescription;
    private int parentCategoryId;

    public Category(int categoryId, String categoryName, String categoryDescription, int parentCategoryId) {
        this.categoryId = categoryId;
        this.categoryNameString = categoryName;
        this.categoryDescription = categoryDescription;
        this.parentCategoryId = parentCategoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryNameString;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryNameString=" + categoryNameString + ", categoryDescription=" + categoryDescription + ", parentCategoryId=" + parentCategoryId + '}';
    }
    
}
