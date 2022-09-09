
public class BulbasaurThing extends PokeThing {

	/**
	 * Creates a new <code>BulbasaurThing</code> object.
	 * Associated graphics file will be bulbasaur.gif
	 */
	public BulbasaurThing()
	{
		super("Bulbasaur", "", 0);	
	}
	
	
	/**
	 * Place a <code>FlowerThing</code> at the <code>BulbasaurThing</code>'s current <code>Location</code>
	 * The <code>FlowerThing</code> will be placed under the <code>BulbasaurThing</code>
	 */
	public void putFlower()
	{
		FlowerThing k = new FlowerThing();
		getBoard().addUnder(k, getLocation());
	}
	
	
	/**
	 * Step function to define the <code>BulbasaurThing</code>'s behavior
	 * <code>BulbasaurThing</code> places a <code>FlowerThing</code> in the current spot and moves
	 */	
	public void step()
	{
		putFlower();
		move();
	}
	
	/**
	 * Behavior to occur when the Thing has been clicked on
	 */
	public void mouseClick() 
	{
		Gui g = getBoard().getGui();
		g.appendTextWindow("Bulbasaur has been tickled.");
	}
	
	public void move() {
		boolean blocked;
		boolean stuck;
		Gui g = getBoard().getGui();
		// If this PokeThing is not currently in a Board, do nothing
		if (null == getBoard())
		{
			return;
		}
		
		// Check the 'next' Location.  If there is a PokeThing there, do not move.
		
		Location nextLoc = dir.getNextLocation(getLocation()); 
		blocked = getBoard().thingAt(nextLoc) instanceof PokeThing;
		stuck = !(nextLoc.isValid(getBoard()));
		
		if (getBoard().thingAt(nextLoc) instanceof PokeThing)
		{
			return;	
		}
		else if (stuck){
			setDirection(getDirection().right());
//			nextLoc = dir.getNextLocation(getLocation()); 
//			System.out.println("DEBUG");
		}
		else {
			setDirection(getDirection().left());
			nextLoc = dir.getNextLocation(getLocation());
			if (getBoard().thingAt(nextLoc) instanceof SquirtleThing)
			{
				setDirection(getDirection().right());
				setDirection(getDirection().right());
				nextLoc = dir.getNextLocation(getLocation());
				
			}
			else {
				setDirection(getDirection().right());
				nextLoc = dir.getNextLocation(getLocation());
			}
//			move();
			
		}
//		Location nextLoc = dir.getNextLocation(getLocation()); 
		
		super.move();
		
	}
//	public void move(Location loc)
//	{
//		// If this PokeThing isn't in a board, or the location is valid, don't move
//		if ((null == getBoard()) || (false == loc.isValid(getBoard())))
//		{
//			return;
//		}
//
//		// Remove self from the current location on the Board and add to loc
//		getBoard().remove(this);
//		setLocation(loc);
//		getBoard().add(this);
//	}
}
