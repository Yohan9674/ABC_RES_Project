package abc.restaurant.webapp.Model;

public class Payment {
    private String reservationId;
    private String paymentType; // "cash" or "visa"
    private String cardNumber;   // Only for Visa payments
    private String nameOnCard;   // Name on card for Visa payments
    private String expiryDate;
    private String cvc;
    private double amount;

    // Getters and Setters
    public String getReservationId() { return reservationId; }
    public void setReservationId(String reservationId) { this.reservationId = reservationId; }

    public String getPaymentType() { return paymentType; }
    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getNameOnCard() { return nameOnCard; }
    public void setNameOnCard(String nameOnCard) { this.nameOnCard = nameOnCard; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getCvc() { return cvc; }
    public void setCvc(String cvc) { this.cvc = cvc; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}