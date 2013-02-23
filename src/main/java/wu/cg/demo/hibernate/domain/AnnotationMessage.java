package wu.cg.demo.hibernate.domain;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
public class AnnotationMessage {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "MESSAGE_TEXT")
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NEXT_MESSAGE_ID")
    private AnnotationMessage nextMessage;

    public AnnotationMessage getNextMessage() {
	return nextMessage;
    }

    public void setNextMessage(AnnotationMessage nextMessage) {
	this.nextMessage = nextMessage;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

}
