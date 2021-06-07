package com.company;

public class SearchTree implements AbNodeList {
    private AbListItem root;

    public SearchTree(AbListItem root) {
        this.root = root;
    }

    @Override
    public AbListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(AbListItem abListItem) {
        if (this.root == null){
            this.root = abListItem;
            return true;
        }
        AbListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(abListItem);
            if (comparison < 0){
                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(abListItem);
                    return true;
                }
            } else if (comparison > 0){
                if (currentItem.previous() != null){
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(abListItem);
                    return true;
                }
            } else {
                System.out.println(abListItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }



    @Override
    public boolean removeItem(AbListItem abListItem) {
        if (abListItem != null){
            System.out.println("Deleting " + abListItem.getValue());
        }
        AbListItem currentItem = this.root;
        AbListItem parentItem = currentItem;
        while (currentItem != null){
            int comparison = currentItem.compareTo(abListItem);
            if (comparison < 0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(AbListItem abListItem, AbListItem parentItem){
        if (abListItem.next() == null){
            if (parentItem.next() == abListItem){
                parentItem.setNext(abListItem.previous());
            } else if (parentItem.previous() == abListItem){
                parentItem.setPrevious(abListItem.previous());
            } else {
                this.root = parentItem.previous();
            }
        } else if (abListItem.previous() == null){
            if (parentItem.next() == abListItem){
                parentItem.setNext(abListItem.next());
            } else if (parentItem.previous() == abListItem){
                parentItem.setPrevious(abListItem.next());
            } else {
                this.root = abListItem.next();
            }
        } else {
            AbListItem currentItem = abListItem.next();
            AbListItem leftMostParent = abListItem;
            while (currentItem.previous() != null){
                leftMostParent = currentItem;
                currentItem = currentItem.previous();
            }
            abListItem.setValue(currentItem.getValue());
            if (leftMostParent == abListItem){
                abListItem.setNext(currentItem.next());
            } else {
                leftMostParent.setPrevious(currentItem.next());
            }
        }
    }

    @Override
    public void traverse(AbListItem root) {
        if (root != null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
