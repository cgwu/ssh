package wu.cg.demo.designpattern.command;

public class DocumentCommand implements Command {
	private Document doc;

	public DocumentCommand(Document doc) {
		this.doc = doc;
	}

	@Override
	public void execute() {
		doc.write();
	}

}
