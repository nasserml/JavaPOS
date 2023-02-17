
package entities;


public class Transaction {
    
    private String id;
    private int cashierId;
    private String cardId;
    private int purchaseId;
    private String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId(int cahierId) {
        this.cashierId = cahierId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
}
