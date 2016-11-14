package entity;

import java.util.Objects;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 */
public class Message {

    private int idMessage;
    private String objet;
    private String corps;

    public Message(String objet, String corps) {
        this.objet = objet;
        this.corps = corps;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idMessage;
        hash = 17 * hash + Objects.hashCode(this.objet);
        hash = 17 * hash + Objects.hashCode(this.corps);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if (this.idMessage != other.idMessage) {
            return false;
        }
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        if (!Objects.equals(this.corps, other.corps)) {
            return false;
        }
        return true;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    @Override
    public String toString() {
        return "Message{" + "idMessage=" + idMessage + ", objet=" + objet + ", corps=" + corps + '}';
    }


    
}
