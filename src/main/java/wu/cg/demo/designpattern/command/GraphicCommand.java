package wu.cg.demo.designpattern.command;

public class GraphicCommand implements Command {
	private Graphic g;

	public GraphicCommand(Graphic g) {
		this.g = g;
	}

	@Override
	public void execute() {
		g.draw();
	}

}
