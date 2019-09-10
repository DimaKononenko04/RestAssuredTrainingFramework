package codewars;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Integer,Integer> getItemsOnPages(){
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

    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || !getItemsOnPages().containsKey(pageIndex)){
            return -1;
        }
        return getItemsOnPages().get(pageIndex);
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

        System.out.println(helper.pageIndex(4));
    }
}
