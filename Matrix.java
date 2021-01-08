package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){}
	
	///constructor 1 - Constructor for new zero matrix
	public Matrix(int rowDim, int colDim){
		/*
		* TODO: write a constructor that would create a matrix
		* of correct size and initialize it to 0. 
		*/
		numRows = rowDim;
		numColumns= colDim;
		data = new int[numRows][numColumns];
	}
	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	 public Matrix(int d[][])
	 {
		/* 1) put the numRows to be the number of 1D arrays in the 2D array
		*  2) specify the numColumns and set it
		*  3) be careful of special cases you are supposed to handle them properly
		*  4) create a new matrix to hold the data
		*  5) copy the data over
		*/
		numRows = d.length;
		//find special case if there are 0 rows;
		if (numRows==0) {
		numColumns = 0;
		}
		else {
		numColumns = d[0].length;
			
		}
		data = new int[numRows][numColumns];
		//copy the data over
	    for (int row=0;row<numRows; row++){
	    	for(int col=0;col<numColumns; col++){
	    		data[row][col] = d[row][col];
	    	}
	    }
		
		
	
		
	  }	

	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return a String that represents this 
		 * 			matrix, as specified in the instruction for M1 - anything else IS NOT acceptable
		 */
		String matrixString = "\n";
		for (int row=0;row<numRows; row++){
			for(int col=0;col<numColumns; col++){
				matrixString += data[row][col];
				matrixString += " ";
			}
			matrixString += "\n";
		}
		return matrixString; // placeholder		
	}
	
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return the correct value
		 * 			after determining if this matrix is equal to the input matrix
		 */
		//same dimesions 
		
		if (m.numColumns == this.numColumns && m.numRows == this.numRows) {
			for (int row= 0; row<this.numRows; row ++) {
				for (int col=0; col<this.numColumns; col++) {
					if(m.data[row][col] != this.data[row][col]) 
					return false;
				}	
			}
		}
			return true;
			
			
		}
		
	
	public Matrix mult(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for multiplication, if not, return null.
		 *  If they are compatible, determine the dimensions of the resulting matrix, and fill it in with
		 *  the correct values for matrix multiplication
		 */
		// right matrix is m 
		// left matrix is this
	
	Matrix result = new Matrix(this.numRows, m.numColumns);
	int sum=0;
	if (this.numColumns != m.numRows) {
		return null;
	}
	else {
		for (int row=0; row< this.numRows; row++) {
			for (int col=0; col<m.numColumns; col++) {
				for (int k=0; k<this.numColumns; k++  ) {
					sum += this.data[row][k]* m.data[k][col];
				}
			result.data[row][col] = sum;
			sum=0;
				
			}
		}
	}
	return result;
	
	}
	
	public Matrix add(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for addition, if not, return null.
		 *  If they are compatible, create a new matrix and fill it in with
		 *  the correct values for matrix addition
		 */
		Matrix result = new Matrix(this.numRows,this.numColumns );
		if (this.numRows != m.numRows && this.numColumns != m.numColumns) {
			return null;
		}
		else {
			for (int row=0;row<this.numRows;row++) {
				for (int col = 0;col<this.numColumns;col++) {
					result.data[row][col] = m.data[row][col] + this.data[row][col];
				}
			}
		}
		return result;
	}
    
    public Matrix transpose()
    {
        /*
         * TODO: replace the below return statement with the correct code,
         */
        Matrix transpose = new Matrix(this.numColumns, this.numRows);
        for (int row=0; row<this.numRows;row++) {
        	for (int col=0; col<this.numColumns; col++) {
        		transpose.data[col][row] = this.data[row][col];
        	}
        }
        return transpose;
    }
}
