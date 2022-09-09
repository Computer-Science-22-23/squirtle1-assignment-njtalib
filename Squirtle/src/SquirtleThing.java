
public class SquirtleThing extends PokeThing {

	int squaresMoved = 0;
	
	/**
	 * SquirtleThing Constructor
	 * Creates a new <code>SquirtleThing</code> object.
	 * Associated graphics file will be squirtle.png
	 */
	public SquirtleThing()
	{
		super("Squirtle", "", 0);	
		setImageFileType(IMAGETYPE_PNG);
	}
	
	
	/**
	 * step method -- this method is called over and over
	 * <code>SquirtleThing</code> moves in a pattern and prints how far it has gone
	 */	
	public void step()
	{
		movementPattern();
		
		Gui g = getBoard().getGui();
		squaresMoved += 1;
		g.appendTextWindow("Squirtle has moved " + squaresMoved + " squares.");
		Location nextLoc = getDirection().getNextLocation(getLocation());

	}
	
	public void getFlower(Location loc) {
		
		
		Board b = getBoard();
		// Check the 'next' Location.  If there is a PokeThing there, do not move. 
		if (getBoard().thingAt(loc) instanceof FlowerThing)
		{
			FlowerThing f = (FlowerThing) b.thingAt(loc);
			b.remove(f);
			
			
		}
	/*	setLocation(0,0);
		getBoard().remove(nextLoc);
//		getBoard().remove(this);
//		setLocation(1, 1);
//		getBoard().add(this);
		System.out.println(nextLoc);
		move(nextLoc); */
		
	}
	/**
	 * movement in a repeating pattern
	 * <code>SquirtleThing</code> turns right if it is blocked or encounters a wall
	 */	
	public void movementPattern()
	{
		// Check the 'next' Location.  If there is a PokeThing or wall there, turn.
		boolean blocked;
		boolean stuck;
		boolean flowerBlock;
		Gui g = getBoard().getGui();
		
		Location nextLoc = getDirection().getNextLocation(getLocation()); 
		blocked = getBoard().thingAt(nextLoc) instanceof PokeThing;
		
		flowerBlock = getBoard().thingAt(nextLoc) instanceof FlowerThing;
		
		stuck = !(nextLoc.isValid(getBoard()));
		
		if (stuck)
		{
			setDirection(getDirection().right());
			nextLoc = getDirection().getNextLocation(getLocation()); 
		}
		else if (flowerBlock) {
			getFlower(nextLoc);
		}
		else if (blocked) {
			
		}
			move();
	}

}


