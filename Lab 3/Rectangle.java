public class Rectangle implements Shape {

	private int length; //length units along x axis
	private int height;  //height units along y axis
	private Point position; // position is the (x,y) coordinates of lower left corner of the rectangle

	/*
	 * Purpose: initializes this Rectangle with length and height of 0
	 *   and position to new Point at 0,0
	 * Parameters: none
	 */
	public Rectangle() {
		this.length = 0;
		this.height = 0;
		this.position = new Point();
	}

	/*
	 * Purpose: initializes this Rectangle with given length and height
	 *   and position to new Point at 0,0
	 * Parameters: int length, int height
	 * Precondition: given length and height >=0
	 */
	public Rectangle(int length, int height) {
		this.length = length;
		this.height = height;
		this.position = new Point();
	}

	/*
	 * Purpose: initializes this Rectangle with given length, height and position
	 * Parameters: int length, int height, Point position
	 * Precondition: given length and height >=0, position is not null
	 */
	public Rectangle(int length, int height, Point position) {
		this.length = length;
		this.height = height;
		this.position = position;
	}

	/*
	 * Purpose: prints a message about the characteristics of this Rectangle
	 * Parameters: none
	 * Returns: void
	 */
	public void printCharacteristics() {
		if (length > height) {
			System.out.println("long rectangle");
		} else if (height > length) {
			System.out.println("tall rectangle");
		} else {
			System.out.println("square");
		}
	}

	public double area() {
		return length * height;
	}

	public double perimeter() {
		return 2 * length + 2 * height;
	}

	public boolean contains(Point p) {
		int x = p.getX();
		int y = p.getY();
		int recX = position.getX();
		int recY = position.getY();

		System.out.println("recX: " + recX + ", recY: " + recY);
		System.out.println("x: " + x + ", y: " + y + ", length: " + length + ", height: " + height);


		if(x < recX || x > recX + length || y < recY || y > recY + height)
			return false;
		else
			return true;
		
	}



	public String toString() {
		return "Rectangle of dimensions: " + length + " by " + height + " at Point: " + position;
	}


}
