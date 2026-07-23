package br.com.codesync.model.enumerations;

public enum BillingType {

    FIXED_PRICE(1, "Fixed Price / Scope Based"),
    TIME_AND_MATERIALS(2, "Time and Materials / Hourly Rate"),
    NON_BILLABLE(3, "Non-Billable / Internal R&D");

    private final Integer id;
    private final String description;

    BillingType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static BillingType fromId(Integer id) {
        for (BillingType type : BillingType.values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("BillingType not found. Id: " + id);
    }
}
