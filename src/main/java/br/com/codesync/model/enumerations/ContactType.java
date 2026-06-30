package br.com.codesync.model.enumerations;

public enum ContactType {

    PERSONAL(1, "Personal Mobile"),
    WORK(2, "Work Phone"),
    WHATSAPP(3, "WhatsApp / Messenger"),
    EMERGENCY(4, "Emergency Contact");

    private final Integer id;
    private final String description;

    ContactType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static ContactType getContactType(Integer id) {
        for (ContactType type : ContactType.values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("ContactType Not Found. Id: " + id);
    }
}
