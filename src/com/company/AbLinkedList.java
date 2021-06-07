package com.company;


public class AbLinkedList implements AbNodeList {
    private AbListItem root;

    public AbLinkedList(AbListItem root) {
        this.root = root;
    }

    @Override
    public AbListItem getRoot() {
        return root;
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
                    currentItem.setNext(abListItem).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0){
                if (currentItem.previous() != null){
                    currentItem.previous().setNext(abListItem).setPrevious(currentItem.previous());
                    abListItem.setNext(currentItem).setPrevious(abListItem);
                } else {
                    abListItem.setNext(this.root).setPrevious(abListItem);
                    this.root = abListItem;
                }
                return true;
            } else {
                System.out.println(abListItem.getValue() + " is already present, not added.");
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
        while (currentItem != null){
            int comparison = currentItem.compareTo(abListItem);
            if (comparison == 0){
                if (currentItem == this.root){
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0){
                currentItem = currentItem.next();
            } else {
                assert abListItem != null;
                System.out.println(abListItem.getValue() + " is not in the list");
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(AbListItem root) {
        if (root == null){
            System.out.println("List is empty");
        } else {
            while (root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
