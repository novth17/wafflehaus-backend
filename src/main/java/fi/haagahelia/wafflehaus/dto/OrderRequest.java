package fi.haagahelia.wafflehaus.dto;

import java.util.List;

/**
 * Represents the structure of an order sent by the customer from the frontend (e.g. Postman or React app).
 * Includes a list of items (each with menu item ID and quantity) and an optional note for special instructions.
 */

public class OrderRequest {

    private List<Item> items;
    private String note;

    public static class Item {
        private Long menuItemId;
        private int quantity;

        public Long getMenuItemId() {
            return menuItemId;
        }

        public void setMenuItemId(Long menuItemId) {
            this.menuItemId = menuItemId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // Getters and Setters
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
