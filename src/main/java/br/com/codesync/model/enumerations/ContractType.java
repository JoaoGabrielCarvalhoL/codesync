package br.com.codesync.model.enumerations;

public enum ContractType {

    INTERNAL_EMPLOYEE(1, "Internal Employee / Fixed Staff"),
    CONTRACTOR_THIRD_PARTY(2, "Third-Party Contractor / On-Demand Freelancer"),
    CLIENT_MEMBER(3, "Client Staff Member"),
    PARTNER(4, "Strategic Partner / Vendor");

    private final Integer id;
    private final String description;

    ContractType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static ContractType fromId(Integer id) {
        for (ContractType type : ContractType.values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("ContractType not found. Id: " + id);
    }

}
