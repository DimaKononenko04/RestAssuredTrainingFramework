package codewars;

import java.util.*;


class Page {
    private int pageIndex;
    private int numberOfItems;
    private List<Integer> items;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    static class Builder{
        private Page page;

        public Builder(){
            page = new Page();
        }

        public Builder withPageIndex(int pageIndex){
            page.pageIndex = pageIndex;
            return this;
        }

        public Builder withNumberOfItems(int numberOfItems){
            page.numberOfItems = numberOfItems;
            return this;
        }

        public Builder withItems(List<Integer> items){
            page.items = items;
            return this;
        }

        public Page build(){
            return page;
        }
    }
}

public class PaginationHelper<I> {
    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    private List<I> collection;
    private int itemsPerPage;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (collection.size())/itemsPerPage + (collection.size() % itemsPerPage > 0 ? 1 : 0);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */

    public Map<Integer,Integer> getNumberOfItemsOnPage(){
        Map<Integer,Integer> itemsOnPage = new LinkedHashMap<>();
        int remainingItems = itemCount();
        for (int i = 0; i <pageCount() ; i++) {
            if (remainingItems-itemsPerPage >= 0){
                itemsOnPage.put(i,itemsPerPage);
                remainingItems-=itemsPerPage;
            }else {
                itemsOnPage.put(i,itemCount() % itemsPerPage);
            }
        }
        return itemsOnPage;
    }

    // using object Page
    public List<Page> getPages(){
        List<Page> pages = new ArrayList<>();
        int remainingItems = itemCount();
        for (int i = 0; i < pageCount(); i++){
            if (remainingItems-itemsPerPage >= 0){
                Page page = new Page();
                page.setPageIndex(i);
                page.setNumberOfItems(itemsPerPage);
                pages.add(page);
                remainingItems-=itemsPerPage;
            }else {
                Page page = new Page();
                page.setPageIndex(i);
                page.setNumberOfItems(itemCount() % itemsPerPage);
                pages.add(page);
            }
        }
        return pages;
    }

    // using Builder
    public List<Page> getPagesTest(){
        List<Page> pages = new ArrayList<>();
        int remainingItems = itemCount();
        for (int i = 0; i < pageCount(); i++){
            if (remainingItems-itemsPerPage >= 0){
                Page page = new Page.Builder()
                        .withPageIndex(i)
                        .withNumberOfItems(itemsPerPage)
                        .build();
                pages.add(page);
                remainingItems-=itemsPerPage;
            }else {
                Page page = new Page.Builder()
                        .withPageIndex(i)
                        .withNumberOfItems(itemCount() % itemsPerPage)
                        .build();
                pages.add(page);
            }
        }
        return pages;
    }

    // using object Page
    public int pageItemCountTest(int pageIndex) {
        if (pageIndex < 0 || pageIndex > getPages().size()){
            return -1;
        }
        return getPages().get(pageIndex).getNumberOfItems();
    }

    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || !getNumberOfItemsOnPage().containsKey(pageIndex)){
            return -1;
        }
        return getNumberOfItemsOnPage().get(pageIndex);
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        // get page index by item index
        return 0;
    }

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a','b','c','d','e','f','g','h','i'),4);
        System.out.println(helper.itemCount());
        System.out.println(helper.pageCount());
        System.out.println(helper.pageItemCount(4));

        // test with object Page
        System.out.println(helper.pageItemCountTest(0));

        System.out.println(helper.pageIndex(4));
    }

}
