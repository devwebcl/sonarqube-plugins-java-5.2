package cl.devweb.sonar.customrule.java.domain;

public enum Annotation {

    JAVAX_PERSISTENCE_ASSOCIATIONOVERRIDE("javax.persistence.AssociationOverride"),

    JAVAX_PERSISTENCE_COLUMN("javax.persistence.Column"),
    JAVAX_PERSISTENCE_EMBEDDABLE("javax.persistence.Embeddable"),
    JAVAX_PERSISTENCE_EMBEDDEDID("javax.persistence.EmbeddedId"),
    JAVAX_PERSISTENCE_ENTITY("javax.persistence.Entity"),

    JAVAX_PERSISTENCE_GENERATEDVALUE("javax.persistence.GeneratedValue"),

    JAVAX_PERSISTENCE_ID("javax.persistence.Id"),
    JAVAX_PERSISTENCE_JOINCOLUMN("javax.persistence.JoinColumn"),
    JAVAX_PERSISTENCE_MANYTOONE("javax.persistence.ManyToOne"),
    JAVAX_PERSISTENCE_ONETOMANY("javax.persistence.OneToMany"),
    JAVAX_PERSISTENCE_ONETOONE("javax.persistence.OneToOne"),

    JAVAX_PERSISTENCE_TABLE("javax.persistence.Table"),
    JAVAX_PERSISTENCE_TEMPORAL("javax.persistence.Temporal"),

    JAVAX_PERSISTENCE_TRANSIENT("javax.persistence.Transient"),
    JAVAX_PERSISTENCE_UNIQUECONSTRAINT("javax.persistence.UniqueConstraint");



    private String name;

    Annotation(String name) {
        this.name = name;
    }

    public String fqn() {
        return name;
    }

}
