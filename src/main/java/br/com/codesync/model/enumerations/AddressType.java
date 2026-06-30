package br.com.codesync.model.enumerations;

public enum AddressType {

    RESIDENTIAL(1, "Residential Address"),
    COMMERCIAL(2, "Commercial / Work Address"),
    BILLING(3, "Billing Address"),
    SHIPPING(4, "Shipping Address");

    private final Integer id;
    private final String description;

    AddressType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static AddressType getAddressType(Integer id) {
        for (AddressType type : AddressType.values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("AddressType Not Found. Id: " + id);
    }
}
