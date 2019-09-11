package codewars;

import java.util.*;


class Page {
    private int pageIndex;
    private int numberOfItems;
    private List<Integer> itemIndexes;

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

    public List<Integer> getItemIndexes() {
        return itemIndexes;
    }

    public void setItemIndexes(List<Integer> itemIndexes) {
        this.itemIndexes = itemIndexes;
    }

}

public class PaginationHelper<I> {

    private List<I> collection;
    private int itemsPerPage;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    public int itemCount() {
        return collection.size();
    }

    public int pageCount() {
        return (collection.size())/itemsPerPage + (collection.size() % itemsPerPage > 0 ? 1 : 0);
    }

    public List<Page> getPages(){
        List<Page> pages = new ArrayList<>();
        int remainingItems = itemCount();
        int itemCurrentIndex = 1;
        for (int i = 0; i < pageCount(); i++){
            Page page = new Page();
            if (remainingItems-itemsPerPage >= 0){
                page.setPageIndex(i);
                page.setNumberOfItems(itemsPerPage);
                List<Integer> indexes = new ArrayList<>();
                for (int j = 0; j <itemsPerPage ; j++) {
                    indexes.add(itemCurrentIndex);
                    itemCurrentIndex++;
                }
                page.setItemIndexes(indexes);
                pages.add(page);
                remainingItems-=itemsPerPage;
            }else {
                page.setPageIndex(i);
                page.setNumberOfItems(itemCount() % itemsPerPage);
                List<Integer> indexes = new ArrayList<>();
                for (int j = 0; j <itemCount() % itemsPerPage ; j++) {
                    indexes.add(itemCurrentIndex);
                }
                page.setItemIndexes(indexes);
                pages.add(page);
            }
        }
        return pages;
    }

    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= getPages().size()){
            return -1;
        }
        return getPages().get(pageIndex).getNumberOfItems();
    }

    public int pageIndex(int itemIndex) {
        for (Page page : getPages()) {
            for (Integer index : page.getItemIndexes()) {
                if (index == itemIndex){
                    return page.getPageIndex();
                }
            }
        }
        return -1;

//        return getPages().stream().filter(page -> page.getItemIndexes().stream().anyMatch(index -> index == itemIndex)).findFirst().map(Page::getPageIndex).orElse(-1);
    }

}
