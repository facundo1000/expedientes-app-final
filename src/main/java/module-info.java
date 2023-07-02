module edu.unam.expedientesappfinal {
  requires javafx.controls;
  requires javafx.fxml;
  requires com.dlsc.formsfx;
  requires net.synedra.validatorfx;
  requires org.kordamp.bootstrapfx.core;
  requires java.sql;
  requires jakarta.transaction;
  requires jakarta.persistence;
  requires org.hibernate.commons.annotations;
  requires org.hibernate.orm.core;

  opens edu.unam.expedientesappfinal to
      javafx.fxml;

  opens edu.unam.expedientesappfinal.modelos;

  exports edu.unam.expedientesappfinal;
}
