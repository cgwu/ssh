package wu.cg.demo.designpattern.command;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("法1:");
		
		Document doc = new Document();
		Graphic graphic = new Graphic();
		doc.write();
		graphic.draw();
		
		System.out.println("法2:");
		
		Command cmdDoc = new DocumentCommand(doc);
		Command cmdGraphic = new GraphicCommand(graphic);
		cmdDoc.execute();
		cmdGraphic.execute();
		
		System.out.println("done");
	}

}
