package com.fareye.training.model;

public class Item {
    private int itemCode;
    private String itemName;

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode=" + itemCode +
                ", itemName='" + itemName + '\'' +
                '}';
    }

    public Item(int itemCode, String itemName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
    }
}
